package cs3500.pa02.controllers;

import cs3500.pa02.Difficulty;
import cs3500.pa02.fileutilities.WriteFilesToPath;
import cs3500.pa02.models.StudySessionModel;
import cs3500.pa02.questionutilities.FormatQuestions;
import cs3500.pa02.questionutilities.Question;
import cs3500.pa02.questionutilities.RandomizeQuestions;
import cs3500.pa02.questionutilities.ReadAsQuestions;
import cs3500.pa02.readers.InputReader;
import cs3500.pa02.views.StudySessionConsoleView;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 * Controller for controlling a study session
 */
public class StudySessionController implements Controller {

  private final StudySessionConsoleView studySessionConsoleView;
  private final InputReader inputReader;
  private State state = State.InitialInputPhase;
  private StudySessionModel studySessionModel;
  private Path inputPath;
  private ArrayList<Question> questions;
  private int numQuestions;

  /**
   * Instantiates a StudySessionController
   *
   * @param readable a readable to read input from
   * @param appendable an appendable to append the output to
   */
  public StudySessionController(Readable readable, Appendable appendable) {
    this.inputReader = new InputReader(readable);
    this.studySessionConsoleView = new StudySessionConsoleView(appendable);
  }

  /**
   * Initiates the controller
   */
  public void run() {
    studySessionConsoleView.welcome();
    acceptPath();
    studySessionConsoleView.generated();
    generateQuestions(inputPath);
    acceptNumQuestions();
    studySessionConsoleView.begin();
    studySessionModel = new StudySessionModel(questions, numQuestions);
    setState(State.StudySession);
    studySession();
  }

  /**
   * Accepts a valid input path from the user
   */
  private void acceptPath() {
    String input = inputReader.read();
    this.inputPath = Path.of(input);
    while (!this.inputPath.toFile().exists() || !this.inputPath.toString().endsWith(".sr")) {
      studySessionConsoleView.invalidPath();
      input = inputReader.read();
      this.inputPath = Path.of(input);
    }
  }

  /**
   * Accepts a valid number of questions from the user
   */
  private void acceptNumQuestions() {
    studySessionConsoleView.initialPrompt();
    String input = inputReader.read();
    while (true) {
      try {
        this.numQuestions = Integer.parseInt(input);
        if (this.numQuestions < 1) {
          studySessionConsoleView.invalidNumberPrompt(questions.size());
          input = inputReader.read();
        } else {
          break;
        }
      } catch (NumberFormatException e) {
        studySessionConsoleView.invalidNumberPrompt(questions.size());
        input = inputReader.read();
      }
    }
  }

  /**
   * Generates a list of questions from the given input
   *
   * @param inputPath the given input path for the .sr file
   */
  private void generateQuestions(Path inputPath) {
    ReadAsQuestions readAsQuestions = new ReadAsQuestions(inputPath.toFile());
    ArrayList<Question> questions = readAsQuestions.generateListOfQuestions();
    RandomizeQuestions randomizeQuestions = new RandomizeQuestions(questions);
    this.questions = randomizeQuestions.getRandomizedQuestions();
  }

  /**
   * Runs the study session
   */
  private void studySession() {
    studySessionConsoleView.options();
    while (state.equals(State.StudySession)) {
      try {
        Question next = studySessionModel.nextQuestion();
        int currentQuestion = studySessionModel.getCurrent();
        studySessionConsoleView.separator();
        studySessionConsoleView.displayQuestion(next, currentQuestion);
        String input = inputReader.read();
        handleInput(input, next);
      } catch (IllegalArgumentException e) {
        end();
      }
    }
  }

  /**
   * Handles user input during the study session
   *
   * @param input the user's input
   * @param current the current question
   */
  private void handleInput(String input, Question current) {
    Input userInput = Input.getInput(input);
    switch (userInput) {
      case Hard -> {
        studySessionModel.setDifficulty(current, Difficulty.HARD);
        studySessionModel.incrementQuestions();
      }
      case Easy -> {
        studySessionModel.setDifficulty(current, Difficulty.EASY);
        studySessionModel.incrementQuestions();
      }
      case Answer -> {
        studySessionConsoleView.answer(current);
        studySessionModel.incrementQuestions();
      }
      case Terminate -> end();
      default -> {
        studySessionConsoleView.options();
        handleInput(inputReader.read(), current);
      }
    }
  }

  /**
   * Changes the state of the controller
   */
  private void setState(State state) {
    this.state = state;
  }

  /**
   * Ends the controller
   */
  private void end() {
    setState(State.Stats);
    inputReader.close();
    FormatQuestions formatQuestions = new FormatQuestions(questions);
    String srFormat = formatQuestions.formatAsSr();
    WriteFilesToPath writeFilesToPath = new WriteFilesToPath();
    try {
      writeFilesToPath.writeAtPath(inputPath, srFormat);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    studySessionConsoleView.separator();
    String stats = studySessionModel.packageStats(formatQuestions.getNumHard(),
        formatQuestions.getNumEasy());
    studySessionConsoleView.custom(stats);
    studySessionConsoleView.goodbye();
  }

}


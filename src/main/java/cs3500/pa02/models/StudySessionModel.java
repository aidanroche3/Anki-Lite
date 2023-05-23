package cs3500.pa02.models;

import static cs3500.pa02.views.StudySessionConsoleView.ANSI_CYAN;
import static cs3500.pa02.views.StudySessionConsoleView.ANSI_GREEN;
import static cs3500.pa02.views.StudySessionConsoleView.ANSI_RED;
import static cs3500.pa02.views.StudySessionConsoleView.ANSI_RESET;

import cs3500.pa02.Difficulty;
import cs3500.pa02.questionutilities.Question;
import java.util.ArrayList;

/**
 * Class for modeling a study session
 */
public class StudySessionModel {

  private final ArrayList<Question> questions;
  private final int numQuestions;
  private int currentQuestion;
  private int easyToHard;
  private int hardToEasy;

  /**
   * Instantiates a study session
   *
   * @param questions the list of questions to study
   * @param numQuestions the number of questions to study
   */
  public StudySessionModel(ArrayList<Question> questions, int numQuestions) {
    this.questions = questions;
    this.numQuestions = numQuestions;
    this.currentQuestion = 0;
  }

  /**
   * Gets the next question in the list
   *
   * @return the next question in the list
   */
  public Question nextQuestion() {
    if (currentQuestion < numQuestions && currentQuestion < questions.size()) {
      return questions.get(currentQuestion);
    } else {
      throw new IllegalArgumentException("No more questions left.");
    }
  }

  /**
   * Increments the current question by one
   */
  public void incrementQuestions() {
    this.currentQuestion = this.currentQuestion + 1;
  }

  /**
   * Gets the current question
   *
   * @return the current index
   */
  public int getCurrent() {
    return this.currentQuestion;
  }

  /**
   * Sets the difficulty of the question and updates the stats
   *
   * @param current the current question
   * @param difficulty the difficulty to set the question
   */
  public void setDifficulty(Question current, Difficulty difficulty) {
    if (current.getDifficulty().equals(Difficulty.EASY) && difficulty.equals(Difficulty.HARD)) {
      easyToHard++;
      questions.get(currentQuestion).setDifficulty(difficulty);
    }
    if (current.getDifficulty().equals(Difficulty.HARD) && difficulty.equals(Difficulty.EASY)) {
      hardToEasy++;
      questions.get(currentQuestion).setDifficulty(difficulty);
    }
  }

  /**
   * Packages the statistics as a String
   *
   * @param totalHard the total hard questions in the bank
   * @param totalEasy the total easy questions in the bank
   * @return a formatted String of the packaged stats
   */
  public String packageStats(int totalHard, int totalEasy) {
    return "Great work! Here are your stats for this session: \n"
        + "You answered " + ANSI_CYAN + this.currentQuestion + ANSI_RESET + " questions.\n"
        + this.easyToHard + " questions went from " + ANSI_GREEN + "easy" + ANSI_RESET
        + " to " + ANSI_RED + "hard" + ANSI_RESET + ".\n"
        + this.hardToEasy + " questions went from " + ANSI_RED + "hard" + ANSI_RESET
        + " to " + ANSI_GREEN + "easy" + ANSI_RESET + ".\n"
        + "There are now " + ANSI_RED + totalHard + ANSI_RESET
        + " hard questions in the question bank.\n"
        + "There are now " + ANSI_GREEN + totalEasy + ANSI_RESET
        + " easy questions in the question bank.\n";
  }

}

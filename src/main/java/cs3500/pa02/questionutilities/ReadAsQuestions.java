package cs3500.pa02.questionutilities;

import cs3500.pa02.Difficulty;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class for reading a .sr files as a list of questions
 */
public class ReadAsQuestions {

  private final File file;
  private final ArrayList<Question> questions;

  /**
   * Initializes a ReadAsQuestions
   *
   * @param file the file to be converted into a list of questions
   */
  public ReadAsQuestions(File file) {
    if (file.toString().endsWith(".sr")) {
      this.file = file;
      this.questions = new ArrayList<>();
    } else {
      throw new IllegalArgumentException("Not a valid .sr file");
    }
  }

  /**
   * Generates a list of questions from the file
   *
   * @return a list of questions
   */
  public ArrayList<Question> generateListOfQuestions() {
    this.questions.clear();
    Scanner srScanner;
    try {
      srScanner = new Scanner(file);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    while (srScanner.hasNextLine()) {
      String nextLine = srScanner.nextLine();
      Question nextQuestion = nextQuestion(nextLine);
      this.questions.add(nextQuestion);
    }
    return this.questions;
  }

  /**
   * Creates a new questions from a line of a .sr file
   *
   * @param nextLine the next line in the file
   * @return a question object representing that line
   */
  private Question nextQuestion(String nextLine) {
    StringBuilder questionBuilder = new StringBuilder();
    int index = 3;
    while (!nextThreeCharacters(nextLine, index).equals("[A]")) {
      questionBuilder.append(nextLine.charAt(index));
      index++;
    }
    index += 3;
    StringBuilder answerBuilder = new StringBuilder();
    while (!nextThreeCharacters(nextLine, index).equals("[D]")) {
      answerBuilder.append(nextLine.charAt(index));
      index++;
    }
    index += 3;
    StringBuilder difficultyBuilder = new StringBuilder();
    while (index < nextLine.length()) {
      difficultyBuilder.append(nextLine.charAt(index));
      index++;
    }
    String question = questionBuilder.toString();
    String answer = answerBuilder.toString();
    String difficulty = difficultyBuilder.toString();
    Difficulty questionDifficulty = Difficulty.determineDifficulty(difficulty);
    return new Question(question, answer, questionDifficulty);
  }

  /**
   * Returns the next three characters in the line, "   " if out of bounds
   *
   * @param line the current line
   * @param index the current index
   * @return a String of the next three lines
   */
  private static String nextThreeCharacters(String line, int index) {
    if (index + 2 < line.length()) {
      return String.valueOf(line.charAt(index))
          + line.charAt(index + 1)
          + line.charAt(index + 2);
    }
    throw new IllegalArgumentException("Incorrectly formatted .sr file");
  }
}

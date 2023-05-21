package cs3500.pa02.questionutilities;

import cs3500.pa02.Difficulty;
import java.util.ArrayList;

/**
 * Class for formatting a list of questions as a String
 */
public class FormatQuestions {

  private final ArrayList<Question> questions;
  private int numHard;
  private int numEasy;

  /**
   * Initializes a FormatQuestions
   *
   * @param questions the list of questions to be formatted
   */
  public FormatQuestions(ArrayList<Question> questions) {
    this.questions = questions;
  }

  /**
   * Formats a list of questions for a .sr file
   *
   * @return a String formatted for a .sr file
   */
  public String formatAsSr() {
    StringBuilder content = new StringBuilder();
    for (Question question : this.questions) {
      if (question.getDifficulty().equals(Difficulty.HARD)) {
        numHard++;
      } else {
        numEasy++;
      }
      content.append(question);
      content.append("\n");
    }
    return content.toString();
  }

  /**
   * Gets the number of easy questions in the new question bank
   */
  public int getNumHard() {
    return this.numHard;
  }

  /**
   * Gets the number of easy questions in the new question bank
   */
  public int getNumEasy() {
    return this.numEasy;
  }

}

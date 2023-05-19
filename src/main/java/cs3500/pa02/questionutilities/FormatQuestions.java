package cs3500.pa02.questionutilities;

import java.util.ArrayList;

/**
 * Class for formatting a list of questions as a String
 */
public class FormatQuestions {

  private final ArrayList<Question> questions;

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
   */
  public String formatAsSr() {
    StringBuilder content = new StringBuilder();
    for (Question question : this.questions) {
      content.append(question.toString());
      content.append("\n");
    }
    content.append("\n");
    return content.toString();
  }

}

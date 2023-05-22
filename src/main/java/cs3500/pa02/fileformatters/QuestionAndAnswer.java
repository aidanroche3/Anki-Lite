package cs3500.pa02.fileformatters;

/**
 * Class for formatting a .sr file by extracting questions and answers
 */
public class QuestionAndAnswer extends FileFormat {

  /**
   * Initializes a QuestionAndAnswer
   *
   * @param content the content to be formatted
   */
  public QuestionAndAnswer(String content) {
    super(content);
  }

  /**
   * Returns the questions and answers from the file's content and formats them for a .sr file
   *
   * @return a String of the questions formatted for a .sr file
   */
  @Override
  public String extract() {
    StringBuilder extractedQuestions = new StringBuilder();
    boolean bracketed = false;
    StringBuilder bracketContent = new StringBuilder();
    for (int i = 0; i < content.length(); i++) {
      char previous = setPrevious(content, i);
      char current = content.charAt(i);
      char next = setNext(content, i);

      if (current == '[' && next == '[') {
        bracketed = true;
        bracketContent = new StringBuilder();
      }
      if (bracketed && current == ']' && next == ']') {
        bracketed = false;
        if (bracketContent.toString().contains(":::")) {
          String question = formatQuestion(bracketContent);
          extractedQuestions.append(question);
        }
      }
      if (bracketed && !(current == '\n')
          && !(current == '[' && (previous == '[' || next == '['))) {
        bracketContent.append(current);
      }

    }
    return extractedQuestions.toString();
  }

  /**
   * Formats content as a question and answer
   *
   * @param content a valid question and answer denoted by :::
   * @return the question and answer formatted for a .sr file
   */
  private String formatQuestion(StringBuilder content) {
    StringBuilder formattedQuestion = new StringBuilder();
    formattedQuestion.append("[Q]");
    int index = 0;
    while (!nextThree(content.toString(), index).equals(":::")) {
      formattedQuestion.append(content.charAt(index));
      index++;
    }
    formattedQuestion.append("[A]");
    index += 3;
    while (index < content.length()) {
      formattedQuestion.append(content.charAt(index));
      index++;
    }
    formattedQuestion.append("[D]HARD\n");
    return formattedQuestion.toString();
  }

  /**
   * Returns a String of the next three characters in the content String (including the current
   * index)
   *
   * @param content the content to be parsed
   * @param index the current index
   * @return a String of the next three characters, including the current
   */
  private String nextThree(String content, int index) {
    return String.valueOf(content.charAt(index))
        + content.charAt(index + 1)
        + content.charAt(index + 2);
  }

}

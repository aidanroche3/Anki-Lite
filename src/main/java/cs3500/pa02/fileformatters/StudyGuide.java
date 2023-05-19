package cs3500.pa02.fileformatters;

/**
 * Class for formatting a String of combined files into a summary
 */
public class StudyGuide extends FileFormat {

  /**
   * Instantiates a file formatter with a String of content
   *
   * @param content the content to be formatted into a summary
   */
  public StudyGuide(String content) {
    super(content);
  }

  /**
   * Summarizes the content of a string by keeping headings and bracketed content
   *
   * @return the content String summarized to only contain headings and bracketed content
   */
  public String summarizeContent() {
    StringBuilder summarizedContent = new StringBuilder();
    boolean heading = false;
    boolean bracketed = false;
    StringBuilder bracketContent = new StringBuilder();

    for (int i = 0; i < content.length(); i++) {
      char previous = setPrevious(content, i);
      char current = content.charAt(i);

      // keeps the headings
      if (!heading && current == '#') {
        if (previous == '\n') {
          summarizedContent.append('\n');
        }
        heading = true;
      }
      if (heading) {
        summarizedContent.append(current);
      }
      if (heading && current == '\n') {
        heading = false;
      }

      char next = setNext(content, i);

      // keeps bracketed phrases
      if (!heading && current == '[' && next == '[') {
        bracketed = true;
        bracketContent = new StringBuilder();
        bracketContent.append('-');
        bracketContent.append(' ');
      }
      if (bracketed && current == ']' && next == ']') {
        bracketContent.append('\n');
        bracketed = false;
        if (!bracketContent.toString().contains(":::")) {
          summarizedContent.append(bracketContent);
        }
      }
      if (bracketed && !(current == '\n')
          && !(current == '[' && (previous == '[' || next == '['))) {
        bracketContent.append(current);
      }
    }
    return summarizedContent.toString();
  }

}

package cs3500.pa02.fileformatters;

/**
 * Abstract class for formatting a File's content
 */
public abstract class FileFormat {

  protected final String content;

  /**
   * Initializes a FileFormat
   *
   * @param content a String of content to be formatted
   */
  public FileFormat(String content) {
    this.content = content;
  }

  /**
   * Returns the previous character in the content string, ' ' if previous is out of bounds
   *
   * @param i the current index of content
   * @return the character before index i
   */
  public static char setPrevious(String content, int i) {
    if (i > 0) {
      return content.charAt(i - 1);
    }
    return ' ';
  }

  /**
   * Returns the next character in the content string, ' ' if next is out of bounds
   *
   * @param i the current index of content
   * @return the next character after index i
   */
  public static char setNext(String content, int i) {
    if (i < content.length() - 1) {
      return content.charAt(i + 1);
    }
    return ' ';
  }

}

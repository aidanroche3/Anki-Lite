package cs3500.pa02.readers;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Class for reading a user's input
 */
public class InputReader implements Reader {

  Scanner consoleScanner;

  /**
   * Instantiates an InputReader
   *
   * @param stream the stream to read from
   */
  public InputReader(InputStream stream) {
    this.consoleScanner = new Scanner(stream);
  }

  /**
   * Reads a user's input as a String
   *
   * @return the input as a String
   */
  @Override
  public String read() {
    return consoleScanner.nextLine();
  }

}

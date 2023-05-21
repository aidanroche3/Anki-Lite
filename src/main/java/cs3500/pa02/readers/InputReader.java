package cs3500.pa02.readers;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Class for reading a user's input
 */
public class InputReader implements Reader {

  Scanner consoleScanner;

  public InputReader(InputStream stream) {
    this.consoleScanner = new Scanner(stream);
  }

  /**
   * Reads a user's input as a String
   */
  @Override
  public String read() {
    return consoleScanner.next();
  }

}

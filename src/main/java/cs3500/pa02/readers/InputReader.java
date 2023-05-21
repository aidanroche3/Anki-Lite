package cs3500.pa02.readers;

import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Class for reading a user's input
 */
public class InputReader implements Reader {

  /**
   * Reads a user's input as a String
   */
  @Override
  public String read() {
    Readable consoleInput = new InputStreamReader(System.in);
    Scanner consoleScanner = new Scanner(consoleInput);
    return consoleScanner.next();
  }

}

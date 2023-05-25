package cs3500.pa02.readers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.StringReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class for testing InputReader and its associated methods
 */
class InputReaderTest {

  private InputReader inputReader;

  /**
   * Initializes the test data
   */
  @BeforeEach
  public void setup() {
    String builder = "hello"
        + "\n"
        + "new line";
    Readable readable = new StringReader(builder);
    inputReader = new InputReader(readable);
  }

  /**
   * Tests the read method
   */
  @Test
  public void testRead() {
    String read = inputReader.read();
    assertEquals("hello", read);
    String next = inputReader.read();
    assertEquals("new line", next);
  }


}
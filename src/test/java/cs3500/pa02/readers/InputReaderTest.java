package cs3500.pa02.readers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

/**
 * Class for testing InputReader and its associated methods
 */
class InputReaderTest {

  private final ByteArrayInputStream inputStream =
      new ByteArrayInputStream(new byte[]{104, 101, 108, 108, 111});
  private final InputReader inputReader = new InputReader(inputStream);

  /**
   * Tests the read method
   */
  @Test
  public void testRead() {
    String read = inputReader.read();
    assertEquals("hello", read);
  }


}
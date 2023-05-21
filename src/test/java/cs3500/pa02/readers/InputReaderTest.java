package cs3500.pa02.readers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class for testing InputReader and its associated methods
 */
class InputReaderTest {

  private final ByteArrayInputStream inputStream =
      new ByteArrayInputStream(new byte[]{104, 101, 108, 108, 111});
  private final InputStream sysIn = System.in;
  private final InputReader inputReader = new InputReader();

  /**
   * Instantiates the test data
   */
  @BeforeEach
  public void setup() {
    System.setIn(inputStream);
  }

  /**
   * Tests the read method
   */
  @Test
  public void testRead() {
    String read = inputReader.read();
    assertEquals("hello", read);
  }

  /**
   * Restores the streams
   */
  @AfterEach
  public void restore() {
    System.setIn(sysIn);
  }


}
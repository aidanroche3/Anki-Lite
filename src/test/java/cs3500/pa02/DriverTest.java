package cs3500.pa02;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class for testing Drive and its associated methods
 */
class DriverTest {

  private InputStream sysIn;

  /**
   * Instantiates the test data
   */
  @BeforeEach
  public void setup() {
    sysIn = System.in;
    ByteArrayInputStream mockInputStream = new ByteArrayInputStream(
        ("""
            src/tests/resources/outputDirectory/manyquestions.sr
            3
            a
            t
            """.replaceAll("\\n|\\r\\n", System.getProperty("line.separator")).getBytes()));
    System.setIn(mockInputStream);
  }

  /**
   * Tests the main method
   */
  @Test
  public void testMain() {
    String[] args = {"src/tests/resources/notes-root",
        "filename", "src/tests/resources/outputDirectory/main.md"};
    assertDoesNotThrow(() -> Driver.main(args));
    Driver.main(args);
    try {
      assertEquals(-1, Files.mismatch(
          Path.of("src/tests/resources/outputDirectory/summary.md"),
          Path.of("src/tests/resources/outputDirectory/main.md")));
      assertEquals(-1, Files.mismatch(
          Path.of("src/tests/resources/outputDirectory/summary.sr"),
          Path.of("src/tests/resources/outputDirectory/main.sr")));
    } catch (IOException e) {
      throw new IllegalArgumentException(e);
    }
    String[] invalidNumberOfArgs = {"test", "test"};
    assertThrows(IllegalArgumentException.class, () -> Driver.main(invalidNumberOfArgs));
    String[] zeroArgs = {};
    assertDoesNotThrow(() -> Driver.main(zeroArgs));
  }

  /**
   * Restores the stream
   */
  @AfterEach
  public void restore() {
    System.setIn(sysIn);
  }


}
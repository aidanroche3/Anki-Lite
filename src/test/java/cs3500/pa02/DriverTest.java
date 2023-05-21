package cs3500.pa02;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;

/**
 * Class for testing Drive and its associated methods
 */
class DriverTest {

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
  }

  /**
   * Tests determineMode
   */
  @Test
  public void testDetermineMode() {

  }

}
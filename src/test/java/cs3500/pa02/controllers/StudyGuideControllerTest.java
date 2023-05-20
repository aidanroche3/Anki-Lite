package cs3500.pa02.controllers;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;

/**
 * Class for testing StudyGuideController and its associated methods
 */
class StudyGuideControllerTest {

  /**
   * Tests the run method
   */
  @Test
  public void testRun() {
    Path root = Path.of("src/tests/resources/notes-root");
    String orderFlag = "filename";
    Path output = Path.of("src/tests/resources/outputDirectory/main.md");
    StudyGuideController studyGuideController = new StudyGuideController(root, orderFlag, output);
    assertDoesNotThrow(studyGuideController::run);
    try {
      assertEquals(-1, Files.mismatch(
          Path.of("src/tests/resources/outputDirectory/summary.md"),
          output));
    } catch (IOException e) {
      throw new IllegalArgumentException(e);
    }
  }
}
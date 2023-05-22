package cs3500.pa02.controllers;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    String root = "src/tests/resources/notes-root";
    String orderFlag = "filename";
    String output = "src/tests/resources/outputDirectory/main.md";
    String[] args = {root, orderFlag, output};
    StudyGuideController studyGuideController = new StudyGuideController(args);
    assertDoesNotThrow(studyGuideController::run);
    try {
      assertEquals(-1, Files.mismatch(
          Path.of("src/tests/resources/outputDirectory/summary.md"),
          Path.of(output)));
    } catch (IOException e) {
      throw new IllegalArgumentException(e);
    }
  }

  /**
   * Tests the validateArgs method indirectly
   */
  @Test
  public void testValidateArgs() {
    String[] invalidRoot = {"fake-root",
        "modified", "src/tests/resources/outputDirectory/summary.md"};
    assertThrows(RuntimeException.class, () -> new StudyGuideController(invalidRoot).run());
    String[] nonDirectory = {"src/tests/resources/notes-root/arrays.md", "modified",
        "src/tests/resources/outputDirectory/summary.md"};
    assertThrows(RuntimeException.class, () -> new StudyGuideController(nonDirectory).run());
    String[] invalidFlag = {"src/tests/resources/notes-root",
        "invalid", "src/tests/resources/outputDirectory/summary.md"};
    assertThrows(IllegalArgumentException.class, () -> new StudyGuideController(invalidFlag).run());
    String[] invalidRelativePath = {"src/tests/resources/notes-root",
        "created", "src/tests/resources/fakeDirectory/new"};
    assertThrows(RuntimeException.class, () -> new StudyGuideController(invalidRelativePath).run());
    String[] notInMd = {"src/tests/resources/notes-root",
        "modified", "src/tests/resources/outputDirectory/summary.pdf"};
    assertThrows(RuntimeException.class, () -> new StudyGuideController(notInMd).run());
    String[] invalidOutputMd = {"src/tests/resources/notes-root",
        "created", "/fake/nonexistent.md"};
    assertThrows(RuntimeException.class, () -> new StudyGuideController(invalidOutputMd).run());
    String[] newFile = {"src/tests/resources/notes-root",
        "created", "src/tests/resources/outputDirectory/newfile.md"};
    assertDoesNotThrow(() -> new StudyGuideController(newFile).run());
    String[] validArgs = {"src/tests/resources/notes-root",
        "filename", "src/tests/resources/outputDirectory/summary.md"};
    assertDoesNotThrow(() -> new StudyGuideController(validArgs).run());
  }
}
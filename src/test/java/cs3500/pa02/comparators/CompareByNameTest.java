package cs3500.pa02.comparators;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa02.fileutilities.MarkDownFile;
import java.io.File;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;

/**
 * Class for testing CompareByName and its associated methods
 */
class CompareByNameTest {

  /**
   * Tests the compare method
   */
  @Test
  public void testCompare() {
    File one = Path.of("src/tests/resources/notes-root/arrays.md").toFile();
    File two = Path.of("src/tests/resources/notes-root/vectors.md").toFile();
    MarkDownFile mdOne = new MarkDownFile(one);
    MarkDownFile mdTwo = new MarkDownFile(two);
    CompareByName cbn = new CompareByName();
    assertEquals(-21, cbn.compare(mdOne, mdTwo));
    assertEquals(21, cbn.compare(mdTwo, mdOne));
  }

}
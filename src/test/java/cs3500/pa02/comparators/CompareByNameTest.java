package cs3500.pa02.comparators;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa02.fileutilities.MarkDownFile;
import org.junit.jupiter.api.Test;

/**
 * Class for testing CompareByName and its associated methods
 */
class CompareByNameTest extends FileComparatorTest {

  /**
   * Tests the compare method
   */
  @Test
  public void testCompare() {
    MarkDownFile mdOne = new MarkDownFile(arrays);
    MarkDownFile mdTwo = new MarkDownFile(vectors);
    CompareByName cbn = new CompareByName();
    assertEquals(-21, cbn.compare(mdOne, mdTwo));
    assertEquals(21, cbn.compare(mdTwo, mdOne));
  }

}
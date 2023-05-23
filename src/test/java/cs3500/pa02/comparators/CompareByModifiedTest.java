package cs3500.pa02.comparators;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa02.fileutilities.MarkDownFile;
import java.nio.file.attribute.FileTime;
import org.junit.jupiter.api.Test;

/**
 * Class for testing CompareByModified and its related methods
 */
public class CompareByModifiedTest extends FileComparatorTest {

  /**
   * Tests the compare method
   */
  @Test
  public void testCompare() {
    MarkDownFile one = new MarkDownFile(arrays,
        FileTime.fromMillis(1683850965878L),
        FileTime.fromMillis(1683850988417L));
    MarkDownFile two = new MarkDownFile(vectors,
        FileTime.fromMillis(1683851000934L),
        FileTime.fromMillis(1683865690271L));
    CompareByModified cbm = new CompareByModified();
    assertEquals(-1, cbm.compare(one, two));
    assertEquals(1, cbm.compare(two, one));
  }
}
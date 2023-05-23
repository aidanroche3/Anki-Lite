package cs3500.pa02.comparators;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa02.fileutilities.MarkDownFile;
import java.nio.file.attribute.FileTime;
import org.junit.jupiter.api.Test;

/**
 * Testing the CompareByDate class and its associated methods
 */
class CompareByDateTest extends FileComparatorTest {

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
    CompareByDate cbd = new CompareByDate();
    assertEquals(-1, cbd.compare(one, two));
    assertEquals(1, cbd.compare(two, one));
  }

}
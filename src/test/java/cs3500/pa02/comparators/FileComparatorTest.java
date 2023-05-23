package cs3500.pa02.comparators;

import java.io.File;
import java.nio.file.Path;

/**
 * Abstract class for testing file comparators
 */
public class FileComparatorTest {

  protected File arrays = Path.of("src/tests/resources/notes-root/arrays.md").toFile();
  protected File vectors = Path.of("src/tests/resources/notes-root/vectors.md").toFile();

}

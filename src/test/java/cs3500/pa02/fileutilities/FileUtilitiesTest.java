package cs3500.pa02.fileutilities;

import java.io.File;
import java.nio.file.Path;

/**
 * Abstract class for testing file utilities classes
 */
public abstract class FileUtilitiesTest {

  protected File arrays = Path.of("src/tests/resources/notes-root/arrays.md").toFile();
  protected File test = Path.of("src/tests/resources/notes-root/test.md").toFile();
  protected File vectors = Path.of("src/tests/resources/notes-root/vectors.md").toFile();
  protected File java = Path.of("src/tests/resources/notes-root/lecture-notes/java.md").toFile();
  protected MarkDownFile arraysMd;
  protected MarkDownFile testMd;
  protected MarkDownFile vectorsMd;

}

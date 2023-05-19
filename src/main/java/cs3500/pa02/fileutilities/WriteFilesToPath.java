package cs3500.pa02.fileutilities;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

/**
 * Class for writing a String to a given file
 */
public class WriteFilesToPath {

  /**
   * Writes a given output at the given path
   *
   * @param outputPath the path to write to
   * @param output the output to write at that path
   * @throws IOException on I/O failure
   */
  public void writeAtPath(Path outputPath, String output) throws IOException {
    Path path = Path.of(outputPath.toString());
    FileWriter fileWriter;

    try {
      fileWriter = new FileWriter(path.toString());
    } catch (IOException e) {
      throw new IOException(e);
    }

    for (int i = 0; i < output.length(); i++) {
      fileWriter.write(output.charAt(i));
    }
    fileWriter.close();
  }
}

package cs3500.pa02.fileutilities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import cs3500.pa02.fileformatters.QuestionAndAnswer;
import cs3500.pa02.fileformatters.StudyGuide;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

/**
 * Class for testing WriteFilesToPath and its associated methods
 */
class WriteFilesToPathTest {

  /**
   * Tests the writeFilesToPath method
   */
  @Test
  public void testWriteFilesToPath() {
    File arrays = Path.of("src/tests/resources/notes-root/arrays.md").toFile();
    File testOne = Path.of("src/tests/resources/notes-root/test.md").toFile();
    File vectors = Path.of("src/tests/resources/notes-root/vectors.md").toFile();
    File java = Path.of("src/tests/resources/notes-root/lecture-notes/java.md").toFile();
    ArrayList<File> files = new ArrayList<>(Arrays.asList(arrays, testOne, vectors, java));
    CombineFiles combine = new CombineFiles(files);
    String combined;
    combined = combine.getCombinedFiles();
    StudyGuide studyGuide = new StudyGuide(combined);
    String studyGuideOutput = studyGuide.summarizeContent();
    QuestionAndAnswer questions = new QuestionAndAnswer(combined);
    String questionOutput = questions.extractQuestions();
    Path sampleMd = Path.of("src/tests/resources/outputDirectory/samplesummary.md");
    Path writeAtMd = Path.of("src/tests/resources/outputDirectory/test.md");
    Path sampleSr = Path.of("src/tests/resources/outputDirectory/samplesummary.sr");
    Path writeAtSr = Path.of("src/tests/resources/outputDirectory/test.sr");
    Scanner sampleScan;
    Scanner writeScan;
    WriteFilesToPath filesToPath = new WriteFilesToPath();
    try {
      filesToPath.writeAtPath(writeAtMd, studyGuideOutput);
      filesToPath.writeAtPath(writeAtSr, questionOutput);
    } catch (IOException e) {
      throw new IllegalArgumentException(e);
    }
    try {
      assertEquals(-1, Files.mismatch(sampleMd, writeAtMd));
    } catch (IOException e) {
      throw new IllegalArgumentException(e);
    }
    try {
      sampleScan = new Scanner(sampleSr);
      writeScan = new Scanner(writeAtSr);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    while (sampleScan.hasNextLine() && writeScan.hasNextLine()) {
      assertEquals(sampleScan.nextLine(), writeScan.nextLine());
    }
    Path fake = Path.of("src/tests/resources/fakeDirectory/nonexistent.md");
    assertThrows(IOException.class, () -> filesToPath.writeAtPath(fake,
        studyGuideOutput));
  }

}
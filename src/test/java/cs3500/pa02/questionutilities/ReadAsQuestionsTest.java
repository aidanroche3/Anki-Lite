package cs3500.pa02.questionutilities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class for testing ReadAsQuestions and its associated methods
 */
class ReadAsQuestionsTest extends QuestionUtilitiesTest {

  private File notSr;
  private ReadAsQuestions readAsQuestionsThrows;
  private ReadAsQuestions nonexistentReader;
  private ArrayList<Question> questions;
  private ArrayList<Question> sampleQuestions;

  /**
   * Initializing test data
   */
  @BeforeEach
  public void setup() {
    File file = Path.of("src/tests/resources/outputDirectory/samplesummary.sr").toFile();
    File edgeCases = Path.of("src/tests/resources/outputDirectory/edgecases.sr").toFile();
    notSr = Path.of("src/nonexistent.md").toFile();
    File nonexistent = Path.of("src/nonexistent.sr").toFile();
    ReadAsQuestions readAsQuestions = new ReadAsQuestions(file);
    readAsQuestionsThrows = new ReadAsQuestions(edgeCases);
    nonexistentReader = new ReadAsQuestions(nonexistent);
    questions = readAsQuestions.generateListOfQuestions();
    sampleQuestions = new ArrayList<>(Arrays.asList(arraysOne, arraysTwo, test, vector));
  }

  /**
   * Tests the generateListOfQuestions method
   */
  @Test
  public void testGenerateListOfQuestion() {
    assertThrows(IllegalArgumentException.class, () -> new ReadAsQuestions(notSr));
    assertThrows(RuntimeException.class, () -> nonexistentReader.generateListOfQuestions());
    for (int i = 0; i < sampleQuestions.size(); i++) {
      assertEquals(sampleQuestions.get(i), questions.get(i));
    }
    assertThrows(IllegalArgumentException.class,
        () -> readAsQuestionsThrows.generateListOfQuestions());
  }

}
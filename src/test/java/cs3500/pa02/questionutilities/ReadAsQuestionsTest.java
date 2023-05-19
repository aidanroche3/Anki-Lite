package cs3500.pa02.questionutilities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import cs3500.pa02.Difficulty;
import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class for testing ReadAsQuestions and its associated methods
 */
class ReadAsQuestionsTest {

  File file;
  File edgeCases;
  File notSr;
  File nonexistent;
  ReadAsQuestions readAsQuestions;
  ReadAsQuestions readAsQuestionsThrows;
  ReadAsQuestions nonexistentReader;
  ArrayList<Question> questions;
  ArrayList<Question> sampleQuestions;
  Question arraysOne;
  Question arraysTwo;
  Question test;
  Question vector;

  /**
   * Initializing test data
   */
  @BeforeEach
  public void setup() {
    file = Path.of("src/tests/resources/outputDirectory/samplesummary.sr").toFile();
    edgeCases = Path.of("src/tests/resources/outputDirectory/edgecases.sr").toFile();
    notSr = Path.of("src/nonexistent.md").toFile();
    nonexistent = Path.of("src/nonexistent.sr").toFile();
    readAsQuestions = new ReadAsQuestions(file);
    readAsQuestionsThrows = new ReadAsQuestions(edgeCases);
    nonexistentReader = new ReadAsQuestions(nonexistent);
    questions = readAsQuestions.generateListOfQuestions();
    arraysOne = new Question("Where are arrays stored in memory?",
        "the heap", Difficulty.HARD);
    arraysTwo = new Question("T/F Arrays can hold multiple data types",
        "false", Difficulty.HARD);
    test = new Question("This is a test question",
        "answer", Difficulty.HARD);
    vector = new Question("Which method can resize a vector?",
        "setSize(int size)", Difficulty.HARD);
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
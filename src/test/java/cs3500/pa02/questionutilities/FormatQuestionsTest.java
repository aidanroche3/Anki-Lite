package cs3500.pa02.questionutilities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa02.Difficulty;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class for testing FormatQuestions and its associated methods
 */
class FormatQuestionsTest {

  Question arraysOne;
  Question arraysTwo;
  Question test;
  Question vector;
  ArrayList<Question> sampleQuestions;
  String content;
  FormatQuestions formatQuestions;

  /**
   * Initializing the test data
   */
  @BeforeEach
  public void setup() {
    arraysOne = new Question("Where are arrays stored in memory?",
        "the heap", Difficulty.HARD);
    arraysTwo = new Question("T/F Arrays can hold multiple data types",
        "false", Difficulty.HARD);
    test = new Question("This is a test question",
        "answer", Difficulty.HARD);
    vector = new Question("Which method can resize a vector?",
        "setSize(int size)", Difficulty.HARD);
    sampleQuestions = new ArrayList<>(Arrays.asList(arraysOne, arraysTwo, test, vector));
    content = """
        [Q]Where are arrays stored in memory?[A]the heap[D]HARD
        [Q]T/F Arrays can hold multiple data types[A]false[D]HARD
        [Q]This is a test question[A]answer[D]HARD
        [Q]Which method can resize a vector?[A]setSize(int size)[D]HARD
        
        """;
    formatQuestions = new FormatQuestions(sampleQuestions);
  }

  /**
   * Tests the formatAsSr method
   */
  @Test
  public void testFormatAsSr() {
    assertEquals(content, formatQuestions.formatAsSr());
  }

}
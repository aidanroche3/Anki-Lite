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
class FormatQuestionsTest extends QuestionUtilitiesTest {

  private String content;
  private FormatQuestions formatQuestions;

  /**
   * Initializing the test data
   */
  @BeforeEach
  public void setup() {
    test.setDifficulty(Difficulty.EASY);
    ArrayList<Question> sampleQuestions =
        new ArrayList<>(Arrays.asList(arraysOne, arraysTwo, test, vector));
    content = """
        [Q]Where are arrays stored in memory?[A]the heap[D]HARD
        [Q]T/F Arrays can hold multiple data types[A]false[D]HARD
        [Q]This is a test question[A]answer[D]EASY
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

  /**
   * Tests the getNumHard method
   */
  @Test
  public void testGetNumHard() {
    formatQuestions.formatAsSr();
    assertEquals(3, formatQuestions.getNumHard());
  }

  /**
   * Tests the getNumEasy method
   */
  @Test
  public void testGetNumEasy() {
    formatQuestions.formatAsSr();
    assertEquals(1, formatQuestions.getNumEasy());
  }

}
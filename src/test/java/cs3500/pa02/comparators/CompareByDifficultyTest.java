package cs3500.pa02.comparators;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa02.Difficulty;
import cs3500.pa02.questionutilities.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class for testing the CompareByDifficulty comparator
 */
class CompareByDifficultyTest {

  private Question arraysOne;
  private Question arraysTwo;
  private Question test;
  private Question vector;
  private CompareByDifficulty compareByDifficulty;

  /**
   * Initializing the test data
   */
  @BeforeEach
  public void setup() {
    arraysOne = new Question("Where are arrays stored in memory?",
        "the heap", Difficulty.HARD);
    arraysTwo = new Question("T/F Arrays can hold multiple data types",
        "false", Difficulty.EASY);
    test = new Question("This is a test question",
        "answer", Difficulty.HARD);
    vector = new Question("Which method can resize a vector?",
        "setSize(int size)", Difficulty.EASY);
    compareByDifficulty = new CompareByDifficulty();
  }

  /**
   * Testing the compare method
   */
  @Test
  public void testCompare() {
    assertEquals(-1, compareByDifficulty.compare(arraysOne, test));
    assertEquals(-1, compareByDifficulty.compare(arraysOne, arraysTwo));
    assertEquals(1, compareByDifficulty.compare(arraysTwo, test));
    assertEquals(0, compareByDifficulty.compare(arraysTwo, vector));
  }

}
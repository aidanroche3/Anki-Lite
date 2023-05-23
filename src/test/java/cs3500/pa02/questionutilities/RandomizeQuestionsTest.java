package cs3500.pa02.questionutilities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa02.Difficulty;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class for testing RandomizeQuestions and its associated methods
 */
class RandomizeQuestionsTest extends QuestionUtilitiesTest {

  private RandomizeQuestions randomizeQuestions;

  /**
   * Initializing the test data
   */
  @BeforeEach
  public void setup() {
    test.setDifficulty(Difficulty.EASY);
    vector.setDifficulty(Difficulty.EASY);
    ArrayList<Question> sampleQuestions =
        new ArrayList<>(Arrays.asList(arraysOne, arraysTwo, test, vector));
    randomizeQuestions = new RandomizeQuestions(sampleQuestions);
  }

  /**
   * Tests the getRandomizedQuestions method
   */
  @Test
  public void testGetRandomizedQuestions() {
    ArrayList<Question> questions = randomizeQuestions.getRandomizedQuestions();
    assertEquals(Difficulty.HARD, questions.get(0).getDifficulty());
    assertEquals(Difficulty.HARD, questions.get(1).getDifficulty());
    assertEquals(Difficulty.EASY, questions.get(2).getDifficulty());
    assertEquals(Difficulty.EASY, questions.get(3).getDifficulty());
  }

}
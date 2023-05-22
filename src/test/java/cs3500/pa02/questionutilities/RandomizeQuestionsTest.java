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
class RandomizeQuestionsTest {

  Question arraysOne;
  Question arraysTwo;
  Question test;
  Question vector;
  ArrayList<Question> sampleQuestions;
  ArrayList<Question> sortedQuestions;
  RandomizeQuestions randomizeQuestions;

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
    sampleQuestions = new ArrayList<>(Arrays.asList(arraysOne, arraysTwo, test, vector));
    sortedQuestions = new ArrayList<>(Arrays.asList(test, arraysOne, arraysTwo, vector));
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
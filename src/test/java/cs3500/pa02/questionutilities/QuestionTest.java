package cs3500.pa02.questionutilities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import cs3500.pa02.Difficulty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class for testing Question and its associated methods
 */
class QuestionTest {

  private Question hydrogen;
  private Question hydrogenCopy;
  private Question sameQuestion;
  private Question sameQuestionAndAnswer;
  private Question oxygen;
  private Question roentgenium;
  private Object object;

  /**
   * Initializing the testing data
   */
  @BeforeEach
  public void setup() {
    hydrogen = new Question("What is the chemical symbol for Hydrogen?",
        "The symbol is H", Difficulty.EASY);
    hydrogenCopy = new Question("What is the chemical symbol for Hydrogen?",
        "The symbol is H", Difficulty.EASY);
    sameQuestion = new Question("What is the chemical symbol for Hydrogen?",
        "Different answer", Difficulty.EASY);
    sameQuestionAndAnswer = new Question("What is the chemical symbol for Hydrogen?",
        "The symbol is H", Difficulty.HARD);
    oxygen = new Question("What is the chemical symbol for Oxygen?",
        "The symbol is O", Difficulty.EASY);
    roentgenium = new Question("What element has the chemical symbol Rg?",
        "Roentgenium", Difficulty.HARD);
    object = new Object();
  }

  /**
   * Tests the getQuestion method
   */
  @Test
  public void testGetQuestion() {
    assertEquals("What is the chemical symbol for Hydrogen?", hydrogen.getQuestion());
    assertEquals("What is the chemical symbol for Oxygen?", oxygen.getQuestion());
    assertEquals("What element has the chemical symbol Rg?", roentgenium.getQuestion());
  }

  /**
   * Tests the getAnswer method
   */
  @Test
  public void testGetAnswer() {
    assertEquals("The symbol is H", hydrogen.getAnswer());
    assertEquals("The symbol is O", oxygen.getAnswer());
    assertEquals("Roentgenium", roentgenium.getAnswer());
  }

  /**
   * Tests the getDifficulty method
   */
  @Test
  public void testGetDifficulty() {
    assertEquals(Difficulty.EASY, hydrogen.getDifficulty());
    assertEquals(Difficulty.EASY, oxygen.getDifficulty());
    assertEquals(Difficulty.HARD, roentgenium.getDifficulty());
  }

  /**
   * Tests the setDifficulty method
   */
  @Test
  public void testSetDifficulty() {
    assertEquals(Difficulty.EASY, hydrogen.getDifficulty());
    hydrogen.setDifficulty(Difficulty.HARD);
    assertEquals(Difficulty.HARD, hydrogen.getDifficulty());
  }

  /**
   * Tests the toString method
   */
  @Test
  public void testToString() {
    String hydrogrenString =
        "[Q]What is the chemical symbol for Hydrogen?[A]The symbol is H[D]EASY";
    String roentgeniumString =
        "[Q]What element has the chemical symbol Rg?[A]Roentgenium[D]HARD";
    assertEquals(hydrogrenString, hydrogen.toString());
    assertEquals(roentgeniumString, roentgenium.toString());
  }

  /**
   * Tests the equals method
   */
  @Test
  public void testEquals() {
    assertEquals(hydrogenCopy, hydrogen);
    assertNotEquals(hydrogen, sameQuestion);
    assertNotEquals(hydrogen, sameQuestionAndAnswer);
    assertNotEquals(hydrogen, oxygen);
    assertNotEquals(roentgenium, object);
  }

  /**
   * Tests the hashCode method
   */
  @Test
  public void testHashCode() {
    assertEquals(hydrogen.hashCode(), hydrogenCopy.hashCode());
    assertNotEquals(hydrogen.hashCode(), sameQuestion.hashCode());
    assertNotEquals(hydrogen.hashCode(), sameQuestionAndAnswer.hashCode());
    assertNotEquals(hydrogen.hashCode(), oxygen.hashCode());
  }

}
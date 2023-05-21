package cs3500.pa02.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import cs3500.pa02.Difficulty;
import cs3500.pa02.questionutilities.Question;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class for testing StudySessionModel and its associated methods
 */
class StudySessionModelTest {

  private Question hydrogen;
  private Question sameQuestion;
  private ArrayList<Question> questions;
  private StudySessionModel model;

  /**
   * Initializes the test data
   */
  @BeforeEach
  public void setup() {
    hydrogen = new Question("What is the chemical symbol for Hydrogen?",
        "The symbol is H", Difficulty.EASY);
    sameQuestion = new Question("What is the chemical symbol for Hydrogen?",
        "Different answer", Difficulty.EASY);
    Question sameQuestionAndAnswer = new Question("What is the chemical symbol for Hydrogen?",
        "The symbol is H", Difficulty.HARD);
    Question oxygen = new Question("What is the chemical symbol for Oxygen?",
        "The symbol is O", Difficulty.EASY);
    Question roentgenium = new Question("What element has the chemical symbol Rg?",
        "Roentgenium", Difficulty.HARD);
    questions = new ArrayList<>(Arrays.asList(hydrogen, sameQuestion, sameQuestionAndAnswer,
        oxygen, roentgenium));
  }

  /**
   * Tests the next questions method
   */
  @Test
  public void testNextQuestion() {
    model = new StudySessionModel(questions, 2);
    assertEquals(hydrogen, model.nextQuestion());
    assertEquals(sameQuestion, model.nextQuestion());
    assertThrows(IllegalArgumentException.class, model::nextQuestion);
  }

  /**
   * Tests the getCurrent method
   */
  @Test
  public void testGetCurrent() {
    model = new StudySessionModel(questions, 3);
    assertEquals(0, model.getCurrent());
    model.nextQuestion();
    assertEquals(1, model.getCurrent());
    model.nextQuestion();
    assertEquals(2, model.getCurrent());
  }

  /**
   * Tests the setDifficulty method
   */
  @Test
  public void testSetDifficulty() {
    model = new StudySessionModel(questions, 5);
    model.setDifficulty(hydrogen, Difficulty.EASY);
    assertEquals(Difficulty.EASY, hydrogen.getDifficulty());
    model.setDifficulty(hydrogen, Difficulty.EASY);
    assertEquals(Difficulty.EASY, hydrogen.getDifficulty());
    model.setDifficulty(hydrogen, Difficulty.HARD);
    assertEquals(Difficulty.HARD, hydrogen.getDifficulty());
    model.setDifficulty(hydrogen, Difficulty.HARD);
    assertEquals(Difficulty.HARD, hydrogen.getDifficulty());
    model.setDifficulty(hydrogen, Difficulty.EASY);
    assertEquals(Difficulty.EASY, hydrogen.getDifficulty());
  }

  /**
   * Tests the getEasyToHard method
   */
  @Test
  public void testGetEasyToHard() {
    model = new StudySessionModel(questions, 5);
    model.setDifficulty(hydrogen, Difficulty.EASY);
    model.setDifficulty(hydrogen, Difficulty.HARD);
    model.setDifficulty(hydrogen, Difficulty.HARD);
    model.setDifficulty(hydrogen, Difficulty.EASY);
    assertEquals(1, model.getEasyToHard());
  }

  /**
   * Tests the getHardToEasy method
   */
  @Test
  public void testGetHardToEasy() {
    model = new StudySessionModel(questions, 5);
    model.setDifficulty(hydrogen, Difficulty.HARD);
    model.setDifficulty(hydrogen, Difficulty.EASY);
    model.setDifficulty(hydrogen, Difficulty.HARD);
    model.setDifficulty(hydrogen, Difficulty.EASY);
    assertEquals(2, model.getHardToEasy());
  }
}
package cs3500.pa02.models;

import static cs3500.pa02.views.StudySessionView.ANSI_CYAN;
import static cs3500.pa02.views.StudySessionView.ANSI_GREEN;
import static cs3500.pa02.views.StudySessionView.ANSI_RED;
import static cs3500.pa02.views.StudySessionView.ANSI_RESET;
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
  private Question roentgenium;
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
    roentgenium = new Question("What element has the chemical symbol Rg?",
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
    model.incrementQuestions();
    assertEquals(sameQuestion, model.nextQuestion());
    model.incrementQuestions();
    model = new StudySessionModel(questions, 7);
    model.incrementQuestions();
    model.incrementQuestions();
    model.incrementQuestions();
    model.incrementQuestions();
    assertEquals(roentgenium, model.nextQuestion());
    model.incrementQuestions();
    assertThrows(IllegalArgumentException.class, model::nextQuestion);
    model = new StudySessionModel(questions, 5);
    model.incrementQuestions();
    model.incrementQuestions();
    model.incrementQuestions();
    model.incrementQuestions();
    model.incrementQuestions();
    assertThrows(IllegalArgumentException.class, () -> model.nextQuestion());
  }

  /**
   * Tests the getCurrent method
   */
  @Test
  public void testGetCurrent() {
    model = new StudySessionModel(questions, 3);
    assertEquals(0, model.getCurrent());
    model.incrementQuestions();
    assertEquals(1, model.getCurrent());
    model.incrementQuestions();
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
   * Tests the packageStats
   */
  @Test
  public void testPackageStats() {
    model = new StudySessionModel(questions, 3);
    model.setDifficulty(questions.get(1), Difficulty.HARD);
    model.incrementQuestions();
    String stats = model.packageStats(3, 1);
    String expected = "Great work! Here are your stats for this session: \n"
        + "You answered " + ANSI_CYAN + "1" + ANSI_RESET + " questions.\n"
        + "1 questions went from " + ANSI_GREEN + "easy" + ANSI_RESET
        + " to " + ANSI_RED + "hard" + ANSI_RESET + ".\n"
        + "0 questions went from " + ANSI_RED + "hard" + ANSI_RESET
        + " to " + ANSI_GREEN + "easy" + ANSI_RESET + ".\n"
        + "There are now " + ANSI_RED + "3" + ANSI_RESET + " hard questions in the question bank.\n"
        + "There are now " + ANSI_GREEN + "1" + ANSI_RESET
        + " easy questions in the question bank.\n";
    assertEquals(expected, stats);
  }


}
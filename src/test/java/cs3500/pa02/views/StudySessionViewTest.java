package cs3500.pa02.views;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa02.Difficulty;
import cs3500.pa02.questionutilities.Question;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class for testing StudySessionView and its associated methods
 */
class StudySessionViewTest {

  private final ByteArrayOutputStream output = new ByteArrayOutputStream();
  private PrintStream sysOut;
  private StudySessionView studySessionView;
  Question testQuestion;

  /**
   * Initiates the test data
   */
  @BeforeEach
  public void setup() {
    System.setOut(new PrintStream(output));
    sysOut = System.out;
    studySessionView = new StudySessionView();
    testQuestion = new Question("Test question?", "Answer", Difficulty.HARD);
  }


  /**
   * Tests the welcome method
   */
  @Test
  public void testWelcome() {
    studySessionView.welcome();
    String welcome = """
        
        Welcome to Anki-Lite!
        To begin, input a valid .sr file to study from:\s""".replaceAll(
            "\\n|\\r\\n", System.getProperty("line.separator"));
    assertEquals(welcome, output.toString());
  }

  /**
   * Tests the begin method
   */
  @Test
  public void testBegin() {
    studySessionView.begin();
    String begin = """
        Great! Let's begin!
        
        """.replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
    assertEquals(begin, output.toString());
  }

  /**
   * Tests the invalid path method
   */
  @Test
  public void testInvalidPath() {
    studySessionView.invalidPath();
    String invalidPath = "Please enter a valid path to a .sr file: ";
    assertEquals(invalidPath, output.toString());
  }

  /**
   * Tests initialPrompt method
   */
  @Test
  public void testInitialPrompt() {
    studySessionView.initialPrompt();
    String initialPrompt = "How many questions would you like to study? ";
    assertEquals(initialPrompt, output.toString());
  }

  /**
   * Tests invalidNumberPrompt
   */
  @Test
  public void testInvalidNumberPrompt() {
    studySessionView.invalidNumberPrompt(5);
    String invalidNumberPrompt = "There are 5 questions to study. "
        + "Please enter a valid number of questions: ";
    assertEquals(invalidNumberPrompt, output.toString());
  }

  /**
   * Tests the generating method
   */
  @Test
  public void testGenerating() {
    studySessionView.generated();
    String generating = """
        Hold tight! Generating and randomizing questions...
        """.replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
    assertEquals(generating, output.toString());
  }

  /**
   * Tests the options method
   */
  @Test
  public void testOptions() {
    studySessionView.options();
    String options = """
        Options: H to set hard, E to set easy, A to see answer, T to terminate.
        """.replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
    assertEquals(options, output.toString());
  }

  /**
   * Tests the displayQuestion method
   */
  @Test
  public void testDisplayQuestion() {
    studySessionView.displayQuestion(testQuestion, 1);
    String question = "1. Test question? ";
    assertEquals(question, output.toString());
  }

  /**
   * Tests the separator method
   */
  @Test
  public void testSeparator() {
    studySessionView.separator();
    String separator = """
        ----------------------------------------------------------
        """.replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
    assertEquals(separator, output.toString());
  }

  /**
   * Tests the answer method
   */
  @Test
  public void testAnswer() {
    studySessionView.answer(testQuestion);
    String answer = """
        Answer:Answer
        """.replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
    assertEquals(answer, output.toString());
  }

  /**
   * Tests the stats method
   */
  @Test
  public void testStats() {
    studySessionView.stats(9, 3, 4, 6, 8);
    String stats = """
        Great work! Here are your stats for this session:\s
        You answered 9 questions.
        3 questions went from easy to hard.
        4 questions went from hard to easy.
        There are now 6 hard questions in the question bank.
        There are now 8 easy questions in the question bank.
        """.replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
    assertEquals(stats, output.toString());
  }

  /**
   * Tests the goodbye method
   */
  @Test
  public void testGoodbye() {
    studySessionView.goodbye();
    String goodbye = """
        Thanks for studying! Have a great day!
        """.replaceAll(
        "\\n|\\r\\n", System.getProperty("line.separator"));
    assertEquals(goodbye, output.toString());
  }

  /**
   * Restores the streams
   */
  @AfterEach
  public void restore() {
    System.setOut(sysOut);
  }
}
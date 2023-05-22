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

  // color constants for output text
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_CYAN = "\u001B[36m";

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
    String welcome = ("\n" + ANSI_CYAN + "Welcome to Anki-Lite!" + ANSI_RESET + "\n"
        + "To begin, input a valid .sr file to study from: ").replaceAll(
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
        Options: [H] Set Hard [E] Set Easy [A] See Answer [T] Terminate
        """.replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
    assertEquals(options, output.toString());
  }

  /**
   * Tests the displayQuestion method
   */
  @Test
  public void testDisplayQuestion() {
    studySessionView.displayQuestion(testQuestion, 0);
    String question = ANSI_RED + "1. Test question?" + ANSI_RESET + " ";
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
    String stats = ("Great work! Here are your stats for this session: \n"
        + "You answered " + ANSI_CYAN + "9" + ANSI_RESET + " questions.\n"
        + "3 questions went from " + ANSI_GREEN + "easy" + ANSI_RESET
        + " to " + ANSI_RED + "hard." + ANSI_RESET + "\n"
        + "4 questions went from " + ANSI_RED + "hard" + ANSI_RESET
        + " to " + ANSI_GREEN + "easy." + ANSI_RESET + "\n"
        + "There are now " + ANSI_RED + "6" + ANSI_RESET + " hard questions in the question bank.\n"
        + "There are now " + ANSI_GREEN + "8" + ANSI_RESET
        + " easy questions in the question bank.\n").replaceAll("\\n|\\r\\n",
        System.getProperty("line.separator"));
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
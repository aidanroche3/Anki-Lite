package cs3500.pa02.views;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa02.Difficulty;
import cs3500.pa02.questionutilities.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class for testing StudySessionView and its associated methods
 */
class StudySessionConsoleViewTest {

  // color constants for output text
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_CYAN = "\u001B[36m";

  private StringBuilder output;
  private StudySessionConsoleView studySessionConsoleView;
  private Question testQuestionHard;
  private Question testQuestionEasy;

  /**
   * Initiates the test data
   */
  @BeforeEach
  public void setup() {
    output = new StringBuilder();
    studySessionConsoleView = new StudySessionConsoleView(output);
    testQuestionHard = new Question("Test question?", "Answer", Difficulty.HARD);
    testQuestionEasy = new Question("Test question?", "Answer", Difficulty.EASY);
  }


  /**
   * Tests the welcome method
   */
  @Test
  public void testWelcome() {
    studySessionConsoleView.welcome();
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
    studySessionConsoleView.begin();
    String begin = (ANSI_CYAN + "Great! Let's begin!" + ANSI_RESET + "\n\n")
        .replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
    assertEquals(begin, output.toString());
  }

  /**
   * Tests the invalid path method
   */
  @Test
  public void testInvalidPath() {
    studySessionConsoleView.invalidPath();
    String invalidPath = ANSI_RED + "Please enter a valid path to a .sr file: " + ANSI_RESET;
    assertEquals(invalidPath, output.toString());
  }

  /**
   * Tests initialPrompt method
   */
  @Test
  public void testInitialPrompt() {
    studySessionConsoleView.initialPrompt();
    String initialPrompt = "How many questions would you like to study? ";
    assertEquals(initialPrompt, output.toString());
  }

  /**
   * Tests invalidNumberPrompt
   */
  @Test
  public void testInvalidNumberPrompt() {
    studySessionConsoleView.invalidNumberPrompt(5);
    String invalidNumberPrompt = "There are " + ANSI_CYAN + "5"
        + ANSI_RESET + " questions to study. "
        + ANSI_RED + "Please enter a valid number of questions: " + ANSI_RESET;
    assertEquals(invalidNumberPrompt, output.toString());
  }

  /**
   * Tests the generating method
   */
  @Test
  public void testGenerating() {
    studySessionConsoleView.generated();
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
    studySessionConsoleView.options();
    String options = ("Options: [" + ANSI_RED + "H" + ANSI_RESET + "] Set Hard ["
        + ANSI_GREEN + "E" + ANSI_RESET + "] Set Easy [" + ANSI_CYAN + "A" + ANSI_RESET
        + "] See Answer [" + ANSI_RED + "T" + ANSI_RESET + "] Terminate\n").replaceAll("\\n|\\r\\n",
        System.getProperty("line.separator"));
    assertEquals(options, output.toString());
  }

  /**
   * Tests the displayQuestion method
   */
  @Test
  public void testDisplayQuestion() {
    studySessionConsoleView.displayQuestion(testQuestionHard, 0);
    String questionHard = ANSI_RED + "1. Test question?" + ANSI_RESET + " ";
    assertEquals(questionHard, output.toString());
    output = new StringBuilder();
    studySessionConsoleView = new StudySessionConsoleView(output);
    studySessionConsoleView.displayQuestion(testQuestionEasy, 2);
    String questionEasy = ANSI_GREEN + "3. Test question?" + ANSI_RESET + " ";
    assertEquals(questionEasy, output.toString());
  }

  /**
   * Tests the separator method
   */
  @Test
  public void testSeparator() {
    studySessionConsoleView.separator();
    String separator = "----------------------------------------------------------\n".replaceAll(
        "\\n|\\r\\n", System.getProperty("line.separator"));
    assertEquals(separator, output.toString());
  }

  /**
   * Tests the answer method
   */
  @Test
  public void testAnswer() {
    studySessionConsoleView.answer(testQuestionHard);
    String answer = """
        Answer:Answer
        """.replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
    assertEquals(answer, output.toString());
  }

  /**
   * Tests the stats method
   */
  @Test
  public void testCustom() {
    String custom = "This is a custom message\n";
    studySessionConsoleView.custom(custom);
    assertEquals(custom, output.toString());
  }

  /**
   * Tests the goodbye method
   */
  @Test
  public void testGoodbye() {
    studySessionConsoleView.goodbye();
    String goodbye = (ANSI_CYAN
        + "Thanks for studying! Have a great day!" + ANSI_RESET + "\n").replaceAll(
        "\\n|\\r\\n", System.getProperty("line.separator"));
    assertEquals(goodbye, output.toString());
  }

}
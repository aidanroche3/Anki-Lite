package cs3500.pa02.controllers;

import static cs3500.pa02.views.StudySessionConsoleView.ANSI_CYAN;
import static cs3500.pa02.views.StudySessionConsoleView.ANSI_GREEN;
import static cs3500.pa02.views.StudySessionConsoleView.ANSI_RED;
import static cs3500.pa02.views.StudySessionConsoleView.ANSI_RESET;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.StringReader;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class for testing StudySessionController and its associated methods
 */
class StudySessionControllerTest {

  private Readable userTerminateInput;
  private Appendable userTerminateOutput;

  /**
   * Instantiates the test data
   */
  @BeforeEach
  public void setup() {
    userTerminateInput = new StringReader("""
        src/tests/resources/nonexistent.txt
        src/tests/resources/outputDirectory/
        src/tests/resources/outputDirectory/controllertest.sr
        -1
        h
        10
        e
        h
        a
        t
        """.replaceAll("\\n|\\r\\n", System.getProperty("line.separator")));
    userTerminateOutput = new StringBuilder();
  }

  /**
   * Tests the run method
   */
  @Test
  public void testRun() {
    new StudySessionController(userTerminateInput, userTerminateOutput).run();
    String terminateOutput = userTerminateOutput.toString();
    System.out.println(terminateOutput);
    Scanner sc = new Scanner(terminateOutput);
    String next = (ANSI_CYAN + "Welcome to Anki-Lite!" + ANSI_RESET);
    sc.nextLine();
    assertEquals(next, sc.nextLine());
    next = "To begin, input a valid .sr file to study from: "
        + ANSI_RED + "Please enter a valid path to a .sr file: " + ANSI_RESET
        + ANSI_RED + "Please enter a valid path to a .sr file: " + ANSI_RESET
        + "Hold tight! Generating and randomizing questions...";
    assertEquals(next, sc.nextLine());
    sc.nextLine();
    sc.nextLine();
    next = "Options: [" + ANSI_RED + "H" + ANSI_RESET + "] Set Hard ["
        + ANSI_GREEN + "E" + ANSI_RESET + "] Set Easy [" + ANSI_CYAN + "A" + ANSI_RESET
        + "] See Answer [" + ANSI_RED + "T" + ANSI_RESET + "] Terminate";
    assertEquals(next, sc.nextLine());
    next = "----------------------------------------------------------";
    assertEquals(next, sc.nextLine());
    next = ANSI_RED + "1. this is a test" + ANSI_RESET
        + " ----------------------------------------------------------";
    assertEquals(next, sc.nextLine());
    next = ANSI_GREEN + "2. this is a test" + ANSI_RESET
        + " ----------------------------------------------------------";
    assertEquals(next, sc.nextLine());
    next = ANSI_GREEN + "3. this is a test" + ANSI_RESET + " Answer:for the controller";
    assertEquals(next, sc.nextLine());
    sc.nextLine();
    next = "Great work! Here are your stats for this session: ";
    assertEquals(next, sc.nextLine());
    next = "You answered " + ANSI_CYAN + "3" + ANSI_RESET + " questions.";
    assertEquals(next, sc.nextLine());
    next = "1 questions went from " + ANSI_GREEN + "easy" + ANSI_RESET
        + " to " + ANSI_RED + "hard" + ANSI_RESET + ".";
    assertEquals(next, sc.nextLine());
    next = "1 questions went from " + ANSI_RED + "hard" + ANSI_RESET
        + " to " + ANSI_GREEN + "easy" + ANSI_RESET + ".";
    assertEquals(next, sc.nextLine());
    next = "There are now " + ANSI_RED + "1" + ANSI_RESET
        + " hard questions in the question bank.";
    assertEquals(next, sc.nextLine());
    next = "There are now " + ANSI_GREEN + "2" + ANSI_RESET
        + " easy questions in the question bank.";
    assertEquals(next, sc.nextLine());
    next = ANSI_CYAN + "Thanks for studying! Have a great day!" + ANSI_RESET;
    assertEquals(next, sc.nextLine());
    sc.close();
  }
}
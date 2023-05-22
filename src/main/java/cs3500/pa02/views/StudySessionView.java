package cs3500.pa02.views;

import cs3500.pa02.Difficulty;
import cs3500.pa02.questionutilities.Question;

/**
 * Class for displaying the view of the study session
 */
public class StudySessionView {

  // color constants for colored console output

  /**
   * ANSI escape code
   */
  public static final String ANSI_RESET = "\u001B[0m";
  /**
   * ANSI red color
   */
  public static final String ANSI_RED = "\u001B[31m";
  /**
   * ANSI green color
   */
  public static final String ANSI_GREEN = "\u001B[32m";
  /**
   * ANSI cyan color
   */
  public static final String ANSI_CYAN = "\u001B[36m";

  /**
   * Displays the welcome message
   */
  public void welcome() {
    System.out.println();
    System.out.println(ANSI_CYAN + "Welcome to Anki-Lite!" + ANSI_RESET);
    System.out.print("To begin, input a valid .sr file to study from: ");
  }

  /**
   * Message for beginning the session after initial input
   */
  public void begin() {
    System.out.println(ANSI_CYAN + "Great! Let's begin!" + ANSI_RESET);
    System.out.println();
  }

  /**
   * Prompt for when the user inputs an invalid path
   */
  public void invalidPath() {
    System.out.print(ANSI_RED + "Please enter a valid path to a .sr file: " + ANSI_RESET);
  }

  /**
   * Prompts the user for a valid number of questions
   */
  public void initialPrompt() {
    System.out.print("How many questions would you like to study? ");
  }

  /**
   *  Re-prompts the user if the input is not a valid number
   *
   * @param numQuestions the number of available questions
   */
  public void invalidNumberPrompt(int numQuestions) {
    System.out.print("There are " + ANSI_CYAN + numQuestions + ANSI_RESET + " questions to study. "
        + ANSI_RED + "Please enter a valid number of questions: " + ANSI_RESET);
  }

  /**
   * Prompt for generating and randomizing the questions
   */
  public void generated() {
    System.out.println("Hold tight! Generating and randomizing questions...");
  }

  /**
   * Displays the user's option for a question
   */
  public void options() {
    System.out.println("Options: ["
        + ANSI_RED + "H" + ANSI_RESET + "] Set Hard ["
        + ANSI_GREEN + "E" + ANSI_RESET + "] Set Easy ["
        + ANSI_CYAN + "A" + ANSI_RESET + "] See Answer ["
        + ANSI_RED + "T" + ANSI_RESET + "] Terminate");
  }

  /**
   * Displays the current question to the user
   *
   * @param question the question
   * @param currentQuestion the number of the current question
   */
  public void displayQuestion(Question question, int currentQuestion) {
    if (question.getDifficulty().equals(Difficulty.HARD)) {
      System.out.print(ANSI_RED + (currentQuestion + 1)
          + ". " + question.getQuestion() + ANSI_RESET + " ");
    } else {
      System.out.print(ANSI_GREEN + (currentQuestion + 1)
          + ". " + question.getQuestion() + ANSI_RESET + " ");
    }
  }

  /**
   * Displays a separator
   */
  public void separator() {
    System.out.println("----------------------------------------------------------");
  }

  /**
   * Displays the answer of the current question
   *
   * @param question the current question
   */
  public void answer(Question question) {
    System.out.println("Answer:" + question.getAnswer());
  }

  /**
   * Displays a custom message
   *
   * @param message a custom message to print
   */
  public void custom(String message) {
    System.out.print(message);
  }

  /**
   * Final display message
   */
  public void goodbye() {
    System.out.println(ANSI_CYAN + "Thanks for studying! Have a great day!" + ANSI_RESET);
  }

}

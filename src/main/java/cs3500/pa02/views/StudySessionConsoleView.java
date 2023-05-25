package cs3500.pa02.views;

import cs3500.pa02.Difficulty;
import cs3500.pa02.questionutilities.Question;
import java.io.IOException;

/**
 * Class for displaying the view of the study session
 */
public class StudySessionConsoleView implements StudySessionView {

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
  private final Appendable appendable;

  /**
   * Instantiates a StudySessionConsoleView
   *
   * @param appendable where to append the output
   */
  public StudySessionConsoleView(Appendable appendable) {
    this.appendable = appendable;
  }

  /**
   * Displays the welcome message
   */
  @Override
  public void welcome() {
    try {
      appendable.append(System.getProperty("line.separator"));
      appendable.append(ANSI_CYAN + "Welcome to Anki-Lite!" + ANSI_RESET);
      appendable.append(System.getProperty("line.separator"));
      appendable.append("To begin, input a valid .sr file to study from: ");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Message for beginning the session after initial input
   */
  @Override
  public void begin() {
    try {
      appendable.append(ANSI_CYAN + "Great! Let's begin!" + ANSI_RESET);
      appendable.append(System.getProperty("line.separator"));
      appendable.append(System.getProperty("line.separator"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Prompt for when the user inputs an invalid path
   */
  @Override
  public void invalidPath() {
    try {
      appendable.append(ANSI_RED + "Please enter a valid path to a .sr file: " + ANSI_RESET);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Prompts the user for a valid number of questions
   */
  @Override
  public void initialPrompt() {
    try {
      appendable.append("How many questions would you like to study? ");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   *  Re-prompts the user if the input is not a valid number
   *
   * @param numQuestions the number of available questions
   */
  @Override
  public void invalidNumberPrompt(int numQuestions) {
    try {
      appendable.append("There are " + ANSI_CYAN).append(String.valueOf(numQuestions))
          .append(ANSI_RESET).append(" questions to study. ").append(ANSI_RED)
          .append("Please enter a valid number of questions: ").append(ANSI_RESET);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Prompt for generating and randomizing the questions
   */
  @Override
  public void generated() {
    try {
      appendable.append("Hold tight! Generating and randomizing questions...");
      appendable.append(System.getProperty("line.separator"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Displays the user's option for a question
   */
  @Override
  public void options() {
    try {
      appendable.append("Options: ["
          + ANSI_RED + "H" + ANSI_RESET + "] Set Hard ["
          + ANSI_GREEN + "E" + ANSI_RESET + "] Set Easy ["
          + ANSI_CYAN + "A" + ANSI_RESET + "] See Answer ["
          + ANSI_RED + "T" + ANSI_RESET + "] Terminate");
      appendable.append(System.getProperty("line.separator"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Displays the current question to the user
   *
   * @param question the question
   * @param currentQuestion the number of the current question
   */
  @Override
  public void displayQuestion(Question question, int currentQuestion) {
    if (question.getDifficulty().equals(Difficulty.HARD)) {
      try {
        appendable.append(ANSI_RED).append(String.valueOf(currentQuestion + 1)).append(". ")
            .append(question.getQuestion()).append(ANSI_RESET).append(" ");
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    } else {
      try {
        appendable.append(ANSI_GREEN).append(String.valueOf(currentQuestion + 1)).append(". ")
            .append(question.getQuestion()).append(ANSI_RESET).append(" ");
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
  }

  /**
   * Displays a separator
   */
  public void separator() {
    try {
      appendable.append("----------------------------------------------------------");
      appendable.append(System.getProperty("line.separator"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Displays the answer of the current question
   *
   * @param question the current question
   */
  @Override
  public void answer(Question question) {
    try {
      appendable.append("Answer:").append(question.getAnswer());
      appendable.append(System.getProperty("line.separator"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Displays a custom message
   *
   * @param message a custom message to print
   */
  public void custom(String message) {
    try {
      appendable.append(message);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Final display message
   */
  @Override
  public void goodbye() {
    try {
      appendable.append(ANSI_CYAN + "Thanks for studying! Have a great day!" + ANSI_RESET);
      appendable.append(System.getProperty("line.separator"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}

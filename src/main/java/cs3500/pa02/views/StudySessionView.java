package cs3500.pa02.views;

import cs3500.pa02.questionutilities.Question;

/**
 * Class for displaying the view of the study session
 */
public class StudySessionView {

  /**
   * Displays the welcome message
   */
  public void welcome() {
    System.out.println();
    System.out.println("Welcome to Anki-Lite!");
    System.out.print("To begin, input a valid .sr file to study from: ");
  }

  /**
   * Message for beginning the session after initial input
   */
  public void begin() {
    System.out.println("Great! Let's begin!");
    System.out.println();
  }

  /**
   * Prompt for when the user inputs an invalid path
   */
  public void invalidPath() {
    System.out.print("Please enter a valid path to a .sr file: ");
  }

  /**
   * Prompts the user for a valid number of questions
   */
  public void initialPrompt() {
    System.out.print("How many questions would you like to study? ");
  }

  /**
   *  Re-prompts the user if the input is not a valid number
   */
  public void invalidNumberPrompt(int numQuestions) {
    System.out.print("There are " + numQuestions + " questions to study. "
        + "Please enter a valid number of questions: ");
  }

  /**
   * Prompt for generating and randomizing the questions
   */
  public void generating() {
    System.out.println("Hold tight! Generating and randomizing questions...");
  }

  /**
   * Displays the user's option for a question
   */
  public void options() {
    System.out.println("Options: H to set hard, E to set easy, A to see answer, T to terminate.");
  }

  /**
   * Displays the current question to the user
   */
  public void displayQuestion(Question question, int currentQuestion) {
    System.out.print(currentQuestion + ". " + question.getQuestion() + " ");
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
   * Displays the user stats
   */
  public void stats(int questionsAnswered, int easyToHard, int hardToEasy,
                    int totalHard, int totalEasy) {
    System.out.println();
    System.out.println("Great work! Here are your stats for this session: ");
    System.out.println("You answered " + questionsAnswered + " questions.");
    System.out.println(easyToHard + " questions went from easy to hard.");
    System.out.println(hardToEasy + " questions went from hard to easy.");
    System.out.println("There are now " + totalHard + " hard questions in the question bank.");
    System.out.println("There are now " + totalEasy + " easy questions in the question bank.");
  }

  /**
   * Final display message
   */
  public void goodbye() {
    System.out.println("Thanks for studying! Have a great day!");
  }

}

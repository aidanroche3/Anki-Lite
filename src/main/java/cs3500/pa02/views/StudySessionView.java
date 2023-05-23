package cs3500.pa02.views;

import cs3500.pa02.questionutilities.Question;

/**
 * Interface for displaying a study session
 */
public interface StudySessionView {

  /**
   * Welcomes the user
   */
  void welcome();

  /**
   * Signals the beginning of the session
   */
  void begin();

  /**
   * Signals an invalid path has been entered
   */
  void invalidPath();

  /**
   * Prompts the user for a number of questions to study
   */
  void initialPrompt();

  /**
   * Re-prompts the user if the number of questions entered is invalid
   *
   * @param numQuestions the number of available questions
   */
  void invalidNumberPrompt(int numQuestions);

  /**
   * Signals that the questions have been generated from the file
   */
  void generated();

  /**
   * Displays the options to the user
   */
  void options();

  /**
   * Displays the current question to the user
   *
   * @param question the question to display
   * @param currentQuestion the current question the user is on
   */
  void displayQuestion(Question question, int currentQuestion);

  /**
   * Displays the answer to the current question to the user
   *
   * @param question the current question to display the answer of
   */
  void answer(Question question);

  /**
   * Signals the end of the program
   */
  void goodbye();

}

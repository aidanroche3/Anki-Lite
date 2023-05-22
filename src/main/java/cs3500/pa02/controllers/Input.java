package cs3500.pa02.controllers;

/**
 * Enum for representing different user inputs
 */
public enum Input {
  /**
   * The user wants to set the questions to hard
   */
  Hard,

  /**
   * The user wants to set the question to easy
   */
  Easy,

  /**
   * The user wants to see the answer
   */
  Answer,

  /**
   * The user wants to terminate the program
   */
  Terminate,

  /**
   * The user's input is invalid
   */
  Invalid;

  /**
   * Takes a string and returns the input type
   *
   * @param input a String of the user's input
   * @return an Input representing the user's input
   */
  public static Input getInput(String input) {
    switch (input.toLowerCase()) {
      case "h" -> {
        return Input.Hard;
      }
      case "e" -> {
        return Input.Easy;
      }
      case "a" -> {
        return Input.Answer;
      }
      case "t" -> {
        return Input.Terminate;
      }
      default -> {
        return Input.Invalid;
      }
    }
  }
}

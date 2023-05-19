package cs3500.pa02;

/**
 * Represents the difficulty of a question
 */
public enum Difficulty {
  /**
   * Easy question difficulty
   */
  EASY,
  /**
   * Hard question difficulty
   */
  HARD;

  /**
   * Determines the difficulty based on the given string
   *
   * @param difficulty a String representing a difficulty
   * @return the difficulty
   */
  public static Difficulty determineDifficulty(String difficulty) {
    switch (difficulty.toLowerCase()) {
      case "hard" -> {
        return Difficulty.HARD;
      }
      case "easy" -> {
        return Difficulty.EASY;
      }
      default -> throw new IllegalArgumentException("Not a valid difficulty");
    }
  }
}

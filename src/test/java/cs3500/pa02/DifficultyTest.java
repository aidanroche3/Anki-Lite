package cs3500.pa02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Class for testing Difficulty and its associated methods
 */
class DifficultyTest {

  /**
   * Tests the determineDifficulty method
   */
  @Test
  public void testDetermineDifficulty() {
    assertEquals(Difficulty.HARD, Difficulty.determineDifficulty("Hard"));
    assertEquals(Difficulty.HARD, Difficulty.determineDifficulty("HARD"));
    assertEquals(Difficulty.HARD, Difficulty.determineDifficulty("hard"));
    assertEquals(Difficulty.EASY, Difficulty.determineDifficulty("Easy"));
    assertEquals(Difficulty.EASY, Difficulty.determineDifficulty("EASY"));
    assertEquals(Difficulty.EASY, Difficulty.determineDifficulty("easy"));
    assertThrows(IllegalArgumentException.class, () -> Difficulty.determineDifficulty("Medium"));
  }

}
package cs3500.pa02.comparators;

import cs3500.pa02.questionutilities.Question;
import java.util.Comparator;

/**
 * Class for comparing questions based on their difficulty, with hard questions coming first
 */
public class CompareByDifficulty implements Comparator<Question> {

  /**
   * Compares two Questions based on their difficulty
   *
   * @param one the first object to be compared.
   * @param two the second object to be compared.
   * @return -1 if one is hard, 0 if both are easy difficulty, and 1 if two is hard
   */
  @Override
  public int compare(Question one, Question two) {
    if (one.isHard()) {
      return -1;
    }
    if (two.isHard()) {
      return 1;
    }
    return 0;
  }

}

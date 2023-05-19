package cs3500.pa02.questionutilities;

import cs3500.pa02.comparators.CompareByDifficulty;
import java.util.ArrayList;

/**
 * Class for randomizing a list of questions
 */
public class RandomizeQuestions {

  private final ArrayList<Question> questions;

  /**
   * Initializes a RandomizeQuestions
   *
   * @param questions the list of questions to be randomized
   */
  public RandomizeQuestions(ArrayList<Question> questions) {
    this.questions = questions;
  }

  /**
   * Randomizes the list of questions, with all hard questions being sorted first
   *
   * @return the current list of questions randomized
   */
  public ArrayList<Question> getRandomizedQuestions() {
    questions.sort(new CompareByDifficulty());
    return questions;
  }

}

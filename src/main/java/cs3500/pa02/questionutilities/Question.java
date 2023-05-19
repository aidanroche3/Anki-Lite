package cs3500.pa02.questionutilities;

import cs3500.pa02.Difficulty;

/**
 * Represents a question and answer
 */
public class Question {

  private final String question;
  private final String answer;
  private Difficulty difficulty;

  /**
   * Initializes a question with an answer and difficulty
   *
   * @param question the question
   * @param answer the answer
   * @param difficulty the difficulty
   */
  public Question(String question, String answer, Difficulty difficulty) {
    this.question = question;
    this.answer = answer;
    this.difficulty = difficulty;
  }

  /**
   * Gets the question of a question
   */
  public String getQuestion() {
    return this.question;
  }

  /**
   * Gets the answer of a question
   */
  public String getAnswer() {
    return this.answer;
  }

  /**
   * Gets the difficulty of a question
   *
   * @return the difficulty
   */
  public Difficulty getDifficulty() {
    return this.difficulty;
  }

  /**
   * Sets the difficulty of a question
   *
   * @param difficulty the difficulty
   */
  public void setDifficulty(Difficulty difficulty) {
    this.difficulty = difficulty;
  }

  /**
   * Returns if the question is hard
   *
   * @return if difficulty is hard
   */
  public boolean isHard() {
    return this.difficulty.equals(Difficulty.HARD);
  }

  /**
   * Returns the question as a string
   *
   * @return the question to a string
   */
  @Override
  public String toString() {
    return "[Q]" + this.question + "[A]" + this.answer + "[D]" + this.difficulty;
  }

  /**
   * Compares two Questions for equality
   */
  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Question other)) {
      return false;
    }
    return this.question.equals(other.question)
        && this.answer.equals(other.answer)
        && this.difficulty.equals(other.difficulty);
  }

  /**
   * Computes a hashcode for this Question
   */
  @Override
  public int hashCode() {
    return this.question.hashCode() + this.answer.hashCode() + this.difficulty.hashCode();
  }

}

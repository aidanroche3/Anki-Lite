package cs3500.pa02.questionutilities;

import cs3500.pa02.Difficulty;

/**
 * Abstract class for testing question utility classes
 */
public abstract class QuestionUtilitiesTest {

  protected Question arraysOne = new Question("Where are arrays stored in memory?",
      "the heap", Difficulty.HARD);
  protected Question arraysTwo = new Question("T/F Arrays can hold multiple data types",
      "false", Difficulty.HARD);
  protected Question test = new Question("This is a test question",
      "answer", Difficulty.HARD);
  protected Question vector = new Question("Which method can resize a vector?",
      "setSize(int size)", Difficulty.HARD);

}

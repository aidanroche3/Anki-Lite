package cs3500.pa02.fileformatters;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class QuestionAndAnswerTest extends FileFormattersTest {

  @Test
  public void testExtract() {
    String formatted = """
        [Q]T/F An array can contain multiple types[A]false[D]HARD
        [Q]T/F An array's size can be changed[A]false[D]HARD
        [Q]How do you initialize an integer array in Java?[A]int[] = {..., ..., ...};[D]HARD
        [Q] Testing extra edge cases: [A] answer with ::[D]HARD
        [Q] Testing on new line[A] answer is split up[D]HARD
        """;
    assertEquals(formatted, new QuestionAndAnswer(arraysAndTest).extract());
  }

}
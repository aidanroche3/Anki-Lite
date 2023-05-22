package cs3500.pa02.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Class for testing Input and its associated methods
 */
class InputTest {

  /**
   * Tests the getInput method
   */
  @Test
  public void testGetInput() {
    assertEquals(Input.Hard, Input.getInput("h"));
    assertEquals(Input.Easy, Input.getInput("E"));
    assertEquals(Input.Answer, Input.getInput("a"));
    assertEquals(Input.Terminate, Input.getInput("T"));
    assertEquals(Input.Invalid, Input.getInput("hello"));
  }

}
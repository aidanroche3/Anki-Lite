package cs3500.pa02.controllers;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class for testing StudySessionController and its associated methods
 */
class StudySessionControllerTest {

  private InputStream sysIn;
  private ByteArrayInputStream userTerminate;
  private ByteArrayInputStream naturalTerminate;

  /**
   * Instantiates the test data
   */
  @BeforeEach
  public void setup() {
    sysIn = System.in;
    userTerminate = new ByteArrayInputStream("""
        src/tests/resources/nonexistent.txt
        src/tests/resources/outputDirectory/
        src/manyquestions.sr
        -1
        h
        10
        h
        H
        E
        A
        e
        h
        a
        a
        t
        """.replaceAll("\\n|\\r\\n", System.getProperty("line.separator")).getBytes());
    naturalTerminate = new ByteArrayInputStream("""
        src/manyquestions.sr
        6
        h
        h
        e
        a
        e
        h
        """.replaceAll("\\n|\\r\\n", System.getProperty("line.separator")).getBytes());
  }

  /**
   * Tests the run method
   */
  @Test
  public void testRun() {
    System.setIn(userTerminate);
    assertDoesNotThrow(() -> new StudySessionController().run());
    System.setIn(naturalTerminate);
    assertDoesNotThrow(() -> new StudySessionController().run());
  }

  /**
   * Restores the stream
   */
  @AfterEach
  public void restore() {
    System.setIn(sysIn);
  }

}
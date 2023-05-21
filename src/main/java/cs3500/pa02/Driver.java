package cs3500.pa02;

import cs3500.pa02.controllers.StudyGuideController;
import cs3500.pa02.controllers.StudySessionController;

/**
 * This is the main driver of this project.
 */
public class Driver {

  private static Mode mode;

  /**
   * Project entry point
   *
   * @param args user is required to provide a root path directory, order flag to sort the files,
   *             and an output path to write the summary
   *             Example: "src/tests/resources/notes-root
   *             filename src/tests/resources/outputDirectory/summary.md"
   */
  public static void main(String[] args) {
    // validating that the arguments passed in are valid
    determineMode(args);

    // initiates the correct mode
    switch (mode) {
      case STUDYGUIDE -> new StudyGuideController(args).run();
      case STUDYSESSION -> new StudySessionController().run();
      default -> throw new IllegalArgumentException("Invalid mode.");
    }
  }

  /**
   * Determines which mode the program is in
   *
   * @param args the arguments provided by the user
   */
  private static void determineMode(String[] args) {
    if (args.length == 3) {
      Driver.mode = Mode.STUDYGUIDE;
    } else if (args.length == 0) {
      Driver.mode = Mode.STUDYSESSION;
    } else {
      throw new IllegalArgumentException("Please provide valid root path, "
          + "order flag, and output path for study guide or zero arguments for study session.");
    }
  }
}
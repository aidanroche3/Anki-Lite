package cs3500.pa02;

import cs3500.pa02.controllers.StudyGuideController;
import cs3500.pa02.controllers.StudySessionController;

/**
 * This is the main driver of this project.
 */
public class Driver {

  /**
   * Project entry point
   *
   * @param args user is required to provide a root path directory, order flag to sort the files,
   *             and an output path to write the summary
   *             Example: "src/tests/resources/notes-root
   *             filename src/tests/resources/outputDirectory/summary.md"
   *             or, if there are zero arguments the program initiates a study session
   */
  public static void main(String[] args) {
    // initiates the correct mode
    switch (args.length) {
      case 3 -> new StudyGuideController(args).run();
      case 0 -> new StudySessionController().run();
      default -> throw new IllegalArgumentException("Please provide valid root path, "
          + "order flag, and output path for study guide or zero arguments for study session.");
    }
  }
}
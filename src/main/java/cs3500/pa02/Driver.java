package cs3500.pa02;

import cs3500.pa02.controllers.StudyGuideController;
import cs3500.pa02.controllers.StudySessionController;
import java.nio.file.Path;

/**
 * This is the main driver of this project.
 */
public class Driver {

  private static Mode mode;
  private static Path rootPath;
  private static String orderFlag;
  private static Path outputPath;

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
    validateArgs(args);

    // initiates the correct mode
    switch (mode) {
      case STUDYGUIDE -> new StudyGuideController(rootPath, orderFlag, outputPath).run();
      case STUDYSESSION -> new StudySessionController().run();
      default -> throw new IllegalArgumentException("Invalid mode.");
    }
  }

  /**
   * Initializes the fields of main, checking that the order flag is valid
   *
   * @param args the arguments provided by the user
   */
  private static void validateArgs(String[] args) {

    if (args.length == 3) {

      // sets the mode
      Driver.mode = Mode.STUDYGUIDE;

      // sets the root path, validity will be checked at runtime
      Driver.rootPath = Path.of(args[0]);

      // validates the order flag
      if (args[1].equals("filename") || args[1].equals("created") || args[1].equals("modified")) {
        Driver.orderFlag = args[1];
      } else {
        throw new IllegalArgumentException("Invalid order flag.");
      }

      // sets the output path, validity will be checked at runtime
      Driver.outputPath = Path.of(args[2]);

    } else if (args.length == 0) {

      // sets the mode
      Driver.mode = Mode.STUDYSESSION;

    } else {
      throw new IllegalArgumentException("Please provide valid root path, "
          + "order flag, and output path for study guide or zero arguments for study session.");
    }
  }
}
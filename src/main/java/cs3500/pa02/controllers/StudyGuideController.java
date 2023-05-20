package cs3500.pa02.controllers;

import cs3500.pa02.fileformatters.QuestionAndAnswer;
import cs3500.pa02.fileformatters.StudyGuide;
import cs3500.pa02.fileutilities.CombineFiles;
import cs3500.pa02.fileutilities.FileListSorter;
import cs3500.pa02.fileutilities.FileTypeVisitor;
import cs3500.pa02.fileutilities.MarkDownFile;
import cs3500.pa02.fileutilities.WriteFilesToPath;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller for controlling a study guide
 */
public class StudyGuideController implements Controller {

  private final Path rootPath;
  private final String orderFlag;
  private final Path outputPath;

  /**
   * Initiates a study guide controller
   *
   * @param rootPath the root path to create a study guide from
   * @param orderFlag the order flag to sort the guide
   * @param outputPath the output path to write the guide at
   */
  public StudyGuideController(Path rootPath, String orderFlag, Path outputPath) {
    this.rootPath = rootPath;
    this.orderFlag = orderFlag;
    this.outputPath = outputPath;
  }

  /**
   * Initiates the study guide
   */
  public void run() {
    // initializing a list of valid types of files for the visitor to "collect"
    ArrayList<String> validTypes = new ArrayList<>(List.of(".md"));
    // initializing the file visitor
    FileTypeVisitor fileVisitor = new FileTypeVisitor(validTypes);
    // visiting every file in the root path with the file visitor
    try {
      Files.walkFileTree(rootPath, fileVisitor);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    // initializing a list of files from the visitor
    ArrayList<File> files = fileVisitor.getFiles();
    // converting the list of files into a list of markdown files
    ArrayList<MarkDownFile> mdFiles = MarkDownFile.listToMarkDownFiles(files);
    // sorting the list of markdown files based on the order flag
    FileListSorter fileSorter = new FileListSorter(mdFiles, orderFlag);
    // initializing a list of markdown files from the sorted list
    ArrayList<MarkDownFile> sortedMdFiles = fileSorter.getSortedList();
    // converting the list of markdown files to a list of files
    ArrayList<File> sortedFiles = MarkDownFile.listToFiles(sortedMdFiles);
    // initializing a new combine  files with the sorted list of files
    CombineFiles filerCombiner = new CombineFiles(sortedFiles);
    // initializing a String of the content of the sorted list of files
    String combinedFiles = filerCombiner.getCombinedFiles();
    // initializing a new study guide with the String of combined content
    StudyGuide studyGuide = new StudyGuide(combinedFiles);
    // initializing a String of the summarized content from the combined content
    String formattedFiles = studyGuide.summarizeContent();
    // initializing a new question and answer with the String of combined content
    QuestionAndAnswer questions = new QuestionAndAnswer(combinedFiles);
    // initializing a String of the extracted questions from the combined content
    String questionsAndAnswer = questions.extractQuestions();
    // initializing a new write files to path
    WriteFilesToPath fileWriter = new WriteFilesToPath();
    // writing the summarized content at the output path
    String mdOutput = outputPath.toString();
    if (mdOutput.endsWith(".md")) {
      String srOutput = mdOutput.substring(0, mdOutput.length() - 3) + ".sr";
      Path srPath = Path.of(srOutput);
      try {
        fileWriter.writeAtPath(outputPath, formattedFiles);
        fileWriter.writeAtPath(srPath, questionsAndAnswer);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
      System.out.println("Successfully summarized files of " + rootPath + " at " + outputPath);
    } else {
      throw new IllegalArgumentException("Output path is not a .md file.");
    }
  }

}

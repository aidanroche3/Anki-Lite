package cs3500.pa02.controllers;

/**
 * Enumeration for representing the states of a controller
 */
public enum State {
  /**
   * Initial input phase of the controller
   */
  InitialInputPhase,

  /**
   * User input phase of the controller
   */
  UserInputPhase,

  /**
   * Generating questions phase
   */
  GenerateQuestion,

  /**
   * StudySession phase
   */
  StudySession,

  /**
   * Stats phase
   */
  Stats

}

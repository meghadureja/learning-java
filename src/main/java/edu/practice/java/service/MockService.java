package edu.practice.java.service;

public class MockService {

  /**
   * service api call
   * @param param
   * @return
   */
  public String mockMethod(String param) {
    String mockString = "Hello " + param;
    return mockString;
  }

}

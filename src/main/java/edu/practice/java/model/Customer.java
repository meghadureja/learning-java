package edu.practice.java.model;

public class Customer {
  private String name;
  private int points;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPoints() {
    return points;
  }

  public void setPoints(int points) {
    this.points = points;
  }

  public Customer(String name, int points) {
    this.name = name;
    this.points = points;
  }

  public boolean hasOverHundredPoints() {
    return this.points > 100;
  }

//  public boolean hasValidPoints(int x) throws Exception {
//    if (x == 0) {
//      throw new Exception();
//    }
//    return this.points > x;
//  }

  public boolean hasValidPoints() throws Exception {
    throw new Exception();
  }
}

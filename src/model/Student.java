package model;

import helper.InputException;
import model.base.Person;

public class Student extends Person implements TimestampInterface {

  private final String id;

  // STATIC COUNTER
  private static int counter = 0;

  public static int getCounter() {
    return counter;
  }

  // Unique ID setter
  private String generateId() {
    return "STUD_" + generateTimestamp() + getCounter();
  }

  // CONSTRUCTOR
  public Student(String name, String surname) throws InputException {
    super(name, surname);
    this.id = generateId();
    counter++;
  }

  // GETTERS (name and surname getters are inheritted)
  public String getStudID() {
    return id;
  }

  // toString and equals
  @Override
  public String toString() {
    return "Stud_ID: " + id + " --> " + getName() + " " + getSurname();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || !(obj instanceof Student)) {
      return false;
    }
    return id == ((Student) obj).getStudID();
  }

  // Additional features
  public void showFullInfo() {
    System.out.println("=== STUDENT's FULL INFO ===");
    System.out.println("STUDENT_ID: " + getStudID());
    System.out.println("NAME: " + getName());
    System.out.println("SURNAME: " + getSurname());
    System.out.println("======");
  }
}
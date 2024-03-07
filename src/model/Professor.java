package model;

import helper.InputException;
import model.base.Person;
import helper.Degree;

public class Professor extends Person implements TimestampInterface {

  private final String id;
  private Degree degree;

  // STATIC COUNTER
  private static int counter = 0;

  public static int getCounter() {
    return counter;
  }

  // Unique ID setter
  private String generateId() {
    return "PROF_" + generateTimestamp() + getCounter();
  }

  // CONSTRUCTOR
  public Professor(String name, String surname, Degree degree) throws InputException {
    super(name, surname);
    this.id = generateId();
    this.degree = degree;
    counter++;
  }

  // GETTERS (name and surname getters are inheritted)
  public String getProfID() {
    return id;
  }

  public Degree getDegree() {
    return degree;
  }

  // SETTERS (name and surname inheritted)
  public void setDegree(Degree degree) {
    this.degree = degree;
  }

  // toString and equals
  @Override
  public String toString() {
    return "Prof_ID: " + id + " --> " + getName() + " " + getSurname();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || !(obj instanceof Professor)) {
      return false;
    }
    return id == ((Professor) obj).getProfID();
  }

  // Additional features
  public void showFullInfo() {
    System.out.println("=== PROFESSOR's FULL INFO ===");
    System.out.println("PROFESSOR_ID: " + getProfID());
    System.out.println("NAME: " + getName());
    System.out.println("SURNAME: " + getSurname());
    System.out.println("DEGREE: " + getDegree());
    System.out.println("======");
  }
}

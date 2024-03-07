package model;

import helper.InputException;

public class Course implements TimestampInterface {
  private final String id;
  private String title;
  private int creditPoints;
  private Professor professor;

  private static int counter = 0;

  // instead of setId because final field "id" is to be explictly initialised in
  // the constructor
  // the return value of this method to be assigned to "this.id"
  private String generateId() {
    return "COURS_" + generateTimestamp() + counter;
  }

  // OTHER SETTERS
  public void setTitle(String title) throws InputException {
    if (title == null) {
      throw new InputException("Course title cannot be null");
    }
    if (!title.matches("[A-Z][A-Za-z]{3,}( [A-Z][a-z]+)?( [1-9]{1})?")) {
      throw new InputException("Course title does not match the pattern --> [A-Za-z ]+([1-9]{1-2})?");
    }
    this.title = title;
  }

  public void setCreditPoints(int creditPoints) throws InputException {
    if (creditPoints < 1 || creditPoints > 4) {
      throw new InputException("Credit points out of range [0, 4]");
    }
    this.creditPoints = creditPoints;
  }

  public void setProfessor(Professor professor) throws InputException {
    if (professor == null) {
      throw new InputException("Professor object cannot be null");
    }
    this.professor = professor;
  }

  // CONSTRUCTOR
  public Course(String title, int creditPoints, Professor professor) throws InputException {
    this.id = generateId();
    setTitle(title);
    setCreditPoints(creditPoints);
    setProfessor(professor);
    counter++;
  }

  // GETTERS
  public String getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public int getCreditPoints() {
    return creditPoints;
  }

  public Professor getProfessor() {
    return professor;
  }

  // toString and equals
  @Override
  public String toString() {
    return id + ": " + title + " taught by " + professor.getName() + professor.getSurname();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || !(obj instanceof Course)) {
      return false;
    }
    /*
     * To avoid bugs, for this programm, we will consider the course to be the
     * same if the titles are the same... We want to avoid copies.
     */
    return ((Course) obj).getTitle() == title;
  }
}
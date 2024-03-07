package model;

import helper.InputException;

public class Grade implements TimestampInterface {
  private final String id;
  private int value;
  private Student student;
  private Course course;

  private static int counter = 0;

  // instead of setId because final field "id" is to be explictly initialised in
  // the constructor
  // the return value of this method to be assigned to "this.id"
  private String generateId() {
    return "GRAD_" + generateTimestamp() + counter;
  }

  // SETTERS
  public void setValue(int value) throws InputException {
    if (value < 1 || value > 10) {
      throw new InputException("Grade value out of range [1, 10]");
    }
    this.value = value;
  }

  public void setStudent(Student student) throws InputException {
    if (student == null) {
      throw new InputException("Student object cannot be null");
    }
    this.student = student;
  }

  public void setCourse(Course course) throws InputException {
    if (course == null) {
      throw new InputException("Course object cannot be null");
    }
    this.course = course;
  }

  // CONSTRUCTOR
  public Grade(int value, Student student, Course course) throws InputException {
    this.id = generateId();
    setValue(value);
    setStudent(student);
    setCourse(course);
    counter++;
  }

  // GETTERS
  public String getId() {
    return id;
  }

  public int getValue() {
    return value;
  }

  public Student getStudent() {
    return student;
  }

  public Course getCourse() {
    return course;
  }

  // toString and equals
  @Override
  public String toString() {
    return id + ": " + value + " given to " + student.getName() + " in " + course.getTitle();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || !(obj instanceof Grade)) {
      return false;
    }

    /*
     * There should be no duplicate grades object with the same fields of:
     * STUDENT and COURSE
     * since for course the specific student should only be graded once. If the is a
     * need for a value to be changed, it can be done directly on the object
     */
    return ((Grade) obj).getStudent().equals(student) && ((Grade) obj).getCourse().equals(course);
  }
}
package model.base;

import helper.InputException;
// import java.time.*;
// import java.time.format.DateTimeFormatter;

public class Person {
  private String name;
  private String surname;

  // GETTERS
  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  // CHECKER
  private boolean isNameFormat(String input) {
    return input.matches("[A-Z]{1}[a-z]+( [A-Z]{1}[a-z]*)?");
  }

  // SETTERS
  public void setName(String name) throws InputException {
    if (!isNameFormat(name))
      throw new InputException("Name input does not match the name pattern --> [A-Z]{1}[a-z]+( [A-Z]{1}[a-z]*)?");
    this.name = name;
  }

  public void setSurname(String surname) throws InputException {
    if (!isNameFormat(name))
      throw new InputException("Surname input does not match the name pattern --> [A-Z]{1}[a-z]+( [A-Z]{1}[a-z]*)?");
    this.surname = surname;
  }

  // CONSTRUCTOR
  protected Person(String name, String surname) throws InputException {
    setName(name);
    setSurname(surname);
  }
}

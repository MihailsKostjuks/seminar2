package service;

import java.util.ArrayList;

import helper.Degree;
import helper.InputException;
import model.*;
import model.base.Person;

public class App {
  private static ArrayList<Grade> grades = new ArrayList<>();
  private static Professor profOne, profTwo;
  private static Course courseOne, courseTwo;
  private static Student studOne, studTwo;
  private static ArrayList<Person> people = new ArrayList<>();
  private static ArrayList<Student> allStudents = new ArrayList<Student>();

  public static void main(String[] argv) throws InputException {
    initObjects();
    Grade grOne = new Grade(7, studOne, courseOne);
    Grade grTwo = new Grade(8, studOne, courseTwo);
    Grade grThree = new Grade(9, studTwo, courseOne);
    Grade grFour = new Grade(9, studTwo, courseTwo);
    addGrade(grOne);
    addGrade(grTwo);
    addGrade(grThree);
    addGrade(grFour);
    System.out.println("=============================================================================");
    printAllGrades();
    System.out.println("Testing the expected rejected addition of the new grade in the list..");
    Grade grFive = new Grade(3, studTwo, courseTwo);
    addGrade(grFive);
    System.out.println("=============================================================================");
    System.out.println("Testing the polymorphist via the array of people (students and professors): ");
    people.add(profOne);
    people.add(studOne);
    people.add(profTwo);
    people.add(studTwo);

    allStudents.add(studOne);
    allStudents.add(studTwo);
    for (Person p : people) {
      System.out.println(p);
    }
    System.out.println("======= TESTING CALC BY STUDENT =======");
    System.out.println("Deniss's AVG grade ---> " + calcAvg(studOne));
    System.out.println("Misha's AVG grade ---> " + calcAvg(studTwo));

    System.out.println("======= TESTING CALC BY COURSE =======");
    System.out.println("Deniss's AVG grade ---> " + calcAvg(courseOne));
    System.out.println("Misha's AVG grade ---> " + calcAvg(courseTwo));

    System.out.println("======= TESTING TAUGHT BY PROFESSOR =======");
    System.out.println("Taught by profOne ---> " + taughtBy(profOne));
  }

  private static int taughtBy(Professor p) {
    ArrayList<Course> uniqCourses = new ArrayList<>();
    int total = 0;
    for (Grade g : grades) {
      if (g.getCourse().getProfessor().equals(p) && !uniqCourses.contains(g.getCourse())) {
        total++;
        uniqCourses.add(courseOne);
      }
    }
    return total;
  }

  private static double calcAvg(Student st) {
    double sum = 0;
    int total = 0;

    for (Grade g : grades) {
      if (g.getStudent().equals(st)) {
        sum += g.getValue();
        total++;
      }
    }

    return (total != 0) ? (sum / total) : 0;
  }

  private static double calcAvg(Course c) {
    double sum = 0;
    int total = 0;

    for (Grade g : grades) {
      if (g.getCourse().equals(c)) {
        sum += g.getValue();
        total++;
      }
    }

    return (total != 0) ? (sum / total) : 0;
  }

  private static void initObjects() throws InputException {
    try {
      profOne = new Professor("Jack", "One", Degree.POSTDOCTORAL);
      profTwo = new Professor("Peter", "Two", Degree.PROFESSIONAL);
      //
      courseOne = new Course("JAVA", 4, profOne);
      courseTwo = new Course("Math Analysis 2", 2, profTwo);
      //
      studOne = new Student("Deniss", "Solovjovs");
      studTwo = new Student("Mihails", "Kostjuks");
    } catch (InputException e) {
      System.out.println(e);
      throw e;
    }
    System.out.println("There are 2 professors: ");
    System.out.println(profOne);
    System.out.println(profTwo);

    System.out.println("There are 2 courses: ");
    System.out.println(courseOne);
    System.out.println(courseTwo);

    System.out.println("And there are 2 students: ");
    System.out.println(studOne);
    System.out.println(studTwo);
  }

  private static void addGrade(Grade newGrade) {
    for (Grade grade : grades) {
      if (grade.equals(newGrade)) {
        Student student = newGrade.getStudent();
        String fullName = student.getName() + student.getSurname();

        System.out.println(
            fullName + " already has a grade for " + newGrade.getCourse().getTitle() + " in the list of grades.");
        System.out.println("Edit the existing grade ---> " + grade.getId());
        return;
      }
    }
    grades.add(newGrade);
  }

  private static void printAllGrades() {
    for (Grade g : grades) {
      System.out.println(g);
    }
  }

  // CRUD

  // create
  public static void createStudent(String name, String surname) throws Exception {
    if (name == null || surname == null) {
      throw new Exception("Empty parameters");
    }
    for (Student student: allStudents) {
      if (student.getName().equals(name) && student.getSurname().equals(surname)) {
        throw new Exception("Student already exists");

      }
    }
    Student student = new Student(name, surname);
    allStudents.add(student);
  }

  public static Student retrieveStudentBySurname(String surname) throws Exception {
    if (surname == null) throw new Exception("Empty surname");

    for(Student student: allStudents) {
      if (student.getSurname().equals(surname)) {
        return student;
      }
    }
    throw new Exception("Student not found");
  }

  public static void updateStudentSurname(String name, String surname, String newSurname) throws Exception {
    if (name == null || surname == null) {
      throw new Exception("Empty parameters");
    }

    for(Student student: allStudents) {
      if (student.getName().equals(name) && student.getSurname().equals(surname)) {
        student.setSurname(newSurname);
        return;
      }
    }

    throw new Exception("Student not found");
  }

  public static void deleteStudent(String name, String surname) throws Exception {
    if (name == null || surname == null) {
      throw new Exception("Empty parameters");
    }

    for(Student student: allStudents) {
      if (student.getName().equals(name) && student.getSurname().equals(surname)) {
        allStudents.remove(student);
        return;
      }
    }

    throw new Exception("Student not found");
  }

  public static ArrayList<Student> sortStudentsByAvgGrade() {
    ArrayList<Student> result = new ArrayList<Student>();

    for (Student student: allStudents) {
      try {
        calcAvg(student);
        result.add(student);
      } catch (Exception e) {
        System.out.println(e);
      }
    }

    for (int i = 0; i < result.size(); i++) {
      for (int j = 0; j < result.size(); j++) {

      }
    }

    return result;
  }

}

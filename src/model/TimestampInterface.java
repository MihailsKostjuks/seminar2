package model;

import java.time.*;
import java.time.format.DateTimeFormatter;

/*
timestamp's generator method to be implemented by the classes requiring a unique ID (Student, Professor, Grade, Course)
For examle, for class Professor to be implemented:
prof_ID = "PROF_" + **here goes thetimestamp**

Initially, thought that this could be a part of the Person (parent) class, but then since 
Grade and Course will need as well --> decided to implement a separate interface.
*/
public interface TimestampInterface {
  default String generateTimestamp() {
    var currentTime = LocalDateTime.now();
    var pattern = DateTimeFormatter.ofPattern("yyyyMMddHHmmssns");
    return currentTime.format(pattern).toString();
  }
}

package helper;

public class InputException extends Exception {
  public InputException(String message) {
    super("Object not initialised due to wrong input: " + message);
  }
}

package me.wonwoo.exception;

/**
 * Created by wonwoolee on 2017. 5. 16..
 */
public class NotFoundException extends RuntimeException {

  private final String message;

  public NotFoundException(String message) {
    this.message = message;
  }
}

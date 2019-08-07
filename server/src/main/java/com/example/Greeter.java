package com.example;

/**
 * This is a class.
 */
public class Greeter {

  /**
   * This is a constructor.
   */
  public Greeter() {

  }

  /**
  * @param someone with the name of the person
  * @returns string value with Hello prepended	
  */	
  public final String greet(final String someone) {
    return String.format("Hello, %s!", someone);
  }
}

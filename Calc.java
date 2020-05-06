package hw4;

import static java.lang.Character.isDigit;
import static java.lang.Integer.parseInt;

import exceptions.EmptyException;
import java.util.Scanner;
import java.util.Stack;

/**
 * A program for an RPN calculator that uses a stack.
 */
public final class Calc {

  /**
   * For each user input, add integers/operators/terminate/or
   * do other things accordingly.
   * @param s the string to be operated and potentially adding
   *          to the stack.
   * @param stack the stack that stores all integers.
   */
  private static void doSth(String s, Stack<Integer> stack) {
    // is an int
    if (isInt(s)) {
      pushInt(s, stack);
    } else if (isOperand(s)) {
      // operand
      if (stack.size() < 2) {
        System.err.println("ERROR: Not enough arguments.");
      } else {
        operate(s.charAt(0), stack);
      }
    } else if ("?".equals(s)) {
      System.out.println(stack.toString());
    } else if (".".equals(s)) {
      top(stack);
    } else {
      System.err.println("ERROR: bad token");
    }
  }

  /**
   * try returning the top of the stack when user input '.'.
   * @param stack the stack for all stored Integers.
   */
  private static void top(Stack<Integer> stack) {
    try {
      // prints top
      System.out.println(stack.peek());
    } catch (EmptyException e) {
      System.err.println("ERROR: empty stack");
    }
  }

  /**
   * push integers into stack.
   * @param s the string representation of the integer .
   * @param stack the stack for all stored integers.
   */
  private static void pushInt(String s, Stack<Integer> stack) {
    int i = parseInt(s);
    stack.push(i);
  }

  /**
   * Test whether the string is an operand.
   * @param s the string to be tested.
   * @return whether the string is an operand.
   */
  private static boolean isOperand(String s) {
    return "+".equals(s) || "-".equals(s) || "*".equals(s)
            || "/".equals(s) || "%".equals(s);
  }

  /**
   * Operate the symbol on the last two integers.
   * @param c the operand.
   * @param stack the stack of all stored integers.
   */
  private static void operate(char c, Stack<Integer> stack) {
    // +, -, *, /, and %.
    int b = stack.pop().intValue();
    int a = stack.pop().intValue();
    if (c == '+') {
      stack.push(a + b);
    } else if (c == '-') {
      stack.push(a - b);
    } else if (c == '*') {
      stack.push(a * b);
    } else {
      if (c == '/') {
        divide(a, b, stack);
      } else {
        modulo(a, b, stack);
      }
    }
  }

  /**
   * Operations of modulo.
   * @param a a in a % b.
   * @param b b in a % b.
   * @param stack the stack to store the integers.
   */
  private static void modulo(int a, int b, Stack<Integer> stack) {
    if (b == 0) {
      System.err.println("ERROR: modulo zero");
      stack.push(a);
      stack.push(b);
    } else {
      stack.push(a % b);
    }
  }

  /**
   * Operations of divisions.
   * @param a a in a / b.
   * @param b b in a / b.
   * @param stack the stack to store all integers.
   */
  private static void divide(int a, int b, Stack<Integer> stack) {
    if (b == 0) {
      System.err.println("ERROR: division by zero");
      stack.push(a);
      stack.push(b);
    } else {
      stack.push(a / b);
    }
  }


  /**
   * check if a string is an integer.
   * @param s string to be checked.
   * @return whether the string is an int.
   */
  private static boolean isInt(String s) {
    //char c;
    for (char c:s.toCharArray()) {
      if (!isDigit(c)) {
        return false;
      }
    }
    return true;
  }

  /**
   * The main function.
   *
   * @param args Not used.
   */
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();

    // take inputs and split by white space
    Scanner scnr = new Scanner(System.in);
    String[] items;
    String line;
    while (scnr.hasNext()) {
      line = scnr.nextLine();
      items =  line.split(" ");
      for (int i = 0; i < items.length; i++) {
        if (items[i].equals("!")) {
          return;
        }
        if (items[i].equals("")) {
          continue;
        }
        doSth(items[i], stack);
      }
    }

  }
}

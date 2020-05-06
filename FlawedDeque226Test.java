package hw4;

import exceptions.EmptyException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FlawedDeque226Test {

  private Deque226<String> stringDequeue;

  @Before
  public void setupDequeue() {
    this.stringDequeue = new FlawedDeque226<String>();
  }

  @Test
  public void emptyAtFirst() {
    assertTrue(stringDequeue.empty());
  }

  @Test
  public void notEmptyAfterInsertFront() {
    stringDequeue.insertFront("one");
    assertFalse(stringDequeue.empty());
  }


  @Test
  public void lengthZeroAtFirst() {
    assertEquals(0, stringDequeue.length());
  }

  @Test
  public void stressLengthTestWithInsertFront() {
    for (int i = 0; i < 10000; i++) {
      stringDequeue.insertFront("front");
      assertEquals(i + 1, stringDequeue.length());
    }
    assertFalse(stringDequeue.empty());
  }

  @Test
  public void stressLengthTestWithInsertBack() {
    for (int i = 0; i < 1000; i++) {
      stringDequeue.insertBack("back");
      assertEquals(i + 1, stringDequeue.length());
    }
  } // failed, index differing by 1 at index 2.

  @Test
  public void voidStressTestRemoveFront() {
    for (int i = 0; i < 10000; i++) {
      stringDequeue.insertFront("front");
      assertEquals(i + 1, stringDequeue.length());
    }
    for (int i = 0; i < 10000; i++) {
      stringDequeue.removeFront();
      assertEquals(9999 - i, stringDequeue.length());
    }
    assertTrue(stringDequeue.empty());
  }

  @Test
  public void StressTestRemoveBack() {
    for (int i = 0; i < 10000; i++) {
      stringDequeue.insertFront("front");
      assertEquals(i + 1, stringDequeue.length());
    }
    for (int i = 0; i < 10000; i++) {
      stringDequeue.removeBack();
      assertEquals(9999 - i, stringDequeue.length());
    }
    assertTrue(stringDequeue.empty());
  }

  @Test
  public void notEmptyAfterInsertBack() {
    stringDequeue.insertBack("one");
    assertFalse(stringDequeue.empty());
  }

  @Test
  public void emptyAgainAfterInsertRemoveAtFront() {
    stringDequeue.insertFront("one");
    stringDequeue.removeFront();
    assertTrue(stringDequeue.empty());
  }

  @Test
  public void emptyAgainAfterInsertRemoveAtBack() {
    stringDequeue.insertBack("one");
    stringDequeue.removeBack();
    assertTrue(stringDequeue.empty());
  }

  @Test
  public void emptyAgainAfterInsertFrontRemoveAtBack() {
    stringDequeue.insertFront("one");
    stringDequeue.removeBack();
    assertTrue(stringDequeue.empty());
  }

  @Test
  public void emptyAgainAfterInsertBackRemoveAtFront() {
    stringDequeue.insertBack("one");
    stringDequeue.removeFront();
    assertTrue(stringDequeue.empty());
  }

  @Test (expected = EmptyException.class)
  public void exceptionWhenFrontCalledAtFront() {
    stringDequeue.front();
  }

  @Test (expected = EmptyException.class)
  public void exceptionWhenFrontCalledAtBack() {
    stringDequeue.back();
  } // failed, no error handling

  @Test
  public void frontReturnsCorrectString() {
    for (int i = 0; i < 100; i++) {
      stringDequeue.insertFront("one");
      assertEquals("one", stringDequeue.front());
    }
  }

  @Test
  public void frontReturnsCorrectStringTestDifferentStrings() {
    stringDequeue.insertFront("one");
    assertEquals("one", stringDequeue.front());
    stringDequeue.insertFront("two");
    assertEquals("two", stringDequeue.front());
    stringDequeue.insertFront("three");
    assertEquals("three", stringDequeue.front());
    stringDequeue.insertFront("four");
    assertEquals("four", stringDequeue.front());
    stringDequeue.insertFront("five");
    assertEquals("five", stringDequeue.front());
    stringDequeue.insertFront("six");
    assertEquals("six", stringDequeue.front());
    stringDequeue.insertFront("seven");
    assertEquals("seven", stringDequeue.front());
  }

  @Test
  public void insertBackFailureTestingSequenceOne() {
    stringDequeue.insertBack("one");
    stringDequeue.insertBack("two");
    assertEquals("two", stringDequeue.back());
  }

  @Test
  public void insertBackFailureTestingSequenceTwo() {
    stringDequeue.insertBack("one");
    stringDequeue.insertBack("two");
    stringDequeue.insertBack("three");
    stringDequeue.insertBack("four");
    assertEquals("four", stringDequeue.back());
  }

  @Test
  public void insertBackFailureTestingSequenceThree() {
    stringDequeue.insertBack("one");
    stringDequeue.insertBack("two");
    stringDequeue.insertBack("three");
    stringDequeue.insertBack("four");
    stringDequeue.insertBack("five");
    assertEquals("five", stringDequeue.back());
    stringDequeue.insertBack("six");
    assertEquals("six", stringDequeue.back());
    stringDequeue.insertBack("seven");
    assertEquals("seven", stringDequeue.back());
  } // fails at 7

  @Test
  public void insertBackFailureTestingSequenceFour() {
    stringDequeue.insertBack("one");
    stringDequeue.insertBack("two");
    stringDequeue.insertBack("three");
    stringDequeue.insertBack("four");
    stringDequeue.insertBack("five");
    stringDequeue.insertBack("six");
    stringDequeue.insertBack("seven");
    stringDequeue.insertBack("eight");
    assertEquals("eight", stringDequeue.back());
    stringDequeue.insertBack("nine");
    assertEquals("nine", stringDequeue.back());
    stringDequeue.insertBack("ten");
    assertEquals("ten", stringDequeue.back());
    stringDequeue.insertBack("eleven");
    assertEquals("eleven", stringDequeue.back());
    stringDequeue.insertBack("12");
    assertEquals("12", stringDequeue.back());
  } // fails at 12

  @Test
  public void insertBackFailureTestingSequenceFive() {
    stringDequeue.insertBack("one");
    stringDequeue.insertBack("two");
    stringDequeue.insertBack("three");
    stringDequeue.insertBack("four");
    stringDequeue.insertBack("five");
    stringDequeue.insertBack("six");
    stringDequeue.insertBack("seven");
    stringDequeue.insertBack("eight");
    stringDequeue.insertBack("nine");
    stringDequeue.insertBack("ten");
    stringDequeue.insertBack("eleven");
    stringDequeue.insertBack("12");
    stringDequeue.insertBack("13");
    assertEquals("13", stringDequeue.back());
    stringDequeue.insertBack("14");
    assertEquals("14", stringDequeue.back());
    stringDequeue.insertBack("15");
    assertEquals("15", stringDequeue.back());
    stringDequeue.insertBack("16");
    assertEquals("16", stringDequeue.back());
    stringDequeue.insertBack("17");
    assertEquals("17", stringDequeue.back());
    stringDequeue.insertBack("18");
    assertEquals("18", stringDequeue.back());
    stringDequeue.insertBack("19");
    assertEquals("19", stringDequeue.back());
    stringDequeue.insertBack("20");
    assertEquals("20", stringDequeue.back());
    stringDequeue.insertBack("21");
    assertEquals("21", stringDequeue.back());
  }

  @Test
  public void insertBackFailureTestingSequenceSix() {
    stringDequeue.insertBack("one");
    assertEquals(1, stringDequeue.length());
    stringDequeue.insertBack("two");
    assertEquals(1, stringDequeue.length());
    assertEquals("one", stringDequeue.back());
    stringDequeue.insertBack("three");
    assertEquals(2, stringDequeue.length());
    stringDequeue.insertBack("four");
    assertEquals(2, stringDequeue.length());
    assertEquals("three", stringDequeue.back());
    stringDequeue.insertBack("five");
    assertEquals(3, stringDequeue.length());
    stringDequeue.insertBack("six");
    assertEquals(4, stringDequeue.length());
    stringDequeue.insertBack("seven");
    assertEquals(4, stringDequeue.length());
    assertEquals("six", stringDequeue.back());
    stringDequeue.insertBack("eight");
    assertEquals(5, stringDequeue.length());
    stringDequeue.insertBack("nine");
    assertEquals(6, stringDequeue.length());
    stringDequeue.insertBack("ten");
    assertEquals(7, stringDequeue.length());
    stringDequeue.insertBack("eleven");
    assertEquals(8, stringDequeue.length());
    stringDequeue.insertBack("12");
    assertEquals(8, stringDequeue.length());
    assertEquals("eleven", stringDequeue.back());
    stringDequeue.insertBack("13");
    stringDequeue.insertBack("14");
    stringDequeue.insertBack("15");
    stringDequeue.insertBack("16");
    stringDequeue.insertBack("17");
    stringDequeue.insertBack("18");
    stringDequeue.insertBack("19");
    stringDequeue.insertBack("20");
    stringDequeue.insertBack("21");
    assertEquals("20", stringDequeue.back());
    stringDequeue.insertBack("22");
    assertEquals("22", stringDequeue.back());
    stringDequeue.insertBack("23");
    assertEquals("23", stringDequeue.back());
    stringDequeue.insertBack("24");
    assertEquals("24", stringDequeue.back());
    stringDequeue.insertBack("25");
    assertEquals("25", stringDequeue.back());
    stringDequeue.insertBack("26");
    assertEquals("26", stringDequeue.back());
    stringDequeue.insertBack("27");
    assertEquals("27", stringDequeue.back());
    stringDequeue.insertBack("28");
    assertEquals("28", stringDequeue.back());
    stringDequeue.insertBack("29");
    assertEquals("29", stringDequeue.back());
    stringDequeue.insertBack("30");
    assertEquals("30", stringDequeue.back());
    stringDequeue.insertBack("31");
    assertEquals("31", stringDequeue.back());
    stringDequeue.insertBack("32");
    assertEquals("32", stringDequeue.back());
    stringDequeue.insertBack("33");
    assertEquals("33", stringDequeue.back());
    stringDequeue.insertBack("34");
    assertEquals("34", stringDequeue.back());
    stringDequeue.insertBack("35");
    assertEquals("35", stringDequeue.back());
    stringDequeue.insertBack("36");
    assertEquals("36", stringDequeue.back());
    stringDequeue.insertBack("37");
    assertEquals("37", stringDequeue.back());
    stringDequeue.insertBack("38");
    assertEquals("38", stringDequeue.back());
  } // failed, back returns wrong number at two, but
  //2 4 7 12 21 38


  @Test
  public void TestBackKnowingWhenInsertBackFails() {
    stringDequeue.insertBack("one");
    assertEquals("one", stringDequeue.back());
    stringDequeue.insertBack("two");
    assertEquals("one", stringDequeue.back());
    stringDequeue.insertBack("three");
    assertEquals("three", stringDequeue.back());
    stringDequeue.insertBack("four");
    assertEquals("three", stringDequeue.back());
  } // back() works

  @Test
  public void backReturnsCorrectString() {
    for (int i = 0; i < 100; i++) {
      stringDequeue.insertBack("two");
      assertEquals("two", stringDequeue.back());
    }
  }

  @Test
  public void backAfterInsertFront() {
    for (int i = 0; i < 100; i++) {
      stringDequeue.insertFront("one");
      assertEquals("one", stringDequeue.back());
    }
  }

  @Test
  public void frontAfterInsertBack() {
    for (int i = 0; i < 100; i++) {
      stringDequeue.insertBack("one");
      assertEquals("one", stringDequeue.front());
    }
  }


  @Test (expected = EmptyException.class)
  public void removeFrontFailsFirst() {
    stringDequeue.removeFront();
  } // failed, no error handling

  @Test (expected = EmptyException.class)
  public void removeBackFailsFirst() {
    stringDequeue.removeBack();
  } // failed, no error handling

  @Test (expected = EmptyException.class)
  public void removeFrontFailsWhenCalledTooManyTimes() {
    for (int i = 0; i < 100; i++) {
      stringDequeue.insertFront("one");
    }
    for (int i = 0; i < 100; i++) {
      stringDequeue.removeFront();
    }
    stringDequeue.removeFront();
  } // failed, no error handling

  @Test (expected = EmptyException.class)
  public void removeBackFailsWhenCalledTooManyTimes() {
    for (int i = 0; i < 100; i++) {
      stringDequeue.insertFront("one");
    }
    for (int i = 0; i < 100; i++) {
      stringDequeue.removeFront();
    }
    stringDequeue.removeBack();
  } // failed, no error handling

}

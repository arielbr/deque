## Part A: RPN Calculator

1. Document all error conditions you determined and why they are error conditions. Do this by including the inputs that you used to test your program and what error conditions they exposed:
	
	a. division by 0. Tested with "1 0 / !". Showed division by zero error.
	b. modulo zero. Tested with "2 0 % !". Showed division by zero error.
	
	a, b are error because division by 0 or modulo 0 do not make sense mathematically.
	
	c. empty stack error. Tested with ". 1 1 + % !". Found since nothing is printed out and no error message.
	This is an error as empty stacks have no top to return.
	
	d. not enough arguments. Tested with "1 * !" Illegal expression if not handled.
	This is an error because without >= 2 integers on the stack, operand cannot act on anything (they are all binary operators).
	
	e. bad token. Tested with "1.0 blah oops yo". Nothing gets printed out, no error message if not handled. No info of what happened.
	Error because non-integers and non-operands cannot be interpreted in the expressions.

## Part B: Testing Deques

1. Please give a list of the flaws you uncovered in our implementation and list the JUnit 4 tests (using the names you gave them) that uncovered each flaw. For each flaw you identify, please share an educated guess as to what is the mistake that led to the flaw.

	a. stressLengthTestWithInsertBack Test:
	I found that at a small index length tests fails (index 2). Thus insertBack is flawed. It returns wrong lengths.
	
	b. insertBackFailureTestingSequenceOne-Six Tests:
	I found that after adding consecutively, sometimes back() after insertBack() will return wrong data, since 
	stringDequeue.back() returns a
	different number from the one added. These adds are the nth adds in the sequence (2,4,7,12,21,38...), which Google
	shows following is a recursive math sequence: T(n+1) = T(n)*2-n-1.
	
	c. insertBackFailureTestingSequenceSix Test:
	This test shows that at the nth adds where n is a number in the above sequence, the inserted value to the back takes
	the second-last added value, and length is not incremented.
	
	d. removeFrontFailsFirst and removeFrontFailsWhenCalledTooManyTimes tests:
	EmptyError is expected to be thrown by not thrown when removeFront() is called on an empty deque.
	
	e. removeBackFailsFirst and removeBackFailsWhenCalledTooManyTimes tests:
	EmptyError is expected to be thrown by not thrown when removeBack() is called on an empty deque.
	
	f. exceptionWhenFrontCalledAtBack Test:
	EmptyError is expected to be thrown but not thrown when back() is called on an empty deque. No error handling here.
	
	
2. Discuss the process with which you determined what tests to write. What made this process more difficult?

A: I started with the simplest tests, which involves one method (empty()). Then I tested expected values of empty()
at different situations (empty, after inserting, etc.), and anticipated when errors are thrown. This involves more
other methods. Those are called before testing empty() again.

Similarly, I tested removeFront, removeBack, insertFront, insertBack by comparing expected and actual values returned
by front() and back(). This is hard as insertBack's particular times when error occurs is hard to find.
Then, I tested all back, front, if they return correct values and throw errors when anticipated.

The process is difficult as some tests use more than one method (eg using insert, remove, then compare with front and back)
and it is hard to track which was wrong. Also, removeBack's errors seemed random at first until I tried multiple adds and
stress tests to find out it occurs at fixed numbers for each test.
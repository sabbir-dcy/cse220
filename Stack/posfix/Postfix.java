import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		String str = sc.nextLine();

		getPostfix(str);
	}

	// returns the precedency of the operators
	public static int preced(char c) {
		switch(c) {
			case '*':
			case '/':
			case '%':
				return 2;
			case '+':
			case '-':
				return 1;
		}
		return 0;
	}

	// prints postfix form of expression
	public static void getPostfix(String str) {
		Stack stack = new Stack();
		char[] arr = new char[str.length()];
		int i = 0;

		for (char c : str.toCharArray()) {
			if (c == '+' ||c == '-' ||c == '*' ||c == '/' || c == '%') {

				while (true) {
					// if stack is empty or the operator present in the stack has
					// lower precedenc than push and stop.
					if (stack.peek() == null || preced((char)stack.peek()) < preced(c)) {
						stack.push(c);
						break;
					}
					// if stack is not empty and the operator present in the stack
					// has higher or equal precence take out the operator from stack
					else {
						arr[i++] = (char)stack.pop();
					}
				}
			}	else {
				arr[i++] = c;
			}
		}
		
		// if the control reach to the last element of expression
		// but operators left inside the stack then take out all
		// all the operators
		while(stack.peek() != null) {
			arr[i++] = (char)stack.pop();
		}
		for (char c : arr) {
			System.out.print(c);
		}
	}
}

class Stack {
	Node head;

	public void push(Object data) {
		head = new Node(data, head);
	}

	public Object peek() {
		if (head == null) {
			return null;
		}
		return head.data;
	}

	public Object pop() {
		Node node = head;
		head = head.next;
		node.next = null;
		return node.data;
	}
}

class Node {
	Node next;
	Object data;

	public Node(Object data, Node next) {
		this.data = data;
		this.next = next;
	}
}
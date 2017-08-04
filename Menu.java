 /**
@author Ming Ni
@version 1.0

COP5007 Exam 2
File Name: Menu.java
*/

public abstract class Menu {
	/**
	Handle user's input for this menu.
	*/
	public abstract boolean listenerUserInput();

	/**
	Print out the object.
	*/
	public void print(Object o) {
		System.out.println(o);
	}
}

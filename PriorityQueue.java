
/**
@author Ming Ni
@version 1.0

COP5007 Exam 2
File Name: PriorityQueue.java
*/

import java.util.ArrayList;
import java.util.List;

public class PriorityQueue<T> {
	/**
	 * The data of item in the list.
	 */
	private List<Item<T>> data;

	/**
	 * Construct for the PriorityQueue.
	 */
	PriorityQueue() {
		data = new ArrayList<Item<T>>();
	}

	/**
	 * add new item into the PriorityQueue.
	 * 
	 * @param value
	 * @param priority
	 */
	public void add(T value, int priority) {
		data.add(new Item<T>(value, priority));
	}

	/**
	 * remote the height priority item in the PriorityQueue.
	 * 
	 * @return
	 */
	public T remove() {
		Item<T> item = search(data.get(0), 0);
		data.remove(item);
		return item.getValue();
	}

	/**
	 * A help method used for recursively search the highest priority in the
	 * PriorityQueue.
	 * 
	 * @param result
	 * @param index
	 * @return
	 */
	private Item search(Item result, int index) {
		if (index > data.size() - 1) {
			return result;
		}
		if (data.get(index).getPriority() > result.getPriority()) {
			return search(data.get(index), index + 1);
		} else {
			return search(result, index + 1);
		}
	}

	/**
	 * check if the PriorityQueue is empty.
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return data.isEmpty();
	}

	/**
	 * 
	 * A private class to store the item value and its priority.
	 *
	 * @param <T>
	 */
	private class Item<T> {
		private int priority;
		private T val;

		Item(T v, int priority) {
			this.val = v;
			this.priority = priority;
		}

		public int getPriority() {
			return priority;
		}

		public T getValue() {
			return val;
		}
	}
}

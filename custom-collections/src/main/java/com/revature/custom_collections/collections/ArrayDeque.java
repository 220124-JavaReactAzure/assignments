package com.revature.custom_collections.collections;

/**
 * Resizable-array implementation of the Deque interface. Array deques have no
 * capacity restrictions; they grow as necessary to support usage. Null elements
 * are prohibited.
 *
 * @param <T> the type of elements maintained by this list
 */
public class ArrayDeque<T> implements Deque<T> {

	private int head;
	private int tail;
	private int size;
	private int capacity;
	private Object[] elements;

	/**
	 * Constructs an empty array deque with an initial capacity sufficient to hold
	 * 16 elements.
	 */
	public ArrayDeque() {
		elements = new Object[16];
		capacity = elements.length;
		size = 0;
		head = 0;
		tail = 0;
	}

	// if head moves left, what should the array index be?
	public int nextHeadPush() {
		if (head == 0) {
			return capacity - 1;
		} else if (size == 0) {
			return head;
		} else
			return head - 1;
	}

	// if head moves right, what should the array index be?
	public int nextHeadPop() {
		if (head == capacity - 1) {
			return 0;
		} else
			return head + 1;
	}

	// if tail moves right, what should the array index be?
	public int nextTailPush() {
		if (tail == capacity - 1) {
			return 0;
		} else if (size == 0) {
			return tail;
		} else
			return tail + 1;
	}

	// if tail moves left, what should the array index be?
	public int nextTailPop() {
		if (tail == 0) {
			return capacity - 1;
		} else
			return tail - 1;
	}

	// return first index of element searching from head to tail, or -1 if not found
	public int find(T element) {
		if (head < tail) {
			for (int i = head; i <= tail; i++) {
				if (elements[i].equals(element)) {
					return i;
				}
			}
		} else {
			for (int i = head; i < capacity; i++) {
				if (elements[i].equals(element)) {
					return i;
				}
			}
			for (int i = 0; i <= tail; i++) {
				if (elements[i].equals(element)) {
					return i;
				}
			}
		}
		return -1;
	}

	/**
	 * Constructs an empty array deque with an initial capacity sufficient to hold
	 * the specified number of elements.
	 *
	 * @param initialCapacity lower bound on initial capacity of the deque
	 */
	public ArrayDeque(int initialCapacity) {
		elements = new Object[initialCapacity];
		size = elements.length;
	}

	/**
	 * Inserts the specified element at the end of this deque.
	 *
	 * @param element the element to add
	 * @return true
	 * @throws NullPointerException if the specified element is null
	 */
	@Override
	public boolean add(T element) {
		if (element == null) {
			throw new NullPointerException();
		}
		growIfNecessary();
		tail = nextTailPush();
		elements[tail] = element;
		size++;
		return true;
	}

	/**
	 * Returns true if this deque contains the specified element. More formally,
	 * returns true if and only if this deque contains at least one element e such
	 * that o.equals(e).
	 *
	 * @param element object to be checked for containment in this deque
	 * @return true if this deque contains the specified element
	 */
	@Override
	public boolean contains(T element) {
		if (find(element) >= 0) {
			return true;
		} else
			return false;
	}

	/**
	 * Returns true if this deque contains no elements.
	 *
	 * @return true if this deque contains no elements
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Removes the first occurrence of the specified element in this deque (when
	 * traversing the deque from head to tail). If the deque does not contain the
	 * element, it is unchanged. More formally, removes the first element e such
	 * that o.equals(e) (if such an element exists). Returns true if this deque
	 * contained the specified element (or equivalently, if this deque changed as a
	 * result of the call).
	 *
	 * @param element element to be removed from this deque, if present
	 * @return true if the deque contained the specified element
	 */
	@Override
	public boolean remove(T element) {
		int i = find(element);
		if (i >= 0) {
			removeAtIndex(i);
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		return size;
	}

	/**
	 * Inserts the specified element at the front of this deque.
	 *
	 * @param element the element to add
	 * @throws NullPointerException if the specified element is null
	 */
	@Override
	public void addFirst(T element) {
		if (element == null) {
			throw new NullPointerException();
		}
		growIfNecessary();
		head = nextHeadPush();
		elements[head] = element;
		size++;
	}

	/**
	 * Inserts the specified element at the end of this deque.
	 *
	 * @param element the element to add
	 * @throws NullPointerException if the specified element is null
	 */
	@Override
	public void addLast(T element) {
		add(element);
	}

	/**
	 * Retrieves and removes the first element of this deque, or returns null if
	 * this deque is empty.
	 *
	 * @return the head of this deque, or null if this deque is empty
	 */
	@Override
	public T pollFirst() {
		T answer;
		if (size == 0) {
			return null;
		} else {
			answer = (T) elements[head];
			elements[head] = null;
			head = nextHeadPop();
			size--;
			return answer;
		}
	}

	/**
	 * Retrieves and removes the last element of this deque, or returns null if this
	 * deque is empty.
	 *
	 * @return the tail of this deque, or null if this deque is empty
	 */
	@Override
	public T pollLast() {
		T answer;
		if (size == 0) {
			return null;
		} else {
			answer = (T) elements[tail];
			elements[tail] = null;
			tail = nextTailPop();
			size--;
			return answer;
		}
	}

	/**
	 * Retrieves, but does not remove, the first element of this deque, or returns
	 * null if this deque is empty.
	 *
	 * @return the head of this deque, or null if this deque is empty
	 */
	@Override
	public T peekFirst() {
		if (size == 0) {
			return null;
		} else {
			return (T) elements[head];
		}
	}

	/**
	 * Retrieves, but does not remove, the last element of this deque, or returns
	 * null if this deque is empty.
	 *
	 * @return the tail of this deque, or null if this deque is empty
	 */
	@Override
	public T peekLast() {
		if (size == 0) {
			return null;
		} else {
			return (T) elements[tail];
		}
	}

	/**
	 * Retrieves and removes the head of the queue represented by this deque (in
	 * other words, the first element of this deque), or returns null if this deque
	 * is empty.
	 *
	 * This method is equivalent to pollFirst().
	 *
	 * @return the head of the queue represented by this deque, or null if this
	 *         deque is empty
	 */
	@Override
	public T poll() {
		return pollFirst();
	}

	/**
	 * Retrieves, but does not remove, the head of the queue represented by this
	 * deque, or returns null if this deque is empty.
	 *
	 * This method is equivalent to peekFirst().
	 *
	 * @return the head of the queue represented by this deque, or null if this
	 *         deque is empty
	 */
	@Override
	public T peek() {
		return peekFirst();
	}

	// Checks to see if array is 1 away from being full. If it is, double in size.
	// This should be called before adding an element to the Array Deque.
	private void growIfNecessary() {
		if (size == capacity - 1) {
			Object[] newArray = new Object[capacity * 2];
			for (int i = 0; i < size; i++) {
				newArray[i] = elements[i];
			}
			elements = newArray;
			head = 0;
			tail = size - 1;
		}
	}

	private void removeAtIndex(int index) {
		if (size == 1) {
			size = 0;
			head = 0;
			tail = 0;
			elements[index] = 0;
		} else {
			Object[] newArray = new Object[capacity];
			if (head < tail) {
				int i = 0;
				for (int j = head; j <= tail; j++) {
					if (j != index) {
						newArray[i] = elements[j];
						i++;
					}
				}
				size--;
				head = 0;
				tail = size - 1;
			} else {
				int i = 0;
				for (int j = head; j + head < size; j++) {
					if (j != index) {
						newArray[i] = elements[j];
						i++;
					}
				}
				for (int j = 0; j <= tail; j++) {
					if (j != index) {
						newArray[i] = elements[j];
						i++;
					}
				}
				size--;
				head = 0;
				tail = size - 1;
			}
		}

	}
}

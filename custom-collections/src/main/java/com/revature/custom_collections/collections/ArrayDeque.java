package com.revature.custom_collections.collections;

/**
 * Resizable-array implementation of the Deque interface. Array deques have no
 * capacity restrictions; they grow as necessary to support usage. Null elements
 * are prohibited.
 *
 * @param <T> the type of elements maintained by this list
 */
public class ArrayDeque<T> implements Deque<T> {

  private Object[] elements;
  private int head;
  private int tail;

  private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

  /**
   * Constructs an empty array deque with an initial capacity sufficient to hold
   * 16 elements.
   */
  public ArrayDeque() {
    elements = new Object[16];
  }

  /**
   * Constructs an empty array deque with an initial capacity sufficient to hold
   * the specified number of elements.
   *
   * @param initialCapacity lower bound on initial capacity of the deque
   */
  public ArrayDeque(int initialCapacity) {
    elements = new Object[initialCapacity];
  }

  /**
   * Inserts the specified element at the end of this deque.
   *
   * @param element the element to add
   * @return true
   * @throws NullPointerException if the specified element is null
   */
  @Override
  public boolean add(T element) throws NullPointerException {
    if (element != null) {
      elements = new Object[elements.length + 1];

      T elementToAdd = (T) element;

      elements[elements.length - 1] = elementToAdd;

      return true;
    } else {
      throw new NullPointerException();
    }
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
    if (element != null) {
      final Object[] es = elements;
      for (
        int i = head, end = tail, to = (i <= end) ? end : es.length;;
        i = 0, to = end
      ) {
        for (; i < to; i++) if (element.equals(es[i])) return true;
        if (to == end) break;
      }
    }
    return false;
  }

  /**
   * Returns true if this deque contains no elements.
   *
   * @return true if this deque contains no elements
   */
  @Override
  public boolean isEmpty() {
    if (elements.length == 0) {
      return true;
    }

    return false;
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
    if (element != null) {
      final Object[] es = elements;
      for (
        int i = head, end = tail, to = (i <= end) ? end : es.length;;
        i = 0, to = end
      ) {
        for (; i < to; i++) if (element.equals(es[i])) {
          delete(i);
          return true;
        }
        if (to == end) break;
      }
    }
    return false;
  }
  static final int sub(int i, int j, int modulus) {
    if ((i -= j) < 0) i += modulus;
    return i;
}
  boolean delete(int i) {
    final Object[] es = elements;
    final int capacity = es.length;
    final int h, t;
    // number of elements before to-be-deleted elt
    final int front = sub(i, h = head, capacity);
    // number of elements after to-be-deleted elt
    final int back = sub(t = tail, i, capacity) - 1;
    if (front < back) {
      // move front elements forwards
      if (h <= i) {
        System.arraycopy(es, h, es, h + 1, front);
      } else { // Wrap around
        System.arraycopy(es, 0, es, 1, i);
        es[0] = es[capacity - 1];
        System.arraycopy(es, h, es, h + 1, front - (i + 1));
      }
      es[h] = null;
      head = inc(h, capacity);
      return false;
    } else {
      // move back elements backwards
      tail = dec(t, capacity);
      if (i <= tail) {
        System.arraycopy(es, i + 1, es, i, back);
      } else { // Wrap around
        System.arraycopy(es, i + 1, es, i, capacity - (i + 1));
        es[capacity - 1] = es[0];
        System.arraycopy(es, 1, es, 0, t - 1);
      }
      es[tail] = null;
      return true;
    }
  }

  @Override
  public int size() {
    int size = elements.length;

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
    if (element == null) throw new NullPointerException();
    final Object[] es = elements;
    es[head = dec(head, es.length)] = element;
    if (head == tail) grow(1);
  }

  static final int inc(int i, int modulus) {
    if (++i >= modulus) i = 0;
    return i;
  }

  /**
   * Circularly decrements i, mod modulus.
   * Precondition and postcondition: 0 <= i < modulus.
   */
  static final int dec(int i, int modulus) {
    if (--i < 0) i = modulus - 1;
    return i;
  }

  /**
   * Increases the capacity of this deque by at least the given amount.
   *
   * @param needed the required minimum extra capacity; must be positive
   */
  private void grow(int needed) {
    // overflow-conscious code
    final int oldCapacity = elements.length;
    int newCapacity;
    // Double capacity if small; else grow by 50%
    int jump = (oldCapacity < 64) ? (oldCapacity + 2) : (oldCapacity >> 1);
    if (
      jump < needed || (newCapacity = (oldCapacity + jump)) - MAX_ARRAY_SIZE > 0
    ) newCapacity = newCapacity(needed, jump);
    final Object[] es = elements = Arrays.copyOf(elements, newCapacity);
    // Exceptionally, here tail == head needs to be disambiguated
    if (tail < head || (tail == head && es[head] != null)) {
      // wrap around; slide first leg forward to end of array
      int newSpace = newCapacity - oldCapacity;
      System.arraycopy(es, head, es, head + newSpace, oldCapacity - head);
      for (int i = head, to = (head += newSpace); i < to; i++) es[i] = null;
    }
  }

  /** Capacity calculation for edge conditions, especially overflow. */
  private int newCapacity(int needed, int jump) {
    final int oldCapacity = elements.length, minCapacity;
    if ((minCapacity = oldCapacity + needed) - MAX_ARRAY_SIZE > 0) {
      if (minCapacity < 0) throw new IllegalStateException(
        "Sorry, deque too big"
      );
      return Integer.MAX_VALUE;
    }
    if (needed > jump) return minCapacity;
    return (oldCapacity + jump - MAX_ARRAY_SIZE < 0)
      ? oldCapacity + jump
      : MAX_ARRAY_SIZE;
  }

  /**
   * Inserts the specified element at the end of this deque.
   *
   * @param element the element to add
   * @throws NullPointerException if the specified element is null
   */
  @Override
  public void addLast(T element) {
    if (element == null) throw new NullPointerException();
    final Object[] es = elements;
    es[tail] = element;
    if (head == (tail = inc(tail, es.length))) grow(1);
  }

  /**
   * Retrieves and removes the first element of this deque, or returns null if
   * this deque is empty.
   *
   * @return the head of this deque, or null if this deque is empty
   */
  @Override
  public T pollFirst() {
    final Object[] es;
    final int h;
    T e = (T) elements[0];
    if (e != null) {
      es[h] = null;
      head = inc(h, es.length);
    }
    return e;
  }

  /**
   * Retrieves and removes the last element of this deque, or returns null if this
   * deque is empty.
   *
   * @return the tail of this deque, or null if this deque is empty
   */
  @Override
  public T pollLast() {
    final Object[] es;
    final int t;
    T e = elementAt(es = elements, t = dec(tail, es.length));
    if (e != null) es[tail = t] = null;
    return e;
  }

  /**
   * Returns element at array index i.
   * This is a slight abuse of generics, accepted by javac.
   */
  @SuppressWarnings("unchecked")
  static final <T> T elementAt(Object[] es, int i) {
    return (T) es[i];
  }

  /**
   * Retrieves, but does not remove, the first element of this deque, or returns
   * null if this deque is empty.
   *
   * @return the head of this deque, or null if this deque is empty
   */
  @SuppressWarnings("unchecked")
  @Override
  public T peekFirst() {
    if (elements != null) {
      T head = (T) elements[0];
      return (T) head;
    } else {
      return null;
    }
  }

  /**
   * Retrieves, but does not remove, the last element of this deque, or returns
   * null if this deque is empty.
   *
   * @return the tail of this deque, or null if this deque is empty
   */
  @SuppressWarnings("unchecked")
  @Override
  public T peekLast() {
    if (elements != null) {
      T tail = (T) elements[elements.length - 1];
      return (T) tail;
    } else {
      return null;
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
  // return strBldr.toString();
}

package queue;

import java.util.*;

public class FifoQueue<E> extends AbstractQueue<E> implements Queue<E> {
	private QueueNode<E> last;
	private int size;

	public FifoQueue() {

	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new QueueIterator();
	}

	public void append(FifoQueue<E> q) {
		if (q.last == null) {
			return;
		}
		if (last == null) {
			last = q.last;
			last.next = q.last.next;
		} else {
			QueueNode<E> first = last.next;
			last.next = q.last.next;
			last = q.last;
			last.next = first;
		}
		size += q.size;
		q.size = 0;
		q.last = null;
	}

	/**
	 * Returns the number of elements in this queue
	 * 
	 * @return the number of elements in this queue
	 */
	public int size() {
		/*
		 * QueueNode temp = last; int counter = 0; while(temp.next != last){
		 * counter++; temp = temp.next; } return counter;
		 */
		return size;
	}

	/**
	 * Inserts the specified element into this queue, if possible post: The
	 * specified element is added to the rear of this queue
	 * 
	 * @param x
	 *            the element to insert
	 * @return true if it was possible to add the element to this queue, else
	 *         false
	 */
	public boolean offer(E x) {
		QueueNode<E> temp = new QueueNode<E>(x);
		if (last == null) {
			last = temp;
			last.next = last;
			size++;
			return true;
		}
		temp.next = last.next;
		last.next = temp;
		last = temp;

		size++;
		return true;
	}

	/**
	 * Retrieves and removes the head of this queue, or null if this queue is
	 * empty. post: the head of the queue is removed if it was not empty
	 * 
	 * @return the head of this queue, or null if the queue is empty
	 */
	public E poll() {
		if (last == null) {
			return null;
		}
		QueueNode<E> temp = last.next;
		last.next = last.next.next;
		size--;

		if (size == 0) {
			last = null;
		}
		return temp.element;
	}

	/**
	 * Retrieves, but does not remove, the head of this queue, returning null if
	 * this queue is empty
	 * 
	 * @return the head element of this queue, or null if this queue is empty
	 */
	public E peek() {
		if (last == null) {
			return null;
		}
		return last.next.element;
	}

	private static class QueueNode<E> {
		E element;
		QueueNode<E> next;

		private QueueNode(E x) {
			element = x;
			next = null;
		}

	}

	/**
	 * Returns an iterator over the elements in this queue
	 * 
	 * @return an iterator over the elements in this queue
	 */
	private class QueueIterator implements Iterator<E> {

		private QueueNode<E> pos = last;

		private QueueIterator() {
		}

		@Override
		public boolean hasNext() {
			return pos != null;
		}

		@Override
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			QueueNode<E> temp = pos.next;
			pos = pos.next;
			if (pos == last) {
				pos = null;
			}
			return temp.element;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

}

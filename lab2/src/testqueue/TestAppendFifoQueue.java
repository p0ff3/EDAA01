package testqueue;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import queue.FifoQueue;

public class TestAppendFifoQueue {
	private FifoQueue<Integer> myIntQueue = new FifoQueue<Integer>();
	
	@Test
	public final void testAppend(){
		//Två tomma listor
		FifoQueue<Integer> temp = new FifoQueue<Integer>();
		myIntQueue.append(temp);
		assertEquals("Den ger fel storlek", myIntQueue.size(), 0);
		
		
		//Tom kö konk. till en icketom
		temp = new FifoQueue<Integer>();
		temp.offer(3);
		temp.offer(2);
		temp.append(myIntQueue);
		assertEquals("Den ger fel storlek", 2, temp.size());
		
		
		//icke-tom kö till tom kö.
		temp.offer(3);
		myIntQueue.append(temp);
		assertEquals("Den ger fle storlek", 3, myIntQueue.size());
		assertEquals("Den tömmer inte gmla listan", temp.size(), 0);
		
		//Två icke-tomma köer.
		temp.offer(1);
		temp.offer(4);
		temp.append(myIntQueue);
		assertEquals("De får inte rätt storlek", temp.size(), 5);
		assertEquals("Den tömmer inte gamla kön", myIntQueue.size(), 0);
		
		
		
		
	}
		
}

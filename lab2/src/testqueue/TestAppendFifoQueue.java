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
		//Tv� tomma listor
		FifoQueue<Integer> temp = new FifoQueue<Integer>();
		myIntQueue.append(temp);
		assertEquals("Den ger fel storlek", myIntQueue.size(), 0);
		
		
		//Tom k� konk. till en icketom
		temp = new FifoQueue<Integer>();
		temp.offer(3);
		temp.offer(2);
		temp.append(myIntQueue);
		assertEquals("Den ger fel storlek", 2, temp.size());
		
		
		//icke-tom k� till tom k�.
		temp.offer(3);
		myIntQueue.append(temp);
		assertEquals("Den ger fle storlek", 3, myIntQueue.size());
		assertEquals("Den t�mmer inte gmla listan", temp.size(), 0);
		
		//Tv� icke-tomma k�er.
		temp.offer(1);
		temp.offer(4);
		temp.append(myIntQueue);
		assertEquals("De f�r inte r�tt storlek", temp.size(), 5);
		assertEquals("Den t�mmer inte gamla k�n", myIntQueue.size(), 0);
		
		
		
		
	}
		
}

package at.aau.ue4.bsp1;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
//import static org.junit.Assert.*;

//Wetscher Nicolas 11845621

public class BaseTest {

	private RingBuffer<Integer> ringBuffer = new RingBuffer<>(5);
	private RingBuffer<Integer> ringBufferEmpty = new RingBuffer<>(0);
	private Iterator ringBufferIterator = ringBuffer.iterator();
	private Iterator ringBufferEmptyIterator = ringBufferEmpty.iterator();

	@Test
	public void shouldReturnTrue_whenEmpty() {
		assertTrue(ringBufferEmpty.isEmpty());
	}

	@Test
	public void shouldReturnFalse_whenNotEmpty() {
		ringBuffer.push(1);
		assertFalse(ringBuffer.isEmpty());
	}

	@Test
	public void shouldIncreaseSize_whenPushingItems() {
		assertEquals(0, ringBuffer.size());
		ringBuffer.push(1);
		assertEquals(1, ringBuffer.size());
		ringBuffer.push(2);
		assertEquals(2, ringBuffer.size());

	}

	@Test
	public void shouldDecreaseSize_whenPopItems() {
		ringBuffer.push(1);
		ringBuffer.push(2);
		ringBuffer.push(3);
		assertEquals(3, ringBuffer.size());
		ringBuffer.pop();
		assertEquals(2, ringBuffer.size());
		ringBuffer.pop();
		assertEquals(1, ringBuffer.size());
		ringBuffer.pop();
		assertEquals(0, ringBuffer.size());
	}

	@Test
	public void shouldThrow_whenPushedOverCapacity() {
		ringBuffer.push(1);
		ringBuffer.push(2);
		ringBuffer.push(3);
		ringBuffer.push(4);
		ringBuffer.push(5);
		assertThrows(RuntimeException.class, ()-> ringBuffer.push(6));
	}

	@Test
	public void shouldThrow_whenEmptyPoped(){
		assertThrows(RuntimeException.class, ()-> ringBufferEmpty.pop());
	}

	@Test
	public void shouldThrow_whenExecuted(){
		assertThrows(UnsupportedOperationException.class, ()-> ringBufferIterator.remove());
	}

	@Test
	public void shouldThrow_whenNoNext(){
		assertThrows(new Exception().getClass(), ()-> ringBufferEmptyIterator.next());
	}

	@Test
	public void shouldReturnObjekt_whenExecuted(){
		ringBuffer.push(0);
		ringBuffer.push(1);
		ringBuffer.push(2);
		ringBuffer.push(3);
		ringBuffer.push(4);
		
		//assertEquals(1, ringBufferIterator.next());

		for (int i = 0; i < ringBuffer.size() ; i++) {
			assertEquals(i, ringBufferIterator.next());
		}
		
	}

	@Test
	public void shouldReturnTrue_whenHasNext(){
		ringBuffer.push(1);
		assertTrue(ringBufferIterator.hasNext());

	}

	@Test
	public void shouldReturnFalse_whenHasNoNext(){
		assertFalse(ringBufferIterator.hasNext());

	}

	@Test
	public void shouldThrow_whenWrongInput(){
		ringBuffer.push(1);
		assertFalse(ringBuffer.pop());
	}

}


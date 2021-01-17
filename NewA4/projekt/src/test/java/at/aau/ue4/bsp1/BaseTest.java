package at.aau.ue4.bsp1;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
//import static org.junit.Assert.*;

//Wetscher Nicolas 11845621

public class BaseTest {

	private RingBuffer<Integer> ringBuffer = new RingBuffer<>(5);
	private Iterator ringBufferIterator = ringBuffer.iterator();

	@Test
	public void shouldReturnTrue_whenEmpty() {
		assertTrue(ringBuffer.isEmpty());
	}

	@Test
	public void shouldReturnFalse_whenNotEmpty() {
		ringBuffer.push(1);
		assertFalse(ringBuffer.isEmpty());
	}

	@Test
	public void shouldReturnZero_whenBufferisEmpty(){
		assertEquals(0,ringBuffer.size());
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
	public void Should_ReturnFive_When_BufferHasFiveElement() {
		ringBuffer.push(1);
		ringBuffer.push(2);
		ringBuffer.push(3);
		ringBuffer.push(4);
		ringBuffer.push(5);
		assertEquals(5, ringBuffer.size());
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
		assertThrows(RuntimeException.class, ()-> ringBuffer.pop());
	}

	@Test
	public void shouldThrow_whenExecuted(){
		assertThrows(UnsupportedOperationException.class, ()-> ringBufferIterator.remove());
	}

	@Test
	public void shouldThrow_whenNoNext(){
		assertThrows(new Exception().getClass(), ()-> ringBufferIterator.next());
	}

	@Test
	public void shouldReturnObjekts_whenExecuted(){
		ringBuffer.push(0);
		ringBuffer.push(1);
		ringBuffer.push(2);
		ringBuffer.push(3);
		ringBuffer.push(4);
		for (int i = 0; i < ringBuffer.size() ; i++) {
			assertEquals(i, ringBufferIterator.next());
		}
		
	}

	@Test
	public void shouldReturnTrue_whenBufferIsFull(){
		ringBuffer.push(1);
		ringBuffer.push(2);
		ringBuffer.push(3);
		ringBuffer.push(4);
		ringBuffer.push(5);
		assertTrue(ringBufferIterator.hasNext());

	}

	@Test
	public void shouldReturnFalse_whenBufferIsEmpty(){
		assertFalse(ringBufferIterator.hasNext());

	}

	@Test
	public void shouldReturnException_whenMethodRemoveIsLoaded() {
		assertThrows(UnsupportedOperationException.class, () -> {
			ringBuffer.push(0);
			ringBuffer.push(1);
			ringBuffer.push(2);
			ringBuffer.push(3);
			ringBuffer.push(4);
			ringBufferIterator.remove();
		});
	}

	@Test
	public void shouldReturnException_whenThereIsNoNextElement() {
		assertThrows(NoSuchElementException.class, () -> {
			ringBufferIterator.next();
		});
	}

}


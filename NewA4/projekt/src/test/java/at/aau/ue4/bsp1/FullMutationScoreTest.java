package at.aau.ue4.bsp1;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class FullMutationScoreTest {



    private RingBuffer<Integer> ringBufferEmpty;
    private RingBuffer<Integer> ringBufferFull;
    private Iterator<Integer> ringBufferIteratorFull;
    private Iterator<Integer> ringBufferIteratorEmpty;

    @BeforeEach
    public void initialize() {
        ringBufferEmpty = new RingBuffer(5);
        ringBufferFull = new RingBuffer(5);
        ringBufferFull.push(1);
        ringBufferFull.push(2);
        ringBufferFull.push(3);
        ringBufferFull.push(4);
        ringBufferFull.push(5);
        ringBufferIteratorFull = ringBufferFull.iterator();
        ringBufferIteratorEmpty = ringBufferEmpty.iterator();
    }

    @Test
    public void Should_AssertTrue_When_BufferIsEmpty() {
        assertTrue(ringBufferEmpty.isEmpty());
    }

    @Test
    public void Should_AssertFalse_When_BufferIsNotEmpty() {
        assertFalse(ringBufferFull.isEmpty());
    }

    @Test
    public void Should_ReturnZero_When_BufferIsEmpty() {
        assertEquals(0, ringBufferEmpty.size());
    }

    @Test
    public void Should_ReturnFive_When_BufferHasFiveElement() {
        assertEquals(5, ringBufferFull.size());
    }

    @Test
    public void Should_ThrowRuntimeException_When_BufferLengthIsEqualToCount() {
        assertThrows(RuntimeException.class, () -> {
            ringBufferFull.push(1);
        });
    }

    @Test
    public void Should_ThrowRuntimeException_When_BufferIsEmpty() {
        assertThrows(RuntimeException.class, () -> {
            ringBufferEmpty.pop();
        });
    }

    @Test
    public void Should_ReturnItem_When_BufferIsNotEmpty() {
        for(int i = 1; i<ringBufferFull.size();i++){
            assertEquals(i, (int)ringBufferFull.pop());
        }
    }

    @Test
    public void Should_ReturnFalse_When_BufferIsEmpty() {
        assertFalse(ringBufferIteratorEmpty.hasNext());
    }

    @Test
    public void Should_ReturnTrue_When_BufferIsFull() {
        assertTrue(ringBufferIteratorFull.hasNext());
    }

    @Test
    public void Should_ReturnUnsupportedOperationException_When_MethodRemoveIsLoaded() {
        assertThrows(UnsupportedOperationException.class, () -> {
            ringBufferIteratorFull.remove();
        });
    }

    @Test
    public void Should_ReturnNoSuchElementException_When_ThereIsNoNextElement() {
        assertThrows(NoSuchElementException.class, () -> {
            ringBufferIteratorEmpty.next();
        });
    }

    @Test
    public void Should_ReturnNextElement_When_ThereIsNextElement() {
        for (int i = 1; i < ringBufferFull.size(); i++) {
            assertEquals(i, (int) ringBufferIteratorFull.next());
        }
    }



}

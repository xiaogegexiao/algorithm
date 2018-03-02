package com.algorithm.datastructure;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StackBy2QueuesTest {
    @Test
    public void test() {
        StackBy2Queues stackBy2Queues = new StackBy2Queues();
        stackBy2Queues.push(1);
        stackBy2Queues.pop();
        stackBy2Queues.push(2);
        assertEquals(stackBy2Queues.isEmpty(), false);// return false
        assertEquals(stackBy2Queues.top(), 2); // return 2
        stackBy2Queues.pop();
        assertEquals(stackBy2Queues.isEmpty(), true);// return true
    }
}

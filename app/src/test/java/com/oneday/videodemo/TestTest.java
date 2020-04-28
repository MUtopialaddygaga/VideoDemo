package com.oneday.videodemo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestTest {
    private com.oneday.videodemo.Test test;
    @Before
    public void setUp() throws Exception {
        test = new com.oneday.videodemo.Test();
    }

    @Test
    public void testMethod() {
        assertEquals(0, test.testMethod(), 0);
    }
}
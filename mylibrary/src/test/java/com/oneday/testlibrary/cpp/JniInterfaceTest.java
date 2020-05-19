package com.oneday.testlibrary.cpp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JniInterfaceTest {
    private JniInterface mJniInterface;
    private int[] testArray;

    @Before
    public void setUp() throws Exception {
        testArray = new int[]{
          1,2,3,4,5,6,7,8,9,10
        };
        mJniInterface = new JniInterface();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void accessArray() {
        assertEquals(55, mJniInterface.testAccess(testArray));
    }
}
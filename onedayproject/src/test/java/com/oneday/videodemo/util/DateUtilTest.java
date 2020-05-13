package com.oneday.videodemo.util;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DateUtilTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void parseTimeStamp() {
        assertEquals(0, DateUtil.parseTimeStamp("20200430"));
    }
}
package org.geekbang.time.refactor.generator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RandomIdGeneratorTest {

    @Test
    public void testGetLastSubstrSplittedByDot() {
        RandomIdGenerator randomIdGenerator = new RandomIdGenerator();
        assertEquals("field3", randomIdGenerator.getLastSubstrSplittedByDot("field1.field2.field3"));
        assertEquals("field1", randomIdGenerator.getLastSubstrSplittedByDot("field1"));
        assertEquals("field1#field2#field3", randomIdGenerator.getLastSubstrSplittedByDot("field1#field2#field3"));
    }


}
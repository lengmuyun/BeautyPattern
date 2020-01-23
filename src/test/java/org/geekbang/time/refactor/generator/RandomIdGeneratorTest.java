package org.geekbang.time.refactor.generator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class RandomIdGeneratorTest {

    @Test
    public void testGetLastSubstrSplittedByDot() {
        RandomIdGenerator randomIdGenerator = new RandomIdGenerator();
        assertEquals("field3", randomIdGenerator.getLastSubstrSplittedByDot("field1.field2.field3"));
        assertEquals("field1", randomIdGenerator.getLastSubstrSplittedByDot("field1"));
        assertEquals("field1#field2#field3", randomIdGenerator.getLastSubstrSplittedByDot("field1#field2#field3"));
    }

    @Test
    public void testGetLastSubstrSplittedByDot_nullOrEmpty() {
        RandomIdGenerator randomIdGenerator = new RandomIdGenerator();
        assertEquals("", randomIdGenerator.getLastSubstrSplittedByDot(""));
        assertNull(randomIdGenerator.getLastSubstrSplittedByDot(null));
    }

    @Test
    public void testGenerateRandomAlphameric() {
        RandomIdGenerator randomIdGenerator = new RandomIdGenerator();
        String str = randomIdGenerator.generateRandomAlphameric(6);
        assertNotNull(str);
        assertEquals(6, str.length());
        for (char c : str.toCharArray()) {
            assertTrue((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'));
        }
    }

    @Test
    public void testGenerateRandomAlphameric_lengthEqualsOrLessThanZero() {
        RandomIdGenerator randomIdGenerator = new RandomIdGenerator();
        assertEquals("", randomIdGenerator.generateRandomAlphameric(0));
        assertNull(randomIdGenerator.generateRandomAlphameric(-1));
    }

}
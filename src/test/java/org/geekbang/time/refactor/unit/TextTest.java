package org.geekbang.time.refactor.unit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TextTest {

    @Test
    public void testToNumberNormal() {
        Text text = new Text("123");
        assertEquals(Integer.valueOf(123), text.toNumber());
    }

    @Test
    public void testToNumberWithEmpty() {
        Text empty = new Text("");
        assertNull(empty.toNumber());

        Text text = new Text(null);
        assertNull(text.toNumber());
    }

    @Test
    public void testToNumberWithStringContainsSpace() {
        Text headSpaceText = new Text(" 123");
        assertEquals(Integer.valueOf(123), headSpaceText.toNumber());

        Text tailSpaceText = new Text("123 ");
        assertEquals(Integer.valueOf(123), tailSpaceText.toNumber());

        Text headAndtailSpaceText = new Text(" 123 ");
        assertEquals(Integer.valueOf(123), headAndtailSpaceText.toNumber());

        Text multiHeadAndtailSpaceText = new Text("  123  ");
        assertEquals(Integer.valueOf(123), multiHeadAndtailSpaceText.toNumber());
    }

    @Test
    public void testToNumberWithInvalidChar() {
        Text text = new Text("123a4");
        assertNull(text.toNumber());

        Text spaceText = new Text("123 4");
        assertNull(spaceText.toNumber());
    }

}
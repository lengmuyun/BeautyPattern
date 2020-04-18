package org.geekbang.time.pattern.interpreter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExpressionInterpreterTest {

    @Test
    public void test() {
        ExpressionInterpreter interpreter = new ExpressionInterpreter();
        long result = interpreter.interpret("8 3 2 4 - + *");
        assertEquals(28, result);
    }

}
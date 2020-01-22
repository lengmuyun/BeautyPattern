package org.geekbang.time.refactor.generator;

import org.junit.Test;

public class IdGeneratorTest {

    @Test
    public void generate() {
        IdGenerator generator = new RandomIdGenerator();
        for (int i=0; i<3; i++)
            System.out.println(generator.generate());
    }
}
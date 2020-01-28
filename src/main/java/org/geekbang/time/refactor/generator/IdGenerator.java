package org.geekbang.time.refactor.generator;

public interface IdGenerator {

    String generate() throws IdGenerationFailureException;

}

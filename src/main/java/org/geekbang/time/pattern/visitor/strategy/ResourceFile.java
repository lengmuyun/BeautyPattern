package org.geekbang.time.pattern.visitor.strategy;

public abstract class ResourceFile {

    protected String filePath;
    public ResourceFile(String filePath) {
        this.filePath = filePath;
    }
    public abstract ResourceFileType getType();

}

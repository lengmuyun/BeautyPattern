package org.geekbang.time.pattern.composite;

public class File extends FileSystemNode {

    public File(String path) {
        super(path);
    }

    @Override
    public int countNumOfFiles() {
        return 1;
    }

    @Override
    public long countSizeOfFiles() {
        java.io.File file = new java.io.File(path);
        return file.exists() ? file.length() : 0;
    }

}

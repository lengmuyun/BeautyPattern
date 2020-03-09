package org.geekbang.time.pattern.composite.usage;

import org.geekbang.time.pattern.composite.FileSystemNode;

import java.util.ArrayList;
import java.util.List;

public class QuickDirectory extends FileSystemNode {

    private List<FileSystemNode> subNodes = new ArrayList<>();
    private int numOfFiles = 0;
    private long sizeOfFiles = 0;

    public QuickDirectory(String path) {
        super(path);
    }

    @Override
    public synchronized int countNumOfFiles() {
        return numOfFiles;
    }

    @Override
    public synchronized long countSizeOfFiles() {
        return sizeOfFiles;
    }

    public synchronized void addSubNode(FileSystemNode node) {
        subNodes.add(node);
        numOfFiles += node.countNumOfFiles();
        sizeOfFiles += node.countSizeOfFiles();
    }

    public synchronized void removeSubNode(FileSystemNode fileOrDir) {
        int size = subNodes.size();
        int i = 0;
        for (; i < size; ++i) {
            if (subNodes.get(i).getPath().equalsIgnoreCase(fileOrDir.getPath())) {
                break;
            }
        }
        if (i < size) {
            FileSystemNode node = subNodes.get(i);
            numOfFiles -= node.countNumOfFiles();
            sizeOfFiles -= node.countSizeOfFiles();
            subNodes.remove(i);
        }
    }
}

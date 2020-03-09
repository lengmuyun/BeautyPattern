package org.geekbang.time.pattern.composite;

import java.util.ArrayList;
import java.util.List;

public class Directory extends FileSystemNode {

    private List<FileSystemNode> subNodes = new ArrayList<>();

    public Directory(String path) {
        super(path);
    }

    @Override
    public int countNumOfFiles() {
        int numOfFiles = 0;
        for (FileSystemNode subNode : subNodes) {
            numOfFiles += subNode.countNumOfFiles();
        }
        return numOfFiles;
    }

    @Override
    public long countSizeOfFiles() {
        int sizeOfFiles = 0;
        for (FileSystemNode subNode : subNodes) {
            sizeOfFiles += subNode.countNumOfFiles();
        }
        return sizeOfFiles;
    }

    public void addSubNode(FileSystemNode node) {
        subNodes.add(node);
    }

    public void removeSubNode(FileSystemNode fileOrDir) {
        int size = subNodes.size();
        int i = 0;
        for (; i < size; ++i) {
            if (subNodes.get(i).getPath().equalsIgnoreCase(fileOrDir.getPath())) {
                break;
            }
        }
        if (i < size) {
            subNodes.remove(i);
        }
    }

}

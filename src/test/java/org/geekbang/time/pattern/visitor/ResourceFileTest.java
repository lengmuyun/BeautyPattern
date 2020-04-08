package org.geekbang.time.pattern.visitor;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ResourceFileTest {
    
    @Test
    public void test() {
        List<ResourceFile> resourceFiles = listAllResourceFiles("/usr");

        Extractor extractor = new Extractor();
        for (ResourceFile resourceFile : resourceFiles) {
            resourceFile.accept(extractor);
        }

        Compressor compressor = new Compressor();
        for(ResourceFile resourceFile : resourceFiles) {
            resourceFile.accept(compressor);
        }
    }

    private List<ResourceFile> listAllResourceFiles(String filePath) {
        List<ResourceFile> resourceFiles = new ArrayList<>();
        //...根据后缀(pdf/ppt/word)由工厂方法创建不同的类对象(PdfFile/PPTFile/WordFile)
        resourceFiles.add(new PdfFile("a.pdf"));
        resourceFiles.add(new WordFile("b.word"));
        resourceFiles.add(new PPTFile("c.ppt"));
        return resourceFiles;
    }

}
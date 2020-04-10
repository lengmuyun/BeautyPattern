package org.geekbang.time.pattern.visitor.strategy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ExtractorTest {

    @Test
    public void test() {
        List<ResourceFile> resourceFiles = listAllResourceFiles("/usr");
        for (ResourceFile resourceFile : resourceFiles) {
            Extractor extractor = ExtractorFactory.getExtractor(resourceFile.getType());
            if (extractor != null) {
                extractor.extract2txt(resourceFile);
            }
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
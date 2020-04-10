package org.geekbang.time.pattern.visitor.strategy;

public class PdfExtractor implements Extractor {

    @Override
    public void extract2txt(ResourceFile resourceFile) {
        //...
        System.out.println("Extract PDF.");
    }

}

package org.geekbang.time.oop.program;

import org.geekbang.time.oop.feature.abstraction.Image;

public interface ImageStore {

    String upload(Image image, String bucketName);
    Image download(String url);

}

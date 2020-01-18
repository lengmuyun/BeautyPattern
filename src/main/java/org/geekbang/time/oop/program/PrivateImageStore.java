package org.geekbang.time.oop.program;

import org.geekbang.time.oop.feature.abstraction.Image;

public class PrivateImageStore implements ImageStore {

    @Override
    public String upload(Image image, String bucketName) {
        createBucketIfNotExisting(bucketName);
        // 上传图片到私有云
        // 返回图片的url
        return null;
    }

    @Override
    public Image download(String url) {
        // 从私有云下载图片
        return null;
    }

    private void createBucketIfNotExisting(String bucketName) {
        // 创建bucket
        // 失败会抛出异常
    }

}

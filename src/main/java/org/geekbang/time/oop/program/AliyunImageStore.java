package org.geekbang.time.oop.program;

import org.geekbang.time.oop.feature.abstraction.Image;

public class AliyunImageStore implements ImageStore {

    @Override
    public String upload(Image image, String bucketName) {
        createBucketIfNotExisting(bucketName);
        String accessToken = generateAccessToken();
        // 上传图片到阿里云
        // 返回图片在阿里云上的地址(url)
        return null;
    }

    @Override
    public Image download(String url) {
        String accessToken = generateAccessToken();
        // 从阿里云下载图片
        return null;
    }

    private void createBucketIfNotExisting(String bucketName) {
        // 创建bucket
        // 失败会抛出异常
    }

    private String generateAccessToken() {
        // 根据accesskey/secrectkey生成access token
        return null;
    }

}

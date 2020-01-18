package org.geekbang.time.oop.feature.abstraction;

public interface IPictureStorage {

    void savePicture(Picture picture);
    Image getPicture(String pictureId);
    void deletePicture(String pictureId);
    void modifyMetaInfo(String pictureId, PictureMetaInfo metaInfo);

}

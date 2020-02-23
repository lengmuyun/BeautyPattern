package org.geekbang.time.pattern.prototype;

public interface Cache {

    /**
     * 刷新缓存中的数据
     */
    void refresh();

    /**
     * 根据关键字获取缓存
     * @param key
     * @return
     */
    SearchWord get(String key);

}

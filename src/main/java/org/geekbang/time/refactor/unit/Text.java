package org.geekbang.time.refactor.unit;

public class Text {

    private String content;

    public Text(String content) {
        this.content = content;
    }

    /**
     * 将字符串转换为数字，忽略字符串中的首尾空格
     * 如果字符串中包含除首尾空格之外的非数字字符，返回null
     * @return
     */
    public Integer toNumber() {
        if (content == null || content.isEmpty()) {
            return null;
        }
        try {
            return Integer.parseInt(content.trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }

}

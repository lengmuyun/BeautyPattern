package org.geekbang.time.pattern.flyweight.usage;

import java.awt.*;

public class CharacterStyle {

    private Font font;
    private int size;
    private int colorRGB;

    public CharacterStyle(Font font, int size, int colorRGB) {
        this.font = font;
        this.size = size;
        this.colorRGB = colorRGB;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CharacterStyle)) {
            return false;
        }
        CharacterStyle otherStyle = (CharacterStyle) obj;
        return font.equals(otherStyle.font)
                && size == otherStyle.size
                && colorRGB == otherStyle.colorRGB;
    }
}

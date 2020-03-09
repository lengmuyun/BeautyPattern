package org.geekbang.time.pattern.flyweight.usage;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CharacterStyleFactory {

    private static final List<CharacterStyle> styles = new ArrayList<>();

    public static CharacterStyle getStyle(Font font, int size, int colorRGB) {
        CharacterStyle newStyle = new CharacterStyle(font, size, colorRGB);
        Optional<CharacterStyle> style = styles.stream().filter(characterStyle -> characterStyle.equals(newStyle)).findFirst();
        if (style.isPresent()) {
            return style.get();
        }
        styles.add(newStyle);
        return newStyle;
    }
}

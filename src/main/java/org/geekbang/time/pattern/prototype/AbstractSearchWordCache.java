package org.geekbang.time.pattern.prototype;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractSearchWordCache implements Cache {

    protected Map<String, SearchWord> currentKeywords = new HashMap<>();
    protected long lastUpdateTime = -1;
    protected SearchWordRepository repository = new SearchWordRepository();

    @Override
    public SearchWord get(String key) {
        return currentKeywords.get(key);
    }

}

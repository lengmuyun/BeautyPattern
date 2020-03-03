package org.geekbang.time.pattern.adapter.usage.unify;

import org.geekbang.time.pattern.adapter.usage.unify.adaptor.ISensitiveWordsFilter;

import java.util.ArrayList;
import java.util.List;

public class RiskManagement {

    private List<ISensitiveWordsFilter> filters = new ArrayList<>();

    public void addSensitiveWordsFilter(ISensitiveWordsFilter filter) {
        filters.add(filter);
    }

    public String filterSensitiveWords(String text) {
        String maskedText = text;
        for (ISensitiveWordsFilter filter : filters) {
            maskedText = filter.filter(maskedText);
        }
        return maskedText;
    }

}

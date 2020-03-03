package org.geekbang.time.pattern.adapter.usage.unify.adaptor;

import org.geekbang.time.pattern.adapter.usage.unify.out.ASensitiveWordsFilter;

public class ASensitiveWordsFilterAdaptor implements ISensitiveWordsFilter {

    private ASensitiveWordsFilter filter;

    public ASensitiveWordsFilterAdaptor(ASensitiveWordsFilter filter) {
        this.filter = filter;
    }

    @Override
    public String filter(String text) {
        String maskedText = filter.filterSexyWords(text);
        maskedText = filter.filterPoliticalWords(maskedText);
        return maskedText;
    }

}

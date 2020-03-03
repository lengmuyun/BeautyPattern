package org.geekbang.time.pattern.adapter.usage.unify.adaptor;

import org.geekbang.time.pattern.adapter.usage.unify.out.BSensitiveWordsFilter;

public class BSensitiveWordsFilterAdaptor implements ISensitiveWordsFilter {

    private BSensitiveWordsFilter filter;

    public BSensitiveWordsFilterAdaptor(BSensitiveWordsFilter filter) {
        this.filter = filter;
    }

    @Override
    public String filter(String text) {
        return filter.filter(text);
    }

}

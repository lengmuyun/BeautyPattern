package org.geekbang.time.pattern.adapter.usage.unify.adaptor;

import org.geekbang.time.pattern.adapter.usage.unify.out.CSensitiveWordsFilter;

public class CSensitiveWordsFilterAdaptor implements ISensitiveWordsFilter {

    private CSensitiveWordsFilter filter;

    public CSensitiveWordsFilterAdaptor(CSensitiveWordsFilter filter) {
        this.filter = filter;
    }

    @Override
    public String filter(String text) {
        return filter.filter(text, "***");
    }

}

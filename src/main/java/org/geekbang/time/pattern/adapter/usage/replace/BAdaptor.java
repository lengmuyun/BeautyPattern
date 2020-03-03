package org.geekbang.time.pattern.adapter.usage.replace;

public class BAdaptor implements IA {

    private B b;

    public BAdaptor(B b) {
        this.b = b;
    }

    @Override
    public void fa() {
        b.fb();
    }
}

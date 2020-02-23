package org.geekbang.time.pattern.builder;

/**
 * 当 isRef 为 true 的时候，arg 表示 String 类型的 refBeanId，type 不需要设置；
 * 当 isRef 为 false 的时候，arg、type 都需要设置。
 */
public class ConstructorArg {

    private boolean isRef;
    private Class type;
    private Object arg;

    public ConstructorArg(Builder builder) {
        this.isRef = builder.isRef;
        this.type = builder.type;
        this.arg = builder.arg;
    }

    public boolean isRef() {
        return isRef;
    }

    public Class getType() {
        return type;
    }

    public Object getArg() {
        return arg;
    }

    public static class Builder {

        private boolean isRef;
        private Class type;
        private Object arg;

        public ConstructorArg build() {
            if (!isRef) {
                if (arg == null) {
                    throw new IllegalArgumentException("No ref bean must has arg.");
                }
                if (type == null) {
                    throw new IllegalArgumentException("No ref bean must has type.");
                }
            }
            return new ConstructorArg(this);
        }

        public Builder setRef(boolean ref) {
            isRef = ref;
            return this;
        }

        public Builder setType(Class type) {
            if (!isRef) {
                this.type = type;
            }
            return this;
        }

        public Builder setArg(Object arg) {
            if (isRef && !(arg instanceof String)) {
                throw new IllegalArgumentException("arg should be type of String.");
            }
            this.arg = arg;
            return this;
        }
    }
}

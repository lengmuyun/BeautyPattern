package org.geekbang.time.pattern.builder;

public class ResourcePoolConfig {

    private String name;
    private int maxTotal;
    private int maxIdle;
    private int minIdle;

    public ResourcePoolConfig(Builder builder) {
        this.name = builder.name;
        this.maxTotal = builder.maxTotal;
        this.maxIdle = builder.maxIdle;
        this.minIdle = builder.minIdle;
    }

    public String getName() {
        return name;
    }

    public int getMaxTotal() {
        return maxTotal;
    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public int getMinIdle() {
        return minIdle;
    }

    public static class Builder {
        private static final int DEFAULT_MAX_TOTAL = 8;
        private static final int DEFAULT_MAX_IDLE = 8;
        private static final int DEFAULT_MIN_IDLE = 0;

        private String name;
        private int maxTotal = DEFAULT_MAX_TOTAL;
        private int maxIdle = DEFAULT_MAX_IDLE;
        private int minIdle = DEFAULT_MIN_IDLE;

        public ResourcePoolConfig build() {
            if (name == null || name.length() == 0) {
                throw new IllegalArgumentException("name should not be empty.");
            }
            if (maxIdle > maxTotal) {
                throw new IllegalArgumentException("maxidle can not great than maxTotal.");
            }
            if (minIdle > maxTotal || minIdle > maxIdle) {
                throw new IllegalArgumentException("minIdle can not great than maxTotal or maxIdle.");
            }
            return new ResourcePoolConfig(this);
        }

        public Builder setName(String name) {
            if (name == null || name.length() == 0) {
                throw new IllegalArgumentException("name should not be empty.");
            }
            this.name = name;
            return this;
        }

        public Builder setMaxTotal(int maxTotal) {
            if (maxTotal <= 0) {
                throw new IllegalArgumentException("maxTotal should be positive.");
            }
            this.maxTotal = maxTotal;
            return this;
        }

        public Builder setMaxIdle(int maxIdle) {
            if (maxIdle < 0) {
                throw new IllegalArgumentException("maxIdle should not be negative.");
            }
            this.maxIdle = maxIdle;
            return this;
        }

        public Builder setMinIdle(int minIdle) {
            if (minIdle < 0) {
                throw new IllegalArgumentException("minIdle should not be negative.");
            }
            this.minIdle = minIdle;
            return this;
        }
    }

}

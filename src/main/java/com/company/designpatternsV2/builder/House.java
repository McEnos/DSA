package com.company.designpatternsV2.builder;

public class House {
    // Required parameters
    private String foundation;
    private String structure;

    // Optional parameters
    private boolean hasGarden;
    private boolean hasSwimmingPool;

    private House(HouseBuilder builder) {
        this.foundation = builder.foundation;
        this.structure = builder.structure;
        this.hasGarden = builder.hasGarden;
        this.hasSwimmingPool = builder.hasSwimmingPool;
    }
    public String getFoundation() {
        return foundation;
    }

    public String getStructure() {
        return structure;
    }

    public boolean hasGarden() {
        return hasGarden;
    }

    public boolean hasSwimmingPool() {
        return hasSwimmingPool;
    }

    @Override
    public String toString() {
        return "House{" +
                "foundation='" + foundation + '\'' +
                ", structure='" + structure + '\'' +
                ", hasGarden=" + hasGarden +
                ", hasSwimmingPool=" + hasSwimmingPool +
                '}';
    }

    public static class HouseBuilder {
        // Required parameters
        private String foundation;
        private String structure;

        // Optional parameters
        private boolean hasGarden;
        private boolean hasSwimmingPool;

        public HouseBuilder(String foundation, String structure) {
            this.foundation = foundation;
            this.structure = structure;
        }

        public HouseBuilder setGarden(boolean hasGarden) {
            this.hasGarden = hasGarden;
            return this;
        }

        public HouseBuilder setSwimmingPool(boolean hasSwimmingPool) {
            this.hasSwimmingPool = hasSwimmingPool;
            return this;
        }

        public House build() {
            return new House(this);
        }
    }



}

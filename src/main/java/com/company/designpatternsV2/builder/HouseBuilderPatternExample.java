package com.company.designpatternsV2.builder;

public class HouseBuilderPatternExample {
    public static void main(String[] args) {
        House house1 = new House.HouseBuilder("Concrete", "Wood")
                .setGarden(true)
                .setSwimmingPool(false)
                .build();

        House house2 = new House.HouseBuilder("Steel", "Brick")
                .setGarden(false)
                .setSwimmingPool(true)
                .build();

        System.out.println(house1);
        System.out.println(house2);
    }
}

package com.company.java8.chapter5;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.company.java8.chapter5.Dish.Type.OTHER;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, OTHER),
                new Dish("rice", true, 350, OTHER),
                new Dish("season fruit", true, 120, OTHER),
                new Dish("pizza", true, 550, OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH) );

        List<Dish> specialMenu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, OTHER));


        List<Dish> slicedMenu1 = specialMenu.stream().takeWhile(value -> value.getCalories() < 320)
                .collect(toList());

        List<Dish> slicedMenu2 = specialMenu.stream().dropWhile(value -> value.getCalories() < 320).collect(toList());

        List<Dish> truncatedDishes = specialMenu.stream().filter(value -> value.getCalories() > 300)
                .limit(2).collect(toList());

        List<Dish> truncatedDishes2 = specialMenu.stream().filter(value -> value.getCalories() > 300)
                .skip(2)
                .collect(toList());



        List<String> threeHighCaloricDishNames = menu.stream()
                .filter((value) -> {
                   // System.out.println("Filtering>>> "+value.getName());
                  return   value.getCalories() > 300;
                })
                .map(Dish::getName)
                .limit(3)
                .collect(toList());

        List<String> names = Arrays.asList("Modern","Java","In","Action");

        //Stream<String> stream = names.stream();
        
       // stream.forEach(System.out::println);
        List<Dish> vegeterianDishes = menu.stream().filter(Dish::isVegetarian)
            //    .map(Dish::getName)
                .collect(toList());

        List<Integer> integers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);

        List<Integer> filteredIntegers = integers.stream()
                .filter(value -> value % 2 == 0)
                .distinct()
                .collect(toList());
        System.out.println(filteredIntegers);;

        List<String> bookNames = Arrays.asList("Modern","Java","In","Action");
        List<Integer> lengths = bookNames.stream().map(String::length).collect(toList());

        List<String> list = Arrays.asList("Hello", "world");

        //flatMap method lets you replace each value of a stream with
        //another stream and then concatenates all the generated streams into a single stream

        List<String> collected = list.stream()
                .map(word -> word.split(""))
                .flatMap(value -> Arrays.stream(value))
                .distinct()
                .collect(toList());
        System.out.println(collected);

        String[] arrayOfWords = {"Goodbye","world"};
        Stream<String> stream = Arrays.stream(arrayOfWords);

        if (menu.stream().anyMatch(Dish::isVegetarian)){
            System.out.println("The menu is (somewhat) vegetarian friendly!!");
        }

        boolean isHealthy = menu.stream().allMatch(value -> value.getCalories() < 1000);

        boolean isHealthy2 = menu.stream().noneMatch(value -> value.getCalories() >= 100);

        menu.stream().filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(value -> System.out.println(value.getName()));
              //  .orElse(new Dish("",false,0,OTHER));

        List<Integer> randomNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSquareDivisibleByThree = randomNumbers.stream().map(n -> n*n)
                .filter(n -> n % 3 == 0)
                .findFirst();
             //   .collect(toList());

        Integer summation = randomNumbers.stream().reduce(0, (a, b) -> a + b);

        Integer product = randomNumbers.stream().reduce(1, (a, b) -> a * b);

        Optional<Integer> integerOptional = randomNumbers.stream().reduce((a, b) -> a + b);


        Optional<Integer> min = randomNumbers.stream().reduce((a, b) -> a < b ? a : b);

        Optional<Integer> max = randomNumbers.stream().reduce((a, b) -> a > b ? a : b);

        long count = randomNumbers.stream().count();


        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        List<Transaction> transactionsFor2011 = transactions.stream().filter(value -> value.getYear() == 2011)
               .sorted(comparing(value -> value.getTrader().getName()))
                .collect(toList());
        System.out.println(transactionsFor2011);

        List<String> uniqueCities = transactions.stream().map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct().collect(toList());
        System.out.println(uniqueCities);

        List<Trader> cambridgeTraders = transactions.stream().map(Transaction::getTrader)
                .filter(value -> "Cambridge".equalsIgnoreCase(value.getCity()))
                .sorted(comparing(Trader::getName))
                .collect(toList());
        System.out.println(cambridgeTraders);

        String traderNames = transactions.stream().map(Transaction::getTrader)
                .map(Trader::getName)
                .sorted()
                        .collect(joining());
               // .reduce("",(n1,n2) -> n1 + n2);
        System.out.println(traderNames);

        boolean milanBased = transactions.stream().map(Transaction::getTrader)
                .anyMatch(value -> "Milan".equalsIgnoreCase(value.getCity()));

        List<Transaction> cambridgeTransactions = transactions.stream()
                .filter(value -> "Cambridge".equalsIgnoreCase(value.getTrader().getCity()))
                .collect(toList());
        System.out.println(cambridgeTransactions);

        Optional<Integer> highestValue = transactions.stream()
                .map(Transaction::getValue)
                .reduce((t1, t2) -> t1 > t2 ? t1 : t2);


        Optional<Transaction> smallestTransaction = transactions.stream()
                .reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);

        transactions.stream()
                .min(comparing(Transaction::getValue));

        int calories = menu.stream().mapToInt(Dish::getCalories).sum();


    }
}

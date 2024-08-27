package com.company.completablefuture;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
    }

    private double calculatePrice(String product) {
        delay();
        Random r = new Random();
        return r.nextDouble() * product.charAt(0) + product.charAt(1);
    }

   /* private Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        futurePrice.thenCombine();
        futurePrice.thenCompose()
                .orTimeout(3, TimeUnit.DAYS)
                .completeOnTimeout(new Object(),3,TimeUnit.DAYS)
                .
        new Thread(() -> {
            double price = calculatePrice(product);
            futurePrice.complete(price);
        }).start();
        return futurePrice;
    }*/

    private CompletableFuture<Double> getPricesV2(String product){
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }



    public static void delay() {
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

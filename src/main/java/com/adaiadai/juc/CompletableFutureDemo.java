package com.adaiadai.juc;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {

    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> "supplyAsync").thenAccept(System.out::println);
    }

}

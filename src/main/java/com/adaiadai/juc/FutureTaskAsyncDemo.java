package com.adaiadai.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskAsyncDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(new MyCallable());
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }

}


class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(3* 1000);
        return "call finished";
    }

}

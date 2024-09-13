package com.adaiadai.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(3 * 1000);
        System.out.println("Running..");
        return "call finished";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableDemo callableDemo = new CallableDemo();
        FutureTask<String> futureTask = new FutureTask<>(callableDemo);
        new Thread(futureTask).start();
        System.out.println("FutureTask started");
        System.out.println(futureTask.get());
        System.out.println("FutureTask Finished");
    }

}

package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;



public class MyTask extends MyMain implements Runnable {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void run() {
        Long n = Long.valueOf(0);

        long start = System.currentTimeMillis();
        for (int i = 1; i <=m; i++) {
            n = n + i;
        }
        long finish = System.currentTimeMillis();
        long elapsed = finish - start;
            System.out.println("Сумма всех чисел - " + n + ".Затраченное время - "
                    + elapsed +"мс");
    }
}



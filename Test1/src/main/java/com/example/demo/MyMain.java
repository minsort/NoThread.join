package com.example.demo;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyMain {

    public static Integer m;
    public static Integer k;

    public static void main(String[] args)  {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите целое число от 1 до М ");
        try {
            m = Integer.parseInt(reader.readLine());
        }
        catch (NumberFormatException e){
            System.out.println("Осторожней... Вводить нужно цифры от 0 до 1000000000");
            throw new RuntimeException();
        }
        catch (IOException e) {
            System.out.println("Ой, ошибочка вышла...");
            throw new RuntimeException();
        }

        System.out.println("Введите число потоков ");
        try {
            k = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException e){
            System.out.println("Сказано же - нужно вводить ЧИСЛО!!!");
        } catch (IllegalArgumentException c) {
            System.out.println("Если потоков меньше 1 - значит некому задачу выполнять((");
        } catch (Exception e) {
            System.out.println("Ой, ошибочка вышла...");
            e.printStackTrace();
        }
        try {
            ExecutorService exec = Executors.newFixedThreadPool(k);
            exec.submit(new MyTask());
            exec.shutdownNow();
        } catch (IllegalArgumentException c) {
            System.out.println("Если потоков меньше 1, значит - некому задачу выполнять((");
        }
    }
}


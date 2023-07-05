package com.lambda;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThreadAndLambda implements Runnable {
    public static void main(String[] args) {

        /*调用异步任务2*/
        new Thread(new ThreadAndLambda()).start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "：异步任务");
        }).start();



        /*遍历List集合*/
        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API", "D");
        for (String feature : features) {
            System.out.println(feature);
        }
        /*使用Lambda表达式遍历List集合*/
        features.forEach(n -> System.out.println(n));


        Predicate<String> startsWithJ = (n) -> n.startsWith("L");
        Predicate<String> fourLetterLong = (n) -> n.length() == 7;
        //方法引用是使用两个冒号::这个操作符号
        features.stream()
                .filter(startsWithJ)
                .filter(fourLetterLong).forEach(System.out::println);




        // Without lambda expressions:
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        for (Integer cost : costBeforeTax) {
            double price = cost + 0.12 * cost;
            System.out.println(price);
        }

        // With Lambda expression:
        List<Integer> costBeforeTax2 = Arrays.asList(100, 200, 300, 400, 500);
        costBeforeTax2.stream().map((cost) -> cost + .12 * cost)
                .forEach(System.out::println);



        /*当一种过滤*/
        List<String> filtered = features.stream().filter(x -> x.length() > 2)
                .collect(Collectors.toList());
        System.out.printf("Original List : %s, filtered list : %s %n",
                features, filtered);

        System.out.println("----------------------------");
        /*当一种过滤*/
        features.stream().map(x -> x.toUpperCase())
                .forEach(System.out::println);
        String G7Countries = features.stream().map(x -> x.toUpperCase())
                .collect(Collectors.joining(", "));
        System.out.println(G7Countries);



        /*计算List中的元素的最大值，最小值，总和及平均值*/
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x)
                .summaryStatistics();
        System.out.println("Highest prime number in List : " + stats.getMax());
        System.out.println("Lowest prime number in List : " + stats.getMin());
        System.out.println("Sum of all prime numbers : " + stats.getSum());
        System.out.println("Average of all prime numbers : " + stats.getAverage());

/*        Output :
        Highest prime number in List : 29
        Lowest prime number in List : 2
        Sum of all prime numbers : 129
        Average of all prime numbers : 12.9*/


    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "：异步任务2");
    }


}

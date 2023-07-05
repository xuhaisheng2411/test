package com.Consumer;

/**
 * @Author: Administrator
 * @Desctription: TODO
 * @Date: Created in 2022/4/20 0020 9:52
 * @Version: 1.0
 */
import java.util.Arrays;
import java.util.function.Consumer;

public class consumer {
    public static void main(String[] args) {
        String[] arr = {"张三,男","李四,男","王五,男"};
        printInfo(arr,m->{
            String name = m.split(",")[0];
            System.out.print("name:"+name);
        },m->{
            String age = m.split(",")[1];
            System.out.println(",age:"+age);
        });
    }

    public static void printInfo(String[] arr, Consumer<String> consumer1, Consumer<String> consumer2) {
        Arrays.stream(arr).forEach(m -> consumer1.andThen(consumer2).accept(m));
    }

}

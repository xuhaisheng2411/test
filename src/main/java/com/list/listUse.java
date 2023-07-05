package com.list;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = listUse.class)
@Slf4j
public class listUse {


    public static void main(String[] args) {
    }


    /*
    * 1)普通遍历：for(int i=0; i< arrays.size(); i++)

     2)增强for遍历：for(String str : arrays)

     3)list.forEach((str) -> xxxxx)

     4)使用Iterator迭代器遍历

     5)java8 stream遍历

    * */

    @Test
    public void testList() {
        // 循环遍历List的5方法
        List<String> strList = new ArrayList<>();
        strList.add("aaa");
        strList.add("bbb");
        strList.add("ccc");




        // 1. 普通遍历方式
        for (int i = 0; i < strList.size(); i++) {
            System.out.println(strList.get(i));
        }


        // 2.增强的for循环
        for (String str : strList) {
            System.out.println(str);
        }


        // 3. 使用Iterator迭代器
        Iterator<String> it = strList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            System.out.println(str);
        }


        // 4. java8 Lambda方式 strList.forEach(System.out::println);//和下面的写法等价
        strList.forEach(str -> {
            System.out.println(str);
        });


        strList.stream()
                .filter(a -> a != null)
                .forEach(a -> System.out.println("code = " + a));

    }






    @Test
    public void testHashMap2() {
        List<String> strList = new ArrayList<>();
        strList.add("aaa");
        strList.add("bbb");
        strList.add("ccc");
        System.out.println(strList);//[aaa, bbb, ccc]
        strList.stream()
                .filter(a -> a != null)
                .forEach(a -> System.out.println("code = " + a));


    }


}

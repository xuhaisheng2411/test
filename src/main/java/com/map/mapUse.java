package com.map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=mapUse.class)
public class mapUse {



    public static void main(String[] args) {
    }


    @Test
    public void testHashMap1() {
    //通过Map.keySet使用iterator遍历
        System.out.println("-----3-----");
        Map<Integer, String> map = new HashMap<>();
        map.put(001, "Java");
        map.put(002, "数据库");
        map.put(003, "Vue");
        System.out.println(map);

        /**
          * @Author oscar
          * @Desctription TODO
          * @Date 2022/4/21 0021 9:52
          * @Param []
          * @return 
          */
        System.out.println("方法1======================================================");

        // 通过Map.keySet使用iterator遍历key,然后通过key得到对应的value值
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            String value = map.get(key);
            System.out.println("key = " + key + ", value = " + value);
        }


        System.out.println("方法2======================================================");

        // 通过Map.keySet遍历key,然后通过key得到对应的value值
        for (Integer key : map.keySet()) {
            System.out.println("key = " + key + ", value = " + map.get(key));
        }





        System.out.println("方法3======================================================");

        // 通过Map.entrySet使用iterator遍历key和value；注意 Set entrySet()：返回所有key-value对构成的Set集合
        Iterator<Map.Entry<Integer, String>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<Integer, String> entry = entries.next();
           // System.out.println(entry);
        }
        // 使用For-Each迭代entries，通过Map.entrySet遍历key和value
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
        }


        System.out.println("方法4======================================================");


        // 使用lambda表达式forEach遍历
        map.forEach((k, v) -> System.out.println("key = " + k + ", value = " + v));

        System.out.println("方法5======================================================");

        map.keySet().forEach(key -> {
            System.out.println("key = " + key + ", value = " + map.get(key));
        });


    }


    @Test
    public void testHashMap2() {
        Map<Integer, String> map = new HashMap<>();
        map.put(001, "Java");
        map.put(002, "数据库");
        map.put(003, "Vue");
        System.out.println(map);//{1=Java, 2=数据库, 3=Vue}

        // 使用lambda表达式forEach遍历
        map.forEach((k, v) -> System.out
                .println("key = " + k + ", value = " + v));



    }


}

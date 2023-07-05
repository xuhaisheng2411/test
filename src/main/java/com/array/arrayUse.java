package com.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.stream.Collectors;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = arrayUse.class)
public class arrayUse {


    public static void main(String[] args) {
/*        Runnable target = new MyRunnable2();
        Thread t2 = new Thread(target);
        t2.start();*/


        Hashtable ht=new Hashtable();
        Hashtable gg=new Hashtable();

        ht.put("aaa","hash");
        ht.put("bbb","table");

        gg = (Hashtable) ht.clone();
        System.out.println(ht);
        System.out.println(gg);


    }


    @Test
    public void testArr() {
        int Arr[][] = {{5, 7, 15}, {8, 4, 11}, {3, 6, 13}};
        for (int i = 0; i < Arr.length; i++) {
            for (int j = 0; j < Arr[i].length; j++) {
                System.out.print(Arr[i][j] + "\n");
            }
        }


        for (int[] element : Arr) {
            System.out.println(element);
        }

    }


    @Test
    public void testArr2() {
        int Arr[][] = {{5, 7, 15}, {8, 4, 11}, {3, 6, 13}};
        for (int[] element : Arr) {
            System.out.println(element);
            for (int pa : element) {
                System.out.println(pa);
            }
        }
    }


    @Test
    public void testArr3() {
        int Arr[][] = {{5, 7, 15}, {8, 4, 11}, {3, 6, 13}};
        System.out.println("Arr:" + Arrays.toString(Arr));  //输出的是数组元素的地址。
        int b[][] = {{5, 7, 15}, {8, 4, 11}, {3, 6, 13}};
        System.out.println("Arr:" + Arrays.deepToString(b));

        /*
        * Arr:[[I@15db9742, [I@6d06d69c, [I@7852e922]
          Arr:[[5, 7, 15], [8, 4,11], [3, 6, 13]]
        */


        //int数组转成string数组
        int[] array3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String[] strArr = new String[array3.length];
        for (int i = 0; i < array3.length; i++) {
            strArr[i] = String.valueOf(array3[i]);
        }
        System.out.println("strArr is:" + strArr);
        for (String d : strArr) {
            System.out.println("string数组=" + d);
        }
        int positon = Arrays.binarySearch(strArr, "6");
        System.out.println("str is:" + positon);


        //数组中是否包含某一个值
        String a = "1";
        if (Arrays.asList(strArr).contains(a)) {
            System.out.println("1在这里");
        }


        //将string数组转成set集合
        Set<Integer> collect = Arrays.stream(array3).distinct().boxed().collect(Collectors.toSet());
        //将int数组转成set list集合
        List<Integer> collect2 = Arrays.stream(array3).distinct().boxed().collect(Collectors.toList());
        Set<String> set = new HashSet<String>(Arrays.asList(strArr));
        System.out.println("set:" + set);
        for (String df : set) {
            System.out.println("set集合=" + df);
        }
    }





    /*

     Arrays.asList

    （1）该方法不适用于基本数据类型（byte,short,int,long,float,double,boolean）

    （2）该方法将数组与列表链接起来，当更新其中之一时，另一个自动更新

    （3）不支持add和remove方法

    */

    @Test
    public void testArr4() {
        //将int数组转成list集合
        Integer[] ob = {11,22,33};
        int[] array3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        List<Integer> oblist = Arrays.asList(ob);
        List<Integer> collect2 = Arrays.stream(ob).distinct().collect(Collectors.toList());
        System.out.println("collect2="+collect2);
        System.out.println("oblist="+oblist);
        for(int a:oblist){
            System.out.println(a);
        }
        System.out.println("------------------------");



        //数组排序
        int[] arr4 = {3, 7, 2, 1, 9};
        Arrays.sort(arr4);
        System.out.println("arr4:"+arr4);
        for (int i = 0; i < arr4.length; i++) {
            System.out.println("arr4[i]:"+arr4[i]);
        }
        System.out.println("2------------------------");


        int[] arr5 = {3, 7, 2, 1, 9,3,45,7,8,8,3,2,65,34,5};
        Arrays.sort(arr5, 1, 4);  //从第几个到第几个之间的进行排序
        for (int i = 0; i < arr5.length; i++) {
            System.out.println("arr5[i]:"+arr5[i]);
        }






    }


}

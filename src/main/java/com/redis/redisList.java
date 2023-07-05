package com.redis;

import redis.clients.jedis.Jedis;

/**
 * redis中对于List类型的: rpush、lpush 操作示例
 */
public class redisList {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        /**
         * 示例1： 相当于执行 rpush mylist v1 v2 v3
         */
        Long rpush = jedis.rpush("mylist", "v1", "v2", "v3");
        System.out.println("rpush = " + rpush);
        System.out.println("======================");

        /**
         * 示例2： 相当于执行 lpush mylist v1 v2 v3
         */
        Long lpush = jedis.lpush("mylist", "v11", "v22", "v33");
        System.out.println("lpush = " + lpush);
        System.out.println("======================");


/*        List<String> mylist = jedis.lrange("mylist", 0, -1);
        mylist.stream().forEach(System.out::println);*/

        /**
         * 示例2： 相当于执行 lindex mylist 0
         */
        String mylist1 = jedis.lindex("mylist", 0);
        System.out.println("mylist1 = " + mylist1);

        /**
         * 示例4： 相当于执行 lindex mylist 4
         */
        String mylist2 = jedis.lindex("mylist", 4);
        System.out.println("mylist2 = " + mylist2);


        Long llen = jedis.llen("mylist");
        System.out.println("llen = " + llen);




    }
}
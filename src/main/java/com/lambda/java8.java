package com.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: Administrator
 * @Desctription: TODO
 * @Date: Created in 2022/4/20 0020 10:30
 * @Version: 1.0
 */
public class java8 {

    public  static void main(String[] args){
        //五个user对象
        User user1 = new User(1, "张三", 10);
        User user2 = new User(2, "李四", 15);
        User user3 = new User(3, "王五", 20);
        User user4 = new User(4, "赵六", 25);
        User user5 = new User(5, "严七", 30);

        //将User对象存入list
        List<User> userList = new ArrayList<User>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);


        System.out.println(userList);
        //[User{id=1, username='张三', age=10}, User{id=2, username='李四', age=15}, User{id=3, username='王五', age=20}, User{id=4, username='赵六', age=25}, User{id=5, username='严七', age=30}]

        //1.stram()方法：将集合装为流
        Stream<User> stream = userList.stream();
        System.out.println(stream);//打印对象地址。java.util.stream.ReferencePipeline$Head@65f651eb

        //2.collect()方法：将流转为集合
        List<User> users = userList.stream().collect(Collectors.toList());
        System.out.println(users);
        //[User{id=1, username='张三', age=10}, User{id=2, username='李四', age=15}, User{id=3, username='王五', age=20}, User{id=4, username='赵六', age=25}, User{id=5, username='严七', age=30}]

        //3.filter()方法：将转为流的集合过滤出满足要求的流
        List<User> userList1 = userList.stream().//将集合转为流
                filter(user -> user.getAge() > 20).//过滤出年龄大于20的user。（类似于sql中的where user.age > 20）
                collect(Collectors.toList());//将流转回集合（便于打印观察结果）
        System.out.println(userList1);//[User{id=4, username='赵六', age=25}, User{id=5, username='严七', age=30}]

        //4.map()方法：将每个元素映射成新元素
        List<User> userList2 = userList.stream().filter(user -> user.getAge() > 20).//过滤出年龄大于20的user
                map(user -> {//将过滤得到的user对象的年龄设置为50
            user.setAge(50);//执行你想要的操作，每个元素会映射产生新元素，所以map()方法要有返回值
            return user;//返回新元素
        }).collect(Collectors.toList());//将流转为集合

        System.out.println(userList2);//[User{id=4, username='赵六', age=50}, User{id=5, username='严七', age=50}]

        //5.limit(n)：获取n个元素
        List<User> userList3 = userList.stream().limit(3).collect(Collectors.toList());//获取前三个元素。类似于mysql数据库中的  'limit 参数一,参数二' 关键字的参数二
        System.out.println(userList3);//[User{id=1, username='张三', age=10}, User{id=2, username='李四', age=15}, User{id=3, username='王五', age=20}]

        //6.  skip(n)：跳过n元素
        List<User> userList4 = userList.stream().skip(2).collect(Collectors.toList());//跳过两个元素，类似于mysql数据库中  'limit 参数一,参数二' 关键字的参数一
        System.out.println(userList4);//[User{id=3, username='王五', age=20}, User{id=4, username='赵六', age=50}, User{id=5, username='严七', age=50}]

        //7.skip和limit组合实现分页
        List<User> userList5 = userList.stream().skip((2-1)*2).limit(2).collect(Collectors.toList());//获取第二页数据（每页显示两条数据）
        System.out.println(userList5);//[User{id=3, username='王五', age=20}, User{id=4, username='赵六', age=50}]

        //8.  distinct：去除重复元素
        //向集合中插入一个重复元素
        userList.add(user5);
        System.out.println(userList);//[User{id=1, username='张三', age=10}, User{id=2, username='李四', age=15}, User{id=3, username='王五', age=20}, User{id=4, username='赵六', age=50}, User{id=5, username='严七', age=50}, User{id=5, username='严七', age=30}]
        List<User> userList6 = userList.stream().distinct().collect(Collectors.toList());//去重（实体类中需要实现equals()和hashCode()）
        System.out.println(userList6);//[User{id=1, username='张三', age=10}, User{id=2, username='李四', age=15}, User{id=3, username='王五', age=20}, User{id=4, username='赵六', age=50}, User{id=5, username='严七', age=50}]

    }
}

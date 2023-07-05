package com.prototype;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Administrator
 * @Desctription: TODO
 * @Date: Created in 2022/6/6 0006 10:25
 * @Version: 1.0
 */
@RestController
//@Scope("prototype")
public class prototype {
    private Integer accessCount = 0;

    /*
      * @Author Administrator
      * @Desctription TODO
      * @Date 2022/6/6 0006 10:26
      * @Param
      * @return
      *
      *
      *
      * Controller 线程安不安全
      * 使用@Scope("prototype")后编程多例，线程安全
      */

    public prototype(){
        System.out.println("CategoryController创建了。。。");
    }

    @GetMapping("one")
    public Integer one(){
        System.out.println(++accessCount);
        return accessCount;
    }

    @GetMapping("two")
    public Integer two(){
        System.out.println(++accessCount);
        return accessCount;
    }

    @GetMapping("/is")
    public String is(){
        System.out.println(this);
        return "is";
    }

}

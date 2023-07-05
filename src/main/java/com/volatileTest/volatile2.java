package com.volatileTest;

/**
 * @Author: Administrator
 * @Desctription: TODO
 * @Date: Created in 2022/5/23 0023 18:33
 * @Version: 1.0
 */
public class volatile2 {
    public static void main(String[] args) {



        String s=null;
      /*  if((s!=null)&(s.length()>0));*/
        if((s!=null)&&(s.length()>0));
/*        if((s==null)|(s.length()==0));*/
        if((s==null)||(s.length()==0));

        boolean a=1.5f==1.5;
        boolean b=1.4f==1.4;

        System.out.println(a);
        System.out.println(b);
    }

}

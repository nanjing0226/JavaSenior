package com.nanjing.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Lambda表达式的使用
 *
 * 1、举例：(o1, o2) -> Integer.compare(o1,o2);
 * 2、格式：
 *      -> :lambda操作符 或 箭头操作符
 *      ->左边：lambda形参列表 (其实就是接口中的抽象方法的形参列表)
 *      ->右边：lambda体 (其实就是重写的抽象方法的方法体)
 *
 * 3、 Lambda表达式的使用： (分为6种情况介绍)
 *
 *  总结：
 *     ->左边：lambda形参列表的参数类型可以省略(类型推断)；如果lambda形参列表只有一个参数，其一对()也可以省略
 *     ->右边：lambda体应该使用一对{}包裹；如果lambda体只有一条执行语句（可能是return语句），省略这一对{}和return关键字
 *
 * 4、lambda表达式的本质： 作为接口的实例
 */
public class LambdaTest1 {
    //语法格式一：无参，无返回值
    @Test
    public void test1(){
        Runnable r1=new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱南京");
            }
        };
        r1.run();

        System.out.println("*****************");

        Runnable r2 = () -> {
            System.out.println("我爱南京");
        };

        r2.run();
    }

    //语法格式二： lambda 需要一个参数，但是没有返回值
    @Test
    public void test2(){
        Consumer<String> con = new Consumer<String>(){
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("江苏发展大会");

        System.out.println("*****************");

        Consumer<String> con1=(String s) -> {
          System.out.println(s);
        };
        con1.accept("南京博物院");
    }

    //语法格式三：数据类型可以省略，因为可由编译器推断得出，称为“类型推断”
    public void test3(){
        Consumer<String> con1=(String s) -> {
            System.out.println(s);
        };
        con1.accept("南京博物院");

        System.out.println("*****************");

        Consumer<String> con2=(s) -> {
            System.out.println(s);
        };
        con2.accept("南京博物院");
    }

    @Test
    public void test4(){
        ArrayList<String> list=new ArrayList<>();//类型推断

        int[] arr={1,2,3};//类型推断
    }

    //语法格式四：lambda 若只需要一个参数时，参数的小括号可以省略
    @Test
    public void test5(){
        Consumer<String> con2=(s) -> {
            System.out.println(s);
        };
        con2.accept("南京博物院");

        System.out.println("*****************");

        Consumer<String> con3= s -> {
            System.out.println(s);
        };
        con3.accept("南京博物院");
    }

    //语法格式五：lambda需要两个或以上的参数，多条执行语句，并且可以有返回值
    @Test
    public void test6(){

        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };
        System.out.println(com1.compare(12,21));

        System.out.println("*****************");

        Comparator<Integer> com2 = (o1,o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };

        System.out.println(com2.compare(12,6));
    }

    //语法格式六：当lambda 体只有一条语句时，return 与大括号若有，都可以省略
    @Test
    public void test7(){
        Comparator<Integer> com1 = (o1,o2) -> {
            return o1.compareTo(o2);
        };
        System.out.println(com1.compare(12,6));

        System.out.println("*****************");

        Comparator<Integer> com2 = (o1,o2) -> o1.compareTo(o2);
        System.out.println(com2.compare(12,6));

    }

}

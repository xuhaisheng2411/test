package com.Consumer;

/**
 * @Author: Administrator
 * @Desctription: TODO
 * @Date: Created in 2022/4/20 0020 10:03
 * @Version: 1.0
 */
public class Student {
    String firstName;
    String lastName;
    Double grade;
    Double feeDiscount = 0.0;
    Double baseFee = 20000.0;

    public Student(String firstName, String lastName, Double grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    public void printFee() {
        Double newFee = baseFee - ((baseFee * feeDiscount) / 100);
        System.out.println("The fee after discount: " + newFee);
    }

}

package com.Consumer;

/**
 * @Author: Administrator
 * @Desctription: TODO
 * @Date: Created in 2022/4/20 0020 10:03
 * @Version: 1.0
 */
import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateConsumerDemo {
    public static Student updateStudentFee(Student student, Predicate<Student> predicate, Consumer<Student> consumer) {
        // Use the predicate to decide when to update the discount.
        if (predicate.test(student)) {
            // Use the Consumer to update the discount value.
            consumer.accept(student);
        }
        return student;
    }

    @Test
    public void test() {
        Student student1 = new Student("Ashok", "Kumar", 9.5);
        student1 = updateStudentFee(student1, new Predicate<Student>() {
            @Override
            public boolean test(Student t) {
                return t.grade > 8.5;
            }
        }, new Consumer<Student>() {
            @Override
            public void accept(Student t) {
                t.feeDiscount = 30.0;
            }
        });
        student1.printFee();

        Student student2 = new Student("Rajat", "Verma", 8.0);
        student2 = updateStudentFee(student2, student -> student.grade >= 8, student -> student.feeDiscount = 20.0);
        student2.printFee();
    }


}

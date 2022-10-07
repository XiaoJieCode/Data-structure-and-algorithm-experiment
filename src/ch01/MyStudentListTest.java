package ch01;

import org.junit.Test;

public class MyStudentListTest {
    @Test
    public void testAdd(){
        MyStudentList myStudentList = new MyStudentList();

        Student student = new Student("20212011104");
        student.setStuName("ed");
        Student student1 = new Student("20212011103");
        Student student2 = new Student("20212011103");
        long time = System.nanoTime();
        for (int i = 0; i < 10000; i++) {



            System.out.println("i===="+i+"---"+(System.nanoTime() - time));
            myStudentList.add(new Student(String.valueOf(i)));
        }


    }
}
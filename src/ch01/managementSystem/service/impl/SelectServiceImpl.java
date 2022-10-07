package ch01.managementSystem.service.impl;


import ch01.managementSystem.beans.Student;
import ch01.managementSystem.service.SelectService;

import static ch01.managementSystem.service.MyDatabase.elements;

public class SelectServiceImpl implements SelectService {



    @Override
    public Student selectByNum(String num) {
        for (int i = 0; i <elements.length(); i++) {
            Student stu = (Student)elements.get(i);
            if (stu.getNum().equals(num)) {
                return stu;
            }
        }
        return null;
    }

    @Override
    public Student[] selectByName(String name) {
        Student[] temp = {};
        int count = 0;
        if (name.equals("")){
            temp=new Student[elements.length()];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = (Student) elements.get(i);
            }
        }
        for (int i = 0; i <elements.length(); i++) {
            Student stu = (Student)elements.get(i);
            if (stu.getName().equals(name)) {
                count++;
                temp = new Student[count];
                temp[count-1] = stu;
            }
        }
        return temp;
    }
}

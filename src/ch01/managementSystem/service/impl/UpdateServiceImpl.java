package ch01.managementSystem.service.impl;


import ch01.managementSystem.beans.Student;
import ch01.managementSystem.service.UpdateService;

import static ch01.managementSystem.service.MyDatabase.elements;

public class UpdateServiceImpl implements UpdateService {

    @Override
    public boolean update(Student student) {
        for (int i = 0; i < elements.length(); i++) {
            if ((((Student)(elements.get(i))).getNum().equals(student.getNum()))) {
                Student tempStu = (Student) elements.get(i);

                // ÐÞ¸Ä
                tempStu.setName(student.getName());
                tempStu.setSex(student.getSex());
                tempStu.setEnglishGrade(student.getEnglishGrade());
                tempStu.setMathGrade(student.getMathGrade());

                return true;
            }
        }
       return false;
    }
}

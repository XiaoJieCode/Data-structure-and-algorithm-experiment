package ch01.managementSystem.service.impl;


import ch01.managementSystem.beans.Student;
import ch01.managementSystem.service.AddService;

import static ch01.managementSystem.service.MyDatabase.elements;

public class AddServiceImpl implements AddService{

    @Override
    public boolean add(Student student) {
        // 首先判断学生库中有无存在学生
        for (int i = 0; i < elements.length(); i++) {
            if (elements.get(i).equals(student.getNum())) {
                return false;
            }
        }
        elements.insert(elements.length(), student);

        return true;
    }
}

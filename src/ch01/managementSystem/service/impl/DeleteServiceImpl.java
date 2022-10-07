package ch01.managementSystem.service.impl;


import ch01.managementSystem.beans.Student;
import ch01.managementSystem.service.DeleteService;

import static ch01.managementSystem.service.MyDatabase.elements;

public class DeleteServiceImpl implements DeleteService {


    @Override
    public boolean deleteById(String num) {
        for (int i = 0; i < elements.length(); i++) {
            if (((Student)elements.get(i)).getNum().equals(num)) {
                elements.remove(i);
                return true;
            }
        }
       return false;
    }
}

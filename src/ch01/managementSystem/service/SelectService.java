package ch01.managementSystem.service;


import ch01.managementSystem.beans.Student;

public interface SelectService {
    public Student selectByNum(String num);
    public Student[] selectByName(String name);

}

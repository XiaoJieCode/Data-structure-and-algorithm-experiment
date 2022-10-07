package ch01.managementSystem.test;

import ch01.managementSystem.beans.Student;
import ch01.managementSystem.service.*;
import ch01.managementSystem.service.impl.*;
import org.junit.Test;

public class MSTest {
    // 初始数据
    public static final AddService addService = new AddServiceImpl();
    public static final SelectService selectService = new SelectServiceImpl();
    public static final DeleteService deleteService = new DeleteServiceImpl();
    public static final UpdateService updateService = new UpdateServiceImpl();
    public static final SqListImpl sqList = MyDatabase.elements;
    static {
        Student a = new Student("2008001","Alan" , "F", 93.0, 88.0);
        Student b = new Student("2008002","Danie" , "M", 75.0, 69.0);
        Student c = new Student("2008003","Helen" , "M", 56.0, 77.0);
        Student d = new Student("2008004","Bill" , "F", 87.0, 90.0);
        Student e = new Student("2008005","Peter" , "M", 79.0, 86.0);
        Student f = new Student("2008006","Amy" , "F", 68.0, 75.0);
        sqList.insert(sqList.length(),a);
        sqList.insert(sqList.length(),b);
        sqList.insert(sqList.length(),c);
        sqList.insert(sqList.length(),d);
        sqList.insert(sqList.length(),e);
        sqList.insert(sqList.length(),f);
    }


    @Test
    public void testAddServiceImpl(){
        System.out.println("testAddServiceImpl");
        // 先查看是否有20212011104学生信息
        System.out.println(selectService.selectByNum("20212011104"));
        // 生成学生对象
        Student a = new Student("20212011104","熊文杰" , "M", 100, 100);
        // 添加一个新学生
        addService.add(a);
        // 查看是否有新增学生
        System.out.println(selectService.selectByNum("20212011104"));
    }
    @Test
    public void testDeleteServiceImpl(){
        System.out.println("testDeleteServiceImpl");
        // 删除学号为2008001学生
        boolean b = deleteService.deleteById("2008001");
        // 查看是否有删除学生
        System.out.println("是否删除成功："+b);
    }
    @Test
    public void testSelectServiceImpl(){
        System.out.println("testSelectServiceImpl");
        // 查询学号为2008001学生
        Student student = selectService.selectByNum("2008001");
        System.out.println(student);
    }
    @Test
    public void testUpdateServiceImpl(){
        System.out.println("testUpdateServiceImpl");
        // 修改2008001学号的学生姓名更改为熊文杰
        // 首先查询学号为2008001的学生
        System.out.println(selectService.selectByNum("2008001"));
        Student a = new Student("2008001","熊文杰" , "F", 93.0, 88.0);
        // 修改
        updateService.update(a);
        // 查看是否修改
        System.out.println(selectService.selectByNum("2008001"));

    }
}

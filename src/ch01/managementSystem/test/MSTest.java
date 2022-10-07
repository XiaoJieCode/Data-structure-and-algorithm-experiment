package ch01.managementSystem.test;

import ch01.managementSystem.beans.Student;
import ch01.managementSystem.service.*;
import ch01.managementSystem.service.impl.*;
import org.junit.Test;

public class MSTest {
    // ��ʼ����
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
        // �Ȳ鿴�Ƿ���20212011104ѧ����Ϣ
        System.out.println(selectService.selectByNum("20212011104"));
        // ����ѧ������
        Student a = new Student("20212011104","���Ľ�" , "M", 100, 100);
        // ���һ����ѧ��
        addService.add(a);
        // �鿴�Ƿ�������ѧ��
        System.out.println(selectService.selectByNum("20212011104"));
    }
    @Test
    public void testDeleteServiceImpl(){
        System.out.println("testDeleteServiceImpl");
        // ɾ��ѧ��Ϊ2008001ѧ��
        boolean b = deleteService.deleteById("2008001");
        // �鿴�Ƿ���ɾ��ѧ��
        System.out.println("�Ƿ�ɾ���ɹ���"+b);
    }
    @Test
    public void testSelectServiceImpl(){
        System.out.println("testSelectServiceImpl");
        // ��ѯѧ��Ϊ2008001ѧ��
        Student student = selectService.selectByNum("2008001");
        System.out.println(student);
    }
    @Test
    public void testUpdateServiceImpl(){
        System.out.println("testUpdateServiceImpl");
        // �޸�2008001ѧ�ŵ�ѧ����������Ϊ���Ľ�
        // ���Ȳ�ѯѧ��Ϊ2008001��ѧ��
        System.out.println(selectService.selectByNum("2008001"));
        Student a = new Student("2008001","���Ľ�" , "F", 93.0, 88.0);
        // �޸�
        updateService.update(a);
        // �鿴�Ƿ��޸�
        System.out.println(selectService.selectByNum("2008001"));

    }
}

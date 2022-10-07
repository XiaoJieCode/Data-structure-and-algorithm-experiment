package MyList.test;

import MyList.exception.MyListOutBoundException;
import MyList.impl.SqListImpl;


class SqListTest {
    public SqListImpl list = new SqListImpl();

    @org.junit.jupiter.api.Test
    void clear() {
        System.out.println("-----Test void clear()");
        list.insert(list.length(), new Object());
        list.insert(list.length(), new Object());
        list.insert(list.length(), new Object());
        list.insert(list.length(), new Object());
        System.out.println("当前元素：");
        list.display();
        System.out.println("清除后元素：");
        list.clear();
        list.display();
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        System.out.println("-----Test void isEmpty()");
        list.insert(list.length(), new Object());
        System.out.println("是否为空：" + list.isEmpty());

        list.clear();
        System.out.println("是否为空：" + list.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void length() {
        System.out.println("-----Test void length()");
        System.out.println("当前list长度：" + list.length());
        list.insert(list.length(), new Object());
        System.out.println("当前list长度：" + list.length());
    }

    @org.junit.jupiter.api.Test
    void get() {
        System.out.println("-----Test void get()");
        list.insert(list.length(), new Object());
        System.out.println(list.get(0));
        list.insert(list.length(), new Object());
        list.insert(list.length(), new Object());
        System.out.println(list.get(0));
        System.out.println(list.get(1));
    }

    @org.junit.jupiter.api.Test
    void insert() {
        System.out.println("-----Test void insert()");
        list.insert(list.length(), new Object());
        list.display();
    }

    @org.junit.jupiter.api.Test
    void remove() {
        System.out.println("-----Test void remove()");
        list.insert(list.length(), new Object());
        list.display();
        list.remove(0);
        list.display();

    }

    @org.junit.jupiter.api.Test
    void indexOf() {
        System.out.println("-----Test void indexOf()");
        Object object1 = new Object();
        Object object2 = new Object();
        Object object3 = new Object();
        list.insert(0, object1);
        list.insert(1, object2);
        list.insert(2, object3);
        list.display();
        System.out.println(list.indexOf(object3));
    }

    @org.junit.jupiter.api.Test
    void display() {
        System.out.println("-----Test void display()");
        int i = 0;
        for (i = 0; i < 11; i++) {
            list.insert(i, new Object());
        }
        list.display();
        System.out.println(list.length());
    }
}
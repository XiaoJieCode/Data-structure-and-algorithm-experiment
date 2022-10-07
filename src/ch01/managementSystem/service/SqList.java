package ch01.managementSystem.service;

public interface SqList {
    public void clear();
    public boolean isEmpty();
    public int length();
    public Object get(int i);
    public void insert(int i, Object object);
    public void remove(int i);
    public int indexOf(Object object);
    public void display();

}

package ch01.managementSystem.service.impl;

import MyList.SqList;
import MyList.exception.MyListOutBoundException;

public class SqListImpl implements SqList {
    private Object[] listElem;
    private int curLen;

    public SqListImpl() {
        listElem = new Object[]{};
        curLen = 0;
    }

    @Override
    public void clear() {
        this.curLen = 0;
    }

    @Override
    public boolean isEmpty() {
        return curLen == 0;
    }

    @Override
    public int length() {
        return curLen;
    }

    @Override
    public Object get(int i) {
        if (i+1>curLen){
            throw new MyListOutBoundException("数组越界");
        }
        return listElem[i];
    }

    @Override
    public void insert(int i, Object object) {
        try {
            if (i>=listElem.length){
                throw new MyListOutBoundException("数组越界");
            }
            listElem[i] = object;
            curLen++;
        } catch (MyListOutBoundException e) {
            Object[] temp = new Object[listElem.length+10];
            for (int j = 0; j < curLen; j++) {
                temp[j] = listElem[j];
            }
            listElem = temp;
            insert(i, object);
        }
    }

    @Override
    public void remove(int i){
        Object o = listElem[i];
        if (!(i>=0&&i<=curLen)) {
            throw new MyListOutBoundException("数组越界异常");
        }

        Object[] temp = new Object[curLen - 1];
        for (int j = 0; j < i - 1; j++) {
            temp[j] = listElem[j];
        }

        for (int j = i; j < curLen-1; j++) {
            temp[j] = listElem[j + 1];
        }

        listElem = temp;
        curLen--;
    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < curLen; i++) {
            if (listElem[i].equals(object)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void display() {
        for (int i = 0; i < curLen; i++) {
            System.out.println(listElem[i]);
        }
    }
}

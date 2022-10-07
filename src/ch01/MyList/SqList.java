package MyList;

import MyList.exception.MyListOutBoundException;

public interface SqList {
    public void clear();
    public boolean isEmpty();
    public int length();
    public Object get(int i);
    public void insert(int i, Object object);
    public void remove(int i) throws MyListOutBoundException;
    public int indexOf(Object object);
    public void display();

}

package ch01;

public class MyStudentList {
    private static int listLength = 1000;
    public static final int SIZE_PER_ADD = 1000;
    private int size = 0;
    private Student[] elements = new Student[listLength];
    private int pointer = 0;


    public MyStudentList() {

    }


    public int size() {
        return this.size;
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public boolean contains(Student student) {
        boolean flag = false;
        for (Student stu : elements) {
            flag = stu.equals(student);
        }
        return flag;
    }


    public synchronized boolean add(Student student) {
        boolean flag = false;
        try {
            elements[pointer] = student;
            size++;
            pointer++;
            flag = true;

        } catch (ArrayIndexOutOfBoundsException e) {

            listLength += SIZE_PER_ADD;
            Student[] temp = new Student[listLength];
            for (int i = 0; i < elements.length; i++) {
                temp[i] = elements[i];
            }
            elements = temp;
            add(student);
        }

        return flag;
    }

    public synchronized boolean remove(Student stu) {
        boolean flag = false;
        try {
            for (Student element : elements) {
                flag = element.equals(stu);
                if (flag){
                    size--;
                    pointer--;
                    break;
                }
            }

        } catch (NullPointerException e) {
            throw new NullPointerException();
        }
        return flag;
    }

    public void clear() {
        elements = new Student[listLength];
    }

    public synchronized Student get(String stuNum) {

        for (Student element : elements) {
            Student s = element;
            String stuNum1 = s.getStuNum();
            if (stuNum1.equals(stuNum)){
                return s;
            }
        }
        return null;
    }

    public synchronized Student get(Student stu) {
        for (Student element : elements) {
            if (element.equals(stu)){
                return element;
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder temp = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            temp.append("\n ").append(elements[i]);
        }

        temp.append("]");
        return temp.toString();
    }
}
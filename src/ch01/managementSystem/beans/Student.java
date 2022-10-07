package ch01.managementSystem.beans;

public class Student {
    private String num;
    private String name;
    private String sex;
    private double englishGrade;
    private double mathGrade;

    public Student() {

    }

    public Student(String num, String name, String sex, double englishGrade, double mathGrade) {
        this.num = num;
        this.name = name;
        this.sex = sex;
        this.englishGrade = englishGrade;
        this.mathGrade = mathGrade;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getEnglishGrade() {
        return englishGrade;
    }

    public void setEnglishGrade(double englishGrade) {
        this.englishGrade = englishGrade;
    }

    public double getMathGrade() {
        return mathGrade;
    }

    public void setMathGrade(double mathGrade) {
        this.mathGrade = mathGrade;
    }

    @Override
    public boolean equals(Object o) {
        if (o==null){
            return false;
        }
        if (!(o instanceof Student)) {
            return false;
        }
        return getNum().equals(((Student) o).getNum());
    }

    @Override
    public String toString() {
        return "------------------\nѧ��ѧ�ţ�" + num + "\n" +
                "ѧ��������" + name + "\n" +
                "ѧ���Ա�" + sex + "\n" +
                "��ѧӢ��ɼ���" + englishGrade + "\n" +
                "�ߵ���ѧ�ɼ���" + mathGrade;
    }
}

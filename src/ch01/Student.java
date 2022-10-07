package ch01;

import java.util.Objects;

public class Student {
    private String stuNum;
    private String stuName;
    private String stuSex;
    private Integer HighLevelEnglishGrade;
    private Integer HighMathGrade;

    public Student(String stuNum) {
        this.stuNum = stuNum;
    }

    public Student(String stuNum, String stuName, String stuSex) {
        this.stuNum = stuNum;
        this.stuName = stuName;
        this.stuSex = stuSex;
    }

    public Student(String stuNum, String stuName, String stuSex, Integer highLevelEnglishGrade, Integer highMathGrade) {
        this.stuNum = stuNum;
        this.stuName = stuName;
        this.stuSex = stuSex;
        HighLevelEnglishGrade = highLevelEnglishGrade;
        HighMathGrade = highMathGrade;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public int getHighLevelEnglishGrade() {
        return HighLevelEnglishGrade;
    }

    public void setHighLevelEnglishGrade(int highLevelEnglishGrade) {
        HighLevelEnglishGrade = highLevelEnglishGrade;
    }

    public int getHighMathGrade() {
        return HighMathGrade;
    }

    public void setHighMathGrade(int highMathGrade) {
        HighMathGrade = highMathGrade;
    }

    @Override
    public String toString() {
        return "Student[" +
                "stuNum='" + stuNum + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuSex='" + stuSex + '\'' +
                ", HighLevelEnglishGrade=" + HighLevelEnglishGrade +
                ", HighMathGrade=" + HighMathGrade +
                ']';
    }
    @Override
    public boolean equals(Object s){
        return Objects.equals(this.stuNum, ((Student) s).getStuNum());
    }

}

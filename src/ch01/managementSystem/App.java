package ch01.managementSystem;

import ch01.managementSystem.beans.Student;
import ch01.managementSystem.service.impl.AddServiceImpl;
import ch01.managementSystem.service.impl.DeleteServiceImpl;
import ch01.managementSystem.service.impl.SelectServiceImpl;

import java.util.Scanner;

public class App {
    Scanner scanner = new Scanner(System.in);
    Student tempStu;
    final boolean[] flag = new boolean[1];

    public static void main(String[] args) {
        new App();
    }

    // 界面状态
    private int status;

    // 主界面选项
    public static final int MAIN_MENU = 0;
    public static final int SELECT_MENU = 1;
    public static final int DELETE_MENU = 2;
    public static final int ADD_MENU = 3;
    public static final int UPDATE_MENU = 4;


    public App() {
        init();
        getTask();

    }

    void init() {
        drawMainMenu();
    }

    void getTask() {

        while (true) {
            switch (status) {
                case MAIN_MENU:
                    doMain(scanner.next());
                    break;

                case SELECT_MENU:
                    doSelect(scanner.next());
                    break;

                case DELETE_MENU:
                    doDelete(scanner.next());
                    break;

                case ADD_MENU:
                    doAdd(scanner.next());
                    break;

                case UPDATE_MENU:
                    doUpdate(scanner.next());
                    break;
                default:
                    print("未知异常请重新输入：");
                    throw new RuntimeException("未知异常");
            }
        }
    }

    void print(String msg) {
        System.out.print(msg);
    }

    void drawMainMenu() {
        print("========================\n");
        print("  欢迎使用成绩管理系统    \n");
        print("                       \n");
        print("                       \n");
        print("①查询：按特定的条件查找学生\n" +
                "②修改：按学号对某个学生的某门课程成绩进行修改\n" +
                "③插入：增加新学生的信息\n" +
                "④删除：按学号删除已退学的学生的信息\n" +
                "⑤退出系统\n");
        print("========================\n");
        print("请输入操作前对应序号并回车：");
        status = MAIN_MENU;
    }

    void drawSelectMenu() {
        print("========================\n");
        print("  请输入需要查询的学生的信息 \n");
        print("                       \n");
        print("   输入num=xxx查询指定学号的学生                     \n");
        print("   输入sex=M|F所有查询男|女学生                     \n");
        print("   输入name=xxx查询指定姓名的学生                     \n");
        print("   输入math|english < | > | >= | <= | =xx查询符合成绩条件的学生                     \n");
        print("   输入*查询所有学生                    \n");
        print("   输入main返回主界面     \n");
        print("========================\n");
        print("请输入操作并回车：");
        status = SELECT_MENU;
    }

    void drawDeleteMenu() {
        print("========================\n");
        print("   请输入需要删除的学生的学号   \n");
        print("                       \n");
        print("                       \n");
        print("                       \n");
        print("   输入main返回主界面     \n");
        print("========================\n");
        print("请输入操作并回车：");
        status = DELETE_MENU;
    }

    void drawAddMenu() {
        print("========================\n");
        print("  请输入需要添加的学生信息  \n");
        print("                       \n");
        print("                       \n");
        print("    输入main返回主界面     \n");
        print("========================\n");
        print("请输入学生学号、学生姓名、学生性别(F或M)、大学英语和高等数学成绩");
        print("每个数据以空格分隔\n：");
        status = ADD_MENU;
    }

    void drawUpdateMenu() {
        print("========================\n");
        print("  请输入需要修改的学生的学号 \n");
        print("\n");
        print("\n");
        print("    输入main返回主界面     \n");
        print("========================\n");
        print("请输入操作回车：");
        status = UPDATE_MENU;
    }

    void doMain(String next) {
        switch (next) {
            case "1":
                drawSelectMenu();
                break;
            case "2":
                drawUpdateMenu();
                break;
            case "3":
                drawAddMenu();
                break;
            case "4":
                drawDeleteMenu();
                break;
            case "5":
                print("欢迎再次使用成绩管理系统\n");
                System.exit(1);
                break;
        }
    }

    void doSelect(String next) {
        switch (next) {
            case "main":
                drawMainMenu();
                break;
            case "*":
                SelectServiceImpl selectService = new SelectServiceImpl();
                Student[] students = selectService.selectByName("");
                for (Student student : students) {
                    drawConfirm(student.toString());
                }
                drawConfirm("查询结束\n");
                break;
            default:
                print("请输入学号");
                break;
        }
    }

    void doDelete(String next) {
        switch (next) {
            case "main":
                drawMainMenu();
                break;
            case "Y":
                if (flag[0]) {
                    DeleteServiceImpl deleteService = new DeleteServiceImpl();
                    if (deleteService.deleteById(tempStu.getNum())) {
                        drawConfirm("操作成功！\n");
                    }
                }
                break;
            case "N":
                drawConfirm("操作取消！");
                break;
            default:
                tempStu = null;
                SelectServiceImpl selectService = new SelectServiceImpl();
                tempStu = selectService.selectByNum(next);
                if (tempStu == null) {
                    drawConfirm("该学号学生不存在！请重新输入学号\n");
                } else {
                    flag[0] = true;
                    drawConfirm(tempStu.toString() + "\n" +
                            "是否确认删除此学生？\n" +
                            "输入 Y 或 N \n");
                }

                break;
        }
    }

    void doAdd(String next) {
        try {

            switch (next) {
                case "main":
                    drawMainMenu();
                    break;
                default:
                    Student student = new Student();
                    student.setNum(next);
                    student.setName(scanner.next());
                    student.setSex(scanner.next());
                    student.setEnglishGrade(Integer.parseInt(scanner.next()));
                    student.setMathGrade(Integer.parseInt(scanner.next()));
                    AddServiceImpl addService = new AddServiceImpl();
                    if (addService.add(student)) {
                        drawConfirm("添加成功\n");
                    } else {
                        drawConfirm("添加失败，请检查数据格式\n");
                    }
                    break;
            }
        } catch (Exception e) {
            drawConfirm("请输入合法的参数!\n");
        }
    }

    void doUpdate(String next) {
        switch (next) {
            case "main":
                drawMainMenu();
                break;
            case "Y":
                if (flag[0]) {
                    DeleteServiceImpl deleteService = new DeleteServiceImpl();
                    if (deleteService.deleteById(tempStu.getNum())) {
                        drawConfirm("操作成功！\n");
                    }
                }
                break;
            case "N":
                drawConfirm("操作取消！");
                break;
            default:
                tempStu = null;
                SelectServiceImpl selectService = new SelectServiceImpl();
                tempStu = selectService.selectByNum(next);
                if (tempStu == null) {
                    drawConfirm("该学号学生不存在！请重新输入学号\n");
                } else {
                    flag[0] = true;
                    drawConfirm(tempStu.toString() + "\n" +
                            "是否确认修改此学生？\n" +
                            "输入 Y 或 N \n");

                }
        }
    }

    void drawConfirm(String msg) {
        print("------------------------\n");
        print(msg);
        print("\n");
        print("------------------------\n");
    }
}

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

    // ����״̬
    private int status;

    // ������ѡ��
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
                    print("δ֪�쳣���������룺");
                    throw new RuntimeException("δ֪�쳣");
            }
        }
    }

    void print(String msg) {
        System.out.print(msg);
    }

    void drawMainMenu() {
        print("========================\n");
        print("  ��ӭʹ�óɼ�����ϵͳ    \n");
        print("                       \n");
        print("                       \n");
        print("�ٲ�ѯ�����ض�����������ѧ��\n" +
                "���޸ģ���ѧ�Ŷ�ĳ��ѧ����ĳ�ſγ̳ɼ������޸�\n" +
                "�۲��룺������ѧ������Ϣ\n" +
                "��ɾ������ѧ��ɾ������ѧ��ѧ������Ϣ\n" +
                "���˳�ϵͳ\n");
        print("========================\n");
        print("���������ǰ��Ӧ��Ų��س���");
        status = MAIN_MENU;
    }

    void drawSelectMenu() {
        print("========================\n");
        print("  ��������Ҫ��ѯ��ѧ������Ϣ \n");
        print("                       \n");
        print("   ����num=xxx��ѯָ��ѧ�ŵ�ѧ��                     \n");
        print("   ����sex=M|F���в�ѯ��|Ůѧ��                     \n");
        print("   ����name=xxx��ѯָ��������ѧ��                     \n");
        print("   ����math|english < | > | >= | <= | =xx��ѯ���ϳɼ�������ѧ��                     \n");
        print("   ����*��ѯ����ѧ��                    \n");
        print("   ����main����������     \n");
        print("========================\n");
        print("������������س���");
        status = SELECT_MENU;
    }

    void drawDeleteMenu() {
        print("========================\n");
        print("   ��������Ҫɾ����ѧ����ѧ��   \n");
        print("                       \n");
        print("                       \n");
        print("                       \n");
        print("   ����main����������     \n");
        print("========================\n");
        print("������������س���");
        status = DELETE_MENU;
    }

    void drawAddMenu() {
        print("========================\n");
        print("  ��������Ҫ��ӵ�ѧ����Ϣ  \n");
        print("                       \n");
        print("                       \n");
        print("    ����main����������     \n");
        print("========================\n");
        print("������ѧ��ѧ�š�ѧ��������ѧ���Ա�(F��M)����ѧӢ��͸ߵ���ѧ�ɼ�");
        print("ÿ�������Կո�ָ�\n��");
        status = ADD_MENU;
    }

    void drawUpdateMenu() {
        print("========================\n");
        print("  ��������Ҫ�޸ĵ�ѧ����ѧ�� \n");
        print("\n");
        print("\n");
        print("    ����main����������     \n");
        print("========================\n");
        print("����������س���");
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
                print("��ӭ�ٴ�ʹ�óɼ�����ϵͳ\n");
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
                drawConfirm("��ѯ����\n");
                break;
            default:
                print("������ѧ��");
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
                        drawConfirm("�����ɹ���\n");
                    }
                }
                break;
            case "N":
                drawConfirm("����ȡ����");
                break;
            default:
                tempStu = null;
                SelectServiceImpl selectService = new SelectServiceImpl();
                tempStu = selectService.selectByNum(next);
                if (tempStu == null) {
                    drawConfirm("��ѧ��ѧ�������ڣ�����������ѧ��\n");
                } else {
                    flag[0] = true;
                    drawConfirm(tempStu.toString() + "\n" +
                            "�Ƿ�ȷ��ɾ����ѧ����\n" +
                            "���� Y �� N \n");
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
                        drawConfirm("��ӳɹ�\n");
                    } else {
                        drawConfirm("���ʧ�ܣ��������ݸ�ʽ\n");
                    }
                    break;
            }
        } catch (Exception e) {
            drawConfirm("������Ϸ��Ĳ���!\n");
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
                        drawConfirm("�����ɹ���\n");
                    }
                }
                break;
            case "N":
                drawConfirm("����ȡ����");
                break;
            default:
                tempStu = null;
                SelectServiceImpl selectService = new SelectServiceImpl();
                tempStu = selectService.selectByNum(next);
                if (tempStu == null) {
                    drawConfirm("��ѧ��ѧ�������ڣ�����������ѧ��\n");
                } else {
                    flag[0] = true;
                    drawConfirm(tempStu.toString() + "\n" +
                            "�Ƿ�ȷ���޸Ĵ�ѧ����\n" +
                            "���� Y �� N \n");

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

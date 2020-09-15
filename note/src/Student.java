/**
 * @author MicroLOONG
 */

public class Student {

    /**
     * name 姓名
     * age 年龄
     * interest 兴趣爱好
     */
    String name;
    int age;
    String interest;

    public static void main(String[] args) {
        // 同一个类实例化多个对象
        Student stu1 = new Student();
        Student stu2 = new Student();

        stu1.name = "鸡你太美";
        stu1.age = 22;
        stu1.interest = "唱、跳、rap、篮球";

        stu2.name = "妙蛙种子";
        stu2.age = 20;
        stu2.interest = "妙啊";

        stu1.showInfo();
        stu2.showInfo();
    }

    /**
     * 输出信息
     */
    public void showInfo() {
        System.out.println("姓名：" + name);
        System.out.println("年龄：" + age);
        System.out.println("兴趣爱好：" + interest);
    }
}

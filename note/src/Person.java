/**
 * @author MicroLOONG
 */

public class Person {

    /**
     * name 名字
     * age 年龄
     */
    String name;
    int age;

    public static void main(String[] args) {
        // 声明 Person 类型的变量 person 并实例化
	    Person person = new Person();
	    // 给对象的 name 属性赋值
        person.name = "MicroLOONG";
	    // 调用对象方法
        person.showName();
        int element = person.getAge();
        System.out.println("Age: " + element);
    }

    /**
     * 输出名字
     */
    public void showName() {
        System.out.println("Name: " + name);
    }

    /**
     * 定义年龄
     * @return age
     */
    public int getAge() {
        age = 20;
        return age;
    }
}

/**
 * @author MicroLOONG
 */

public class Overload {

    public static void main(String[] args) {
        Overload ol = new Overload();

        // test1
        System.out.println(ol.test());
        // test2
        ol.test(1);
        // test3
        System.out.println(ol.test(1,"test3"));
        // test4
        System.out.println(ol.test("test4",1));
    }

    public int test() {
        System.out.println("test1");
        return 1;
    }

    public void test(int a) {
        System.out.println("test2");
    }

    public String test(int a, String s) {
        System.out.println("test3");
        return "return test3";
    }

    public String test(String s, int a) {
        System.out.println("test4");
        return "return test4";
    }
}

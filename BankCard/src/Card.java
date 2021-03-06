/*
   按照要求，补全完成代码段，完成卡片，银行卡类，打印输出结果。
   步骤一：我们需要有一个Card类，卡片，它是"银行卡"的父类。
   步骤二：我们还需要有一个BankCard类，银行卡，它是Card类的子类。
   步骤三：在Card类的构造函数中，初始化company(发卡机构)、money(余额)、cardID。
   步骤四：在BankCard类构造函数中，使用super关键字初始化，父类属性。
   输入六个字符，按照顺序依次为Card类对象的发卡机构、余额、卡号，BankCard类对象的发卡机构、余额、卡号，打印输出结果。
 */

import java.util.Scanner;

/**
 * @author MicroLOONG
 */
public class Card {

    public static void main(String[] args) {

        /*
           输入八个字符，
          	按照顺序依次为
          	Card类对象的发卡机构、余额、卡号；
          	BankCard类对象的发卡机构、余额、卡号，
          	打印输出结果。
         */
        Scanner sc = new Scanner(System.in);

        System.out.print("Card类发卡机构：");
        String cCompany = sc.nextLine();
        System.out.print("Card类余额：");
        String cMoney = sc.nextLine();
        System.out.print("Card类卡号：");
        String cCardId = sc.nextLine();
        System.out.print("BankCard类发卡机构：");
        String bCompany = sc.nextLine();
        System.out.print("BankCard类余额：");
        String bMoney = sc.nextLine();
        System.out.print("BankCard类卡号：");
        String bCardId = sc.nextLine();

        // 根据输入的前三个数据,初始化Card类对象的成员变量
        Card card = new Card(cCompany, Double.parseDouble(cMoney), cCardId);
        // 调用print方法输出结果
        card.print();

        // 根据输入的后三个数据，初始化BankCard类对象的成员变量
        BankCard bankCard = new BankCard(bCompany, Double.parseDouble(bMoney), bCardId);
        // 调用print方法输出结果
        bankCard.print();

        boolean result;
        int choice = -1;
        while (choice != 0) {
            System.out.println("\n对Card类操作：\n1. 充值\n2. 消费\n0. 退出");
            System.out.print("请选择： ");
            Scanner input = new Scanner(System.in);
            choice = input.nextInt();
            switch (choice) {
                /*
                   实例化Card类的对象，按照次序进行充值和消费操作，
                   打印输出，充值/消费 是否成功(true/false)。
                 */
                case 0:
                    break;
                case 1:
                    System.out.print("Card类充值金额：");
                    String cdAmount = sc.nextLine();
                    result = card.deposit(Double.parseDouble(cdAmount));
                    if (result) {
                        System.out.println("充值成功");
                    } else {
                        System.out.println("充值失败");
                    }
                    break;
                case 2:
                    System.out.print("Card类消费金额：");
                    String ccAmount = sc.nextLine();
                    result = card.consume(Double.parseDouble(ccAmount));
                    if (result) {
                        System.out.println("消费成功");
                    } else {
                        System.out.println("消费失败");
                    }
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * 	定义私有成员变量：
     * 	company(发卡机构)、
     * 	money(余额)、double类型
     * 	cardId
     */
    private final String company;

    private double money;

    private final String cardId;

    /**
     *  在Card类的构造函数中初始化：
     *  @param company 发卡机构
     *  @param money 余额
     *  @param cardId 卡号，8位0-9的随机数构成，非0开头
     */
    public Card(String company, double money, String cardId) {
        this.company = company;
        this.money = money;
        this.cardId = cardId;
    }

    public void print() {
        String str = this.company +", "+ this.money +", "+ this.cardId;
        System.out.println(str);
    }

    /**
     * 	定义函数 deposit()，实现给卡进行充值的功能，
     *  参数代表充值的金额，充值金额大于0，
     *  则修改卡内余额，返回true，代表充值成功，
     *  否则返回false，代表充值失败。
     */
    public boolean deposit(double amount) {
        if (amount > 0) {
            this.money = this.money + amount;
            System.out.println("\n余额：" + money);
            return true;
        } else {
            return false;
        }
    }

    /**
     * 	定义函数 consume()，实现消费的功能，
     *  参数代表消费金额，消费金额大于0且不多于余额，返回true，
     *  代表消费成功，否则返回false，代表消费失败。
     * @param amount 消费金额
     */
    public boolean consume(double amount) {
        if (amount > 0 && this.money >= amount) {
            this.money = this.money - amount;
            System.out.println("\n余额：" + money);
            return true;
        } else {
            return false;
        }
    }
}

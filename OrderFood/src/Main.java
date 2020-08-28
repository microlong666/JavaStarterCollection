import java.util.Scanner;

/**
 * @author MicroLOONG
 */

public class Main {
    public static void main(String[] args) {
        //定义数据主体：菜品
        String[] dishNames = {"糖醋排骨", "鱼香肉丝", "水煮菜心"};
        //单价
        double[] prices = {38.0, 20.0, 30.0};
        //点赞数
        int[] praiseNums = new int[3];
        //定义数据主体：订单-订餐人   餐品信息   送餐时间   送餐地址   总金额   订单状态
        String[] names = new String[4];
        //菜品名称+订份数
        String[] dishMsg = new String[4];
        int[] times = new int[4];
        String[] addresses = new String[4];
        double[] sumPrices = new double[4];
        //0：已预订   1：已完成
        int[] states = new int[4];

        //初始化2个订单信息
        names[0] = "晓静";
        dishMsg[0] = "糖醋排骨 2份";
        times[0] = 10;
        addresses[0] = "长春路13号";
        //餐费>50 免配送费；否则，配送费6元
        sumPrices[0] = 76;
        states[0] = 0;

        names[1] = "王红";
        dishMsg[1] = "鱼香肉丝 1份";
        times[1] = 13;
        addresses[1] = "珠江路27号";
        //餐费>50 免配送费；否则，配送费6元
        sumPrices[1] = 26;
        states[1] = 1;

        //搭建项目整体流程框架
        Scanner input = new Scanner(System.in);
        //用户输入0返回时的输入数字，num=0 时重复显示主菜单；num在用户每次订餐操作后进行提示重新赋值
        int num;
        System.out.println("欢迎使用\"在线订餐系统\"");
        //记录用户是否退出系统的状态：退出true；不退出false
        boolean flag = false;
        do {
            System.out.println("*************************");
            System.out.println("1、我要订餐");
            System.out.println("2、查看餐袋");
            System.out.println("3、签收订单");
            System.out.println("4、删除订单");
            System.out.println("5、我要点赞");
            System.out.println("6、退出系统");
            System.out.println("*************************");
            System.out.print("请选择：");
            int choose = input.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("\n*********我要订餐**************");
                    //订餐前提是订单未满,boolean变量来标识订单是否满了的结果，满了false-不能订餐，反之能订餐
                    boolean isAdd = false;
                    for (int i = 0; i < names.length; i++) {
                        if (names[i] == null) {
                            //订单未满，可以订餐
                            isAdd = true;
                            //订餐
                            System.out.print("请输入订餐人姓名：");
                            String name = input.next();
                            //循环输出菜品信息
                            System.out.println("序号\t菜名\t\t单价");
                            for (int j = 0; j < dishNames.length; j++) {
                                String praise = (praiseNums[j] == 0) ? "" : praiseNums[j] + "赞";
                                System.out.println((j + 1) + "\t\t" + dishNames[j] + "\t\t" + prices[j] + "\t" + praise);
                            }
                            //菜品编号的输入及判断
                            System.out.print("请输入您要点的菜品编号：");
                            int no = input.nextInt();
                            while (no < 1 || no > dishNames.length) {
                                System.out.print("本店没有这个菜品，请重新选择：");
                                no = input.nextInt();
                            }
                            //点菜份数
                            System.out.print("请输入您需要的份数：");
                            int number = input.nextInt();
                            //送餐时间的输入及判断
                            System.out.print("请输入送餐时间（送餐时间只能在10-20之间的整点）：");
                            int time = input.nextInt();
                            int timeMin = 10;
                            int timeMax = 20;
                            while (time < timeMin || time > timeMax) {
                                System.out.println("您的输入有误，请输入10-20之间的整数：");
                                time = input.nextInt();
                            }
                            //送餐地址
                            System.out.print("请输入送餐地址：");
                            String address = input.next();
                            //输出订餐信息给用户看
                            System.out.println("订餐成功！");
                            //注意：用户选择的菜品下标比真正的数组元素下标大1
                            String dishInfo = dishNames[no - 1] + " " + number + "份";
                            System.out.println("\n您订的是：" + dishInfo);
                            System.out.println("送餐时间：" + time + "点");
                            //定义餐费变量dishPrice，赋值为单价和份数的乘积
                            double dishPrice = prices[no - 1] * number;
                            //定义配送费peiSong，如果大于50元设置为0，否则设置为6
                            double peiSong = dishPrice > 50 ? 0 : 6;
                            //定义总金额sumPrice，赋值为餐费变量dishPrice和配送费peiSong的和
                            double sumPrice = dishPrice + peiSong;
                            System.out.println("餐费：" + dishPrice + "元；配送费：" + peiSong + "；总计：" + sumPrice + "元");

                            //把订餐信息添加到订单信息，插入订单的位置是关键：i
                            //把订餐信息添加到订单信息，index为i，设置信息包括订餐人，餐品信息，送餐时间，送餐地址，总金额
                            names[i] = name;
                            dishMsg[i] = dishInfo;
                            times[i] = time;
                            addresses[i] = address;
                            sumPrices[i] = sumPrice;
                            // 打印输出
                            System.out.println("\n订单信息是：" + names[i] + "   " + dishMsg[i] + "   "
                                    + times[i] + "点   " + addresses[i] + "   " + sumPrices[i] + "元");
                            //本次订餐结束，跳出循环
                            break;
                        }
                    }
                    if (!isAdd) {
                        System.out.println("对不起，您的餐袋已满！");
                    }
                    break;
                case 2:
                    System.out.println("\n*********查看餐袋**************");
                    System.out.println("序号\t订餐人\t\t订餐菜品\t\t\t配送时间\t\t配送地址\t\t\t订餐金额\t\t订单状态");
                    for (int i = 0; i < names.length; i++) {
                        //输出非空订单信息
                        if (names[i] != null) {
                            String time = times[i] + "点";
                            String state = (states[i] == 0) ? "已预订" : "已完成";
                            System.out.println((i + 1) + "\t\t" + names[i] + "\t\t" + dishMsg[i] + "\t\t"
                                    + time + "\t\t" + addresses[i] + "\t\t" + sumPrices[i] + "\t\t" + state);
                        }
                    }
                    break;
                case 3:
                    System.out.println("\n*********签收订单**************");
                    //签收之前，要先判断订单是否存在，boolean
                    //false-不存在，不能签收；true-存在，且预订状态，能签收；存在，完成状态，不能签收
                    boolean isSign = false;
                    System.out.print("请输入您要签收的订单编号：");
                    int signNo = input.nextInt();
                    for (int i = 0; i < names.length; i++) {
                        //判断名字不为空并且订单状态是未签收，并且数组的index等于订单编号减1
                        if (names[i] != null && states[i] == 0 && i == signNo - 1) {
                            //有订单信息，并且用户输入的订单编号能找到
                            isSign = true;
                            //并且订单状态为已预订，能签收
                            //设置订单状态为1：已签收
                            states[i] = 1;
                            System.out.println("订单签收成功！");
                        } else if (names[i] != null && states[i] == 1 && i == signNo - 1) {
                            //有订单信息，并且用户输入的订单编号能找到
                            isSign = true;
                            //但是订单状态为已完成，不能签收
                            System.out.println("您选择的订单已经完成签收，不能再次签收！");
                        }
                    }
                    if (!isSign) {
                        System.out.println("您选择的订单不存在！");
                    }
                    break;
                case 4:
                    System.out.println("\n*********删除订单**************");
                    //删除之前，要先判断订单是否存在，boolean
                    //false-不存在，不能删除；true-存在，且预订状态，不能删除；存在，完成状态，删除
                    boolean isDelete = false;
                    System.out.print("请输入您要删除的订单编号：");
                    int deleteNo = input.nextInt();
                    for (int i = 0; i < names.length; i++) {
                        if (names[i] != null && states[i] == 0 && i == deleteNo - 1) {
                            //有订单信息，并且用户输入的订单编号我能找到
                            isDelete = true;
                            //并且订单状态为已预订，不能删除
                            System.out.println("您选择的订单未签收，不能删除！");
                        } else if (names[i] != null && states[i] == 1 && i == deleteNo - 1) {
                            //有订单信息，并且用户输入的订单编号我能找到
                            isDelete = true;
                            //但是订单状态为已完成，能删除
                            //找到删除订单的位置下标  i ，把i后面的元素依次往前移动，最后一个数组元素要置空
                            //注意：移动的过程其实是把后一个元素往前一个元素复制的过程
                            for (int j = i; j < names.length - 1; j++) {
                                names[j] = names[j + 1];
                                dishMsg[j] = dishMsg[j + 1];
                                times[j] = times[j + 1];
                                addresses[j] = addresses[j + 1];
                                sumPrices[j] = sumPrices[j + 1];
                                states[j] = states[j + 1];
                            }
                            //最后一个元素一定要置空，置空后就可以下新的订单了
                            names[names.length - 1] = null;
                            dishMsg[names.length - 1] = null;
                            times[names.length - 1] = 0;
                            addresses[names.length - 1] = null;
                            sumPrices[names.length - 1] = 0;
                            states[names.length - 1] = 0;
                            System.out.println("删除订单成功！");
                        }
                    }
                    if (!isDelete) {
                        System.out.println("您选择的订单不存在！");
                    }
                    break;
                case 5:
                    System.out.println("\n*********我要点赞**************");
                    //循环输出菜品信息
                    System.out.println("序号\t菜名\t\t单价");
                    for (int j = 0; j < dishNames.length; j++) {
                        String praise = (praiseNums[j] == 0) ? "" : praiseNums[j] + "赞";
                        System.out.println((j + 1) + "\t\t" + dishNames[j] + "\t\t" + prices[j] + "\t" + praise);
                    }
                    //点赞
                    System.out.print("请输入您要点赞的菜品序号：");
                    int praiseNo = input.nextInt();
                    while (praiseNo < 1 || praiseNo > dishNames.length) {
                        System.out.print("本店没有这个菜品，无法点赞！请重新输入一个菜品序号：");
                        praiseNo = input.nextInt();
                    }
                    //把对应序号的菜品点赞数加1，关键点：把哪个位置的菜品点赞数+1
                    praiseNums[praiseNo - 1]++;
                    System.out.println("\n点赞情况：");
                    //打印每个菜品的点赞数量
                    for (int m = 0; m < dishNames.length; m++) {
                        System.out.println(dishNames[m] + "   " + praiseNums[m]);
                    }
                    break;
                case 6:
                    //退出系统
                    flag = true;
                    break;
                default:
                    //退出系统
                    flag = true;
                    break;
            }
            if (!flag) {
                System.out.print("请输入0返回：");
                num = input.nextInt();
            } else {
                break;
            }
        } while (num == 0);
        System.out.println("谢谢使用，欢迎下次光临！");
    }
}

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author MicroLOONG
 */

public class Main {

    public static void main(String[] args) {
        Main dm = new Main();
        dm.initial();
        dm.startMenu();
    }

    /**
     * 创建图书 book 对象
     */
    BookSet book = new BookSet();

    /**
     * 借出书籍数量
     */
    private int lendCount = 0;

    /**
     * 获取借出书籍数量
     * @return lendCount
     */
    public int getLendCount() {
        return lendCount;
    }

    /**
     * 未借出书籍数量
     */
    private int existCount = 0;

    /**
     * 获取未借出书籍数量
     * @return existCount
     */
    public int getExistCount() {
        return existCount;
    }

    /**
     * 每一次的暂存租金
     */
    private long charge;

    /**
     * 获取租金
     * @return charge
     */
    public long getCharge() {
        return charge;
    }

    /**
     * 设置租金
     * @param charge 租金
     */
    public void setCharge(long charge) {
        this.charge = charge;
    }

    /**
     * 初始三个图书
     */
    public void initial() {
        book.name[0] = "数据结构";
        book.state[0] = 0;
        book.date[0] = "2018-7-1";
        book.count[0] = 15;

        book.name[1] = "数据库";
        book.state[1] = 1;
        book.count[1] = 12;

        book.name[2] = "离散数学";
        book.state[2] = 1;
        book.count[2] = 30;

        book.name[3] = "计算机基础";
        book.state[3] = 1;
        book.count[3] = 2;
    }

    /**
     * 开始菜单
     */
    public void startMenu() {
        System.out.println("欢迎使用图书借阅系统");
        System.out.println("-------------------------------------");
        System.out.println("0. 借出排行榜");
        System.out.println("1. 查看图书");
        System.out.println("2. 新增图书");
        System.out.println("3. 删除图书");
        System.out.println("4. 借出图书");
        System.out.println("5. 归还图书");
        System.out.println("6. 退出");
        System.out.print("--------------------------------------\n");
        System.out.print("请选择： ");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        switch(choice) {
            case 0:
                // 借出排行榜
                list();
                returnMain();
                break;
            case 1:
                // 查询图书
                search();
                returnMain();
                break;
            case 2:
                // 新增图书
                add();
                break;
            case 3:
                // 删除图书
                delete();
                break;
            case 4:
                // 借出图书
                lend();
                break;
            case 5:
                // 归还图书
                returnBook();
                break;
            case 6:
                // 退出
                System.out.println("\n谢谢使用！");
                break;
            default:
                break;
        }
    }

    /**
     * 返回主菜单
     */
    public void returnMain() {
        Scanner input = new Scanner(System.in);
        System.out.print("输入0返回：");
        if(input.nextInt() == 0) {
            startMenu();
        } else {
            System.out.println("输入错误, 异常终止！");
        }
    }

    /**
     * 借出排行榜
     */
    public void list() {
        // 定义新数组，用来存放排序后图书信息
        String[] newName = new String[50];
        int[] newCount = new int[50];

        for (int k = 0; k < book.name.length; k++) {
            newName[k] = book.name[k];
            newCount[k] = book.count[k];
        }

        // 利用冒泡排序算法进行排序
        for (int i = 0; i < newName.length; i++) {
            for (int j = i + 1; j < newName.length; j++) {
                if (newCount[i] > newCount[j]) {
                    // 通过数组操作完成顺序交替
                    int tempCount = newCount[i];
                    newCount[i] = newCount[j];
                    newCount[j] = tempCount;
                    String tempName = newName[i];
                    newName[i] = newName[j];
                    newName[j] = tempName;
                }
            }
        }
        System.out.println("---> 排行榜\n");
        System.out.println("**************************");
        System.out.println("次数\t名称");
        // 显示排行榜信息
        for (int i = newName.length - 1; i >= 0; i--) {
            if(newName[i] != null) {
                System.out.println(newCount[i]+"\t<<"+ newName[i]+ ">>" );
            }
        }
        System.out.println("**************************");
        // returnMain();
    }

    /**
     * 查看图书
     */
    public void search(){
        System.out.println("---> 查看图书\n");
        System.out.println("序号\t状 态\t名称\t\t\t借出日期");

        /*
        1. 遍历图书信息并按顺序输出,序号从1开始，如果图书未借出，则借出日期用"----"表示，状态字段用"借出"和"未借出"标识
        2. 打印已借出书籍，并设置lendCount
        3. 打印未借出书籍，并设置existCount
         */
        lendCount = 0;
        existCount = 0;
        for (int i = 0; i < book.name.length; i++) {
            if (book.name[i] == null) {
                break;
            }
            String order = String.valueOf(i + 1);
            String status, strDate;
            if (book.state[i] == 0) {
                status = "借出";
                lendCount = lendCount + book.count[i];
            } else {
                status = "未借出";
                existCount = existCount + book.count[i];
            }
            if (book.date[i] != null && !book.date[i].isEmpty()) {
                strDate = book.date[i];
            } else {
                strDate = "----";
            }
            System.out.println(order + "\t\t" + status + "\t" + book.name[i] + "\t\t\t" + strDate);
        }
        System.out.println("**************************");
    }

    /**
     * 新增图书
     */
    public void add() {
        // 为方便测试，拆分方法为键盘输入方法和核心追加书籍方法
        String name = getInputData();
        addBook(name);
        System.out.println("**************************");
        returnMain();
    }

    /**
     * 追加图书
     * @param name 书名
     */
    public void addBook(String name) {
        for (int i = 0; i < book.name.length; i++) {
            // 查询最后一个空位置插入
            if (book.name[i] == null ) {
                book.name[i] = name;
                // 更改新增的图书可借状态
                book.state[i] = 1;
                System.out.println("新增《"+name+"》成功！");
                break;
            }
        }
    }

    /**
     * 键盘输入数据
     * @return 图书名称
     */
    private String getInputData() {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入图书名称： ");
        return input.next();
    }

    /**
     * 删除图书
     */
    public void delete() {
        System.out.println("---> 删除图书\n");
        String name = getInputData();
        // 为方便测试用例，抽出一个方法
        deleteBook(name);
        returnMain();
    }

    /**
     * 删除图书核心方法
     * @param name 待删书名
     */
    public void deleteBook(String name) {
        // 标识删除成功与否
        boolean flag = false;
        // 遍历数组，查找匹配信息
        for (int i = 0 ; i < book.name.length; i++){
            // 查找到，每个元素前移一位
            // 判断书籍是否满足删除条件
            if (book.name[i] != null && book.name[i].equalsIgnoreCase(name) && book.state[i] == 1) {
                // 最后一个不为空的元素置空
                int j = i;
                while (book.name[j+1] != null) {
                    book.name[j] = book.name[j+1];
                    book.state[j] = book.state[j+1];
                    book.date[j] = book.date[j+1];
                    j++;
                }
                book.name[j] = null;
                book.date[j] = null;
                System.out.println("删除《"+name+"》成功！");
                // 置位，表示删除成功
                flag = true;
                break;
            } else if (book.name[i] != null && book.name[i].equalsIgnoreCase(name) && book.state[i] == 0) {
                // 判断查询到的书籍已被借出
                System.out.println("《"+name+"》为借出状态，不能删除！");
                // 置位
                flag = true;
                break;
            }
        }
        if (!flag){
            System.out.println("没有找到匹配信息！");
        }
        System.out.println("**************************");
    }

    /**
     * 借出图书
     */
    public void lend() {
        System.out.println("---> 借出图书\n");
        Scanner input = new Scanner(System.in);
        System.out.print("请输入图书名称： ");
        // 要借出的图书名称
        String want = input.next();
        System.out.print("请输入借出日期（年-月-日）：");
        // 借出日期
        String lendDate = input.next();
        // 为方便测试，抽出方法
        lendBook(want, lendDate);
        System.out.println("**************************");
        returnMain();
    }

    /**
     * 借出图书核心方法
     * @param want 待借书名
     * @param lendDate 借出日期
     */
    public void lendBook(String want, String lendDate) {
        for (int i = 0; i < book.name.length; i++){
            if (book.name[i] == null) {
                // 无匹配
                System.out.println("没有找到匹配信息！");
                break;
            } else if (book.name[i].equalsIgnoreCase(want) && book.state[i] == 1) {
                // 找到匹配可借
                book.state[i] = 0;
                book.date[i] = lendDate;
                System.out.println("借出《"+want+"》成功!");
                book.count[i]++;
                break;
            } else if (book.name[i].equalsIgnoreCase(want) && book.state[i] == 0) {
                // 找到匹配已被借出
                System.out.println("《"+want+"》已被借出！");
                break;
            }
        }
    }

    /**
     * 归还图书并计算租金
     */
    public void returnBook() {
        System.out.println("---> 归还图书\n");
        Scanner input = new Scanner(System.in);
        System.out.print("请输入图书名称： ");
        String want = input.next();
        System.out.print("请输入归还日期（年-月-日）：");
        String reDate = input.next();
        // 为方便测试，抽出方法
        returnBook(want, reDate);
        System.out.println("**************************");
        returnMain();
    }

    /**
     * 归还图书并计算租金
     * @param want 待还书名
     * @param reDate 归还日期
     */
    public void returnBook(String want, String reDate) {
        // 初始化租金
        this.setCharge(0);
        long loan;
        for (int i = 0; i < book.name.length; i++) {
            // 无匹配
            if (book.name[i] == null) {
                System.out.println("没有找到匹配信息！");
                break;
                // 找到匹配对应书籍
            } else if (book.name[i].equalsIgnoreCase(want) && book.state[i] == 0) {
                /*
                1.设置为未借出状态
                2.计算租金
                 */
                book.state[i] = 1;
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                long to = 0;
                long from = 0;
                try {
                    to = df.parse(reDate).getTime();
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                try {
                    from = df.parse(book.date[i]).getTime();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                loan = (to - from) / (1000 * 60 * 60 * 24);
                setCharge(loan);

                System.out.println("\n归还《" + want + "》成功!");
                System.out.println("借出日期为：" + book.date[i]);
                System.out.println("归还日期为：" + reDate);
                System.out.println("应付租金（元）：" + loan);
                break;
            } else if (book.name[i].equals(want) && book.state[i] == 1) {
                // 找到匹配但没有借出
                System.out.println("该图书没有被借出！无法进行归还操作。");
                break;
            }
        }
    }

    /**
     * 计算日期差
     *
     * @param dstr1 第一个日期
     * @param dstr2 第二个日期
     */
    public long charge(String dstr1, String dstr2) {
        long charge = 0;
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date d1 = sd.parse(dstr1);
            Date d2 = sd.parse(dstr2);
            charge = (d2.getTime() - d1.getTime()) / (24 * 60 * 60 * 1000);
            this.setCharge(charge);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return charge;
    }
}

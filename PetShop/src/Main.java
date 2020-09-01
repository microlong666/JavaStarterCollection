import java.util.Scanner;

/**
 * @author MicroLOONG
 */

public class Main {

    public static void main(String[] args) {
        Master master = new Master("张先生", 100);
        Scanner input = new Scanner(System.in);
        System.out.println("欢迎您来到宠物店！");
        System.out.print("请选择要领养的宠物类型（1.狗狗  2.企鹅）：");
        int typeId = input.nextInt();
        Pet pet = master.getPet(typeId);
        if (pet != null) {
            System.out.println("领养成功！\n");
            pet.print();
            master.feed(pet);
            master.play(pet);
        } else {
            System.out.println("对不起，没有此类型的宠物，领养失败");
        }
    }
}

class Master {

    private String name;
    private int money;

    /**
     * 有参构造方法。
     * @param name 主人名字
     * @param money 元宝数
     */
    public Master(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }
    public String getName() {
        return name;
    }
    /**
     * 主人给宠物喂食。
     */
    public void feed(Pet pet) {
        pet.eat();
    }

    /**
     * 主人领养宠物
     * @param typeId 宠物编号
     * @return pet
     */
    public Pet getPet(int typeId){
        Pet pet = null;
        if(typeId == 1) {
            pet = new Dog("二哈", "哈士奇", 80, 0);
        } else if(typeId == 2) {
            pet = new Penguin("楠楠", "Q妹", 4, 20);
        }
        return pet;
    }

    /**
     * 主人与宠物玩耍
     */
    public void play(Pet pet) {
        // 判断传值参数pet是否为狗狗，如果传入的是狗狗，判断条件为true
        if (pet instanceof Dog) {
            // 给dog对象实例化
            Dog dog = (Dog) pet;
            dog.catchingFlyDisc();
        } else if (pet instanceof Penguin) {
            // 判断传值参数pet是否为企鹅，如果传入的是企鹅，判断条件为true
            // 给pgn对象实例化
            Penguin pgn = (Penguin) pet;
            pgn.swimming();
        }
    }
}


abstract class Pet {

    private String name;
    int health;
    int love;

    /**
     * 抽象方法eat(),负责宠物吃饭功能。
     */
    public abstract void eat();

    public Pet() {

    }

    /**
     * 有参构造方法。
     * @param name 昵称
     * @param health 健康值
     * @param love 亲密度
     */
    public Pet(String name, int health, int love) {
        this.name = name;
        this.health = health;
        this.love = love;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        if (health < 0 || health > 100) {
            System.out.println("健康值应该在0至100之间，默认值为60。");
            this.health = 60;
            return;
        }
        this.health = health;
    }

    public void setLove(int love) {
        if (love < 0 || love > 100) {
            System.out.println("亲密度应该在0至100之间，默认值为10。");
            this.love = 10;
            return;
        }
        this.love = love;
    }

    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }
    public int getLove() {
        return love;
    }

    /**
     * 输出宠物信息。
     */
    public void print() {
        System.out.println("宠物的自白：\n我的名字叫" + this.name +
                "，健康值是" + this.health + "，和主人的亲密度是"
                + this.love + "。");
    }
}

class Dog extends Pet {

    private final String strain;

    /**
     * 有参构造方法。
     * @param name 昵称
     * @param strain 品种
     */
    public Dog(String name, String strain, int health, int love) {
        super(name, health, love);
        this.strain = strain;
    }
    public String getStrain() {
        return strain;
    }

    /**
     * 重写父类的print方法。
     */
    @Override
    public void print() {
        // 调用父类的print方法
        super.print();
        System.out.println("我是一只" + this.strain + "。\n");
    }

    /**
     * 实现吃食方法。
     */
    @Override
    public void eat() {
        if(getHealth() >= 100) {
            System.out.println("狗狗"+this.getName() +"吃饱了，不需要喂食了！");
        } else {
            this.setHealth(this.getHealth() + 5);
            System.out.println("狗狗"+this.getName() + "吃饱啦！健康值增加5。");
        }
    }
    /**
     * 实现接飞盘方法
     */
    public void catchingFlyDisc() {
        if (getHealth() < 10) {
            System.out.println("狗狗" + this.getName() + "健康值过低！请稍后再带它玩耍哦！");
        } else {
            System.out.println("狗狗" + this.getName() + "正在接飞盘！健康值减少10，亲密度增加5。");
            this.setHealth(this.getHealth() - 10);
            this.setLove(this.getLove() + 5);
        }
    }
}

class Penguin extends Pet {

    private final String sex;

    /**
     * 有参构造方法。
     *
     * @param name 昵称
     * @param sex 性别
     */
    public Penguin(String name, String sex, int health, int love) {
        super(name, health, love);
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    /** 重写父类的print方法。 */
    @Override
    public void print() {
        super.print();
        System.out.println("性别是" + this.sex + "。\n");
    }

    /** 实现吃食方法。 */
    @Override
    public void eat() {
        if (getHealth() >= 100) {
            System.out.println("企鹅" + this.getName() + "吃饱了，不需要喂食了！");
        } else {
            this.setHealth(this.getHealth() + 5);
            System.out.println("企鹅" + this.getName() + "吃饱啦！健康值增加5。");
        }
    }

    /** 实现游泳方法 */
    public void swimming() {
        if (getHealth() < 10) {
            System.out.println("企鹅" + this.getName() + "健康值过低！请稍后再带它玩耍哦！");
        } else {
            System.out.println("企鹅" + this.getName() + "正在游泳！健康值减少10，亲密度增加5。");
            this.setHealth(this.getHealth() - 10);
            this.setLove(this.getLove() + 5);
        }
    }
}
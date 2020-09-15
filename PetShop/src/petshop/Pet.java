package petshop;

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

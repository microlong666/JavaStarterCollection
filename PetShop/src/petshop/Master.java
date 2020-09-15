package petshop;

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
        if (typeId == 1) {
            pet = new Dog("二哈", "哈士奇", 80, 0);
        } else if (typeId == 2) {
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
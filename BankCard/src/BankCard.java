/**
 * 	创建BankCard类，银行卡，
 * 	它是Card类的子类
 */
class BankCard extends Card {

    /**
     * 在BankCard类构造函数中，
     * 使用super关键字初始化，父类属性。
     * @param company 所属银行
     * @param money 余额
     * @param cardId 银行卡号
     */
    public BankCard(String company, double money, String cardId) {
        super(company, money, cardId);
    }
}


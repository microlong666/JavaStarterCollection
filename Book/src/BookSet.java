/**
 * @author MicroLOONG
 */

public class BookSet {

    /**
     * 数组1存储图书名称数组
     */
    String[] name = new String[50];

    /**
     * 数组2存储图书借出状态：0已借出/1可借
     */
    int[] state = new int[50];

    /**
     * 数组3存储图书借出日期
     */
    String[] date = new String[50];

    /**
     * 借出次数
     */
    int[] count = new int[50];

    /**
     * 获取书名
     * @return name
     */
    public String[] getName() {
        return name;
    }

    /**
     * 设置书名
     * @param name 书名
     */
    public void setName(String[] name) {
        this.name = name;
    }

    /**
     * 获取借出状态
     * @return state
     */
    public int[] getState() {
        return state;
    }

    /**
     * 设置接出状态
     * @param state 状态
     */
    public void setState(int[] state) {
        this.state = state;
    }

    /**
     * 获取借出日期
     * @return date
     */
    public String[] getDate() {
        return date;
    }

    /**
     * 设置借出日期
     * @param date 日期
     */
    public void setDate(String[] date) {
        this.date = date;
    }

    /**
     * 获取借出次数
     * @return count
     */
    public int[] getCount() {
        return count;
    }

    /**
     * 设置借出次数
     * @param count 次数
     */
    public void setCount(int[] count) {
        this.count = count;
    }
}

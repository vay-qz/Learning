package pers.vay.stringpool;

/**
 * @author qiaozhe
 */
public class StringpoolTest {
    /**
     * 进入String常量池测试
     * <p>
     *     String字符串有两种创建方式
     *     1.直接使用"",e.g. "String"
     *     2.使用new创建，new String("String")
     * </p>
     */
    public void interStringPool() {
        String a = "1";
        String b = new String("1");
        System.out.println(a == b);
    }

    public static void main(String[] args) {
        StringpoolTest test = new StringpoolTest();
        test.interStringPool();
    }
}

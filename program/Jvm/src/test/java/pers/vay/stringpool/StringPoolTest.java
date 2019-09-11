package pers.vay.stringpool;


import org.junit.jupiter.api.Test;

/**
 * @author qiaozhe
 */
public class StringPoolTest {

    /**
     * 进入String常量池测试
     * <p>
     *     String字符串有两种创建方式
     *     1.直接使用"",e.g. "String"
     *     2.使用new创建，new String("String")
     * </p>
     */
    @Test
    public void interStringPool() {
        String a = new String("1");
        String b = new String("1");
        System.out.println(a == b);
    }
}

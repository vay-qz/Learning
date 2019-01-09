import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Main main = new Main();
        main.test();
        NioTest nioTest = new NioTest();
//        nioTest.testIO();
//        nioTest.testNIORead();
//        nioTest.testNIOWrite();
//        nioTest.testNIOReadAndWrite();
        NIONetTest nioNetTest = new NIONetTest();
        nioNetTest.serverTest();
//        nioNetTest.clientTest();
    }

    public void test(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        IntSummaryStatistics stats = numbers
                .stream()
                .mapToInt((x) -> x).summaryStatistics();

    }
}

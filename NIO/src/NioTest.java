import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author qiaozhe
 */
public class NioTest {

    private String readPath = "E:/github/testRead.txt";
    private String writePath = "E:/github/testWrite.txt";

    public void testIO(){
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(readPath)));
            String line;
            StringBuffer str = new StringBuffer();
            while((line = reader.readLine()) != null){
                str.append(line).append("\n\r");
            }
            System.out.println(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testNIORead(){
        try(FileChannel inFileChannel = new FileInputStream(readPath).getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate(100);
            int length = -1;

            while((length = inFileChannel.read(buffer)) != -1){
                System.out.println(buffer);
                buffer.clear();
                System.out.println(buffer);
                byte[] a = buffer.array();
                System.out.println(new String(a, 0, a.length));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testNIOWrite(){
        try(FileChannel outFileChannel = new FileOutputStream(writePath).getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate(100);
            buffer.put("write".getBytes());
            System.out.println(buffer);
            buffer.flip();
            System.out.println(buffer);
            outFileChannel.write(buffer);
            System.out.println(buffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testNIOReadAndWrite(){
        try(FileChannel in = new FileInputStream(readPath).getChannel();
            FileChannel out = new FileOutputStream(writePath).getChannel()){
            ByteBuffer buffer = ByteBuffer.allocate(10);
            int length = -1;
            while((length = in.read(buffer)) != -1){
                buffer.flip();
                while((length = out.write(buffer))!=0);
                buffer.clear();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}

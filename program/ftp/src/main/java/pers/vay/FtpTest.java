package pers.vay;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTPClient;

import java.io.*;

/**
 * @author qiaozhe
 */
public class FtpTest {

    private long splitlength = 1000;

    public void test() {
        FTPClient ftp = getFTPClient();
        File file = new File("D://test.pdf");
        InputStream is = null;
        try(FileOutputStream fout = new FileOutputStream(file)) {
            ftp.changeWorkingDirectory("test/");
//            ftp.setRestartOffset(splitlength);
            is = ftp.retrieveFileStream(encode("12.pdf"));
            IOUtils.copyLarge(is, fout, 0, splitlength);
            fout.flush();
            ftp.logout();
//            int l = -1;
//            byte[] tmp = new byte[1024];
//            while((l = is.read(tmp)) != -1){
//                fout.write();
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        FTPClient ftp2 = getFTPClient();
        try(FileOutputStream fout = new FileOutputStream(file, true)) {
            ftp2.setRestartOffset(splitlength);
            ftp2.changeWorkingDirectory("test/");
            is = ftp2.retrieveFileStream(encode("12.pdf"));
            IOUtils.copyLarge(is, fout);
            fout.flush();

//            int l = -1;
//            byte[] tmp = new byte[1024];
//            while((l = is.read(tmp)) != -1){
//                fout.write();
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void writeFile(InputStream is) {

    }

    private FTPClient getFTPClient() {
        FTPClient ftp = new FTPClient();
        try {
            String url = "172.23.23.250";
            String username = "thunisoft";
            String password = "6789@jkl";
            ftp.connect(url);
            ftp.login(username, password);
        }catch (Exception e) {
            System.out.println("get ftpclient error");
        }
        return ftp;
    }

    protected String encode(String fileName) throws UnsupportedEncodingException {
        return new String(fileName.getBytes("GBK"), "ISO8859-1");
    }

}

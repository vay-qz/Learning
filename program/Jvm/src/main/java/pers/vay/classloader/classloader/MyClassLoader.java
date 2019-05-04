package pers.vay.classloader.classloader;

import java.io.*;

public class MyClassLoader extends ClassLoader {

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        File file = new File("D:/Person.class");
        InputStream stream  = getInputStream(file);
        byte[] bytes = toByteArray(stream);
        return defineClass(name, bytes, 0, bytes.length);
    }

    public InputStream getInputStream(File file) {
        try {
            return new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public byte[] toByteArray(InputStream in) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024 * 4];
        int n = 0;
        try{
            while ((n = in.read(buffer)) != -1) {
                out.write(buffer, 0, n);
            }
        }catch (IOException e){

        }

        return out.toByteArray();
    }

}

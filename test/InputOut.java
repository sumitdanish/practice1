package test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InputOut {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // TODO Auto-generated method stub
        List<String> list = new ArrayList<String>();
        list.add("Sumit");
        list.add("Sumit123");
        list.add("hello123");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File("test.bin")));
        out.writeObject(list);
        out.close();
        ObjectInputStream oin = new ObjectInputStream(new FileInputStream(new File("test.bin")));
        List<String> l = (List<String>) oin.readObject();
        for (String s : l) {
            System.out.println(s);
        }
    }


}

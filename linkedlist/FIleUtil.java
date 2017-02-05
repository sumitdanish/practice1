package linkedlist;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FIleUtil {


    public static String[] getValue(String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(fileName));
        return sc.nextLine().split(",");

    }


}

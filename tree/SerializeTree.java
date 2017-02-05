package tree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SerializeTree {

    static List<String> list;
    static int ind = 0;

    public SerializeTree() {
        // TODO Auto-generated constructor stub
        list = new ArrayList<String>();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // TODO Auto-generated method stub
        SerializeTree s1 = new SerializeTree();
        TreeNode tn = null;
        CreateTree ct = new CreateTree();
        Scanner sc = new Scanner(new File("tree.txt"));
        for (String s : sc.next().split(",")) {
            int data = Integer.parseInt(s);
            tn = ct.createTree(tn, data);
        }
        s1.serialize(tn);
        s1.serialiInFile(list);
        List<String> l = s1.deserializeFromFile();
//		for(String j : l){
//			System.out.print(j+",");
//		}
        TreeNode t1 = s1.deserialize(l);
        ct.inOrder(t1);
    }

    public String serialize(TreeNode tn) {
        if (tn == null) {
            list.add("#");
            return "";
        }
        list.add(String.valueOf(tn.getData()));
        serialize(tn.getLeft());
        serialize(tn.getRight());
        return "";
    }

    public TreeNode deserialize(List<String> list) {
        if (list.get(ind).equals("#")) {
            ind++;
            return null;
        }

        //System.out.println(list.get(ind));
        TreeNode t = new TreeNode(Integer.parseInt(list.get(ind)));
        ind++;
        t.setLeft(deserialize(list));
        t.setRight(deserialize(list));
        return t;
    }


    public void serialiInFile(List<String> list) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File("st.bin")));
        out.writeObject(list);
        out.close();
    }

    public List<String> deserializeFromFile() throws IOException, ClassNotFoundException {
        ObjectInputStream oin = new ObjectInputStream(new FileInputStream(new File("st.bin")));
        return (List<String>) oin.readObject();
    }

}

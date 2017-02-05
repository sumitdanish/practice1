package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DFSInMattrix {


    static int[][] adjMatt;
    static boolean[] visited;

    public DFSInMattrix(int i) {
        adjMatt = new int[i][i];
        visited = new boolean[i];
    }

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(new File("dfs.txt"));
        int i = Integer.parseInt(sc.nextLine());
        DFSInMattrix d = new DFSInMattrix(i);
        while (sc.hasNext()) {
            String[] s = sc.nextLine().split(",");
            d.addMatt(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
            d.addMatt(Integer.parseInt(s[1]), Integer.parseInt(s[0]));
        }
        for (int j = 0; j < i; j++) {
            for (int k = 0; k < i; k++) {
                System.out.print(adjMatt[j][k] + ",");
            }
            System.out.println();
        }
        d.dfs(0, i);
    }

    public void addMatt(int i, int j) {
        adjMatt[i][j] = 1;
    }

    public void dfs(int i, int n) {
        visited[i] = true;
        System.out.println(i);
        for (int j = 0; j < n; j++) {
            if (!visited[j] && adjMatt[i][j] == 1) {
                dfs(j, n);
            }
        }
    }

}

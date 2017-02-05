package mattrix;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestInMattrix {
    int[] row = {0, 1, 0, -1};
    int[] col = {-1, 0, 1, 0};

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] mat = {{1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                {1, 1, 1, 0, 1, 1, 1, 0, 1, 0},
                {1, 0, 1, 1, 1, 1, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 0, 0, 0, 0, 1, 0, 0, 1}};
        boolean[][] visi = new boolean[9][10];
        Point src = new Point(0, 0);
        Point dest = new Point(3, 4);

        int dist = new ShortestInMattrix().minDist(mat, 9, 10, src, dest, visi);
        System.out.println(dist);
    }


    public boolean isValid(int row, int col, int[][] mat, int r, int c, boolean[][] visi) {
        return r >= 0 && c >= 0 && r < row && c < col && mat[r][c] == 1 && !visi[r][c];
    }


    public int minDist(int[][] mat, int ro, int co, Point src, Point dist, boolean[][] visi) {
        Queue<Record> q = new LinkedList<>();
        Record r = new Record(0, src);
        q.add(r);
        visi[src.getX()][src.getY()] = true;
        while (!q.isEmpty()) {
            Record r1 = q.peek();
            Point p1 = r1.getPoint();
            if (p1.getX() == dist.getX() && p1.getY() == dist.getY()) {
                return r1.getDist();
            }
            q.poll();
            for (int i = 0; i < 4; i++) {
                int r2 = p1.getX() + row[i];
                int c2 = p1.getY() + col[i];
                if (isValid(ro, co, mat, r2, c2, visi)) {
                    visi[r2][c2] = true;
                    Point p3 = new Point(r2, c2);
                    Record r3 = new Record(r1.getDist() + 1, p3);
                    q.add(r3);
                }
            }
        }
        return -1;
    }

}

class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

class Record {
    private Point point;
    private int dist;

    public Record(int dist, Point point) {
        this.dist = dist;
        this.point = point;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public int getDist() {
        return dist;
    }

    public void setDist(int dist) {
        this.dist = dist;
    }

}
package string;

public class MaxDepthOfBracket {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s = "( p((q)) ((s)t) )";
        new MaxDepthOfBracket().maxDepth(s);
    }

    public void maxDepth(String s) {
        int count = 0;
        int max_depth = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
                if (max_depth < count) {
                    max_depth = count;
                }
            } else if (s.charAt(i) == ')') {
                count--;
            }
        }
        if (count < 0) {
            System.out.println("No Depth");
        } else {
            System.out.println("Max Depth : " + max_depth);
        }
    }

}

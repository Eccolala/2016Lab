package Artifical.Eight;


public class Hello {
    public static void main(String args[]) {
        int start[][] = {{2,0,3},
                        {1,8,4},
                        {7,6,5}};

        Eight eight = new Eight(start);
        eight.heuristicSearch();
        eight.findPath();

    }
}

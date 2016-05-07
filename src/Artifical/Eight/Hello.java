package Artifical.Eight;


public class Hello {
    public static void main(String args[]) {
        int start[][] = {{8,0,3},
                        {2,1,4},
                        {7,6,5}};

        Eight eight = new Eight(start);
        eight.heuristicSearch();
        eight.findPath();

    }
}

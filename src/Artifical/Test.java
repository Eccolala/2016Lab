package Artifical;


import static Artifical.Eight.Util.showMatrix;

/**
 * 数字 0 代表空格
 */
public class Test {
    public static void main(String args[]) {
        int start[][] = {{1, 4, 3}, {7, 0, 6}, {5, 8, 2}};
        int goal[][] = {{1, 2, 3}, {8, 0, 4}, {7, 6, 5}};

        showMatrix(start);

    }
}

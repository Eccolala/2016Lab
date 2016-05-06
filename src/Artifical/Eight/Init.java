package Artifical.Eight;

import java.util.List;

import static Artifical.Eight.Util.findPosMov;
import static Artifical.Eight.Util.showMatrix;

/**
 * 入口函数
 */
public class Init {
    public static void main(String args[]) {

        int array[][] = {{0, 2, 3}, {4, 5, 5}, {7, 8, 9}};
        List<int[][]> mMatrixs = findPosMov(array);

        for (int[][] item : mMatrixs) {
            showMatrix(item);
        }
//        findZero(array);
    }
}

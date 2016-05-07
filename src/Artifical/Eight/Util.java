//package Artifical.Eight;
//
//
//import Artifical.Eight.model.State;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Util {
//    /**
//     * 移动的方向
//     */
//    public final static int MOVE_UP = 0;
//    public final static int MOVE_DOWN = 1;
//    public final static int MOVE_LEFT = 2;
//    public final static int MOVE_RIGHT = 3;
//
//
//    /**
//     * 根据方向和0的位置移动 0
//     *
//     * @param array
//     * @param direction
//     */
//    public static int[][] moveByDire(int array[][], int direction, int pos_x, int pos_y) {
//        switch (direction) {
//            case MOVE_UP:
//                return moveUp(array, pos_x, pos_y);
//            case MOVE_DOWN:
//                return moveDown(array, pos_x, pos_y);
//            case MOVE_LEFT:
//                return moveLeft(array, pos_x, pos_y);
//            default:
//                return moveRight(array, pos_x, pos_y);
//        }
//    }
//
//    /**
//     * 0 向上移动
//     *
//     * @param array
//     * @param pos_x
//     * @param pos_y
//     * @return
//     */
//    public static int[][] moveUp(int array[][], int pos_x, int pos_y) {
//        int newArray[][] = new int[3][3];
//        for (int i = 0; i < array.length; i++)
//            for (int j = 0; j < array.length; j++) {
//                newArray[i][j] = array[i][j];
//            }
//
//        int temp = 0;
//        temp = newArray[pos_x][pos_y];
//        newArray[pos_x][pos_y] = newArray[pos_x - 1][pos_y];
//        newArray[pos_x - 1][pos_y] = temp;
//        return newArray;
//    }
//
//    /**
//     * 0 向下移动
//     *
//     * @param array
//     * @param pos_x
//     * @param pos_y
//     * @return
//     */
//    public static int[][] moveDown(int array[][], int pos_x, int pos_y) {
//        int newArray[][] = new int[3][3];
//        for (int i = 0; i < array.length; i++)
//            for (int j = 0; j < array.length; j++) {
//                newArray[i][j] = array[i][j];
//            }
//
//        int temp = 0;
//        temp = newArray[pos_x][pos_y];
//        newArray[pos_x][pos_y] = newArray[pos_x + 1][pos_y];
//        newArray[pos_x + 1][pos_y] = temp;
//        return newArray;
//    }
//
//    /**
//     * 0 向左移动
//     *
//     * @param array
//     * @param pos_x
//     * @param pos_y
//     * @return
//     */
//    public static int[][] moveLeft(int array[][], int pos_x, int pos_y) {
//        int newArray[][] = new int[3][3];
//        for (int i = 0; i < array.length; i++)
//            for (int j = 0; j < array.length; j++) {
//                newArray[i][j] = array[i][j];
//            }
//
//        int temp = 0;
//        temp = newArray[pos_x][pos_y];
//        newArray[pos_x][pos_y] = newArray[pos_x][pos_y - 1];
//        newArray[pos_x][pos_y - 1] = temp;
//        return newArray;
//    }
//
//    /**
//     * 0 向右移动
//     *
//     * @param array
//     * @param pos_x
//     * @param pos_y
//     * @return
//     */
//    public static int[][] moveRight(int array[][], int pos_x, int pos_y) {
//        int newArray[][] = new int[3][3];
//        for (int i = 0; i < array.length; i++)
//            for (int j = 0; j < array.length; j++) {
//                newArray[i][j] = array[i][j];
//            }
//
//        int temp = 0;
//        temp = newArray[pos_x][pos_y];
//        newArray[pos_x][pos_y] = newArray[pos_x][pos_y + 1];
//        newArray[pos_x][pos_y + 1] = temp;
//        return newArray;
//    }
//
//    /**
//     * 初始化Open表与Closed表
//     */
//    public static void initList() {
//        ArrayList<int[][]> mOpenList = new ArrayList<>();
//        ArrayList<int[][]> mClosedList = new ArrayList<>();
//    }
//
//    public static boolean isTargetNode(State node) {
//
//        return false;
//    }
//
//
//    /**
//     * 显示数组
//     */
//    public static void showMatrix(int[][] array) {
//
//        for (int[] anArray : array) {
//            for (int j = 0; j < anArray.length; j++) {
//                System.out.print(anArray[j]);
//                if (j == anArray.length - 1) {
//                    System.out.print('\n');
//                }
//            }
//        }
//    }
//
//    /**
//     * 寻找当前节点 0的位置，并产生扩展后的节点列表
//     */
//
//    public static List<int[][]> findPosMov(int[][] array) {
//        List<int[][]> mMatrixs = new ArrayList<>();
//        int m = -1;
//        int n = -1;
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                if (array[i][j] == 0) {
//                    m = i;
//                    n = j;
//                    break;
//                }
//            }
//        }
//
//        if (m == 0 && n == 0) {
//            mMatrixs.add(moveRight(array, m, n));
//            mMatrixs.add(moveDown(array, m, n));
//        } else if (m == 0 && n == 1) {
//            mMatrixs.add(moveRight(array, m, n));
//            mMatrixs.add(moveDown(array, m, n));
//            mMatrixs.add(moveLeft(array, m, n));
//        } else if (m == 0 && n == 2) {
//            mMatrixs.add(moveDown(array, m, n));
//            mMatrixs.add(moveLeft(array, m, n));
//        } else if (m == 1 && n == 0) {
//            mMatrixs.add(moveRight(array, m, n));
//            mMatrixs.add(moveDown(array, m, n));
//            mMatrixs.add(moveUp(array, m, n));
//        } else if (m == 1 && n == 1) {
//            mMatrixs.add(moveRight(array, m, n));
//            mMatrixs.add(moveLeft(array, m, n));
//            mMatrixs.add(moveDown(array, m, n));
//            mMatrixs.add(moveUp(array, m, n));
//        } else if (m == 1 && n == 2) {
//            mMatrixs.add(moveLeft(array, m, n));
//            mMatrixs.add(moveDown(array, m, n));
//            mMatrixs.add(moveUp(array, m, n));
//        } else if (m == 2 && n == 0) {
//            mMatrixs.add(moveUp(array, m, n));
//            mMatrixs.add(moveRight(array, m, n));
//        } else if (m == 2 && n == 1) {
//            mMatrixs.add(moveRight(array, m, n));
//            mMatrixs.add(moveLeft(array, m, n));
//            mMatrixs.add(moveUp(array, m, n));
//        } else {
//            mMatrixs.add(moveLeft(array, m, n));
//            mMatrixs.add(moveUp(array, m, n));
//        }
//
//        return mMatrixs;
//
//    }
//
//
//    /**
//     * 根据Value 的值重排 Open表
//     */
//    public static void reSort() {
//
//    }
//
//
//    /**
//     * 扩展节点 （包括深度、记录父节点、ID编号、启发值）
//     */
//    public static void genNewState(State oldState) {
//        int col = 1;
//        int row = 1;
//        int temp = 0;
//
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                if (oldState.arrState[i][j] == 0) {
//                    col = i;    //保持行坐标
//                    row = j;    //保存列坐标
//                    break;
//                }
//
//            }
//        }
//
//        if (row + 1 < 3){
//            State newState = new State();
//            newState.depth = oldState.depth +1;
//            newState.parent = oldState.nID;
//            //newState.nID = nAutoIncrease++;//对ID自动编号
//        }
//
//
//    }
//    public static void show(int[][] arrState) {
//        for (int i = 0; i < 3; i++) {
//            System.out.print("\t");
//            for (int j = 0; j < 3; j++)
//                System.out.println(arrState[i][j]);
//        }
//    }
//
//    public static int w(int array[][],int[][] goal) {
//
//        int count = 0;
//        for (int i = 0; i < 3; i++)
//            for (int j = 0; j < 3; j++) {
//                if (array[i][j] == 0)
//                    continue;
//                if (array[i][j] != goal[i][j])
//                    count++;
//            }
//        return count;
//
//    }
//
//    public static void sortOpen(List<State> mList){
//        State temp = new State();
//        for (int i = 0;i < 5;i++){
//            for (int j = 0;j < 5;j++) {
//                if (mList.get(i).value > mList.get(j).value) {
//                    temp = mList.get(i);
//                    mList.get(i) = mList.get(j);
//                    mList.get(j) = temp;
//                }
//            }
//        }
//
//    }
//
//}

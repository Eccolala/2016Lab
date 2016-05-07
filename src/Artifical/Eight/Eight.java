package Artifical.Eight;

import Artifical.Eight.model.State;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 八数码解决类
 */
public class Eight {
    //Open表
    private List<State> open;
    //open表的索引
    private int openIndex;

    private List<State> closed;
    private int closedIndex;
    //开始状态
    private int start[][];
    //节点自增
    private int nAutoIncrease;
    //目标状态
    private int goal[][] = {{1, 2, 3},
            {8, 0, 4},
            {7, 6, 5}};

    //构造函数
    public Eight(int s[][]) {
        start = new int[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                start[i][j] = s[i][j];
        nAutoIncrease = 0;
        //open栈顶位置
        openIndex = 0;
        closedIndex = 0;
        State state = new State();
        open = new ArrayList<>();
        closed = new ArrayList<>();
        open.add(state);
        openIndex++;
    }

    public void init() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                open.get(0).arrState[i][j] = start[i][j];
        open.get(0).nID = 0;
        open.get(0).depth = 0;
        open.get(0).parent = 0;

        open.get(0).value = w(start) + 0;
    }


    /**
     * 显示数组
     *
     * @param array
     */
    public void showMatrix(int[][] array) {

        for (int[] anArray : array) {
            for (int j = 0; j < anArray.length; j++) {
                System.out.print(anArray[j]);
                if (j == anArray.length - 1) {
                    System.out.print('\n');
                }
            }
        }
    }

    //启发值 f(n) = depth + w(n)
    public int f(State s) {
        return s.depth + w(s.arrState);
    }


    //计算期望值w ,不在位,好使的
    public int w(int array[][]) {

        int count = 0;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                if (array[i][j] == 0)
                    continue;
                if (array[i][j] != goal[i][j])
                    count++;
            }
        return count;

    }


    /**
     * 依据 value的值由大到小重新排列open表
     *
     * 此处被 lambda表达式替换
     */
//    public void sortOpen() {
//        State temp = new State();
//        for (int i = 0; i < open.size(); i++)
//            for (int j = i + 1; j < open.size() + 1; j++)
//                if (open.get(i).value > open.get(j).value) {
//                    temp = open.get(i);
//                    open.get(i) = open.get(j);
//                    open.get() = temp;
//                }
//    }

    /**
     * 扩展节点 （包括深度、记录父节点、ID编号、启发值）
     */
    public void genNewState(State oldState) {
        int row = -1;
        int col = -1;
        int temp = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (oldState.arrState[i][j] == 0) {
                    row = i;    //保存行坐标
                    col = j;    //保存列坐标
                    break;
                }

            }
        }

        //0 向下移动
        if (row + 1 < 3) {
            //这里的问题是 newState 是oldState 的一个引用所以 newState 一变 oldState 也会跟着变
            State newState = new State();
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    newState.arrState[i][j] = oldState.arrState[i][j];
//            State newState = oldState;
            newState.depth = oldState.depth + 1;
            newState.parent = oldState.nID;
            nAutoIncrease = nAutoIncrease + 1;
            newState.nID = nAutoIncrease;//对ID自动编号

            temp = newState.arrState[row][col];
            newState.arrState[row][col] = newState.arrState[row + 1][col];
            newState.arrState[row + 1][col] = temp;

            newState.value = w(newState.arrState) + newState.depth;
            //将新节点增加至open 表
            genToOpen(newState);

        }
        if (row - 1 > -1)//0向上移动
        {
            // State newState = oldState;
            State newState = new State();
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    newState.arrState[i][j] = oldState.arrState[i][j];
            newState.depth = oldState.depth + 1;
            newState.parent = oldState.nID;
            nAutoIncrease = nAutoIncrease + 1;
            newState.nID = nAutoIncrease;//对ID自动编号

            //switch
            temp = newState.arrState[row][col];
            newState.arrState[row][col] = newState.arrState[row - 1][col];
            newState.arrState[row - 1][col] = temp;

            newState.value = w(newState.arrState) + newState.depth;
            //newState.value = f(newState);
            //push newState to open
            genToOpen(newState);
        }

        if (col + 1 < 3)//0向右移动
        {
            //State newState = oldState;
            State newState = new State();
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    newState.arrState[i][j] = oldState.arrState[i][j];
            newState.depth = oldState.depth + 1;
            newState.parent = oldState.nID;
            nAutoIncrease = nAutoIncrease + 1;
            newState.nID = nAutoIncrease;//对ID自动编号

            //switch
            temp = newState.arrState[row][col];
            newState.arrState[row][col] = newState.arrState[row][col + 1];
            newState.arrState[row][col + 1] = temp;

            newState.value = w(newState.arrState) + newState.depth;
            //newState.value = f(newState);
            //push newState to open
            genToOpen(newState);
        }

        if (col - 1 > -1)//0向左移动
        {
//            State newState = oldState;
            State newState = new State();
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    newState.arrState[i][j] = oldState.arrState[i][j];
            newState.depth = oldState.depth + 1;
            newState.parent = oldState.nID;
            nAutoIncrease = nAutoIncrease + 1;
            newState.nID = nAutoIncrease;//对ID自动编号

            //switch
            temp = newState.arrState[row][col];
            newState.arrState[row][col] = newState.arrState[row][col - 1];
            newState.arrState[row][col - 1] = temp;

            newState.value = w(newState.arrState) + newState.depth;
            //newState.value = f(newState);
            //push newState to open
            genToOpen(newState);
        }


    }

    /**
     * remove 可能会有问题，还没测试
     *
     * @param s
     */
    //把open表中已访问的state放到closed表中
    public void moveToClosed(State s) {
        ++closedIndex;

        closed.add(s);

        //delete from open table
//        for (int j = 0; j < openIndex - 1; j++)
//            open[j] = open[j + 1];
        //open length-1
        open.remove(s);
        openIndex--;
    }

    public void genToOpen(State s) {
        if (IsInOpen(s)) {
            //show(s);
            //cout<<"该状态已存在open表中！"<<endl;
            nAutoIncrease--;
            return;
        }
        if (IsInClosed(s)) {
            //show(s);
            //cout<<"该状态已存在closed表中！"<<endl;
            nAutoIncrease--;
            return;
        }

        openIndex++;

        open.add(s);

//        open.get(i).depth = s.depth;
//        open.get(i).parent = s.parent;
//        open.get(i).value = s.value;
    }

    //current state compare to goal state
    public boolean compare(State s) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (s.arrState[i][j] != goal[i][j])
                    return false;
        return true;
    }

    //Is current state in closed table ,应该没毛病
    public boolean IsInClosed(State s) {
        for (int k = 0; k < closedIndex; k++) {
            if (closed.get(k).equals(s))
                return true;
        }

        return false;
    }

    // Is current state in open table，应该没毛病
    public boolean IsInOpen(State s) {
        for (int k = 0; k < openIndex; k++) {
            if (open.get(k).equals(s))
                return true;
        }

        return false;
    }

    //主函数
    //递归搜索
    public void heuristicSearch() {
        init();
        //保存当前状态
        State curState;

        while (openIndex != -1) {
            curState = open.get(0);

            showMatrix(open.get(0).arrState);

            System.out.println();
            if (closedIndex >= 80 || openIndex >= 80) {
                System.out.println("宽度已达到极限");
                return;
            }

            if (compare(curState)) {
                System.out.println("已获得求解");
                System.out.println();
                return;    //输出
            }

            moveToClosed(open.get(0));    //将该结点放入closed表中
            genNewState(curState);    //扩展结点 并且将结点压入open表中

            //重排open表
            Collections.sort(open, (o1, o2) -> {
                int a = o1.value;
                int b = o2.value;
                return a > b ? 1 : -1;
            });
        }
        System.out.println("深度达到极限");
    }

    public void findPath() {
        Collections.sort(open, (o1, o2) -> {
            int a = o1.value;
            int b = o2.value;
            return a > b ? 1 : -1;
        });
//        showMatrix(open.get(0).arrState);
//        System.out.println();

            moveToClosed(open.get(0));

//        for (int i = closedIndex; i > -1; i--) {
//            if (closed.get(i).nID == currentID) {
//                showMatrix(closed.get(i).arrState);    //输出
//                currentID = closed.get(i).parent;
//            }
//        }

//        for (int i = 0; i < closedIndex; i++) {
//            if (closed.get(i).nID == currentID) {
//                showMatrix(closed.get(i).arrState);
//                currentID = closed.get(i).parent;
//            }
//        }
        int currentID = closed.get(closedIndex - 1).parent;
        showMatrix(closed.get(closedIndex - 1).arrState);
        System.out.println();
        for (int i = closedIndex - 1;i > -1;i--){
            if (closed.get(i).nID == currentID){
                showMatrix(closed.get(i).arrState);
                System.out.println();
                currentID = closed.get(i).parent;
            }
        }
// while (closedIndex > 0) {
//
//            int key = closedIndex - 1;
//            if (closed.get(key).nID == currentID) {
//                showMatrix(closed.get(closedIndex).arrState);
//                System.out.println();
//                currentID = closed.get(closedIndex).parent;
//            }
//            closedIndex--;
//        }

//        for (State s : closed){
//            showMatrix(s.arrState);
//            System.out.println();
//        }
    }
}

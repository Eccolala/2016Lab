//package Artifical.Eight;
//
//import Artifical.Eight.model.State;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static javafx.scene.input.KeyCode.M;
//
///**
// * 八数码解决类
// */
//public class Eight {
//    //Open表
//    private List<State> open;
//    private int openIndex;
//
//    private List<State> close;
//    private int closeIndex;
//    //开始状态
//    private int start[][];
//    //自增
//    private int nAutoIncrease;
//    //目标状态
//    private int goal[][] = {{1, 2, 3},
//                            {8, 0, 4},
//                            {7, 6, 5}};
//
//    //构造函数
//    public Eight(int start[][]) {
//        this.start = start;
//        nAutoIncrease = 1;
//        open = new ArrayList<>();
//        close = new ArrayList<>();
//    }
//
//    public void init() {
//        State state = new State();
//        for (int i = 0; i < 3; i++)
//            for (int j = 0; j < 3; j++)
//                state.arrState[i][j] = start[i][j];
//        state.nID = 0;
//        state.depth = 0;
//        state.parent = 0;
//        state.value = w(start) + 0;
//        open.add(state);
//    }
//
//    //计算期望值w ,不在位
//    public int w(int array[][]) {
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
//    public void show(State s) {
//        for (int i = 0; i < 3; i++) {
//            System.out.print("\t");
//            for (int j = 0; j < 3; j++)
//                System.out.println(s.arrState[i][j]);
//        }
//    }
//
//    //启发值 f(n) = depth + w(n)
//    public int f(State s) {
//        return s.depth + w(s.arrState);
//    }
//
//    /**
//     * 依据 value的值由大到小重新排列open表
//     */
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
//
//    /**
//     * 扩展节点的方法请看我的 Util方法
//     * @param s
//     */
//
//    //把open表中已访问的state放到closed表中
//    public void moveToClosed(State s) {
//        int i = ++closedIndex;
//
//        closed[i] = s;
//
//        //delete from open table
//        for (int j = 0; j < openIndex - 1; j++)
//            open[j] = open[j + 1];
//        //open length-1
//        openIndex--;
//    }
//
//    public void genToOpen(State newState) {
//        if (IsInOpen(s)) {
//            //show(s);
//            //cout<<"该状态已存在open表中！"<<endl;
//            nAutoIncrease--;
//            return;
//        }
//        if (IsInClosed(s)) {
//            //show(s);
//            //cout<<"该状态已存在closed表中！"<<endl;
//            nAutoIncrease--;
//            return;
//        }
//
//        int i = ++openIndex;
//
//        open[i] = s;
//
//        open[i].depth = s.depth;
//        open[i].parent = s.parent;
//        open[i].value = s.value;
//    }
//
//    //current state compare to goal state
//    public boolean compare(State s) {
//        for (int i = 0; i < 3; i++)
//            for (int j = 0; j < 3; j++)
//                if (s.arrState[i][j] != goal[i][j])
//                    return false;
//        return true;
//    }
//
//    //Is current state in closed table
//    public boolean IsInClosed(State s) {
//        for (int k = 0; k <=)
//    }
//
//    // Is current state in open table
//    public boolean IsInOpen(State s) {
//        for (int k = 0; k <= openIndex; k++) {
//            if (open[k] == s)
//                return true;
//        }
//
//        return false;
//    }
//
//    //主函数
//    //递归搜索
//    public void heuristicSearch(){
//        init();
//        //保存当前状态
//        State curState = new State();
//
//        int n = 0;
//
//    }
//}

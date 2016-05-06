package Artifical.Eight.model;

/**
 * 节点类
 */
public class State {
    /**
     * 初始时每个节点的估价函数值为0，估价就是f(x)
     */
    //当前节点的值
    public int[][] arrState;
    //父节点的id
    public int parent;
    //当前节点的id
    public int nID;
    //该节点在第几层
    public int depth;
    //该节点的启发值f(n)
    public int value;

    public State() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                arrState[i][j] = -1;
        this.parent = -1;
        this.nID = -1;
        this.depth = -1;
        this.value = -1;
    }

}

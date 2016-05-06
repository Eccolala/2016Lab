package Artifical.CrossRiver.model;

/**
 * 节点，或者称之为状态
 * first,second,third 分别代表正常人，野人，小船的位置
 */
public class Node {
    private int first;
    private int second;
    private int third;

    public Node(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getThird() {
        return third;
    }

    public void setThird(int third) {
        this.third = third;
    }


}

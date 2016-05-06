package Artifical.CrossRiver;

import Artifical.CrossRiver.model.Item;
import Artifical.CrossRiver.model.Node;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * CrossRiver 的工具类
 */
public class Util {
    public static void delImproper(List<Item> mList) {
        Iterator<Item> iterator = mList.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (item.getThird() > 1) {
                iterator.remove();
            } else if (item.getFirst() < item.getSecond()) {
                iterator.remove();
            }
        }
    }

    /**
     * 将算法结果打印成链表形式,类似<5,5,1> -> <5,1,0> -> <5,2,1>
     */
    public static void printList(List<Node> mNodes) {
        for (Node node : mNodes) {
            System.out.print(" -> " + "<" + node.getFirst() + "," + node.getSecond() + ","
                    + node.getThird() + ">");
        }
    }

    /**
     * 判断当前节点是否为目标节点
     *
     * @param mNode  已知节点
     * @param target 目标节点
     * @return
     */
    public static boolean isTarget(Node mNode, Node target) {
        if (mNode.getFirst() == target.getFirst()
                && mNode.getSecond() == target.getSecond()
                && mNode.getThird() == target.getThird()) {
            return true;
        }

        return false;
    }

    /**
     * 创造组合数
     *
     * @param in 是野人数和人类数
     * @return
     */
    public static List<Item> createComb(int in) {
        List<Item> mItems = new ArrayList<>();
        for (int i = 0; i <= in; i++)
            for (int j = 0; j <= in; j++)
                for (int k = 0; k <= in; k++)
                    mItems.add(new Item(i, j, k));
        return mItems;
    }

    /**
     * 新建mNodes列表, 将 mItems中的数据转移到 mNodes中
     *
     * @param mItems
     */
    public static void addCom2Node(List<Item> mItems) {
        List<Node> mNodes = new ArrayList<>();
        for (Item item : mItems) {
            mNodes.add(new Node(item.getFirst(), item.getSecond(), item.getThird()));
        }
    }
}

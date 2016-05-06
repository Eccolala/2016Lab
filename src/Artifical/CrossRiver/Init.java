package Artifical.CrossRiver;

import Artifical.CrossRiver.core.Solver;
import Artifical.CrossRiver.model.Item;

import java.util.List;

import static Artifical.CrossRiver.Util.createComb;
import static Artifical.CrossRiver.Util.delImproper;

/**
 * 入口函数
 */
public class Init {
    public static void main(String args[]){
        Solver mSolver = new Solver();
        List<Item> mList = createComb(5);

        delImproper(mList);
        for (Item item : mList){
            System.out.print("(" + item.getFirst());
            System.out.print(item.getSecond());
            System.out.print(item.getThird() + ")");
            System.out.print("\n");
        }
    }
}

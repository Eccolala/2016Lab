package Artifical.CrossRiver.core;

import Artifical.CrossRiver.model.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * 算法的解决者
 */
public class Solver {
    /**
     * 创造组合数
     * @param in 野人数和人类数
     * @return
     */
    public List<Item> createComb(int in) {
        List<Item> mItems = new ArrayList<>();
        for (int i = 0; i <= in; i++)
            for (int j = 0; j <= in; j++)
                for (int k = 0; k <= in; k++)
                    mItems.add(new Item(i,j,k));
        return mItems;
    }
}

package Artifical.Eight;

import Artifical.Eight.model.State;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 入口函数
 */
public class Init {
    public static void main(String args[]) {

        int array[][] = {{0, 7, 1},
                {4, 5, 5},
                {7, 8, 9}};

        int goal[][] = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        List<State> mList = new ArrayList<State>();

        State s = new State();
        s.value = 1;
        mList.add(s);

        State s0 = new State();
        s0.value = 5;
        mList.add(s0);

        State s1 = new State();
        s1.value = 5;
        mList.add(s1);

        State s2 = new State();
        s2.value = 2;
        mList.add(s2);

        State s3 = s2;
        mList.add(s3);


        //根据List 的 value值从大到小排列
        Collections.sort(mList, (o1, o2) -> {
            int a = o1.value;
            int b = o2.value;
            return a > b ? -1 : 1;
        });


//        for (State state : mList) {
//            System.out.println(state.value);
//        }

        if (mList.get(4).equals(s)){
            System.out.print("Treu");
        }else {
            System.out.print("False");
        }


    }
}

package com.algorithm._02linkedList;

import com.algorithm.utils.List;

/**
 * @Description : //Main
 * @Author : BETTERME
 */
public class Main {

    public static void main(String[] args) {

        List<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(1,50);
        list.set(3,60);
        list.remove(0);
        list.remove(list.size()-1);
        System.out.println(list);
    }
}

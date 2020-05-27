package com.joy.test;

import com.joy.erfen.Dichotomy;

import java.util.Arrays;
import java.util.Dictionary;

public class Test {
    public static void main(String[] args) {
        int[] a = {5, 2, 8, 10, 11};
        //第一步是有序
        Arrays.sort(a);
        System.out.println(Dichotomy.dichotomy(a,-1));
    }
}

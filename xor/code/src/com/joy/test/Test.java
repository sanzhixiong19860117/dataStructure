package com.joy.test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        demo1();
        demo2();
        int[] a = {1, 1, 2, 2, 3, 3, 4, 4, 4};
        findNum1(a);
    }

    //交换两个数字不用中间变量
    private static void demo1() {
        int a = 20;
        int b = 10;
        //使用异或操作
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a = " + a + ",b = " + b);
    }

    private static void demo2() {
        int[] a = {1, 1, 2, 2, 3, 3, 4, 4, 4};
        int emp = 0;
        for (int i = 0; i < a.length  ; i++) {
            emp^= a[i];
        }
        System.out.println("数据为="+emp);
    }

    private static void findNum1(int[] arr){
        int erp = 0;//查找出是那个数字
        int index = 0;
        int erp1 = 0;
        int[] a = new int[arr.length];
        for (int i = 0; i < arr.length ; i++) {
            erp ^= arr[i];
        }
        for (int i = 0; i < arr.length ; i++) {
            erp1^=arr[i];
            if(erp != arr[i] && erp1==0){
                if(!isOpen(a,arr[i])){
                    a[index] = arr[i];
                    index++;
                }
            }
        }
        System.out.print(Arrays.toString(a));
    }

    private static Boolean isOpen(int[] arr,int num){
        for (int i = 0; i < arr.length ; i++) {
            if(arr[i] == num){
                return true;
            }
        }
        return false;
    }
}

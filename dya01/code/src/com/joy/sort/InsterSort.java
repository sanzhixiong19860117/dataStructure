package com.joy.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author joy
 * @date 2020/5/25
 * 插入排序
 */
public class InsterSort {
    public static void main(String[] args) {
        int min = 10;
        int max = 10;
        int time = 500000;
        int[] arr = {};
        int[] arr1 = {};
        boolean isRight = true;
        for (int i = 0; i < time ; i++) {
            arr = Glob.createArray(max,min);
            arr1 = Glob.cpArray(arr);
            insterSort(arr);
            Glob.systemSort(arr1);
            if(!Glob.equer(arr,arr1)){
                //操作
                isRight = false;
                break;
            }
        }
        if(isRight){
            System.out.println("is nice");
            System.out.println(Arrays.toString(arr));
        }else{
            System.out.println("出现错误了");
        }
    }

    private static void insterSort(int[] arr){
        if(null == arr || arr.length<2){
            return;
        }
        int tmp = 0;
        //从第一张开始判断1-n
        for (int i = 1; i < arr.length; i++) {
            //斗地主的牌型比较
            for (int j = i-1; j >=0&&arr[j]>arr[j+1] ; j--) {
                Glob.swop(arr,j,j+1);
            }
        }
    }
}

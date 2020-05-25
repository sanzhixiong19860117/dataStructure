package com.joy.sort;

import java.lang.reflect.Array;

/**
 * @author joy
 * @date 2020/5/25
 * 插入排序
 */
public class InsterSort {
    public static void main(String[] args) {
        int[] arr = {1,100,3,2,88,66};
        insterSort(arr);
        for (int i = 0; i < arr.length ; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void insterSort(int[] arr){
        if(null == arr || arr.length<2){
            return;
        }

        int tmp = 0;

        //第一步循环操作最外层的数据
        for (int i = 1; i < arr.length ; i++) {
            //大的往后插入
            if(arr[i]<arr[i-1]){
                tmp = arr[i];
                for (int j = i; j > 0; j--) {
                    if(j>0 && arr[j-1]>tmp){
                        arr[j] = arr[j-1];
                    }
                    else{
                        arr[j] = tmp;
                        break;
                    }
                }
            }
        }
    }
}

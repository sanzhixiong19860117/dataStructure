package com.joy.sort;

import java.util.Arrays;

/**
 * @author joy
 * @date 2020/5/26
 */
public class Glob {
    /**
     * 创建数组
     * @param min  最小的数据
     * @param max  数组的长度
     * @return
     */
    public static int[] createArray(int min,int max){
        if(min<0 || max<0){
            System.out.println("min or max 数据有问题");
            return null;
        }
        //创建一个数组
        int[] arr = new int[(int)(Math.random()*(max+1))];

        //放入数据
        for (int i = 0; i < arr.length ; i++) {
            arr[i] = (int)(Math.random()*(max+1))-(int)(Math.random()*min);
        }
        return arr;
    }

    //拷贝数组
    public static int[] cpArray(int[] arr){
        if(null == arr){
            System.out.println("cpArray 出错");
            return null;
        }
        int[] newcp = new int[arr.length];
        for (int i = 0; i <newcp.length ; i++) {
            newcp[i] = arr[i];
        }
        return newcp;
    }

    //系统函数sort
    public static void systemSort(int[] arr){
        if(null == arr){
            return;
        }
        Arrays.sort(arr);
    }

    //数据的对比
    public static boolean equer(int[] arr1,int[] arr2){
        //数据操作
        if(null == arr1 || null == arr2){
            return false;
        }
        //长度是否一致
        if(arr1.length != arr2.length){
            return false;
        }
        //判断数据是否一致
        for (int i = 0; i < arr1.length ; i++) {
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }

    /**
     * 交换的数组
     * @param arr1 交换数组
     * @param i 坐标
     * @param j
     */
    public static void swop(int[] arr1,int i,int j){
        arr1[i] = arr1[i]^arr1[j];
        arr1[j] = arr1[i]^arr1[j];
        arr1[i] = arr1[i]^arr1[j];
    }
}

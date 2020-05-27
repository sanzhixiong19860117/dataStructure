package com.joy.glob;

import java.util.Arrays;

public final class Glob {
    /**
     * 创建一个数组
     * @param arrMaxLen 数组的最大的长度
     * @param valueMin  数据的最小值
     * @return
     */
    public final static int[] createArray(int arrMaxLen,int valueMin){
        if(arrMaxLen<0 || valueMin<0){
            System.out.println("创建数组有问题"+arrMaxLen+"==="+valueMin);
            return null;
        }
        //随机一个大小
        int ranValue = (int)(Math.random()*(arrMaxLen+1));
        int[] arr = new int[ranValue];
        //下面是赋值
        for (int i = 0; i < arr.length ; i++) {
            int max = (int)(Math.random()*(arrMaxLen+1));
            int min = (int)(Math.random()*valueMin);
            arr[i] = max - min;
        }
        return arr;
    }

    /**
     * 使用系统函数进行排序
     * @param arr
     */
    public final static void systemSort(int[] arr){
        Arrays.sort(arr);
    }

    /**
     * 进行对比操作
     * @param arr1
     * @param arr2
     * @return
     */
    public final static boolean equal(int[] arr1,int[] arr2){
        //非法操作判断
        if(null == arr1 || null == arr2){
            return false;
        }
        //判断两个数组是否长度一致，否则也不让你过
        if(arr1.length != arr2.length){
            return false;
        }
        //判断两个数组里面的数据是否一致
        for (int i = 0; i < arr1.length ; i++) {
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }

    /**
     * 拷贝数组
     * @param arr
     * @return
     */
    public final static int[] copyArr(int[] arr){
        if(null == arr){
            return null;
        }
        int[] a1 = new int[arr.length];
        for (int i = 0; i <a1.length ; i++) {
            a1[i] = arr[i];
        }
        return a1;
    }
}

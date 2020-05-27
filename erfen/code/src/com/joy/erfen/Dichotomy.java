package com.joy.erfen;

/**
 * 二分类
 */
public final class Dichotomy {
    private Dichotomy() {
    }


    public static final boolean dichotomy(int[] arr, int num) {
        if (null == arr) {
            System.out.println("dichotomy 数据有问题");
            return false;
        }
        //核心算法
        int L = 0;              //最左边
        int R = arr.length - 1; //最右边
        int mid = 0;            //中间的数值
        while (L < R) {
            mid = L + ((R - L) >> 1);
            //判断数据是否找到
            if (arr[mid] == num) {
                return true;
            } else if (arr[mid] > num) {
                //说明在左侧
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return arr[mid] == num;
    }
}

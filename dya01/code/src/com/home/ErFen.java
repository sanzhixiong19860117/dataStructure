package com.home;

import com.joy.sort.Glob;

import java.util.Arrays;

/**
 * @author joy
 * @date 2020/5/26
 */
public class ErFen {
    public static void main(String[] args) {
        int min = 10;
        int max = 20;
        int[] arr = Glob.createArray(min,max);
        Glob.systemSort(arr);
        System.out.println(Arrays.toString(arr));
        if(erfen(arr,10)){
            System.out.println("找到了");
        }else {
            System.out.println("没有找到对应的操作");
        }
    }

    private static boolean erfen(int[] sortedArr,int num){
        if (sortedArr == null || sortedArr.length == 0) {
            return false;
        }
        int L = 0;
        int R = sortedArr.length - 1;
        int mid = 0;
        while (L < R) {
            mid = L + ((R - L) >> 1); // mid = (L + R) / 2
            if (sortedArr[mid] == num) {
                return true;
            } else if (sortedArr[mid] > num) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return sortedArr[L] == num;
    }
}

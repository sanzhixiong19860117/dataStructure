package com.joy.sort;

import java.util.Arrays;

/**
 * @author joy
 * @date 2020/5/25
 */
public class SelectDemo {
    public static void main(String[] args) {
        //选择排序
        int[] arr = {1,3,55,2,99,33,22};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectSort(int[] a){
        if(null == a || a.length<2){
            System.out.println("数据出现错误");
            return;
        }

        //选择排序
        //0-n-1
        for (int i = 0; i < a.length -1 ; i++) {
            int min = i;//这里是最小的数为当前0
            for (int j = i+1; j <a.length ; j++) {
                //这个循环就是最小的i+1 到n这里的数据进行循环
                if(a[j]<a[min]){
                  //与最小数据进行对比,如果满足条件就把下表进行给予
                    min = j;
                }
            }
            //判断min和i是否相当
            if(min != i){
                //进行数据的替换
                int tmp = a[i];
                a[i] = a[min];
                a[min] = tmp;
            }
        }
    }
}

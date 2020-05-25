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

        //从第一张开始判断1-n
        for (int i = 1; i < arr.length; i++) {
            //斗地主的牌型比较
            if(arr[i]<arr[i-1]){
                tmp = arr[i];//记录当前的数据
                //这个操作是从小的这张排开始1移动到0的位置
                for (int j = i; j >0 ; j--) {
                    //如果前面的数据大于当前的数据就可以交换，如果不是的话就赋值
                    if(j>0 && arr[j-1]>tmp){
                        //交换两个数据
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

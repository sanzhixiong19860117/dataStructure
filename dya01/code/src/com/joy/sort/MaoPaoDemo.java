package com.joy.sort;

/**
 * @author joy
 * @date 2020/5/25
 */
public class MaoPaoDemo {
    public static void main(String[] args) {
        int[] arr = {3,2,4,5,99,7,9};
        maopao(arr);
        for (int i = 0; i <arr.length ; i++) {
            System.out.println(arr[i]);
        }
    }

    //冒泡排序函数
    private static void maopao(int[] arr){
        if(null == arr || arr.length<2){
            System.out.println("数据有错误");
            return;
        }
        for (int i = 0; i <arr.length ; i++) {
            for (int j = i+1; j <arr.length ; j++) {
                //交换数据
                if(arr[i]>arr[j]){
//                    int tmp = arr[i];
//                    arr[i] = arr[j];
//                    arr[j] = tmp;
                    arr[i] = arr[i]^arr[j];
                    arr[j] = arr[i]^arr[j];
                    arr[i] = arr[i]^arr[j];
                }
            }
        }
    }
}

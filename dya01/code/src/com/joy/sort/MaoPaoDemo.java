package com.joy.sort;

/**
 * @author joy
 * @date 2020/5/25
 */
public class MaoPaoDemo {
    public static void main(String[] args) {
        int min = 10;
        int max = 20;
        int time = 500000;
        int[] arr = {};
        int[] arr1 = {};
        boolean isRight = true;
        for (int i = 0; i < time ; i++) {
            arr = Glob.createArray(min,max);
            arr1 = Glob.cpArray(arr);
            maopao(arr);
            Glob.systemSort(arr1);
            if(!Glob.equer(arr,arr1)){
                isRight = false;
            }
        }
        if(isRight){
            System.out.println("is nice");
        }else{
            System.out.println("操作错误");
        }
    }

    //冒泡排序函数
    private static void maopao(int[] arr){
        if(null == arr){
            System.out.println("数据有错误");
            return;
        }
        for (int i = 0; i <arr.length ; i++) {
            for (int j = i+1; j <arr.length ; j++) {
                //交换数据
                if(arr[i]>arr[j]){
                    arr[i] = arr[i]^arr[j];
                    arr[j] = arr[i]^arr[j];
                    arr[i] = arr[i]^arr[j];
                }
            }
        }
    }
}

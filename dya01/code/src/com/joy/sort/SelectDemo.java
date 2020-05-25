package com.joy.sort;

/**
 * @author joy
 * @date 2020/5/25
 */
public class SelectDemo {
    public static void main(String[] args) {
        //选择排序
        int[] arr = {1,3,55,2,99,33,22};
        selectSort(arr);
        for (int i = 0; i <arr.length ; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void selectSort(int[] a){
        if(null == a || a.length<2){
            System.out.println("数据出现错误");
            return;
        }

        for (int i = 0; i <a.length-1; i++) {
            int min = i;
            for (int j = i+1; j <a.length ; j++) {
                if(a[j]<a[min]){
                    min = j;
                }
            }

            if(min != i){
                int tmp = a[i];
                a[i] = a[min];
                a[min] = tmp;
            }
        }
    }
}

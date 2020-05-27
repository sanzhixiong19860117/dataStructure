package com.joy.test;
import com.joy.glob.Glob;
public class Test {
    public static void main(String[] args) {
        int time = 500000;  //50w次的操作
        int max = 20;       //最大的数组长度
        int min = 20;       //最小的数据
        int[] arr1 = {};    //数组1
        int[] arr2 = {};    //数组2
        boolean isRight = true; //是否正确

        //第一步循环很多次的操作，对应的第2个部分
        for (int i = 0; i < time ; i++) {
            arr1 = Glob.createArray(max,min);   //给我们的数组随机大小和填充数字
            arr2 = Glob.copyArr(arr1);          //拷贝数组
            Glob.systemSort(arr2);              //对数组2进行系统排序
            insertSort(arr1);                   //调用我门自己的排序
            if(!Glob.equal(arr1,arr2)){
                isRight = false;
                break;
            }
        }

        if(isRight){
            System.out.println("is nice 相当的棒");
        }else{
            System.out.println("非常的糟糕，你有错误");
        }
    }

    /**
     * 选择排序
     * @param arr
     */
    private static void insertSort(int[] arr){
        if(null == arr){
            return;
        }

        for (int i = 0; i < arr.length ; i++) {
            int data = i;
            for (int j = i+1; j < arr.length ; j++) {
                if(arr[j]<arr[data]){
                    data = j;
                }
            }

            //交换操作
            int tmp = arr[i];
            arr[i] = arr[data];
            arr[data] = tmp;
        }
    }
}

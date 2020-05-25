

# 数据机构基础课程

## 评价算法的优劣的三个主要条件

1. 时间复杂度（程序的主要算法导致）
2. 常量复杂度（程序本身的复杂度）
3. 额外空间的复杂度（在函数有没有在进行申请额外的空间）

## 常量复杂度是什么？

就是不随着量级的增加，花费时间总是固定的这样的操作。

常用的有：

- 算数表达式（+，-，*，/，%）等
- 逻辑运算符（<,>,<<,>>,)
- ++，--
- 赋值等这些基本的操作

## 额外空间的复杂度是什么？

如果函数g

```java
private void g(int[] a){
  //如果这里面有重新分配的空间，我们就它额外的
  int[] b = a;
  //这里的b就是额外空间复杂度
}
```

## 时间复杂度的估算

本节内容还没有完全理解透彻，后面理解透彻在来补充

## 三个基本排序

1.冒泡排序

```java
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
      //核心点就是在
      //交换两个数位的位置，
        for (int i = 0; i <arr.length ; i++) {
            for (int j = i+1; j <arr.length ; j++) {
                //交换数据
                if(arr[i]>arr[j]){
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }
}
```

不用中间变量也可以进行数据交换操作

```java
arr[i] = arr[i]^arr[j];
arr[j] = arr[i]^arr[j];
arr[i] = arr[i]^arr[j];
```

2.选择排序

```java
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
				//注意：第一个循环是到0-n-1
        for (int i = 0; i <a.length-1; i++) {
            int min = i;
          //1-n-1开始循环
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
```

插入排序

```java
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
        //第一步循环操作最外层的数据
        for (int i = 1; i < arr.length ; i++) {
            //大的往后插入
            if(arr[i]<arr[i-1]){
                tmp = arr[i];
                for (int j = i; j > 0; j--) {
                    if(j>0 && arr[j-1]>tmp){
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
```
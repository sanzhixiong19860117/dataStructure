# 二分查找的基础

## 二分的一些常用的地方

- 在一个数组上面找到一个数是否存在（基础）
- 在一个有序数组中，找到某一个数最左侧的位置
- 在一个有序数组中，找到某个最后侧的位置
- 局部最小的问题

## 二分查找基础应用

1.二分查找的核心算法

```java
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
            mid = L + ((R - L) >> 1);//((R - L) >> 1) 括号不要忘记
            //判断数据是否找到
            if (arr[mid] == num) {
                return true;
            } else if (arr[mid] > num) {
                //说明在左侧
                R = mid - 1;
            } else {
              	//说明在右侧
                L = mid + 1;
            }
        }
        return arr[mid] == num;
    }
}

```

然后进行测试

```java
package com.joy.test;

import com.joy.erfen.Dichotomy;

import java.util.Arrays;
import java.util.Dictionary;

public class Test {
    public static void main(String[] args) {
        int[] a = {5, 2, 8, 10, 11};
        //第一步是有序
        Arrays.sort(a);
        System.out.println(Dichotomy.dichotomy(a,-1));
    }
}
```

## 题目：查找离数据最近的数

```java
package com.home;

import java.util.Arrays;

public class HomeWork3 {

    // 在arr上，找满足>=value的最左位置
    public static int nearestIndex(int[] arr, int value) {
        int L = 0;
        int R = arr.length - 1;
        int index = -1; // 记录最左的对号
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] >= value) {
                index = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return index;
    }

    // for test
    public static int test(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= value) {
                return i;
            }
        }
        return -1;
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        int[] arr = {};
        int value = 0;
        for (int i = 0; i < testTime; i++) {
            arr = generateRandomArray(maxSize, maxValue); //创建数组
            Arrays.sort(arr);
            value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            if (test(arr, value) != nearestIndex(arr, value)) {
                printArray(arr);
                System.out.println(value);
                System.out.println(test(arr, value));
                System.out.println(nearestIndex(arr, value));
                succeed = false;
                break;
            }
        }
        System.out.println("value="+value);
        System.out.println(test(arr, value));
        System.out.println(nearestIndex(arr, value));
        System.out.println(succeed ? "Nice!" + value +"==="+ Arrays.toString(arr): "Fucking fucked!");
    }
}
```
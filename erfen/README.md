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
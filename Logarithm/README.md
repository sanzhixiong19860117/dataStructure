

# 对数器

## 对数器的作用

作用：简单的来说，对我们写的一些算法进行一个验证结果这样的一个东西。

## 排序的对数器的设计

设计的步骤（我这里只是针对几个简单的排序进行的设计）

1. 随机创建数组的大小，并且给出随机的数据
2. 给出一个很巨大的循环次数
3. 使用系统的数组的排序功能给一个必然正确排序以后的数据
4. 然后使用我们创建的数组排序后和系统排序以后的数据进行对比，如果正确的话，我们的排序算法就一定是没有错的

## 给数组进行随机大小，给数组数据随机数值

```java
/**
 * 创建一个数组
 * @param arrMaxLen 数组的最大的长度
 * @param valueMin  数据的最小值
 * @return
 */
public final static int[] createArray(int arrMaxLen,int valueMin){
    if(arrMaxLen<0 || valueMin<0){
        System.out.println("创建数组有问题"+arrMaxLen+"==="+valueMin);
        return null;
    }
    //随机一个大小
    int ranValue = (int)Math.random()*(arrMaxLen+1);
    int[] arr = new int[ranValue];
    //下面是赋值
    for (int i = 0; i < arr.length ; i++) {
        int max = (int)(Math.random()*(arrMaxLen+1));
        int min = (int)(Math.random()*valueMin);
        arr[i] = max - min;
    }
    return arr;
}
```

下面写一个测试操作

```java
int[] arr = Glob.createArray(20,20);
System.out.println(Arrays.toString(arr));
```

```
[13, -2, 8, 5]
```

这一步我们就设计完成了

## 设计一个很大的数据进行循环操作

这个不是很难定义一个变量让他的测试的数字很大就完事，后面会再次提到这个。

## 使用系统的排序函数

```java
/**
 * 使用系统函数进行排序
 * @param arr
 */
public final static void systemSort(int[] arr){
    Arrays.sort(arr);
}
```

这个为我们以后两个数字进行对比有一个依据。

## 最后一步就是让系统排好的数据和我们写的排序进行对比

```java
/**
 * 进行对比操作
 * @param arr1
 * @param arr2
 * @return
 */
public final static boolean equal(int[] arr1,int[] arr2){
    //非法操作判断
    if(null == arr1 || null == arr2){
        return false;
    }
    //判断两个数组是否长度一致，否则也不让你过
    if(arr1.length != arr2.length){
        return false;
    }
    //判断两个数组里面的数据是否一致
    for (int i = 0; i < arr1.length ; i++) {
        if(arr1[i] != arr2[2]){
            return false;
        }
    }
    return true;
}
```

可以进行一个简单的测试以后在进行对数的测试。

```java
int[] n = {3,1,2,4};
insertSort(n);
System.out.println(Arrays.toString(n));
```

测试一个排序没有问题了，最后我们用对数器的方式来操作一下，代码如下，插入排序，冒泡排序都已经测试过了。

```java
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
```

希望这个能够帮到大家。
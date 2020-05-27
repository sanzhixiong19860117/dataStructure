# 异或

异或很简单的二进制运算，同性排斥，异性相吸

## 简单的操作

2^4:换算是二进制的操作

0010

0100

运算结果的：0110 = 6（十进制数）

## 题目1.交换两个变量的数据，不能用中间变量

```java
//交换两个数字不用中间变量
private static void demo1() {
    int a = 20;
    int b = 10;
    //使用异或操作
    a = a ^ b;//第一次的结果
    b = a ^ b;
    a = a ^ b;
    System.out.println("a = " + a + ",b = " + b);
}
```

## 题目2.找出一个数组中，出现的奇数次的一个数

```java
private static void demo2() {
    int[] a = {1, 1, 2, 2, 3, 3, 4, 4, 4};
    int emp = 0;
    for (int i = 0; i < a.length  ; i++) {
        emp^= a[i];
    }
    System.out.println("数据为="+emp);
}
```

这个解答是利用的刚才那个同性相斥，异性相吸的原则。

## 题目3.扩展提找出所有出现的偶数集合

```java
private static void findNum1(int[] arr){
    int erp = 0;//查找出是那个数字
    int index = 0;
    int erp1 = 0;
    int[] a = new int[arr.length];
    for (int i = 0; i < arr.length ; i++) {
        erp ^= arr[i];
    }
    for (int i = 0; i < arr.length ; i++) {
        erp1^=arr[i];
        if(erp != arr[i] && erp1==0){
            if(!isOpen(a,arr[i])){
                a[index] = arr[i];
                index++;
            }
        }
    }
    System.out.print(Arrays.toString(a));
}

private static Boolean isOpen(int[] arr,int num){
    for (int i = 0; i < arr.length ; i++) {
        if(arr[i] == num){
            return true;
        }
    }
    return false;
}
```
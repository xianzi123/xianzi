package com.park.test;

import org.apache.ibatis.reflection.ArrayUtil;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author hxy
 * @create 2024-4-28 18:31
 */
public class hxyf {

public static void main(String[] args) {
    //    现有5名候选人要竞选班长，每个人的编号分别为1、2、3、4、5。
    int[] arr = new int[6];
//    2.现有若干人为这5个候选人进行投票。循环接受每个人从键盘输入所投票的编号，若投票有效，则进行统计相应候选人的票数，若投票无效，则提示投票无效，并继续接受下一个投票，直到接受的投票为0号时，投票结束。
    for (;true;) {
        System.out.println("输入投票号");
        int num = new java.util.Scanner(System.in).nextInt();
        if (num == 0) {
            break;
        } else if (num > 0 && num < 6) {
            arr[num]++;
        } else {
            System.out.println("投票无效");
        }
    }
//    3.显示出每位候选人的得票数，并显示出最终哪位候选人当选了班长。
    for (int i=1 ;i<=5;i++){
        System.out.println("候选人"+i+"得票数"+arr[i]);
    }

   Arrays.sort(arr);
    System.out.println("最终候选人"+arr[5]+"当选班长");


}
}

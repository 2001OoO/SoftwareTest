package com.softwaretest;

public class test1 {
    public static void main(String[] args) {
        int x = 10;
        if (x < 0 || test(x)) {
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
    }

//    当i大于0时返回true,小于等于0时返回false
    public static boolean test(Integer i){
        System.out.println("进入test（）");
        if(i>0) return true;
        else return false;
    }
}

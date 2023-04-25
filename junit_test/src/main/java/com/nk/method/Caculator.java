package com.nk.method;

public class Caculator {
    private static Integer result;

    public void add(Integer a,Integer b){
        result = a + b;
    }

    public void reduce(Integer a,Integer b){
        result = a - b;
    }

    public void ride(Integer a,Integer b){
        result = a * b;
    }

    public void except(Integer a,Integer b){
        result = a / b;
    }

    public Integer GetResult(){
        return result;
    }
}

package com.seafooler.study;

public class Client {
    public static void main(String[] args) {
        /*Api api = Factory.createApi(2);
        api.test1("哈哈，不要紧张，只是个测试而已！");*/
        Api api = Factory.createApi();
        api.test1("哈哈，不要紧张，只是个测试而已！");
    }
}

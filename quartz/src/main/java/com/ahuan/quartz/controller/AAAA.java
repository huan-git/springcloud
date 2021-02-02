package com.ahuan.quartz.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @program: springcloud
 * @description: TODO this is the description of the AAAA class
 * @author: ahuan
 * @version: 2021-01-17 20:20
 **/
public class AAAA {
    public static void main(String[] args) {
        List list=new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            if("1".equals(next.toString())){
                iterator.remove();
                continue;
            }
            System.out.println(111);
        }
        System.out.println(list);
    }
}
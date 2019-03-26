package com.huawei.process;

import com.huawei.util.PropertiesLoader;

/**
 * @author rango
 * @date 2019/3/26 22:09
 */
public class Start {
    public static void main(String[] args) {
        PropertiesLoader pp = new PropertiesLoader("co.properties");
        String car = pp.getProperty("car");
        System.out.println(car);
    }
}

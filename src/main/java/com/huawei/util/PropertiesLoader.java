package com.huawei.util;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.InputStream;
import java.util.Properties;


/**
 * @author rango
 * @date 2019/3/26 22:03
 */

public class PropertiesLoader {

    private final static Logger LOG = Logger.getLogger(PropertiesLoader.class);
    public static Properties properties;
    private static String filePath = "/resource/";
    // 读取src下配置文件 在resource目录下--- 属于读取内部文件 注意："/" 必须有，是指根本下
//    properties.load(Config.class.getResourceAsStream("/init.properties"));
//    或者
//properties.load(this.getClass().getResourceAsStream("/init.properties"));


    public PropertiesLoader(String fileName) {
        InputStream in = null;
        //获取路径
        String path =  this.getClass().getResource("/co.properties").getPath();
        File file = new File(path);
        String abPath = file.getAbsolutePath();

        System.out.println("path="+path);
        System.out.println("abpath="+abPath);
        try {

            properties = new Properties();
            properties.load(PropertiesLoader.class.getResourceAsStream("/" + fileName));

        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("配置文件解析错误");
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    LOG.error("文件输入流解析错误");
                }
            }
        }

    }

    public String getProperty(String key) {
        String value = properties.getProperty(key);
        return value;
    }

}
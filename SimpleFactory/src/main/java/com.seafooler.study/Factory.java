package com.seafooler.study;

/*public class Factory {
    public static Api createApi(int type) {
        if (type == 1) {
            return new Impl1();
         } else if (type == 2) {
            return new Impl2();
        } else {
            return null;
        }
    }
}*/

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Factory {
    public static Api createApi() {
        Properties p = new Properties();
        InputStream in = null;
        try {
            in = Factory.class.getResourceAsStream("/FactoryTest.properties");
            p.load(in);
        } catch (Exception e) {
            System.out.println("装载工厂配置文件出错了，具体的堆栈信息如下所示：");
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Api api = null;

        try {
            api = (Api) Class.forName(p.getProperty("ImplClass")).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return api;
    }
}

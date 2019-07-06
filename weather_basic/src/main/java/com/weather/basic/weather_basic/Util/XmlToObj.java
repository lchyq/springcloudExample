package com.weather.basic.weather_basic.Util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/**
 * 将xml转换为obj的工具类
 */
public class XmlToObj {
    public static Object xmlToObjUtil(Class<?> clazz,String xmlString) throws JAXBException, IOException {
        //将string解析为二进制流
        Reader reader = new StringReader(xmlString);
        Object obj = null;
        //将xml解析为指定对象
        JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
        //创建解析xml的对象
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        obj = unmarshaller.unmarshal(reader);
        if(null != reader){
            reader.close();
        }
        return obj;
    }
}

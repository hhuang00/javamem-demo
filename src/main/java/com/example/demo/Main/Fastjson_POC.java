package com.example.demo.Main;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.sun.rowset.JdbcRowSetImpl;

public class Fastjson_POC {
    public static void main(String[] args){
//        User user = new User("1","lisi","123123","13212341234");
//        String json1 = JSON.toJSONString(user);
//        String json2 = JSON.toJSONString(user,SerializerFeature.WriteClassName);
//        System.out.println("序列化数据2："+json2);

        String json = "{\"@type\":\"com.example.demo.Main.User\",\"id\":\"1\",\"name\":\"lisi\",\"password\":\"123123\",\"phone\":\"13212341234\"}";
//        System.out.println(JSON.parse(json2));
        System.out.println(JSON.parseObject(json));
    }
}

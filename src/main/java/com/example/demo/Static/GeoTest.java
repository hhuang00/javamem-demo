package com.example.demo.Static;

public class GeoTest {
    static {
        try {
            Runtime.getRuntime().exec("touch /Users/admin/IdeaProjects/demo/success1.txt");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

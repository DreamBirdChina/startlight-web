package com.dreambird.Json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chen.jun on 2018/2/27.
 */
public class MyJson {

    public static void main(String[] args) throws JSONException {
        ParseJson("{\"name\":\"Alexia\",\"age\":\"23\"}");
        CreateJson();
    }

    //����JSON
    private static void ParseJson(String jsonString) throws JSONException
    {
        JSONObject jObject = new JSONObject(jsonString);
        System.out.println(jObject.get("name"));
    }

    //����һ��JSON
    private static void CreateJson() throws JSONException
    {
        // ���湹������map��һ��list��һ��Employee����
        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("name", "Alexia");
        map1.put("sex", "female");
        map1.put("age", "23");

        Map<String, String> map2 = new HashMap<String, String>();
        map2.put("name", "Edward");
        map2.put("sex", "male");
        map2.put("age", "24");

        // ��Mapת��ΪJSONArray����
        JSONArray jArray = new JSONArray();
        jArray.put(map1);
        jArray.put(map2);
        //����JSON
        JSONObject jObject=new JSONObject();
        jObject.put("List", jArray);
        jObject.put("Count","1200");

        System.out.println(jObject.toString());
    }

}

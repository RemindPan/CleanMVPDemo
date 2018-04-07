package com.example.data.utils;

import java.util.HashMap;

import javax.inject.Inject;

/**
 * Created by tinyfight on 2018/4/7.
 */

public class WeatherTownIDMapUtil {
    private static HashMap<String, String> townIDMap = new HashMap<>();

    static {
        townIDMap.put("beijing","CHBJ000000");
        townIDMap.put("shanghai","CHSH000000");
        townIDMap.put("tianjin","CHTJ000000");
        townIDMap.put("chongqing","CHCQ000000");
    }

    public static String getTownID(int code){
        switch (code){
            case 0x01:
                return townIDMap.get("beijing");
            case 0x02:
                return townIDMap.get("shanghai");
            case 0x03:
                return townIDMap.get("tianjin");
            case 0x04:
                return townIDMap.get("chongqing");
        }
        return "";
    }
}

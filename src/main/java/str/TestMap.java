/**
 * Alibaba.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package str;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 *
 * @author wenxiangqin
 * @version $Id: TestMap.java, v 0.1 2022-03-03 5:28 下午 wenxiangqin Exp $$
 */
public class TestMap {


    public static void main(String[] args) {
        Map<String, Map<String, String>> map = new HashMap<>();
        Map<String, String> visiblesMap = new HashMap<>();
        Map<String, String> localesMap = new HashMap<>();
        visiblesMap.put("agreementDetails.*.brandList", "true");
        visiblesMap.put("agreementDetails.*.categoryList", "true");
        visiblesMap.put("agreementDetails.*.saleShopList", "true");
        localesMap.put("categoryList", "一级类目");

        map.put("visibles", visiblesMap);
        map.put("locales", localesMap);

        String string = JSON.toJSONString(map);
        Map map1 = JSON.parseObject(string, Map.class);
        System.out.println(map1);
        System.out.println(string);
    }
}
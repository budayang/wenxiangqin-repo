package p1;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.List;

public class JsonTest {
    public static void main(String[] args) {
//        testJson1();
    }

    public static void testJson1() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("string", "string");
        jsonObject.put("int", 2);
        jsonObject.put("boolean", true);
        List<Integer> asList = Arrays.asList(1, 2, 3);
        jsonObject.put("list", asList);
        jsonObject.put("null", null);
        System.out.println(jsonObject);
    }

    public static void testJson2() {

    }
}

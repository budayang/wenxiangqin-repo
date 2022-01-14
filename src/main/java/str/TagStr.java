package str;

import java.util.HashMap;

public class TagStr {
    public static void main(String[] args) {
        String subString = "tag1||tag2||tag3";
        String[] tags = subString.split("\\|\\|");
        for (String tag : tags) {
            System.out.println(tag);
        }

        HashMap<String, String> stringStringHashMap = new HashMap<>();
        String value = stringStringHashMap.get("key");
    }
}

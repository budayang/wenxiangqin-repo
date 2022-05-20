/**
 * Alibaba.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author wenxiangqin
 * @version $Id: 无重复字符的最长子串.java, v 0.1 2022-05-19 3:19 下午 wenxiangqin Exp $$
 */
public class 无重复字符的最长子串 {

    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int max = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
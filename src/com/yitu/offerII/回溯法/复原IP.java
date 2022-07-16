package com.yitu.offerII.回溯法;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/0on3uN/
 */
public class 复原IP {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new LinkedList<>();
        helper(s, 0, 0, "", "", result);
        return result;
    }

    private void helper(String s, int i, int segI, String seg, String ip, List<String> result) {
        if (i == s.length() && segI == 3 && isValidSeg(seg)) {
            result.add(ip + seg);
        } else if (i < s.length() && segI <= 3) {
            char ch = s.charAt(i);
            if (isValidSeg(seg + ch)) {
                helper(s, i + 1, segI, seg + ch, ip, result);
            }

            if (seg.length() > 0 && segI < 3) {
                helper(s, i + 1, segI + 1, "" + ch, ip + seg + ".", result);
            }
        }
    }

    private boolean isValidSeg(String seg) {
        return Integer.parseInt(seg) <= 255
                && (seg.equals("0") || seg.charAt(0) != '0');
    }
}

// ref:https://leetcode.com/problems/word-break-ii/

import java.util.ArrayList;
import java.util.List;

public class lc140_hashtable {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(s, wordDict, res, sb, 0);
        return res;
    }
    public boolean isInD(String s, List<String> wordDict) {
        for (String str: wordDict) {
            if (str.equals(s)) return true;
        }
        return false;
    }
    public void dfs(String s, List<String> wordDict, List<String> res, StringBuilder sb, int idx) {
        if (idx == s.length()) {
            sb.deleteCharAt(sb.length() - 1);
            String st = new String(sb.toString());
            res.add(st);
            return;
        }


        for (int j = idx; j <= s.length(); j++) {
            String subStr = s.substring(idx,j);
            if (isInD(subStr, wordDict)) {
                int len = sb.length();
                for (char c: subStr.toCharArray()) {
                    sb.append(c);
                }
                sb.append(' ');
                dfs(s, wordDict, res, sb, j);
                sb.setLength(len);

            }
        }



    }
}

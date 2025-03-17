import java.util.*;

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<String>> dp = new HashMap<>();
        Set<String> wordSet = new HashSet<>(wordDict);
        return dfs(s, 0, wordSet, dp);
    }

    private List<String> dfs(String s, int start, Set<String> wordSet, Map<Integer, List<String>> dp) {
        if (dp.containsKey(start)) return dp.get(start);
        List<String> result = new ArrayList<>();
        if (start == s.length()) {
            result.add("");
            return result;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);
            if (wordSet.contains(word)) {
                List<String> sublist = dfs(s, end, wordSet, dp);
                for (String sub : sublist) {
                    result.add(word + (sub.isEmpty() ? "" : " ") + sub);
                }
            }
        }

        dp.put(start, result);
        return result;
    }
}

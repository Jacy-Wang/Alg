import java.util.HashMap;

public class LongestSubstringwithAtMostKDistinctCharacters {
    public static void main(String[] args) {
        LongestSubstringwithAtMostKDistinctCharacters ls = new LongestSubstringwithAtMostKDistinctCharacters();
        String s = "cedaecabccb";
        int k = 4;
        int res = ls.getMaxLength(s, k);
        System.out.println(res);
    }

    public int getMaxLength(String s, int k) {
        if (s.length() == 0 || k == 0)
            return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        map.put(s.charAt(0), 1);
        char c;
        int maxLen = 1;
        int cnt = 1;
        while (left <= right && right < s.length()) {
            while (map.size() <= k && right < s.length() - 1) {
                right++;
                c = s.charAt(right);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                    cnt++;
                } else {
                    if (map.size() < k) {
                        map.put(c, 1);
                        cnt++;
                    } else {
                        right--;
                        break;
                    }                    
                }
            }
            maxLen = Math.max(maxLen, cnt);
            if (right == s.length() - 1)
                break;
            while (map.size() == k) {
                c = s.charAt(left);
                int v = map.get(c);
                if (v == 1)
                    map.remove(c);
                else
                    map.put(c, v - 1);
                left++;
                cnt--;
            }            
        }
        return maxLen;
    }
}

import java.util.Arrays;
import java.util.HashMap;

public class LongestArithmeticProgression {
    public static void main(String[] args) {
        int[][] arr = new int[][]{new int[]{1, 4, 6, 7}, new int[]{0,1,2,3,5,10,15,20}, new int[]{0,1,2,5,8,16,24}, new int[]{1, 7, 10, 15, 27, 29}, new int[]{5, 10, 15, 20, 25, 30}, new int[]{1, 7, 10, 13, 14, 19}};

        for (int i = 0; i < arr.length; i++) {
            System.out.println(new LongestArithmeticProgression().getLongest(arr[i]));
        }
    }

    public int getLongest(int[] nums) {
        if (nums.length < 3)
            return nums.length;
        Arrays.sort(nums);
        HashMap<Integer, HashMap<Integer, Integer>> diff = new HashMap<>();
        int maxLen = 2;
        for (int i = 1; i < nums.length; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            if (i == 1) {
                map.put(nums[i] - nums[i - 1], 2);
                diff.put(i, map);
            } else {
                for (int j = i - 1; j >= 0; j--) {
                    int tmp = nums[i] - nums[j];
                    if (j == 0) {
                        map.put(tmp, 2);
                    } else {
                        HashMap<Integer, Integer> cur = diff.get(j);
                        if (cur.containsKey(tmp)) {
                            int l = cur.get(tmp) + 1;
                            map.put(tmp, l);
                            maxLen = Math.max(maxLen, l);
                        } else {
                            map.put(tmp, 2);
                        }
                    }
                }
                diff.put(i, map);
            }
        }
        return maxLen;
    }
}

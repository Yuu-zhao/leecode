import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindMinDifference {

    /**
     * 给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：timePoints = ["23:59","00:00"]
     * 输出：1
     * 示例 2：
     * <p>
     * 输入：timePoints = ["00:00","23:59","00:00"]
     * 输出：0
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-time-difference
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("23:59");
        list.add("23:54");
        list.add("23:51");
        findMinDifference(list);
    }

    public static int findMinDifference(List<String> timePoints) {
        if (timePoints.size() < 2) return 0;
        List<Integer> list = timePoints.stream().map(e -> {
            String[] split = e.split(":");
            return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
        }).sorted().collect(Collectors.toList());
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            min = Math.min(min,list.get(i)-list.get(i-1));
        }
        return Math.min(min,list.get(0)+1440-list.get(list.size()-1));
    }
    public int findMinDifference_(List<String> timePoints) {
        int[] arr = new int[timePoints.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(timePoints.get(i).substring(0, 2)) * 60 + Integer.parseInt(timePoints.get(i).substring(3));
        }
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i] - arr[i - 1]);
        }
        return Math.min(min, arr[0] + 1440 - arr[arr.length - 1]);
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// 2/18 leetcode sorting problem
// ref: https://leetcode.com/problems/merge-intervals/
public class lc56_mergeInterval {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) return 0;
                return a[0] - b[0];
            }
        });
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] cur_interval = intervals[i];
            if (i == 0) res.add(intervals[i]);
            int start = cur_interval[0];
            int end = cur_interval[1];
            if (start <= res.get(res.size() - 1)[1]) {
                res.get(res.size() - 1)[1] = Math.max(end, res.get(res.size() - 1)[1]);
            } else {
                res.add(cur_interval);
            }
        }
        int[][] ans = new int[res.size()][2];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        lc56_mergeInterval sol = new lc56_mergeInterval();
        int[][] input = {{1,2}, {2,3}, {4,6}};
        for (int[] arr : sol.merge(input)) {
            for (int i: arr) {
                System.out.println(i);
            }
            System.out.println('\n');
        }

    }
}

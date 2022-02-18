import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//ref: https://leetcode.com/problems/meeting-rooms-ii/
public class lc253_meetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) return 0;
                return a[0] - b[0];
            }
        });

        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>(new Comparator<>(){
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1] == b[1]) return 0;
                return a[1] - b[1];
            }
        });


        for (int[] interval: intervals) {
            if (!minHeap.isEmpty() && interval[0] >= minHeap.peek()[1]) {
                minHeap.poll();
            }
            minHeap.offer(interval);
        }
        return minHeap.size();
    }

    public static void main(String[] args) {
        lc253_meetingRoomsII sol = new lc253_meetingRoomsII();
        System.out.println(sol.minMeetingRooms(new int[][]{{0, 30},{5, 10},{15, 20}}));
    }
}

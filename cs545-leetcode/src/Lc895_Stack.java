// ref: https://leetcode.com/problems/maximum-frequency-stack/
// difficulty: hard
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Lc895_Stack {
    Map<Integer, Integer> freq;
    Map<Integer, Deque<Integer>> group;
    int maxFreq;
    public Lc895_Stack() {
        maxFreq = 0;
        group = new HashMap<>();
        freq = new HashMap<>();
    }

    public void push(int val) {
        if (!freq.containsKey(val)) {
            freq.put(val, 1);
        } else {
            freq.put(val, freq.get(val) + 1);
        }
        maxFreq = Math.max(maxFreq, freq.get(val));
        int frequency = freq.get(val);

        if (!group.containsKey(frequency)) {
            group.put(frequency, new ArrayDeque<Integer>());
            group.get(frequency).offerLast(val);
        } else {
            group.get(frequency).offerLast(val);
        }

    }

    public int pop() {
        int val = group.get(maxFreq).pollLast();
        freq.put(val, freq.get(val) - 1);
        if (group.get(maxFreq) == null || group.get(maxFreq).isEmpty()) {
            maxFreq -= 1;
        }
        return val;

    }
}

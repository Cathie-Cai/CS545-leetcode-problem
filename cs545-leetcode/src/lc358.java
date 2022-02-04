// leetcode reference: https://leetcode.com/problems/rearrange-string-k-distance-apart/

import java.util.*;

public class lc358 {
    public class Pair<Character, Integer> {
        Character key;
        Integer val;
        public Pair (Character key, Integer val) {
            this.key = key;
            this.val = val;
        }
        public Character getKey(){
            return this.key;
        }
        public Integer getValue() {
            return this.val;
        }
    }
    public String rearrangeString(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }

        PriorityQueue<Pair<Character, Integer>> maxHeap = new PriorityQueue<>(new Comparator<Pair<Character, Integer>>(){
            @Override
            public int compare(Pair<Character, Integer> p1, Pair<Character, Integer> p2) {
                if (p1.getValue() > p2.getValue()) {
                    return -1;
                } else if (p1.getValue() < p2.getValue()) {
                    return 1;
                } else {
                    return p1.getKey() - p2.getKey();
                }
            }
        });

        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            maxHeap.offer(new Pair(entry.getKey(), entry.getValue()));
        }

        StringBuilder res = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            if (k == 0) {
                return s;
            }
            if (maxHeap.size() < k && maxHeap.peek().getValue() > 1) {
                return new String();
            }
            int n = Math.min(k, maxHeap.size());
            List<Pair<Character, Integer>> tmp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                res.append(maxHeap.peek().getKey());
                tmp.add(maxHeap.peek());
                maxHeap.poll();
            }
            for (int i = 0; i < tmp.size(); i++) {
                if (tmp.get(i).getValue() > 1) {
                    maxHeap.offer(new Pair(tmp.get(i).getKey(), tmp.get(i).getValue() - 1));
                }
            }
        }
        return new String(res);
    }

    public static void main(String[] args) {
        lc358 sol = new lc358();
        System.out.println(sol.rearrangeString("aabbcc", 3));
    }
}

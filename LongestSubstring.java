import java.util.Queue;
import java.util.Stack;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        Queue<Character> queue = new java.util.LinkedList<>();
        for (char c : s.toCharArray()) {
            if (queue.contains(c)) {
                while (queue.peek() != c) {
                    queue.poll();
                }
                queue.poll(); // Remove the duplicate character
            }
            queue.offer(c);
            maxLength = Math.max(maxLength, queue.size());
        }
        return maxLength;
    }
}

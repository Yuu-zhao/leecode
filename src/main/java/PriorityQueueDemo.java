import java.util.*;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(insertSort().toArray()));
    }

    private static List<Integer> insertSort() {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new PriorityQueue<Integer>(7);
        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            queue.add(random.nextInt(100));
        }
        for (int i = 0; i < queue.size(); i++) {
            list.add(queue.poll());
        }
        return list;
    }
}

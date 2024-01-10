package problems.t872;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution2 {

    private final Object lock = new Object();

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(4);
        System.out.println(new Solution2().leafSimilar(root1, root2));
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        try {
            List<Integer> sequence1 = Collections.synchronizedList(new ArrayList<>());
            List<Integer> sequence2 = Collections.synchronizedList(new ArrayList<>());
            Thread thread1 = new Thread(() -> handleNode(root1, sequence1));
            thread1.start();
            Thread thread2 = new Thread(() -> handleNode(root2, sequence2));
            thread2.start();
            int i = 0;
            while (thread1.isAlive() || thread2.isAlive() || sequence1.size() > i) {
                synchronized (lock) {
                    lock.wait();
                }
                while (sequence1.size() > i && sequence2.size() > i) {
                    if (!sequence1.get(i).equals(sequence2.get(i))) {
                        return false;
                    }
                    i++;
                }
                if (!thread1.isAlive() && !thread2.isAlive() && sequence1.size() != sequence2.size()) {
                    return false;
                }
            }
            return true;
        } catch (InterruptedException e) {
            return false;
        }
    }

    private void handleNode(TreeNode node, List<Integer> sequence) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            sequence.add(node.val);
            synchronized (lock) {
                lock.notify();
            }
        } else {
            handleNode(node.left, sequence);
            handleNode(node.right, sequence);
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}



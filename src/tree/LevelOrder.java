package tree;

import java.util.*;

/**
 * @Description
 * @Author CP
 * @Date 2020/11/27
 */
public class LevelOrder {
    private final List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        root.left = node2;
        root.right = node3;
        node2.right = node4;
        node3.right = node5;
        LevelOrder levelOrder = new LevelOrder();
        System.out.println(levelOrder.leverOrderDfs2(root));
    }

    public List<List<Integer>> leverOrderDfs(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (res.size() == level) {
            res.add(new ArrayList<Integer>());
        }
        res.get(level).add(root.val);
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }

    public List<List<Integer>> leverOrderDfs2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Deque<TreeNode> nodeStack = new ArrayDeque<>();
        Deque<Integer> depthStack = new ArrayDeque<>();
        nodeStack.addLast(root);
        depthStack.addLast(0);

        List<List<Integer>> res = new ArrayList<>();
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pollLast();
            int depth = depthStack.pollLast();
            if (res.size() == depth) {
                res.add(depth, new ArrayList<>());
            }
            res.get(depth).add(node.val);
            if (node.right != null) {
                nodeStack.addLast(node.right);
                depthStack.addLast(depth + 1);
            }
            if (node.left != null) {
                nodeStack.addLast(node.left);
                depthStack.addLast(depth + 1);
            }
        }
        return res;
    }

    public List<Integer> leverOrderBfs(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return res;
    }

}

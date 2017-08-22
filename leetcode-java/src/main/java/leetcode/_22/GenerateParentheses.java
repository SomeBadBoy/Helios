package leetcode._22;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 生成一个树，遍历所有的叶子节点，即可
 *
 * @author wenqi.wei created on 2017/7/28
 * @version 1.0
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        if (n == 0) return Collections.emptyList();
        if (n == 1) return Collections.singletonList("()");
        List<String> res = new LinkedList<>();
        Node root = new Node(1, 0, "(");
        treeify(root, n);
        search(root, res);
        return res;
    }

    void search(Node node, List<String> res) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            res.add(node.str);
            return;
        }
        search(node.left, res);
        search(node.right, res);
    }

    void treeify(Node parent, int max) {
        if (parent == null) return;
        if (parent.lc >= max && parent.rc >= max) return;
        if (parent.lc < max) {
            parent.left = new Node(parent.lc + 1, parent.rc, parent.str + "(");
            treeify(parent.left, max);
        }
        if (parent.rc < max && parent.rc < parent.lc) {
            parent.right = new Node(parent.lc, parent.rc + 1, parent.str + ")");
            treeify(parent.right, max);
        }
    }

    class Node {
        public int lc;
        public int rc;
        String str;
        Node left;
        Node right;

        public Node() {
        }

        public Node(int lc, int rc, String str) {
            this.lc = lc;
            this.rc = rc;
            this.str = str;
        }
    }
}

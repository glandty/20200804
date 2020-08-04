class Node {
    public int val;
    public Node left;
    public Node right;

    public Node(int val) {
        this.val = val;
    }
}
public class TestTree {
    //lca 表示最近公共祖先
    private Node lca = null;
    //求最近公共祖先
    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        if(root == null) {
            return  null;
        }
        findNode(root, p, q);
        return lca;
    }
    private boolean findNode(Node root, Node p, Node q) {
        if(root == null) {
            return false;
        }
        int left = findNode(root.left, p , q) ? 1 : 0;
        int right = findNode(root.right, p, q) ? 1 : 0;
        int mid = (root == p || root == q) ? 1 : 0;
        if(left + right + mid == 2) {
            lca = root;
        }
        return (left + right + mid) > 0;
    }

    //二叉搜索树构建排序的双向链表
    public Node Convert(Node pRootOfTree) {
      if(pRootOfTree == null) {
        return null;
      }
       if(pRootOfTree.left == null && pRootOfTree.right == null) {
        return pRootOfTree;
       }
       Node left = Convert(pRootOfTree.left);
       Node leftTail = left;
       while(leftTail != null && leftTail.right != null) {
           leftTail = leftTail.right;
       }
       if(left != null) {
           leftTail.right = pRootOfTree;
           pRootOfTree.left = leftTail;
       }
       Node right = Convert(pRootOfTree.right);
       if(right != null) {
           right.left = pRootOfTree;
           pRootOfTree.right = right;
       }
       return left == null ? pRootOfTree : left;
    }

    //给定先序\中序求树
    private int index;
    public Node buildTree(int[] preorder, int[] inorder) {
        index = 0;
        return  buildTreeHelp(preorder, inorder, 0,inorder.length);
    }

    private Node buildTreeHelp(int[] preorder, int[] inorder, int left, int right) {
        if(left >= right) {
            return null;
        }
        if(index >= preorder.length) {
            return null;
        }
        Node root =new Node(preorder[index]);
        index++;
        int pos = find(inorder, left, right, root.val);
        root.left = buildTreeHelp(preorder, inorder, left, pos);
        root.right = buildTreeHelp(preorder, inorder, pos+1, right);
        return root;
    }

    private int find(int[] inorder, int left, int right, int toFind) {
        for (int i = left; i < right; i++) {
            if(inorder[i] == toFind) {
                return i;
            }
        }
        return -1;
    }
}

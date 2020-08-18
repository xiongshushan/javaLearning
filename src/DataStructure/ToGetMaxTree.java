package DataStructure;

import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author xiong
 * @ClassName ToGetMaxTree
 * @description Construct the MaxTree for element non-repeatable array
 * @description Time complexity:O(n)    Space complexity:O(n)
 * @create 2020-08-19 4:22
 * @Version 1.0
 */
public class ToGetMaxTree {
    public static void main(String[] args) {
        int[] arr = new int[]{5,4,15,2,13,35,12,6,22,18};
        TreeNode maxTree = getMaxTree(arr);
        System.out.println("链表父节点为：" + maxTree.value);
    }

    public static TreeNode getMaxTree(int[] arr){
        TreeNode[] nArr = new TreeNode[arr.length];
        for (int i = 0; i != arr.length; i++){
            nArr[i] = new TreeNode(arr[i]);
        }

        Stack<TreeNode> stack = new Stack<>();
        HashMap<TreeNode, TreeNode> lBigMap = new HashMap<>();
        HashMap<TreeNode, TreeNode> rBigMap = new HashMap<>();

        for (int i = 0; i != nArr.length; i++){
            TreeNode curTreeNode = nArr[i];
            while ((!stack.isEmpty()) && stack.peek().value < curTreeNode.value){
                popStackSetMap(stack,lBigMap);
            }
            stack.push(curTreeNode);
        }
        while (!stack.isEmpty()){
            popStackSetMap(stack,lBigMap);
        }

        for (int i = nArr.length - 1; i != -1; i--){
            TreeNode curNode = nArr[i];
            while ((!stack.isEmpty()) && stack.peek().value < curNode.value){
                popStackSetMap(stack,rBigMap);
            }
            stack.push(curNode);
        }
        while (!stack.isEmpty()){
            popStackSetMap(stack,rBigMap);
        }

        TreeNode head = null;
        for (int i = 0; i != nArr.length; i++){
            TreeNode curNode = nArr[i];
            TreeNode left = lBigMap.get(curNode);
            TreeNode right = rBigMap.get(curNode);

            if (left == null && right == null){
                head = curNode;
            }else if (left == null){
                if (right.left == null){
                    right.left = curNode;
                }else {
                    right.right = curNode;
                }
            }else if (right == null){
                if (left.left == null){
                    left.left = curNode;
                }else {
                    left.right =curNode;
                }
            }else {
                TreeNode parent = left.value < right.value ? left:right;
                if (parent.left == null){
                    parent.left = curNode;
                }else {
                    parent.right = curNode;
                }
            }
        }
        return head;
    }

    public static void popStackSetMap(Stack<TreeNode> stack, HashMap<TreeNode, TreeNode> map){
        TreeNode popTreeNode = stack.pop();
        if (stack.isEmpty()){
            map.put(popTreeNode,null);
        }else {
            map.put(popTreeNode,stack.peek());
        }
    }

}

//The description of TreeNode  just like the binary tree
class TreeNode{
    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int data){
        this.value = data;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
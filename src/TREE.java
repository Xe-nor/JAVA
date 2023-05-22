import java.util.LinkedList;
import java.util.Queue;

public class TREE {
        public static class Node{
            int data;
            Node left;
            Node right;
            Node(int data){
                this.data=data;
                left =null;
                right=null;
            }
        }
        public  static class BinaryTree{
            static int index = -1;
            public static Node buildTree(int nodes[]){
                index++;
                if (nodes[index] == -1){
                    return null;
                }
                Node newNode = new Node(nodes[index]);
                newNode.left = buildTree(nodes);
                newNode.right = buildTree(nodes);
                return newNode;
            }
            public static void preorder(Node root) {
                if(root == null) {
                    System.out.print(-1+" ");
                    return;
                }
                System.out.print(root.data+" ");
                preorder(root.left);
                preorder(root.right);
            }

            public static void inorder(Node root) {
                if(root == null) {
                    System.out.print(-1+" ");
                    return;
                }
                inorder(root.left);
                System.out.print(root.data+" ");
                inorder(root.right);
            }

            public static void postorder(Node root) {
                if(root == null) {
                    System.out.print(-1+" ");
                    return;
                }
                postorder(root.left);
                postorder(root.right);
                System.out.print(root.data+" ");
            }

            public static void levelOrder(Node root) {
                if(root == null) {
                    return;
                }
                Queue<Node> q = new LinkedList<>();
                q.add(root);
                q.add(null);
                while(!q.isEmpty()) {
                    Node curr = q.remove();
                    if(curr == null) {
                        System.out.println();
                        //queue empty
                        if(q.isEmpty()) {
                            break;
                        } else {
                            q.add(null);
                        }
                    } else {
                        System.out.print(curr.data+" ");
                        if(curr.left != null) {
                            q.add(curr.left);
                        }
                        if(curr.right != null) {
                            q.add(curr.right);
                        }
                    }
                }
            }

        }

    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();

        Node root = tree.buildTree(nodes);
        tree.levelOrder(root);
//        System.out.println(root.data);
    }
}

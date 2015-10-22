/**
 * 
 * @author Patrik
 *
 */
public class TreeNode {
	private int data; 
	private TreeNode left;
	private TreeNode right;
	
	/**
	 * 
	 * @param data
	 */
	public TreeNode(int data){
		this.data = data;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getData() {
		return data;
	}

	/**
	 * 
	 * @param data
	 */
	public void setData(int data) {
		this.data = data;
	}

	/**
	 * 
	 * @return
	 */
	public TreeNode getLeft() {
		return left;
	}

	/**
	 * 
	 * @param left
	 */
	public void setLeft(TreeNode left) {
		this.left = left;
	}

	/**
	 * 
	 * @return
	 */
	public TreeNode getRight() {
		return right;
	}

	/**
	 * 
	 * @param right
	 */
	public void setRight(TreeNode right) {
		this.right = right;
	}
	
	public void printTree() {
        if (this.right != null) {
            right.printTree(true, "");
        }
        printNodeValue();
        if (left != null) {
            left.printTree(false, "");
        }
    }

	private void printTree(boolean isRight, String indent) {
	    if (right != null) {
	        right.printTree(true, indent + (isRight ? "        " : " |      "));
	    }
	    System.out.print(indent);
	    if (isRight) {
	        System.out.print(" /");
	    } else {
	        System.out.print(" \\");
	    }
	    System.out.print("----- ");
	    printNodeValue();
	    if (left != null) {
	        left.printTree(false, indent + (isRight ? " |      " : "        "));
	    }
	}
	
	private void printNodeValue() {
	    System.out.print(data);
	    System.out.print('\n');
	}
	
}

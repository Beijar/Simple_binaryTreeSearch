/**
 * Class som representerar en nod i ett bin�rt s�ktr�d
 * @author Patrik
 *
 */
public class TreeNode {
	private int data; 
	private TreeNode left;
	private TreeNode right;
	
	/**
	 * Init. av v�rdet f�r noden
	 * @param data
	 */
	public TreeNode(int data){
		this.data = data;
	}
	
	/**
	 * 
	 * @return nodens v�rde
	 */
	public int getData() {
		return data;
	}

	/**
	 * 
	 * @param data s�tter nodens v�rde
	 */
	public void setData(int data) {
		this.data = data;
	}

	/**
	 * 
	 * @return returnerar v�nster child nod
	 */
	public TreeNode getLeft() {
		return left;
	}

	/**
	 * 
	 * @param left �ndrar v�nster child nod
	 */
	public void setLeft(TreeNode left) {
		this.left = left;
	}

	/**
	 * 
	 * @return returnerar h�ger child nod
	 */
	public TreeNode getRight() {
		return right;
	}

	/**
	 * 
	 * @param right �ndrar h�ger child nod
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

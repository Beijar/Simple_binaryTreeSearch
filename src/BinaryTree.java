/**
 * 
 * @author Patrik
 *
 */
public class BinaryTree {
	private TreeNode root;
	private int size;
	
	public void add(int data){
		TreeNode newNode = new TreeNode(data);
		if(root == null){
			root = newNode;
			return;
		}
		else{
			insert(root, newNode); //maybe
		}
	}
	
	public TreeNode insert(TreeNode current, TreeNode newNode){
		TreeNode currentNode = current;
		
		if(currentNode != null){
			if(currentNode.getData() != newNode.getData()) {
				if(currentNode.getData() > newNode.getData()) {
					TreeNode left = insert(currentNode.getLeft(), newNode);
					if(left != null) {
						currentNode.setLeft(left);
					}
				}
				else{
					TreeNode right = insert(currentNode.getRight(), newNode);
					if(right != null) {
						currentNode.setRight(right);
					}
				}
			}
			else{
				throw new IllegalArgumentException("Värdet existerar redan i trädet.");
			}
		}
		else {
			currentNode = newNode;
			return currentNode;
		}
		return null;
	}
	
	public void delete(int data){
		
	}
	
	public TreeNode find(TreeNode current, int dataToFind){
		return null;
	}
	
	private void inOrder(TreeNode current){
	
	}
	
	private TreeNode remove(TreeNode current, int dataToRemove){
		return null;
	}
	
	private TreeNode findSuccessor(TreeNode current){
		return null;
	}
	
	public TreeNode getRoot() {
		return root;
	}
	
	
}

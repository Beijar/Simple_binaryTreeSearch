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
				throw new IllegalArgumentException("VŠrdet existerar redan i trŠdet.");
			}
		}
		else {
			currentNode = newNode;
			return currentNode;
		}
		return null;
	}
	
	public TreeNode find(TreeNode current, int dataToFind){
		TreeNode currentNode = current;
		int data = dataToFind;
		TreeNode result = null;
		
		if(currentNode != null) {
			if(currentNode.getData() == data){
				result = currentNode;
			}
			else if(currentNode.getData() > data) {
				result = find(currentNode.getLeft(), data);
			}
			else{
				result = find(currentNode.getRight(), data);
			}
		}
		return result;
	}
	
	private void inOrder(TreeNode current){
		
	}
	
	public void delete(int data){
		TreeNode newTree = remove(root, data);
		if(newTree != null){
			root = newTree;
		}
	}
	
	private TreeNode remove(TreeNode current, int dataToRemove){
		int data = dataToRemove;
		TreeNode result = null;
		
		System.out.println("Finding node to remove...");
		
		if(current != null) {
			if(current.getData() == data) {
				System.out.println("Found node!");
					TreeNode successor = findSuccessor(current);
					current.setData(successor.getData());
			}
			else if(current.getData() > data) {
					remove(current.getLeft(), data);
			}
			else{
					remove(current.getRight(), data);
			}
		}
		return current;
	}
	
	private TreeNode findSuccessor(TreeNode current){
		System.out.println("Finding successor...");
		TreeNode result = null;
		if(current.getRight() != null) {
			TreeNode successor = current.getRight();
			TreeNode parent = current;
			
			while(successor.getLeft() != null) {
				parent = successor;
				successor = successor.getLeft();
			}
			
			result = successor;
			//current.setData(successor.getData());
			
			if(successor.getRight() != null) {
				successor = successor.getRight();
			}
			else {
				parent.setLeft(null);
				successor = null;
			}
		}
		else if(current.getLeft() != null) {
			result = current.getLeft();
		}

		System.out.println("Successor moved!");
		return result;
	}
	
	public TreeNode getRoot() {
		return root;
	}
	
	
}

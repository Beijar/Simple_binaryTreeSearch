
public class Visualization {
	public static void main(String[] args){
		BinaryTree tree = new BinaryTree();
		tree.add(5);
		tree.add(3);
		tree.add(4);
		tree.add(8);
		tree.add(11);
		tree.add(0);
		tree.add(12);
		tree.add(7);
		tree.add(6);
		tree.add(10);
		tree.add(9);
		tree.add(13);
		tree.add(14);
		tree.add(2);
		tree.add(1);
		
		tree.getRoot().printTree();
		
		tree.delete(12);
		
		tree.getRoot().printTree();
		
		
		//TreeNode findResult = tree.find(tree.getRoot(), 0);
		
		//System.out.println(findResult.getData());
		
	}
}

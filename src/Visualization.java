
public class Visualization {
	public static void main(String[] args){
		BinaryTree tree = new BinaryTree();
		tree.add(5);
		tree.add(3);
		tree.add(4);
		tree.add(7);
		tree.add(8);
		tree.add(0);
		tree.add(9);

		tree.getRoot().printTree();
		
		
	}
}

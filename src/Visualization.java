
public class Visualization {
	public static void main(String[] args){
		//Initierar träd
		BinaryTree tree = new BinaryTree();
		//Insättning av diverse värden
		tree.add(60);
		tree.add(30);
		tree.add(20);
		tree.add(40);
		tree.add(10);
		tree.add(50);
		tree.add(90);
		tree.add(80);
		tree.add(70);
		tree.add(100);
		tree.add(120);
		tree.add(35);
		tree.add(37);

		
		//första print efter insättning
		tree.getRoot().printTree();
		
		//bortagning av nod
		System.out.println("Deleting node...");
		tree.delete(30);
		
		//print efter borttagning
		tree.getRoot().printTree();
		
		System.out.println("Printing tree values in order...");
		tree.inOrder(tree.getRoot());
		
		TreeNode findResult = tree.find(tree.getRoot(), 10);
		System.out.println("\n");
		System.out.println("find result: " + findResult.getData());
		
	}
}

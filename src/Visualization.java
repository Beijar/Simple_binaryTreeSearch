
public class Visualization {
	public static void main(String[] args){
		//Initierar träd
		BinaryTree tree = new BinaryTree();
		//Insättning av diverse värden
		tree.add(15); tree.add(5); tree.add(3); tree.add(4); tree.add(6); tree.add(61);
		tree.add(62); tree.add(63); tree.add(25); tree.add(26); tree.add(10); tree.add(8);
		tree.add(14); tree.add(12); tree.add(11); tree.add(13); tree.add(2); tree.add(3);
		tree.add(1); tree.add(99); tree.add(101); tree.add(100);
		
		tree.getRoot().printTree();
		System.out.println("\n-----------------------------------\n");
		
		tree.delete(10); 
		tree.delete(99); 
		tree.delete(15);
		tree.delete(100); 
		tree.delete(13);
		tree.delete(6);
		tree.delete(3); 
		tree.delete(1);	
		tree.delete(2);	
		tree.delete(61);
		tree.delete(62);
		tree.delete(63); 
		
		tree.getRoot().printTree();
		System.out.println("\n-----------------------------------\n");
		
		tree.inOrder(tree.getRoot());
		
	}
}

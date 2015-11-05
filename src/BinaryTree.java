/**
 * 
 * @author Patrik
 * Represenation av ett binärt sökträd med stöd för instättning, uppsökning, borttagning 
 * och uppräkning av noder och värden. 
 * 
 */
public class BinaryTree {
	private TreeNode root;
	//TODO: WHAT TO DO WITH SIZE??????
	private int size; 
	
	/**
	 * Insättning av värde till trädet. Skapar en nod utifrån värdet på inparametern
	 * och använder sig av hjälpmetoden insert för att placera nya noden i trädet.
	 * @param data, värdet på den nya noden i trädet
	 */
	public void add(int data){
		TreeNode newNode = new TreeNode(data);
		if(root == null){
			root = newNode;
			return;
		}
		else{
			root = insert(root, newNode);
		}
	}
	
	/**
	 * Metod som jämför den nya nodens värden med existerande (mindre/högre jämförelse av nodvärde)
	 *  för att finna plats som den ska sparas på
	 * @param current Startnoden för sökningen av vart den nya noden ska placeras.
	 * @param newNode Den nya noden som ska placeras i sökträdet
	 * @return returnerar det nya (modifierade) trädet.
	 */
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
			size++;
			return currentNode;
		}
		return currentNode;
	}
	
	/**
	 * Sökmetod som letar upp en nod i trädet utifrån dess värde. 
	 * @param current Startnoden för sökningen av nod med specifikt värde.
	 * @param dataToFind Värdet för noden man söker efter
	 * @return returnerar den sökta noden om den existerar i trädet, annars null. 
	 */
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
	
	/**
	 * Tar emot värdet för noden som ska tas bort ur trädet. 
	 * Kallar på hjälpmetoden remove för borttagning och omstrukturering av trädet
	 * samt sätter det nya (modifierade) trädet som remove returnerar till root.
	 * @param data värdet för noden som ska tas bort.
	 */
	public void delete(int data){
		TreeNode newTree = remove(root, data);
		if(newTree != null){
			root = newTree;
		}
	}
	
	/**
	 * Metoden letar upp önskad nod att ta bort utifrån nodvärde. Om den finner med match
	 * mellan indata värde och ett nodvärde ur trädet kallar den på findSuccessor för att hitta en efterföljare
	 * till noden som tas bort.
	 * @param current, startnoden för sökning 
	 * @param dataToRemove, nodvärdet för noden som skall tas bort
	 * @return returnerar det nya (modifierade trädet) 
	 */
	private TreeNode remove(TreeNode current, int dataToRemove){
		int data = dataToRemove;
		
		if(current != null) {
			if(current.getData() == data) {
					TreeNode successor = findSuccessor(current);
					size--;
					if(successor != null) {
						current.setData(successor.getData());
					}
					else {
						current = null;
					}
			}
			else if(current.getData() > data) {
					current.setLeft(remove(current.getLeft(), data));
			}
			else{
					current.setRight(remove(current.getRight(), data));
			}
		}
		return current;
	}
	
	/**
	 * Letar upp efterföljare till en vald nod som skall tas bort. 
	 * Efterföljaren letar den först upp i högra barnets vänstraste nod.
	 * Om det endast finns högerbarn väljs den första ut som efterföljare.
	 * Om ett högerbarn ej finns så blir förälder till borttagna noden efterföljare.
	 * @param current Noden som behöver ersättas med en efterföljare
	 * @return returnerar det nya subträdet. 
	 */
	private TreeNode findSuccessor(TreeNode current){
		TreeNode result = null;
		TreeNode parent = current;
		if(current.getRight() != null) {
			TreeNode successor = current.getRight();
			int level = 0;
			
			while(successor.getLeft() != null) {
				parent = successor;
				successor = successor.getLeft();
				level++;
			}
			
			if(successor.getRight() != null) {
				if(level < 0) {
					parent.setRight(successor.getRight());
				} 
				else {
					parent.setLeft(successor.getRight());
				}
			}
			else if(level > 0) {
				parent.setLeft(null);
			}
			else {
				parent.setRight(null);
			}
			
			result = successor;
		}
		else if(current.getLeft() != null) {
			TreeNode successor = current.getLeft();
			
			current.setData(successor.getData());
			current.setLeft(successor.getLeft());
			current.setRight(successor.getRight());
			
			result = current;
		}
		return result;
	}
	
	/**
	 * 
	 * @return Returnerar root noden.
	 */
	public TreeNode getRoot() {
		return root;
	}
	
	/**
	 * Letar upp noder i storleksordning samt printar ut dem i konsolen.
	 * @param current startnoden för uppletning och utprint.
	 */
	public void inOrder(TreeNode current){
		if (current == null) {
			return;
		}
		else{
			inOrder(current.getLeft());
			System.out.print(current.getData() + " ");
			inOrder(current.getRight());
		}
	}
	
}

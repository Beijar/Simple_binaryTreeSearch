/**
 * 
 * @author Patrik
 * Represenation av ett binŠrt sšktrŠd med stšd fšr instŠttning, uppsškning, borttagning 
 * och upprŠkning av noder och vŠrden. 
 * 
 */
public class BinaryTree {
	private TreeNode root;
	//TODO: WHAT TO DO WITH SIZE??????
	private int size; 
	
	/**
	 * InsŠttning av vŠrde till trŠdet. Skapar en nod utifrŒn vŠrdet pŒ inparametern
	 * och anvŠnder sig av hjŠlpmetoden insert fšr att placera nya noden i trŠdet.
	 * @param data, vŠrdet pŒ den nya noden i trŠdet
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
	 * Metod som jŠmfšr den nya nodens vŠrden med existerande (mindre/hšgre jŠmfšrelse av nodvŠrde)
	 *  fšr att finna plats som den ska sparas pŒ
	 * @param current Startnoden fšr sškningen av vart den nya noden ska placeras.
	 * @param newNode Den nya noden som ska placeras i sšktrŠdet
	 * @return returnerar det nya (modifierade) trŠdet.
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
				System.out.println("VŠrdet " + newNode.getData() + " existerar redan i trŠdet");
				//throw new IllegalArgumentException("VŠrdet existerar redan i trŠdet.");
				//TODO: USE EXCEPTION...
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
	 * Sškmetod som letar upp en nod i trŠdet utifrŒn dess vŠrde. 
	 * @param current Startnoden fšr sškningen av nod med specifikt vŠrde.
	 * @param dataToFind VŠrdet fšr noden man sšker efter
	 * @return returnerar den sškta noden om den existerar i trŠdet, annars null. 
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
	 * Tar emot vŠrdet fšr noden som ska tas bort ur trŠdet. 
	 * Kallar pŒ hjŠlpmetoden remove fšr borttagning och omstrukturering av trŠdet
	 * samt sŠtter det nya (modifierade) trŠdet som remove returnerar till root.
	 * @param data vŠrdet fšr noden som ska tas bort.
	 */
	public void delete(int data){
		TreeNode newTree = remove(root, data);
		if(newTree != null){
			root = newTree;
		}
	}
	
	/**
	 * Metoden letar upp šnskad nod att ta bort utifrŒn nodvŠrde. Om den finner med match
	 * mellan indata vŠrde och ett nodvŠrde ur trŠdet kallar den pŒ findSuccessor fšr att hitta en efterfšljare
	 * till noden som tas bort.
	 * @param current, startnoden fšr sškning 
	 * @param dataToRemove, nodvŠrdet fšr noden som skall tas bort
	 * @return returnerar det nya (modifierade trŠdet) 
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
	 * Letar upp efterfšljare till en vald nod som skall tas bort. 
	 * Efterfšljaren letar den fšrst upp i hšgra barnets vŠnstraste nod.
	 * Om det endast finns hšgerbarn vŠljs den fšrsta ut som efterfšljare.
	 * Om ett hšgerbarn ej finns sŒ blir fšrŠlder till borttagna noden efterfšljare.
	 * @param current Noden som behšver ersŠttas med en efterfšljare
	 * @return returnerar det nya subtrŠdet. 
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
				if(level == 0) {
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
	 * @param current startnoden fšr uppletning och utprint.
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

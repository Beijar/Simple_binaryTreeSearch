/**
 * 
 * @author Patrik
 * Represenation av ett bin�rt s�ktr�d med st�d f�r inst�ttning, upps�kning, borttagning 
 * och uppr�kning av noder och v�rden. 
 * 
 */
public class BinaryTree {
	private TreeNode root;
	//TODO: WHAT TO DO WITH SIZE??????
	private int size; 
	
	/**
	 * Ins�ttning av v�rde till tr�det. Skapar en nod utifr�n v�rdet p� inparametern
	 * och anv�nder sig av hj�lpmetoden insert f�r att placera nya noden i tr�det.
	 * @param data, v�rdet p� den nya noden i tr�det
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
	 * Metod som j�mf�r den nya nodens v�rden med existerande (mindre/h�gre j�mf�relse av nodv�rde)
	 *  f�r att finna plats som den ska sparas p�
	 * @param current Startnoden f�r s�kningen av vart den nya noden ska placeras.
	 * @param newNode Den nya noden som ska placeras i s�ktr�det
	 * @return returnerar det nya (modifierade) tr�det.
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
				System.out.println("V�rdet " + newNode.getData() + " existerar redan i tr�det");
				//throw new IllegalArgumentException("V�rdet existerar redan i tr�det.");
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
	 * S�kmetod som letar upp en nod i tr�det utifr�n dess v�rde. 
	 * @param current Startnoden f�r s�kningen av nod med specifikt v�rde.
	 * @param dataToFind V�rdet f�r noden man s�ker efter
	 * @return returnerar den s�kta noden om den existerar i tr�det, annars null. 
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
	 * Tar emot v�rdet f�r noden som ska tas bort ur tr�det. 
	 * Kallar p� hj�lpmetoden remove f�r borttagning och omstrukturering av tr�det
	 * samt s�tter det nya (modifierade) tr�det som remove returnerar till root.
	 * @param data v�rdet f�r noden som ska tas bort.
	 */
	public void delete(int data){
		TreeNode newTree = remove(root, data);
		if(newTree != null){
			root = newTree;
		}
	}
	
	/**
	 * Metoden letar upp �nskad nod att ta bort utifr�n nodv�rde. Om den finner med match
	 * mellan indata v�rde och ett nodv�rde ur tr�det kallar den p� findSuccessor f�r att hitta en efterf�ljare
	 * till noden som tas bort.
	 * @param current, startnoden f�r s�kning 
	 * @param dataToRemove, nodv�rdet f�r noden som skall tas bort
	 * @return returnerar det nya (modifierade tr�det) 
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
	 * Letar upp efterf�ljare till en vald nod som skall tas bort. 
	 * Efterf�ljaren letar den f�rst upp i h�gra barnets v�nstraste nod.
	 * Om det endast finns h�gerbarn v�ljs den f�rsta ut som efterf�ljare.
	 * Om ett h�gerbarn ej finns s� blir f�r�lder till borttagna noden efterf�ljare.
	 * @param current Noden som beh�ver ers�ttas med en efterf�ljare
	 * @return returnerar det nya subtr�det. 
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
	 * @param current startnoden f�r uppletning och utprint.
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

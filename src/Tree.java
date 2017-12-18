import java.util.Vector;

public class Tree {
	
	private Node Root;
	
	
	
	public Tree() {
		Root = new Node();
		Root.getData().setName("VFSD:\\");
	}


	public Node getRoot() {
		return Root;
	}

	public void setRoot(Node root) {
		Root = root;
	}
	
	
}
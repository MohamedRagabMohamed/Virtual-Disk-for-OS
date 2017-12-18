import java.util.Vector;

public class Node{

	
	private FFType data;
	private Vector<Node> chiledrin; 
	

	public Node() {
		chiledrin = new Vector<Node>();
		data = new FFType();
	}

	
	public FFType getData() {
		return data;
	}

	public void setData(FFType data) {
		this.data = data;
	}


	public Vector<Node> getChiledrin() {
		return chiledrin;
	}


	public void setChiledrin(Vector<Node> chiledrin) {
		this.chiledrin = chiledrin;
	}
	
	
	
}

import java.util.Vector;

public class Block {

	private int size;
	private boolean occupe;
	private Vector<Integer>nextindx;
	
	
	
	public Block() {
		nextindx = new Vector<Integer>();
		this.occupe = false;
	}
	
	public Vector<Integer> getNextindx() {
		return nextindx;
	}

	public void setNextindx(Vector<Integer> nextindx) {
		this.nextindx = nextindx;
	}
	public void AddNextindx (int nextindx) {
		this.nextindx.addElement(nextindx);
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public boolean isOccupe() {
		return occupe;
	}
	public void setOccupe(boolean occupe) {
		this.occupe = occupe;
	}
	
	
}
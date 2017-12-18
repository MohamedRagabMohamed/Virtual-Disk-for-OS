public class FFType{

	
	private String Name ,CreationDate ,LastModificationDate,Path;
	private int startBlock;
	
	
	
	public FFType(){
	}

	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getStartBlock() {
		return startBlock;
	}
	
	public void setStartBlock(int startBlock) {
		this.startBlock = startBlock;
	}


	public String getCreationDate() {
		return CreationDate;
	}

	public void setCreationDate(String creationDate) {
		CreationDate = creationDate;
	}

	public String getLastModificationDate() {
		return LastModificationDate;
	}

	public void setLastModificationDate(String lastModificationDate) {
		LastModificationDate = lastModificationDate;
	}


	public String getPath() {
		return Path;
	}


	public void setPath(String path) {
		Path = path;
	}
	
	
}
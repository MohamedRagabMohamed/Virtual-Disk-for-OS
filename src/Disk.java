import java.util.Vector;

public class Disk {
	private static Tree system;
	private static Vector<Folder> folders; 
	private static Vector<File> files;
	private static Vector<Block> blocks;
	private method mymethod;
	
	public Disk() {
		folders = new Vector<Folder>();
		//folders.add(new Folder());
		files = new Vector<File>();
		system = new Tree();
		blocks = new Vector<Block>();
		for(int i = 0 ; i < 100 ; i++)blocks.add(new Block());
	}

	
	
	
	public static Tree getSystem() {
		return system;
	}




	public static void setSystem(Tree system) {
		Disk.system = system;
	}




	public static Vector<Block> getBlocks() {
		return blocks;
	}




	public static void setBlocks(Vector<Block> blocks) {
		Disk.blocks = blocks;
	}




	public static Vector<Folder> getFolders() {
		return folders;
	}




	public static void setFolders(Vector<Folder> folders) {
		Disk.folders = folders;
	}




	public static Vector<File> getFiles() {
		return files;
	}




	public static void setFiles(Vector<File> files) {
		Disk.files = files;
	}




	public method getMymethod() {
		return mymethod;
	}




	public void setMymethod(method mymethod) {
		this.mymethod = mymethod;
	}




	public void DisplayStatus()
	{
		int c = 0;
		System.out.print("Empty Slots: ");
		for(int i = 0 ; i < blocks.size();i++)
		{
			if(!blocks.get(i).isOccupe())
			{
				System.out.print(i + 1 + "	");
				c++;
			}
			if(i%10==0)System.out.println();
		}
		System.out.println(c);
		System.out.println("\n\nEmpty space : " + (c/1000000.0) * 1000000 );
	}
	public void DisplayTreeStructure(Node start)
	{
		
		if(start.getChiledrin().size() > 0)
		{
			System.out.print(start.getData().getName() +" :");
			for(int i = 0 ; i < start.getChiledrin().size() ; i++)
				DisplayTreeStructure2(start.getChiledrin().get(i));
		}
		else
		{
			System.out.println(start.getData().getName() );
		}
	}
	public void DisplayTreeStructure2(Node start)
	{
		
		if(start.getChiledrin().size() > 0)
		{
			for(int i = 0 ; i < start.getChiledrin().size() ; i++)
			{
				System.out.print(start.getData().getName()+ "  " );
				DisplayTreeStructure(start.getChiledrin().get(i));
			}
		}
	}
	
	
}

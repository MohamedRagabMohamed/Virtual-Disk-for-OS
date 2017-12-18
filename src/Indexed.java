import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Indexed extends method{
	
	

	public void CFile(String filename,int size ,String path )
	{
		String mypath = path;
		for(int i = 0 ; i < getMyDisk().getFiles().size() ; i++)
		{
			if(getMyDisk().getFiles().get(i).getName().equals(filename) &&
					getMyDisk().getFiles().get(i).getPath().equals(path) )
			{
				System.out.println("File is exists in this path!!");
				return;
			}
				
		}
		Node cur = getMyDisk().getSystem().getRoot();
		path = path.replace("VFSD:\\", "");
		int indx = path.indexOf("\\"); 
		if(indx == -1) indx = path.length() ;
		String goon = path.substring(0,indx);
		path = path.replace(goon+"\\", "");
		//System.out.println(path + "  " + goon);
		while(true)
		{
			for(int w = 0 ; w < cur.getChiledrin().size() ; w++)
			{
				//System.out.println(111111);
				if(cur.getChiledrin().get(w).getData().getName().equals(goon))
				{
					cur = cur.getChiledrin().get(w);	
				}
			}
			if(indx == path.length() && cur.getData().getName().equals(goon))
			{
				File temp = new File();
				DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				Date today = new Date();
				Date todayWithZeroTime = null;
				try {
					todayWithZeroTime = formatter.parse(formatter.format(today));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String str = todayWithZeroTime.toString();
				temp.setCreationDate(str);
				temp.setLastModificationDate(str);
				temp.setName(filename);
				temp.setPath(mypath);
				double count = size / 100.0 ;
				size = (int) Math.ceil(count);
				temp.setSize(size);
				int indxs = -1 ;
				for(int i = 0 ; i < getMyDisk().getBlocks().size() ; i++)
				{
					if(!getMyDisk().getBlocks().get(i).isOccupe() && size > 0 )
					{ 
						if(indxs == -1)indxs = i ;
						size--;
						getMyDisk().getBlocks().get(indxs).AddNextindx(i);
						getMyDisk().getBlocks().get(i).setOccupe(true);
					}
				}
				temp.setStartBlock(indxs);
				temp.setType(filename.substring(filename.indexOf(".")));
				getMyDisk().getFiles().add(temp);
				Node test = new Node();
				test.setData(temp);
				cur.getChiledrin().add(test);
				System.out.println("File created successfully.");
				return;
			}
			indx = path.indexOf("\\"); 
			if(indx == -1) indx = path.length();
			path = path.substring(0,indx);
			if(indx == path.length()) path = path.replaceFirst(path, "");
			path = path.replace(path+"\\", "");
			if(path.length()==0)
			{
				System.out.println("Folder not found!!");
				return;
			}
			
		}
	}
	
	
	
	public void CFolder (String filename,String path )
	{
		String mypath = path;
		for(int i = 0 ; i < getMyDisk().getFolders().size() ; i++)
		{
			if(getMyDisk().getFolders().get(i).getName().equals(filename) &&
					getMyDisk().getFolders().get(i).getPath().equals(path) )
			{
				System.out.println("Folder is exists in this path!!");
				return;
			}
				
		}
		String goon= "";
		Node cur = getMyDisk().getSystem().getRoot();
		//System.out.println(path);
		path = path.replace("VFSD:\\", "");
		int indx = path.indexOf("\\");
		if(indx == -1) indx = path.length() ;
		if(path.length() > 0){
			goon = path.substring(0,indx);
			System.out.println(goon);
			path = path.replaceFirst(goon, "");
		}
		while(true)
		{
			for(int w = 0 ; w < cur.getChiledrin().size() ; w++)
			{
				if(cur.getChiledrin().get(w).getData().getName().equals(goon))
				{
					cur = cur.getChiledrin().get(w);	
				}
			}
			if(indx == path.length())
			{
				Folder temp = new Folder();
				DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				Date today = new Date();
				Date todayWithZeroTime = null;
				try {
					todayWithZeroTime = formatter.parse(formatter.format(today));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String str = todayWithZeroTime.toString();
				temp.setCreationDate(todayWithZeroTime.toString());
				temp.setLastModificationDate(temp.getCreationDate());;
				temp.setName(filename);
				temp.setPath(mypath);
				temp.setStartBlock(-1);
				getMyDisk().getFolders().add(temp);
				Node test = new Node();
				test.setData(temp);
				cur.getChiledrin().add(test);
				System.out.println("Folder created successfully.");
				return;
			}
			indx = path.indexOf("\\"); 
			if(indx == -1) indx = path.length();
			path = path.substring(0,indx);
			if(indx == path.length()) path = path.replaceFirst(path, "");
			path = path.replaceFirst(path, "");

		}
	}
	
	public void DeleteFile(String location)
	{
		int i = location.lastIndexOf("\\");
		String filename=location.substring(i);
		for(int w = 0 ; w < getMyDisk().getFiles().size() ; w++)
		{
			if(getMyDisk().getFiles().get(w).getName().equals(filename))
			{
				i = w;
			}
			else
				i = -1;
		}
		
		if(i == -1)
		{
			System.out.println("This file not found!!");
		}
		else if(i >= 0 && location.substring(0,6).equals("VFSD:\\"))
		{
			getMyDisk().getFiles().remove(i);
			Node cur= new Node();
			cur = getMyDisk().getSystem().getRoot();
			location = location.replaceFirst("VFSD:\\", "");
			int indx = location.indexOf("\\"); 
			if(indx == -1) indx = location.length()-1 ;
			String path = location.substring(6,indx);
			location = location.replaceFirst(path+"\\", "");
			while(true)
			{
				for(int w = 0 ; w < cur.getChiledrin().size() ; w++)
				{
					if(cur.getChiledrin().get(w).getData().getName().equals(path))
					{
						if(path.contains("."))
						{
							indx = cur.getData().getStartBlock();
							File tmp = (File)cur.getData();
							getMyDisk().getBlocks().elementAt(w).setOccupe(false);
							getMyDisk().getBlocks().elementAt(w).setNextindx(null);
							cur.getChiledrin().remove(w);
							System.out.println("File deleted successfully.");
							return;
						}
						cur = cur.getChiledrin().get(w);
					}
				}
				indx = location.indexOf("\\"); 
				if(indx == -1) indx = location.length()-1;
				path = location.substring(0,indx);
				location = location.replaceFirst(path+"\\", "");
			}
		}
	}
	
	public void DeleteFolder (String location , String foldername)
	{
		int i = location.lastIndexOf("\\");
		for(int w = 0 ; w < getMyDisk().getFolders().size() ; w++)
		{
			if(getMyDisk().getFolders().get(w).getName().equals(foldername))
			{
				i = w;
			}
			else
				i = -1;
		}
		if(i == -1)
		{
			System.out.println("This fOlder not found!!");
		}
		else if(i >= 0 && location.substring(0,6).equals("VFSD:\\"))
		{
			getMyDisk().getFolders().remove(i);
			Node cur= new Node();
			cur = getMyDisk().getSystem().getRoot();
			location = location.replaceFirst("VFSD:\\", "");
			int  w , indx = location.indexOf("\\"); 
			if(indx == -1) indx = location.length()-1 ;
			String path = location.substring(6,indx);
			location = location.replaceFirst(path+"\\", "");
			while(true)
			{
				for( w = 0 ; w < cur.getChiledrin().size() ; w++)
				{
					if(cur.getChiledrin().get(w).getData().getName().equals(foldername))
					{
							cur.getChiledrin().remove(w);
							System.out.println("File deleted successfully.");
							return;
					}
				}
				indx = location.indexOf("\\"); 
				if(indx == -1) indx = location.length();
				path = location.substring(0,indx);
				location = location.replaceFirst(path+"\\", "");
			}
		}
	}
	
	
	
}

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class VFSD {
	
	
	public static void main(String [] Args) 
	{
		Disk myobject = new Disk();	
		Indexed index2 = new Indexed();
		Contiguous index1 = new Contiguous();
		System.out.print("1- Contiguous Allocation\n2- Indexed Allocation\n\nEnter allocation method :");
		int type;
		BufferedReader br = null;
		try {
			br = new BufferedReader( new FileReader("input.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner sc = new Scanner(br);

		type = sc.nextInt();
		if(type == 1 ) myobject.setMymethod(index1);
		else if(type == 2)myobject.setMymethod(index2);
		String input , name , path , sizz;
		
		while(true)
		{
			input = sc.nextLine();
			int idx = input.indexOf(" ");
			if(idx == -1)idx = input.length();
			String start = input.substring(0,idx);
			
			if(start.equals("CFile") )
			{
				
				input = input.replace(start+" ", "");
				idx = input.indexOf(" ");
				if(idx == -1)idx = input.length();
				name = input.substring(0,idx);
				input = input.replace(name+" ", "");
				idx = input.indexOf(" ");
				if(idx == -1)idx = input.length();
				sizz = input.substring(0,idx);
				input = input.replace(sizz+" ", "");
				idx = input.indexOf(" ");
				if(idx == -1)idx = input.length();
				path = input.substring(0,idx);
				if(myobject.getMymethod() instanceof Indexed)
				{
					index2.CFile(name, Integer.parseInt(sizz) , path);	
				}
				else
				{
					index1.CFile(name, Integer.parseInt(sizz) , path);
				}
			}
			else if(start.equals("CFolder"))
			{
				
				input = input.replaceFirst(start+" ", "");
				idx = input.indexOf(" ");
				if(idx == -1)idx = input.length();
				name = input.substring(0,idx);
				input = input.replaceFirst(name+" ", "");
				idx = input.indexOf(" ");
				if(idx == -1)idx = input.length();
				path = input.substring(0,idx);
				//System.out.println(path);
				if(myobject.getMymethod() instanceof Indexed)
				{
					//System.out.println(path);
					index2.CFolder(name, path);	
				}
				else
				{
					
					index1.CFolder(name, path);
				}
			}
			else if(start.equals("DeleteFile"))
			{
				input =  input.replaceFirst(start+" ", "");
				idx = input.indexOf(" ");
				if(idx == -1)idx = input.length();
				path = input.substring(0,idx);
				if(myobject.getMymethod() instanceof Indexed)
				{
					index2.DeleteFile(path);	
				}
				else
				{
					index1.DeleteFile(path);
				}
			}
			else if(start.equals("DeleteFolder"))
			{
				input = input.replaceFirst(start+" ", "");
				idx = input.indexOf(" ");
				if(idx == -1)idx = input.length();
				name = input.substring(0,idx);
				input = input.replaceFirst(name+" ", "");
				idx = input.indexOf(" ");
				if(idx == -1)idx = input.length();
				path = input.substring(0,idx);
				if(myobject.getMymethod() instanceof Indexed)
				{
					index2.DeleteFolder(name, path);	
				}
				else
				{
					index1.DeleteFolder(name, path);
				}
			}
			else if(start.equals("DisplayDiskStatus"))
			{
				myobject.DisplayStatus();
			}
			else if(start.equals("DisplayDiskStructure"))
			{
				myobject.DisplayTreeStructure(myobject.getSystem().getRoot());
			}
			else if(start.equals("Exit"))
			{
				System.out.println("Good bye!!");
				break;
			}
		}
	
	}

	/*


	1
CFile file.txt 100 VFSD:\Folder1
CFolder Folder1 VFSD:\
CFile file.txt 100 VFSD:\Folder1
CFile file.txt 100 VFSD:\Folder1
CFile file1.txt 100 VFSD:\Folder1
CFile file2.txt 100 VFSD:\Folder1
CFile file3.txt 100 VFSD:\Folder1
CFile file88.txt 100 VFSD:\Folder1
CFile filassade.txt 100 VFSD:\Folder1
CFolder Folder12 VFSD:\
CFolder Folder13 VFSD:\
CFolder Folder14 VFSD:\
CFolder Folder15 VFSD:\
CFile file.txt 100 VFSD:\Folder12
CFile file.txt 100 VFSD:\Folder14
CFile file.txt 100 VFSD:\Folder155
CFile file.txt 100 VFSD:\Folder13
CFile file.txt 100 VFSD:\Folder15
CFile file2.txt 100 VFSD:\Folder12
CFile file.txt 100 VFSD:\Folder2
CFile file.txt 100 VFSD:\Folder13
CFile fil45e.txt 100 VFSD:\Folder14
	DisplayDiskStatus
	 * */
	
}

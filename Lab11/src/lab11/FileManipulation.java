package lab11;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileManipulation {

	private File speed=new File("C:\\Users\\micha\\Documents\\CS2003(Algorithms)\\Backup\\SPEED");//speed folder
	private File[] speedFiles=new File[12];//holds all files in speed
	private File[] relevantFiles=new File[11];//holds all files in speed starting with "SPEED"
	private File apollo=new File("C:\\Users\\micha\\Documents\\CS2003(Algorithms)\\Backup\\APOLLO");
	private File apollo1=new File("C:\\Users\\micha\\Documents\\CS2003(Algorithms)\\Backup\\APOLLO\\APOLLO_20171102_1of4");
	private File[] apolloFiles;
	public FileManipulation() {
		speedManipulation();
		apolloManipulation();
	}
	
	private void speedManipulation() {
		int count=0;
		speedFiles=speed.listFiles();//puts all files in speed into speedFiles
		for(int i=0;i<speedFiles.length;i++) {
			if(!(speedFiles[i].getName()).startsWith("SPEED")) {//if file name doesn't start with "SPEED"
				speedFiles[i].delete();//delete file
				speedFiles[i]=null;
			}
			else {
				relevantFiles[count]=speedFiles[i];//otherwise add it to relevantFiles
				count++;
			}
		}
		for(int i=0;i<relevantFiles.length;i++) {
			if(relevantFiles[i]!=null)
				System.out.println(relevantFiles[i]);//print relevantFiles
		}
	}
	
	private void apolloManipulation() {
		int count=0;
		int j=0;
		count=(apollo.getName()).charAt((apollo.getName()).lastIndexOf("of")+1);//number of files supposed to be in folder
		apolloFiles=new File[count];//array length of number of files
		apolloFiles=apollo.listFiles();//puts all files in apollo into apolloFiles
		for(int i=0;i<apolloFiles.length;i++) {
			if(apolloFiles[i]==null) {
				System.out.println("not enough files");//checks if there are enough files in apollo
				j=1;
			}
			else
				j=0;
		}
		if(j==0)
			System.out.println("correct number of files");
	}

	public static void main(String[] args) {
		new FileManipulation();
	}
}

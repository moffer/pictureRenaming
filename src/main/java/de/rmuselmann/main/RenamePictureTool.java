package de.rmuselmann.main;

import java.io.File;
import java.util.List;

public class RenamePictureTool {

	public static void main(String[] args) {
		String filePath = args.length > 0 ? args[0] : null;
		if (filePath == null || new File(filePath) == null || !new File(filePath).isDirectory()) {
			System.out.println("Need a directory as first parameter!");
			System.out.println("End..");
			System.exit(-1);
		}
		System.out.println("Begin...");
		System.out.println("Searching...");
		FolderFileReader ffr = new FolderFileReader();
		List<File> list = ffr.getFiles(new File(filePath));
		System.out.println("Renaming...");
		FileRenamer fr = new FileRenamer();
		fr.rename(list);
		System.out.println("End..");
	}
}

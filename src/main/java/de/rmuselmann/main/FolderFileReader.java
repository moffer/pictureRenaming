package de.rmuselmann.main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FolderFileReader {

	private List<String> extensions;

	public FolderFileReader() {
		extensions = new ArrayList<>();
		extensions.add("jpg");
		extensions.add("jepg");
		extensions.add("png");
	}

	public List<File> getFiles(File parent) {
		List<File> files = new ArrayList<>();
		for (final File fileEntry : parent.listFiles()) {
			if (fileEntry.isDirectory()) {
				files.addAll(getFiles(fileEntry));
			} else {
				String extension = "";
				int i = fileEntry.getAbsolutePath().lastIndexOf('.');
				if (i > 0) {
					extension = fileEntry.getAbsolutePath().substring(i + 1);
				}
				if (extensions.contains(extension.toLowerCase())) {
					files.add(fileEntry);
				}
			}
		}
		return files;
	}
}

package de.rmuselmann.main;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FileRenamer {

	public void rename(List<File> files) {
		for (File file : files) {
			String name = file.getName();

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			long ts = file.lastModified();
			String date = sdf.format(new Date(ts));

			String fileNameResult = date + "." + name;
			File destination = new File(file.getParentFile().getAbsoluteFile() + "\\" + fileNameResult);
			try {
				System.out.println("Rename File: " + file.getCanonicalPath() + " to: " + destination.getCanonicalPath());
			} catch (IOException e) {
				e.printStackTrace();
			}
			file.renameTo(destination);
		}
	}
}

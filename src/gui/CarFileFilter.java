package gui;
import java.io.File;

import javax.swing.filechooser.FileFilter;

public class CarFileFilter extends FileFilter {


	public boolean accept(File file) {
		if(file.isDirectory()) {
			return true;
		}
		String name = file.getName();
		String extension = Utils.getFileExtension(name);//returnez numele extensiei
		
		if(extension ==null) {
			return false;
		}
		if(extension.equals("txt")) {
			return true;
		}
		return false;
	}

	
	public String getDescription() {
		
		return "CarsFile(*.txt)";
	}

}

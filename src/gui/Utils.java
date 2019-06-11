package gui;

public class Utils {
	
	
    // Get the extension of a file.
    //http://circe.univ-fcomte.fr/docs/java/tutorial.20060804/uiswing/components/filechooser.html#filters
	
	public static String getFileExtension(String name) {
		int pointIndex = name.lastIndexOf(".");
		//verific daca am punct sau extensie
		if (pointIndex == -1) {
			return null;
		}

		if (pointIndex == name.length() - 1) {
			return null;
		}
		return name.substring(pointIndex + 1, name.length());
	}

}

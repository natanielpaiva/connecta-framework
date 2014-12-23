package br.com.cds.connecta.framework.core.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author Ryan Achilles de Thuin
 * @since 10/01/2014
 * @version 0.1
 */
public class UtilFile {

    private UtilFile() {
    }
    public static String FILE_SEPARATOR = File.separator;

    public static void createPath(String pathname) {


        File file = new File(pathname);

        if (!file.exists()) {
            file.mkdirs();
        }

    }

    public static File getRoot(String path) {
        File file = new File(path);
        if (file.exists()) {
            if (file.getParentFile() != null) {
                file = getRoot(file.getParent());
            }
        } else {
            return null;
        }
        return file;
    }
    
    
    public static void gravarArquivo(String path,String texto){
		try {
			
			File file = new File(path);
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(texto);
			bw.newLine();
			bw.flush();
		    bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}

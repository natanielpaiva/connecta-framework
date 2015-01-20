package br.com.cds.connecta.framework.core.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * 
 * Classe Utilitária para maninpuar arquivos ZIP.
 * 
 *
 *
 */
public class ZIPUtil {
	
//	public static void main(String[] args){
//		
//		String filename = "D:\\Downloads\\sample.zip";
//		String outputFolder = "D:\\opt\\files";
//		
//		ZIPUtil.unzip(filename, outputFolder);
//		
//	}
	
	private ZIPUtil(){
		
	}

	public static String[] unzip(String filename, String outputFolder){
		
		String[] unzipfiles = {};
		
		byte[] buffer = new byte[1024];
		 
	     try{
	 
	    	//create output directory is not exists
	    	File folder = new File(outputFolder);
	    	if(!folder.exists()){
	    		throw new IOException("Pasta de destino inexistente!");
//	    		folder.mkdir();
	    	}
	 
	    	//get the zip file content
	    	ZipInputStream zis = new ZipInputStream(new FileInputStream(filename));
	    	//get the zipped file list entry
	    	ZipEntry ze = zis.getNextEntry();
	    	 
	    	List<String> files = new ArrayList<String>();
	 
	    	while(ze!=null){
	 
	    	   String fileName = ze.getName();
	    	   String pathFile = outputFolder + File.separator + fileName;
	    	   
	           File newFile = new File(pathFile);	           
	           files.add(pathFile);
	 
	           //create all non exists folders
	           //else you will hit FileNotFoundException for compressed folder
	           new File(newFile.getParent()).mkdirs();
	 
	           FileOutputStream fos = new FileOutputStream(newFile);             
	 
	           int len;
	           while ((len = zis.read(buffer)) > 0) {
	        	   fos.write(buffer, 0, len);
	           }
	 
	            fos.close();   
	            ze = zis.getNextEntry();
	    	}
	    	
	    	unzipfiles = files.toArray(unzipfiles);
	 
	        zis.closeEntry();
	    	zis.close();
	 
	    }catch(IOException ex){
	       ex.printStackTrace(); 
	    }
	   		
		return unzipfiles ;
	}
	
}

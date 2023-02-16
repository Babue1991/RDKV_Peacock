package com.automatics.rdkv.STBhomescreen;

import java.io.File;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class ReadTextInImage {

	public static void main(String[] args) {
		String path="/home/user/Downloads/Application.jpg";
		
        System.out.println(ReadTextInImage.crackImage(path));
	}
	
	 public static String crackImage(String filePath) {
	        File imageFile = new File(filePath);
	        ITesseract instance = new Tesseract();
	        instance.setDatapath("/home/user/eclipse-workspace/RDKV_Peacock/src/main/resources/");
	        
	        instance.setLanguage("eng");
	        
	        try {
	            String result = instance.doOCR(imageFile);
	            return result;
	        } catch (TesseractException e) {
	            System.err.println(e.getMessage());
	            return "Error while reading image";
	        }
	    }

}

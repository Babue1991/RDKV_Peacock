package com.automatics.rdkv.commonmethods;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import javax.imageio.ImageIO;

import com.automatics.rdkv.constants.ImageCaptureConstants;
import com.automatics.rdkv.constants.LanguageConstants;
import com.automatics.test.AutomaticsTestBase;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class GrabText {

	public static void main(String[] args) throws Exception {
		String path="/home/user/Downloads/SearchbarHighlight(1).jpg";
		GrabText grabText = new GrabText();
		BufferedImage	liveImage = ImageIO.read(new File("/home/user/Desktop/greyimage1.jpg"));
		//System.out.println(grabText.crackImage(liveImage));
		System.out.println(grabText.crackNumber(liveImage));
	}

	public String crackImage(BufferedImage filePath) {
		String text;
		String result;
		ITesseract instance = new Tesseract();
		 // instance.setDatapath(LanguageConstants.TRAIN_DATA_PATH);
		 // instance.setLanguage(LanguageConstants.ENGLISH_LANGUAGE);

		    instance.setDatapath(LanguageConstants.TRAIN_DATA_PATH);
		    instance.setLanguage("eng");
		
		
		try {
			text = instance.doOCR(filePath);
			result = text.trim();
	//		LOGGER.info("The grabbed text from image is: " +result);
			System.out.println("The grabbed text from image is: " +result);
			return result;
		} catch (TesseractException e) {
			System.err.println(e.getMessage());
			return "Error while reading image";
		}
	}
	
	public String crackNumber(BufferedImage imageFile) throws Exception {
		
	    //final File imageFile = new File("imageWith Digits.jpg");
	    ITesseract instance = new Tesseract();
	    instance.setDatapath(LanguageConstants.TRAIN_DATA_PATH);
	    instance.setLanguage("eng");
	    instance.setTessVariable("tessedit_char_whitelist", "0123456789");
	    String result = instance.doOCR(imageFile);
	    System.out.println(result);
		return result;
	}

	public boolean checkSpecialChar(String actual) {
		
		
		Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(actual);
		boolean b = m.find();

		if (b)
		   System.out.println("There is a special character in my string");
		else
		   System.out.println("There is a no special character in my string");
		
		return b;
	}

}

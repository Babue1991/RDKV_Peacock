package com.automatics.rdkv.commonmethods;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.automatics.rdkv.constants.ImageCaptureConstants;
import com.automatics.rdkv.constants.LanguageConstants;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class GrabText {

	public static void main(String[] args) throws IOException {
		String path="/home/user/Downloads/Application.jpg";
		GrabText grabText = new GrabText();
		BufferedImage	liveImage = ImageIO.read(new File("/home/user/Desktop/image1.jpg"));
		System.out.println(grabText.crackImage(liveImage));
	}

	public String crackImage(BufferedImage filePath) {

		ITesseract instance = new Tesseract();
	//	instance.setDatapath(LanguageConstants.TRAIN_DATA_PATH);
	//	instance.setLanguage(LanguageConstants.ENGLISH_LANGUAGE);

		instance.setDatapath(LanguageConstants.TRAIN_DATA_PATH);
		instance.setLanguage("eng");
		
		
		try {
			String result = instance.doOCR(filePath);
			System.out.println("The text present in the image is: "+result);
			return result;
		} catch (TesseractException e) {
			System.err.println(e.getMessage());
			return "Error while reading image";
		}
	}

}

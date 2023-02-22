package com.automatics.rdkv.STBhomescreen;


import java.io.File;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class ReadText {
	public static void main(String[] args)
	{
		Tesseract tesseract = new Tesseract();
		try {

			tesseract.setDatapath("/home/user/Downloads");

			// the path of your tess data folder
			// inside the extracted file
			String text
			= tesseract.doOCR(new File("ApplicationTextImage.jpg"));

			// path of your image file
			System.out.print(text);
		}
		catch (TesseractException e) {
			System.out.println("in exception");
			e.printStackTrace();
		}
	}
}



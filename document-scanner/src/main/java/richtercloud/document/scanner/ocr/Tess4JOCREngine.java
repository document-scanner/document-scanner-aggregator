/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package richtercloud.document.scanner.ocr;

import java.awt.image.BufferedImage;


/**
 *
 * @author richter
 */
public class Tess4JOCREngine implements OCREngine {

    @Override
    public String recognizeImage(BufferedImage image) {
        throw new UnsupportedOperationException("Not supported yet. Figure out maven dependencies");
        
//        Tesseract instance = Tesseract.getInstance();  // JNA Interface Mapping
//        // Tesseract1 instance = new Tesseract1(); // JNA Direct Mapping
//
//        try {
//            String result = instance.doOCR(imageFile);
//            System.out.println(result);
//        } catch (TesseractException e) {
//            System.err.println(e.getMessage());
//        }
    }
    
}

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
public interface OCREngine {
    
    /**
     * recognizes the characters of {@code image}
     * @param image
     * @return the recognized characters
     */
    String recognizeImage(BufferedImage image);
}

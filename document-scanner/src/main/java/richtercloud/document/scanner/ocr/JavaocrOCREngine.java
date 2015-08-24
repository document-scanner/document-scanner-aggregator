/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package richtercloud.document.scanner.ocr;

import java.awt.image.BufferedImage;
import net.sourceforge.javaocr.ocrPlugins.mseOCR.OCRScanner;
import net.sourceforge.javaocr.scanner.PixelImage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A {@link OCREngine} implementation which uses javaocr - which needs a lot of
 * training data and initially does nothing - which is what this implementation
 * consequently does currently.
 * @author richter
 */
public class JavaocrOCREngine implements OCREngine {
    private static final Logger LOGGER = LoggerFactory.getLogger(JavaocrOCREngine.class);
    private final OCRScanner scanner = new OCRScanner();

    @Override
    public String recognizeImage(BufferedImage image) {
        PixelImage pixelImage = new PixelImage(image);
        pixelImage.toGrayScale(true);
        pixelImage.filter();
        String text = this.scanner.scan(image, 0, 0, 0, 0, null);
        LOGGER.debug("OCR result: {}", text);
        return text;
    }
    
}

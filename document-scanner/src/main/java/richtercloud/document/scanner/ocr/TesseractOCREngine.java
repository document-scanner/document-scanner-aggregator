/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package richtercloud.document.scanner.ocr;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.imageio.ImageIO;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A {@link OCREngine} which uses tesseract in inter-process communication
 * because no Java-bindings exist.
 * @author richter
 */
public class TesseractOCREngine implements OCREngine {
    /**
     * the default name of the tesseract binary
     */
    public final static String TESSERACT_DEFAULT = "tesseract";
    private static final Logger LOGGER = LoggerFactory.getLogger(JavaocrOCREngine.class);
    private String tesseract = TESSERACT_DEFAULT;
    private List<String> languages;

    public TesseractOCREngine(List<String> languages) {
        if(languages == null || languages.isEmpty()) {
            throw new IllegalArgumentException("languages mustn't be null or empty");
        }
        this.languages = languages;
    }
    
    public TesseractOCREngine(String tesseractCmd, List<String> languages) {
        this(languages);
        this.tesseract = tesseractCmd;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public List<String> getLanguages() {
        return Collections.unmodifiableList(this.languages);
    }
    
    /**
     * checks whether the specified {@code tesseract} command is available and
     * accessible/executable
     * @param tesseract the command to check
     * @throws InterruptedException if an {@code InterruptedException} occurs during {@link Runtime#exec(java.lang.String) }
     * @throws IOException causing the binary to be presumed unavailable
     */
    public static void checkTesseractAvailable(String tesseract) throws IOException,InterruptedException {
        new ProcessBuilder(tesseract).start().waitFor();
    }
    
    public static void checkTesseractAvailableExceptions(String tesseract) {
        try {
            checkTesseractAvailable(tesseract);
        }catch(IOException ex) {
            throw new IllegalStateException(String.format("The tesseract binary '%s' isn't available or inaccessible (see nested exception for details)", tesseract), ex);
        } catch (InterruptedException ex) {
            throw new RuntimeException(String.format("An unexpected exception occured during the search of the tesseract binary '%s' because the process has been interrupted (see nested exception for details)", tesseract), ex);
        }
    }
    
    @Override
    public String recognizeImage(BufferedImage image) {
        checkTesseractAvailableExceptions(this.tesseract);
        LOGGER.debug("tesseract binary '{}' found and executable", this.tesseract);
        Iterator<String> languagesItr = this.languages.iterator();
        String lanuguageString = languagesItr.next();
        while(languagesItr.hasNext()) {
            lanuguageString += "+"+languagesItr.next();
        }
        ProcessBuilder tesseractProcessBuilder = new ProcessBuilder(this.tesseract, "-l", lanuguageString, "stdin", "stdout")
                .redirectOutput(ProcessBuilder.Redirect.PIPE);
        try {
            Process tesseractProcess = tesseractProcessBuilder.start();
            ImageIO.write(image, "png", tesseractProcess.getOutputStream());
            tesseractProcess.getOutputStream().flush();
            tesseractProcess.getOutputStream().close(); //sending EOF not an option because it's not documented what is expected (sending -1 once or twice doesn't have any effect, also with flush)
            tesseractProcess.waitFor();
            StringWriter tesseractResultWriter = new StringWriter();
            IOUtils.copy(tesseractProcess.getInputStream(), tesseractResultWriter);
            String tesseractResult = tesseractResultWriter.toString();
            LOGGER.debug("OCR result: {}", tesseractResult);
            return tesseractResult;
        } catch (IOException | InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }
    
}

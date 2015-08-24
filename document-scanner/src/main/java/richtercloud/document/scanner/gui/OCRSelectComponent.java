/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package richtercloud.document.scanner.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JPanel;

/**
 * Arranges multiple (or one) image in different selection panel and handles
 * selection on them for OCR.
 * 
 * No cross image selection are supported. Starting a selection on one panel
 * removes the selection on another.
 * @author richter
 */
/*
internal implementation notes:
- due to the fact that constructors with List<OCRSelectPanel> and List<BufferedImage>
argument have the same erasure, provide List<OCRSelectPanel> because often
action methods of OCRSelectPanel are adjusted by callers
*/
public class OCRSelectComponent extends JPanel {
    private static final long serialVersionUID = 1L;
    /**
     * The pages of which the drawing area ought to be composed
     */
    private List<OCRSelectPanel> imagePanels = new LinkedList<>();
    private OCRSelectPanel selectedPanel = null;
        
    protected OCRSelectComponent() {
    }
    
    public OCRSelectComponent(OCRSelectPanel panel) {
        this();
        this.imagePanels.add(panel);
    }
    
    
    public OCRSelectComponent(List<OCRSelectPanel> panels) {
        this();
        int preferredWidth = 0, preferredHeight = 0;
        FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 5, 5);
        this.setLayout(layout);
        for(OCRSelectPanel panel : panels) {
            preferredHeight += panel.getImage().getHeight();
            preferredWidth = Math.max(preferredWidth, panel.getImage().getWidth());
            panel.addSelectionListener(new PanelSelectionListener(panel));
            this.imagePanels.add(panel);
            this.add(panel);
        }
        this.setPreferredSize(new Dimension(preferredWidth, preferredHeight));
    }

    public List<OCRSelectPanel> getImagePanels() {
        return Collections.unmodifiableList(this.imagePanels);
    }
    
    public BufferedImage getSelection() {
        for(OCRSelectPanel panel : this.imagePanels) {
            if(panel.getDragStart() != null && panel.getDragEnd() != null) {
                BufferedImage imageSelection = panel.getImage().getSubimage(panel.dragSelectionX(),
                        panel.dragSelectionY(),
                        panel.dragSelectionWidth(),
                        panel.dragSeletionHeight());
                return imageSelection;
            }
        }
        return null;
    }

    private class PanelSelectionListener implements OCRSelectPanelSelectionListener {
        private final OCRSelectPanel panel;

        PanelSelectionListener(OCRSelectPanel panel) {
            this.panel = panel;
        }

        @Override
        public void selectionChanged() {
            OCRSelectComponent.this.selectedPanel = this.panel;
            for(OCRSelectPanel panel0: OCRSelectComponent.this.imagePanels) {
                if(!panel0.equals(OCRSelectComponent.this.selectedPanel)) {
                    panel0.unselect();
                }
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package richtercloud.document.scanner.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JPanel;

/**
 * A panel which represents one PDF or image page/scan.
 * @author richter
 */
public class OCRSelectPanel extends JPanel implements MouseListener, MouseMotionListener {
    private static final long serialVersionUID = 1L;
    private Point dragStart;
    private Point dragEnd;
    private final BufferedImage image;
    private final Set<OCRSelectPanelSelectionListener> selectionListeners = new HashSet<>();

    public OCRSelectPanel(BufferedImage image) {
        this.image = image;
        this.setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
        this.init0();
    }
    
    private void init0() {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    public BufferedImage getImage() {
        return this.image;
    }
    
    public void unselect() {
        this.dragStart = null;
        this.dragStart = null;
        this.repaint();
    }
    
    public void addSelectionListener(OCRSelectPanelSelectionListener listener) {
        this.selectionListeners.add(listener);
    }
    
    public void removeSelectionListener(OCRSelectPanelSelectionListener listener) {
        this.selectionListeners.remove(listener);
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent evt) {
        this.setDragStart(evt.getPoint());
        for(OCRSelectPanelSelectionListener listener : this.selectionListeners) {
            listener.selectionChanged();
        }
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent evt) {
        this.setDragEnd(evt.getPoint());
        for(OCRSelectPanelSelectionListener listener : this.selectionListeners) {
            listener.selectionChanged();
        }
    }
        
    /**
     * one single click should remove the OCR frame
     * @param evt
     */
    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        this.setDragEnd(null);
        this.setDragStart(null);
        this.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(java.awt.event.MouseEvent evt) {
        this.setDragEnd(evt.getPoint());
        this.repaint();
        for(OCRSelectPanelSelectionListener listener : this.selectionListeners) {
            listener.selectionChanged();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.image, 0, 0, this);
        if(this.getDragStart() != null && this.getDragEnd() != null) {
            g.drawRect(this.dragSelectionX(), 
                    this.dragSelectionY(),
                    this.dragSelectionWidth(), //width
                    this.dragSeletionHeight() //height
            );
        }
    }
    
    public int dragSelectionX() {
        return Math.min(this.getDragStart().x, this.getDragEnd().x);
    }
    
    public int dragSelectionY() {
        return Math.min(this.getDragStart().y, this.getDragEnd().y);
    }
    
    public int dragSelectionWidth() {
        return Math.max(this.getDragEnd().x, this.getDragStart().x)-Math.min(this.getDragEnd().x, this.getDragStart().x);
    }
    
    public int dragSeletionHeight() {
        return Math.max(this.getDragEnd().y, this.getDragStart().y)-Math.min(this.getDragEnd().y, this.getDragStart().y);
    }

    /**
     * @return the dragStart
     */
    public Point getDragStart() {
        return this.dragStart;
    }

    /**
     * @param dragStart the dragStart to set
     */
    protected void setDragStart(Point dragStart) {
        this.dragStart = dragStart;
    }

    /**
     * @return the dragEnd
     */
    public Point getDragEnd() {
        return this.dragEnd;
    }

    /**
     * @param dragEnd the dragEnd to set
     */
    protected void setDragEnd(Point dragEnd) {
        this.dragEnd = dragEnd;
    }
    
}

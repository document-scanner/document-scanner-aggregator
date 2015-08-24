/**
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package richtercloud.document.scanner.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import javax.persistence.EntityManager;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import richtercloud.document.scanner.setter.IdSpinnerSetter;
import richtercloud.document.scanner.setter.SpinnerSetter;
import richtercloud.document.scanner.setter.TextFieldSetter;
import richtercloud.document.scanner.setter.ValueSetter;
import richtercloud.reflection.form.builder.ReflectionFormBuilder;
import richtercloud.reflection.form.builder.ReflectionFormPanel;
import richtercloud.reflection.form.builder.components.OCRResultPanel;
import richtercloud.reflection.form.builder.components.OCRResultPanelRetriever;
import richtercloud.reflection.form.builder.components.ScanResultPanel;
import richtercloud.reflection.form.builder.components.ScanResultPanelRetriever;
import richtercloud.reflection.form.builder.components.annotations.OCRResult;
import richtercloud.reflection.form.builder.components.annotations.ScanResult;
import richtercloud.reflection.form.builder.jpa.IdPanel;
import richtercloud.reflection.form.builder.jpa.JPAReflectionFormBuilder;
import richtercloud.reflection.form.builder.retriever.ValueRetriever;

/**
 *
 * @author richter
 */
public class DocumentForm extends javax.swing.JPanel {
    private static final long serialVersionUID = 1L;
    private final static Map<Class<? extends JComponent>, ValueSetter<?>> VALUE_SETTER_DEFAULT;
    static {
        Map<Class<? extends JComponent>, ValueSetter<?>>  valueSetter0 = new HashMap<>();
        valueSetter0.put(JTextField.class, TextFieldSetter.getInstance());
        valueSetter0.put(JSpinner.class, SpinnerSetter.getInstance());
        valueSetter0.put(IdPanel.class, IdSpinnerSetter.getInstance());
        VALUE_SETTER_DEFAULT = valueSetter0;
    }
    private OCRResultPanelRetriever oCRResultPanelRetriever;
    private ScanResultPanelRetriever scanResultPanelRetriever;

    /**
     * Creates new form DocumentForm
     */
    private DocumentForm() {
        this.initComponents();
    }
    
    public DocumentForm(Set<Class<?>> entityClasses, 
            EntityManager entityManager, 
            final OCRResultPanelRetriever oCRResultPanelRetriever, 
            final ScanResultPanelRetriever scanResultPanelRetriever) throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this(entityClasses, 
                ReflectionFormBuilder.CLASS_MAPPING_DEFAULT, 
                ReflectionFormBuilder.VALUE_RETRIEVER_MAPPING_DEFAULT, 
                DocumentForm.VALUE_SETTER_DEFAULT,
                entityManager, 
                oCRResultPanelRetriever, 
                scanResultPanelRetriever);
    }
    
    public DocumentForm(Set<Class<?>> entityClasses, Map<Class<?>, Class<? extends JComponent>> classMapping, Map<Class<? extends JComponent>, ValueRetriever<?, ?>> valueRetrieverMapping, Map<Class<? extends JComponent>, ValueSetter<?>> valueSetterMapping, EntityManager entityManager, final OCRResultPanelRetriever oCRResultPanelRetriever, final ScanResultPanelRetriever scanResultPanelRetriever) throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.initComponents();
        List<Pair<Class<? extends Annotation>, Callable<? extends JComponent>>> annotationMapping = new LinkedList<>();
        annotationMapping.add(new ImmutablePair<Class<? extends Annotation>, Callable<? extends JComponent>>(OCRResult.class, new Callable<OCRResultPanel>() {
            @Override
            public OCRResultPanel call() throws Exception {
                return new OCRResultPanel(oCRResultPanelRetriever);
            }
        }));
        annotationMapping.add(new ImmutablePair<Class<? extends Annotation>, Callable<? extends JComponent>>(ScanResult.class, new Callable<ScanResultPanel>() {

            @Override
            public ScanResultPanel call() throws Exception {
                return new ScanResultPanel(scanResultPanelRetriever);
            }
        }));
        ReflectionFormBuilder<?> reflectionFormBuilder = new JPAReflectionFormBuilder<>(classMapping, valueRetrieverMapping, entityManager, annotationMapping);
        this.init0(entityClasses, reflectionFormBuilder, valueSetterMapping);
    }
    
    private void init0(Set<Class<?>> entityClasses, ReflectionFormBuilder reflectionFormBuilder, Map<Class<? extends JComponent>, ValueSetter<?>> valueSetterMapping) throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        for(Class<?> entityClass : entityClasses) {
            ReflectionFormPanel reflectionFormPanel = reflectionFormBuilder.transform(entityClass);
            JScrollPane reflectionFormPanelScrollPane = new JScrollPane(reflectionFormPanel);
            this.entityCreationTabbedPane.add(entityClass.getSimpleName(), reflectionFormPanelScrollPane);
            List<Field> relevantFields = reflectionFormBuilder.retrieveRelevantFields(entityClass);
            JMenu entityClassMenu = new JMenu(entityClass.getSimpleName());
            for(Field relevantField : relevantFields) {
                JMenuItem relevantFieldMenuItem = new JMenuItem(relevantField.getName());
                relevantFieldMenuItem.addActionListener(new FieldActionListener(reflectionFormPanel, relevantField, valueSetterMapping));
                entityClassMenu.add(relevantFieldMenuItem);
            }
            this.oCRResultPopup.add(entityClassMenu);
        }
        this.entityCreationTabbedPane.validate();
        this.validate();
    }
    
    private class FieldActionListener implements ActionListener {
        private final Field field;
        private final ReflectionFormPanel<?> reflectionFormPanel;
        private final Map<Class<? extends JComponent>, ValueSetter<?>> valueSetterMapping;

        FieldActionListener(ReflectionFormPanel reflectionFormPanel, Field field, Map<Class<? extends JComponent>, ValueSetter<?>> valueSetterMapping) {
            this.field = field;
            this.reflectionFormPanel = reflectionFormPanel;
            this.valueSetterMapping = valueSetterMapping;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JComponent comp = this.reflectionFormPanel.getComponentByField(this.field);
            String oCRSelection = DocumentForm.this.oCRResultTextArea.getSelectedText();
            ValueSetter valueSetter = this.valueSetterMapping.get(comp.getClass());
            if(valueSetter != null) {
                valueSetter.setValue(oCRSelection, comp);
            }else {
                //@TODO: handle feedback
            }
        }
        
    }

    public JTextArea getoCRResultTextArea() {
        return this.oCRResultTextArea;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        oCRResultPopup = new javax.swing.JPopupMenu();
        oCRResultPopupHintMenuItem = new javax.swing.JMenuItem();
        oCRResultPopupSeparator = new javax.swing.JPopupMenu.Separator();
        splitPane = new javax.swing.JSplitPane();
        oCRResultPanel = new javax.swing.JPanel();
        oCRResultLabel = new javax.swing.JLabel();
        oCRResultTextAreaScrollPane = new javax.swing.JScrollPane();
        oCRResultTextArea = new javax.swing.JTextArea();
        entityCreationTabbedPane = new javax.swing.JTabbedPane();

        oCRResultPopupHintMenuItem.setText("Paste into");
        oCRResultPopupHintMenuItem.setEnabled(false);
        oCRResultPopup.add(oCRResultPopupHintMenuItem);
        oCRResultPopup.add(oCRResultPopupSeparator);

        splitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        oCRResultLabel.setText("OCR result");

        oCRResultTextArea.setColumns(20);
        oCRResultTextArea.setRows(5);
        oCRResultTextArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                oCRResultTextAreaMouseClicked(evt);
            }
        });
        oCRResultTextAreaScrollPane.setViewportView(oCRResultTextArea);

        javax.swing.GroupLayout oCRResultPanelLayout = new javax.swing.GroupLayout(oCRResultPanel);
        oCRResultPanel.setLayout(oCRResultPanelLayout);
        oCRResultPanelLayout.setHorizontalGroup(
            oCRResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(oCRResultPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(oCRResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(oCRResultTextAreaScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                    .addGroup(oCRResultPanelLayout.createSequentialGroup()
                        .addComponent(oCRResultLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        oCRResultPanelLayout.setVerticalGroup(
            oCRResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, oCRResultPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(oCRResultLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(oCRResultTextAreaScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        splitPane.setTopComponent(oCRResultPanel);
        splitPane.setRightComponent(entityCreationTabbedPane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(splitPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(splitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void oCRResultTextAreaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oCRResultTextAreaMouseClicked
        if(evt.getButton() == MouseEvent.BUTTON3) {
            //right click
            this.oCRResultPopup.show(this.oCRResultTextArea, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_oCRResultTextAreaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane entityCreationTabbedPane;
    private javax.swing.JLabel oCRResultLabel;
    private javax.swing.JPanel oCRResultPanel;
    private javax.swing.JPopupMenu oCRResultPopup;
    private javax.swing.JMenuItem oCRResultPopupHintMenuItem;
    private javax.swing.JPopupMenu.Separator oCRResultPopupSeparator;
    private javax.swing.JTextArea oCRResultTextArea;
    private javax.swing.JScrollPane oCRResultTextAreaScrollPane;
    private javax.swing.JSplitPane splitPane;
    // End of variables declaration//GEN-END:variables
}

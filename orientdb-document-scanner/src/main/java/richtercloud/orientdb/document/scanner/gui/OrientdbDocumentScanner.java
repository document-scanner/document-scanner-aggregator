/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package richtercloud.orientdb.document.scanner.gui;

import au.com.southsky.jfreesane.SaneDevice;
import au.com.southsky.jfreesane.SaneException;
import au.com.southsky.jfreesane.SaneSession;
import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.exception.ODatabaseException;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <h2>Status bar</h2>
 * In order to provide static status for a selected (and eventually configurable) set of components (selected scanner, image selection mode, etc.) and dynamic info, warning and error message, a status bar (at the bottom of the main application
 * window is introduced which is a container and contains a subcontainer for each static information and one for the messages. The latter is a popup displaying a scrollable list of message entries which can be removed from it (e.g. with a close button). Static status subcontainer can be sophisticated, e.g. the display for the currently selected scanner can contain a button to select a scanner while none is selected an be a label only while one is selected. That's why they're containers. The difference between static information and messages is trivial.
 * @author richter
 */
public class OrientdbDocumentScanner extends javax.swing.JFrame {
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = LoggerFactory.getLogger(OrientdbDocumentScanner.class);
    private static final int ORIENTDB_PORT_DEFAULT = 2424;
    private static final String CONNECTION_URL_EXAMPLE = "remote:localhost/GratefulDeadConcerts";
    private static final String CONNECTION_URL_TOOLTIP_TEXT = String.format("[mode]:[path] (where mode is one of <b>remote</b>, <b>plocal</b> or <b>??</b> and path is in the form [IP or hostname]/[database name], e.g. %s)", CONNECTION_URL_EXAMPLE);
    private static final String APP_NAME = "OrientDB document scanner";
    private static final String APP_VERSION = "1.0";
    private static final String UNSAVED_NAME = "unsaved";
    private SaneDevice device;
    private ODatabaseDocumentTx db;

    private void onDeviceSet() {
        assert device != null;
        scannerLabel.setText(device.toString());
        GroupLayout layout = new GroupLayout(statusBar);
        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        hGroup.addGroup(layout.createParallelGroup().
                 addComponent(scannerLabel));
        layout.setHorizontalGroup(hGroup);
        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
                 addComponent(scannerLabel));
        layout.setVerticalGroup(vGroup);
        statusBar.setLayout(layout);
        pack();
        this.invalidate();
    }

    private void onDeviceUnset() {
        assert device == null;
        GroupLayout layout = new GroupLayout(statusBar);
        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        hGroup.addGroup(layout.createParallelGroup().
                 addComponent(scannerLabel).addComponent(selectScannerButton));
        layout.setHorizontalGroup(hGroup);
        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
                 addComponent(scannerLabel).addComponent(selectScannerButton));
        layout.setVerticalGroup(vGroup);
        statusBar.setLayout(layout);
        pack();
        this.invalidate();
    }

    private void selectScanner() {
        InetAddress address;
        try {
            address = InetAddress.getLocalHost();
            SaneSession session = SaneSession.withRemoteSane(address);
            device = session.getDevice("pixma:04A926A3_SDF7X0141050B");
        } catch (UnknownHostException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        scanMenuItem.setEnabled(true);
    }

    private JComponent generateImageComponent(BufferedImage image) {
        ImageIcon imageIcon = new ImageIcon(image);
        JLabel retValue = new JLabel(imageIcon);
        retValue.setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
        return retValue;
    }

    /**
     * Creates new form OrientdbDocumentScanner
     */
    public OrientdbDocumentScanner() {
        initComponents();
        onDeviceUnset();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scannerLabel = new javax.swing.JLabel();
        selectScannerButton = new javax.swing.JButton();
        selectScannerDialog = new javax.swing.JDialog();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        databaseDialog = new javax.swing.JDialog();
        databaseConnectionURLTextField = new javax.swing.JTextField();
        databaseConnectionURLLabel = new javax.swing.JLabel();
        databaseUsernameTextField = new javax.swing.JTextField();
        databaseUsernameLabel = new javax.swing.JLabel();
        databasePasswordTextField = new javax.swing.JPasswordField();
        databasePasswordLabel = new javax.swing.JLabel();
        databaseCancelButton = new javax.swing.JButton();
        databaseConnectButton = new javax.swing.JButton();
        databaseConnectionFailureLabel = new javax.swing.JLabel();
        statusBar = new javax.swing.JPanel();
        mainTabbedPane = new javax.swing.JTabbedPane();
        mainMenuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        scannerSelectionMenu = new javax.swing.JMenu();
        selectScannerMenuItem = new javax.swing.JMenuItem();
        knownScannersMenuItemSeparator = new javax.swing.JPopupMenu.Separator();
        scanMenuItem = new javax.swing.JMenuItem();
        openMenuItem = new javax.swing.JMenuItem();
        databaseMenuSeparator = new javax.swing.JPopupMenu.Separator();
        databaseConnectionMenu = new javax.swing.JMenu();
        connectDatabaseMenuItem = new javax.swing.JMenuItem();
        knownDatabasesMenuItemSeparartor = new javax.swing.JPopupMenu.Separator();
        saveMenuItem = new javax.swing.JMenuItem();
        exitMenuItemSeparator = new javax.swing.JPopupMenu.Separator();
        exitMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();

        scannerLabel.setText("No scanner selected");

        selectScannerButton.setText("Select Scanner");
        selectScannerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectScannerButtonActionPerformed(evt);
            }
        });

        selectScannerDialog.setTitle(String.format("Select scanner - %s %s", APP_NAME, APP_VERSION));

        jTextField1.setText("jTextField1");

        jLabel1.setText("Address");

        jButton1.setText("Search");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout selectScannerDialogLayout = new javax.swing.GroupLayout(selectScannerDialog.getContentPane());
        selectScannerDialog.getContentPane().setLayout(selectScannerDialogLayout);
        selectScannerDialogLayout.setHorizontalGroup(
            selectScannerDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectScannerDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(selectScannerDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, selectScannerDialogLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, selectScannerDialogLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jSeparator1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE))
                .addContainerGap())
        );
        selectScannerDialogLayout.setVerticalGroup(
            selectScannerDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectScannerDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(selectScannerDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                .addContainerGap())
        );

        databaseDialog.setTitle(String.format("Connect to database - %s %s", APP_NAME, APP_VERSION));
        databaseDialog.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                databaseDialogWindowClosed(evt);
            }
        });

        databaseConnectionURLTextField.setText(CONNECTION_URL_EXAMPLE);
        databaseConnectionURLTextField.setToolTipText(CONNECTION_URL_TOOLTIP_TEXT);
        databaseConnectionURLTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                databaseConnectionURLTextFieldActionPerformed(evt);
            }
        });

        databaseConnectionURLLabel.setText("Connection URL");
        databaseConnectionURLLabel.setToolTipText(CONNECTION_URL_TOOLTIP_TEXT);

        databaseUsernameTextField.setText("root");

        databaseUsernameLabel.setText("Username");

        databasePasswordLabel.setText("Password");

        databaseCancelButton.setText("Cancel");
        databaseCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                databaseCancelButtonActionPerformed(evt);
            }
        });

        databaseConnectButton.setText("Connect");
        databaseConnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                databaseConnectButtonActionPerformed(evt);
            }
        });

        databaseConnectionFailureLabel.setText(" ");

        javax.swing.GroupLayout databaseDialogLayout = new javax.swing.GroupLayout(databaseDialog.getContentPane());
        databaseDialog.getContentPane().setLayout(databaseDialogLayout);
        databaseDialogLayout.setHorizontalGroup(
            databaseDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, databaseDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(databaseDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(databaseConnectionFailureLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, databaseDialogLayout.createSequentialGroup()
                        .addGroup(databaseDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(databasePasswordLabel)
                            .addComponent(databaseConnectionURLLabel)
                            .addComponent(databaseUsernameLabel))
                        .addGap(18, 18, 18)
                        .addGroup(databaseDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(databasePasswordTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(databaseUsernameTextField)
                            .addComponent(databaseConnectionURLTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)))
                    .addGroup(databaseDialogLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(databaseConnectButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(databaseCancelButton)))
                .addContainerGap())
        );
        databaseDialogLayout.setVerticalGroup(
            databaseDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(databaseDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(databaseDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(databaseConnectionURLTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(databaseConnectionURLLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(databaseDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(databaseUsernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(databaseUsernameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(databaseDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(databasePasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(databasePasswordLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(databaseConnectionFailureLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(databaseDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(databaseCancelButton)
                    .addComponent(databaseConnectButton))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(String.format("%s %s", APP_NAME, APP_VERSION));
        setLocation(new java.awt.Point(0, 0));
        setSize(new java.awt.Dimension(400, 300));

        javax.swing.GroupLayout statusBarLayout = new javax.swing.GroupLayout(statusBar);
        statusBar.setLayout(statusBarLayout);
        statusBarLayout.setHorizontalGroup(
            statusBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        statusBarLayout.setVerticalGroup(
            statusBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        fileMenu.setText("File");

        scannerSelectionMenu.setText("Scanner selection");

        selectScannerMenuItem.setText("Select scanner...");
        selectScannerMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectScannerMenuItemActionPerformed(evt);
            }
        });
        scannerSelectionMenu.add(selectScannerMenuItem);
        scannerSelectionMenu.add(knownScannersMenuItemSeparator);

        fileMenu.add(scannerSelectionMenu);

        scanMenuItem.setText("Scan");
        scanMenuItem.setEnabled(false);
        scanMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scanMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(scanMenuItem);

        openMenuItem.setText("Open scan...");
        fileMenu.add(openMenuItem);
        fileMenu.add(databaseMenuSeparator);

        databaseConnectionMenu.setText("Database selection");

        connectDatabaseMenuItem.setText("Connect to database");
        connectDatabaseMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectDatabaseMenuItemActionPerformed(evt);
            }
        });
        databaseConnectionMenu.add(connectDatabaseMenuItem);
        databaseConnectionMenu.add(knownDatabasesMenuItemSeparartor);

        fileMenu.add(databaseConnectionMenu);

        saveMenuItem.setText("Save in database");
        saveMenuItem.setEnabled(false);
        fileMenu.add(saveMenuItem);
        fileMenu.add(exitMenuItemSeparator);

        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        mainMenuBar.add(fileMenu);

        helpMenu.setText("Help");

        aboutMenuItem.setText("About...");
        helpMenu.add(aboutMenuItem);

        mainMenuBar.add(helpMenu);

        setJMenuBar(mainMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mainTabbedPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(statusBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void selectScannerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectScannerButtonActionPerformed

    }//GEN-LAST:event_selectScannerButtonActionPerformed

    private void scanMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scanMenuItemActionPerformed
        scan();
    }//GEN-LAST:event_scanMenuItemActionPerformed

    private void selectScannerMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectScannerMenuItemActionPerformed
        selectScanner();
    }//GEN-LAST:event_selectScannerMenuItemActionPerformed

    private void connectDatabaseMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectDatabaseMenuItemActionPerformed
        databaseDialog.pack();
        databaseDialog.setLocationRelativeTo(this);
        databaseDialog.setVisible(true);
    }//GEN-LAST:event_connectDatabaseMenuItemActionPerformed

    private void databaseConnectionURLTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_databaseConnectionURLTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_databaseConnectionURLTextFieldActionPerformed

    private void databaseConnectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_databaseConnectButtonActionPerformed
        try {
            databaseConnectionFailureLabel.setText("Connecting...");
            connectDatabase();
            databaseDialog.setVisible(false);
        } catch(ODatabaseException ex) {
            String message = ex.getMessage();
            if(ex.getCause() != null) {
                message = String.format("%s (caused by '%s')", message, ex.getCause().getMessage());
            }
            databaseConnectionFailureLabel.setText(String.format("<html>The connection to the specified database with the specified credentials failed with the following error: %s</html>", message));
        }
    }//GEN-LAST:event_databaseConnectButtonActionPerformed

    private void databaseDialogWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_databaseDialogWindowClosed
        databaseConnectionFailureLabel.setText(" ");
    }//GEN-LAST:event_databaseDialogWindowClosed

    private void databaseCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_databaseCancelButtonActionPerformed
        databaseDialog.setVisible(false);
        databaseConnectionFailureLabel.setText(" ");
    }//GEN-LAST:event_databaseCancelButtonActionPerformed

    /**
     * connects to an OrientDB database using the current values of the text
     * properties of the text inputs in the database connection dialog. Expect a
     * {@link ODatabaseException} if the connection doesn't succeed due to an
     * errornous URL or wrong credentials. Excepts the remote engine to be on
     * the classpath (usually provided by orientdb-client module (in doubt check
     * with {@code Orient.instance().registerEngine(new OEngineRemote());}).
     */
    private void connectDatabase() {
        String connectionURL = databaseConnectionURLTextField.getText();
        db = new ODatabaseDocumentTx(connectionURL);
        String username = databaseUsernameTextField.getText();
        String password = new String(databasePasswordTextField.getPassword());
        db.open(username, password);
        saveMenuItem.setEnabled(true);
    }

    private void scan() {
        assert device != null;
        try {
            device.open();
            BufferedImage image = device.acquireImage();
            DocumentTab newTab = new DocumentTab();
            JComponent imageComponent = generateImageComponent(image);
            newTab.getImageScrollPane().setViewportView(imageComponent);
            mainTabbedPane.add(UNSAVED_NAME, newTab);
            this.invalidate();
        } catch (IOException | SaneException ex) {
            handleException(ex);
        } finally {
            if(device != null) {
                try {
                    device.close();
                } catch (IOException ex) {
                    handleException(ex);
                }
            }
        }
    }

    private void handleException(Throwable ex) {
        LOGGER.info("handling exception {}", ex);
        MessagePanelEntry entry = new MessagePanelEntry(new JLabel(ex.getMessage()));
        GroupLayout layout = new GroupLayout(statusBar);
        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        hGroup.addGroup(layout.createParallelGroup().
                 addComponent(entry));
        layout.setHorizontalGroup(hGroup);
        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
                 addComponent(entry));
        layout.setVerticalGroup(vGroup);
        statusBar.setLayout(layout);
        pack();
        this.invalidate();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrientdbDocumentScanner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new OrientdbDocumentScanner().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem connectDatabaseMenuItem;
    private javax.swing.JButton databaseCancelButton;
    private javax.swing.JButton databaseConnectButton;
    private javax.swing.JLabel databaseConnectionFailureLabel;
    private javax.swing.JMenu databaseConnectionMenu;
    private javax.swing.JLabel databaseConnectionURLLabel;
    private javax.swing.JTextField databaseConnectionURLTextField;
    private javax.swing.JDialog databaseDialog;
    private javax.swing.JPopupMenu.Separator databaseMenuSeparator;
    private javax.swing.JLabel databasePasswordLabel;
    private javax.swing.JPasswordField databasePasswordTextField;
    private javax.swing.JLabel databaseUsernameLabel;
    private javax.swing.JTextField databaseUsernameTextField;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JPopupMenu.Separator exitMenuItemSeparator;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPopupMenu.Separator knownDatabasesMenuItemSeparartor;
    private javax.swing.JPopupMenu.Separator knownScannersMenuItemSeparator;
    private javax.swing.JMenuBar mainMenuBar;
    private javax.swing.JTabbedPane mainTabbedPane;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JMenuItem scanMenuItem;
    private javax.swing.JLabel scannerLabel;
    private javax.swing.JMenu scannerSelectionMenu;
    private javax.swing.JButton selectScannerButton;
    private javax.swing.JDialog selectScannerDialog;
    private javax.swing.JMenuItem selectScannerMenuItem;
    private javax.swing.JPanel statusBar;
    // End of variables declaration//GEN-END:variables
}


import com.formdev.flatlaf.FlatDarkLaf;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UnsupportedLookAndFeelException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author krisar
 */
public class GUI_HauptmenueJKS extends javax.swing.JFrame {

    /**
     * Creates new form GUI
     */
    private static DBVerbindung db;
    private DefaultComboBoxModel<String> kategorieComboBoxModel;

    private void initializeDBConnection() {
        System.out.println("Datenbankverbindung wird initalisiert...");
        try {
            // Verbindungsdetails überprüfen
            System.out.println("Verbindung zur Datenbank ‚Notizblock‘ auf localhost:3306 mit Benutzername ‚root‘ wird hergestellt...");

            // DBVerbindung-Objekt initialisieren
            this.db = new DBVerbindung(SteuerungJKS.SERVER, SteuerungJKS.PORT, SteuerungJKS.DATENBANK, SteuerungJKS.USER, SteuerungJKS.PASSWORT);

            // Verbindung öffnen
            this.db.connect();

            System.out.println("Die Verbindung zur Datenbank wurde erfolgreich hergestellt.");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GUI_HauptmenueJKS.class.getName()).log(Level.SEVERE, "Datenbanktreiber nicht gefunden", ex);
            System.err.println("Datenbanktreiber nicht gefunden: " + ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(GUI_HauptmenueJKS.class.getName()).log(Level.SEVERE, "Beim Verbinden mit der Datenbank ist ein SQL-Fehler aufgetreten", ex);
            System.err.println("Beim Verbinden mit der Datenbank ist ein SQL-Fehler aufgetreten: " + ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(GUI_HauptmenueJKS.class.getName()).log(Level.SEVERE, "Ein unerwarteter Fehler ist aufgetreten.", ex);
            System.err.println("Ein unerwarteter Fehler ist aufgetreten: " + ex.getMessage());
        }
    }

    private void loadNotizen() {
        String username = SteuerungJKS.Username;
        String selectQk = "SELECT Titel FROM Notiz WHERE UserID = ? ";
        try {
            ResultSet result = db.executeSelectP(selectQk, username);
            List<String> titelList = convertResultSetToList(result, "Titel");
            DefaultComboBoxModel<String> titelComboBoxModel = new DefaultComboBoxModel<>(titelList.toArray(new String[0]));
            cb_search.setModel(titelComboBoxModel);
        } catch (SQLException ex) {
            Logger.getLogger(GUI_HauptmenueJKS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadKategories() {
        String selectQk = "SELECT Kategorien_name FROM Kategorie";
        try {
            ResultSet result = db.executeSelect(selectQk);
            List<String> kategorien = convertResultSetToList(result, "Kategorien_name");
            kategorieComboBoxModel = new DefaultComboBoxModel<>(kategorien.toArray(new String[0]));
            cb_Kategorie.setModel(kategorieComboBoxModel);
        } catch (SQLException ex) {
            Logger.getLogger(GUI_HauptmenueJKS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadTags() {
        String selectQs = "SELECT Bezeichnung FROM Tag";
        try {
            ResultSet result = db.executeSelect(selectQs);
            List<String> tags = convertResultSetToList(result, "Bezeichnung");
            DefaultComboBoxModel<String> tagsComboBoxModel = new DefaultComboBoxModel<>(tags.toArray(new String[0]));
            cb_schlagwort.setModel(tagsComboBoxModel);// Populate cb_schlagwort combo box
            cb_Tags.setModel(tagsComboBoxModel);
        } catch (SQLException ex) {
            Logger.getLogger(GUI_HauptmenueJKS.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static List<String> convertResultSetToList(ResultSet resultSet, String columb) {
        List<String> dataList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                // Annahme: Die Spalte "name" enthält die anzuzeigenden Daten
                String data = resultSet.getString(columb);
                dataList.add(data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataList;
    }

    public GUI_HauptmenueJKS() {
        System.out.println("Init HM");
        System.out.println(SteuerungJKS.Username);
        initComponents();
        System.out.println("initComponents");
        initializeDBConnection();
        System.out.println("init DBConn");
        loadKategories();
        System.out.println("Load Katergories");
        loadTags();
        System.out.println("Load Tags");
        loadNotizen();
        System.out.println("Load Notizen");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_Notiz = new javax.swing.JTextArea();
        bt_add = new javax.swing.JButton();
        tf_Titel = new javax.swing.JTextField();
        cb_Kategorie = new javax.swing.JComboBox<>();
        cb_schlagwort = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        bt_Suche = new javax.swing.JButton();
        cb_search = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        ta_Note = new javax.swing.JTextArea();
        cb_Tags = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        bt_logout = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

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
        jScrollPane3.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jInternalFrame1.setVisible(true);
        jInternalFrame1.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ta_Notiz.setColumns(20);
        ta_Notiz.setRows(5);
        jScrollPane1.setViewportView(ta_Notiz);

        jInternalFrame1.getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 400, 170));

        bt_add.setText("Hinzufügen");
        bt_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_addActionPerformed(evt);
            }
        });
        jInternalFrame1.getContentPane().add(bt_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, 400, 70));

        tf_Titel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_TitelActionPerformed(evt);
            }
        });
        jInternalFrame1.getContentPane().add(tf_Titel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 280, -1));

        cb_Kategorie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_KategorieActionPerformed(evt);
            }
        });
        jInternalFrame1.getContentPane().add(cb_Kategorie, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 132, -1));

        cb_schlagwort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_schlagwortActionPerformed(evt);
            }
        });
        jInternalFrame1.getContentPane().add(cb_schlagwort, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 247, -1));

        jLabel1.setText("Tag (Schlagwort) wählen:");
        jInternalFrame1.getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 220, -1));

        jLabel2.setText("Kategorie wählen:");
        jInternalFrame1.getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 130, -1));

        jLabel3.setText("Titel der Notiz:");
        jInternalFrame1.getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 290, -1));

        jLabel4.setText("Beschreibung :");
        jInternalFrame1.getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 150, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setText("Neue Notiz erstellen:");
        jInternalFrame1.getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jTabbedPane1.addTab("Hinzufügen", jInternalFrame1);

        jInternalFrame2.setVisible(true);

        bt_Suche.setText("Suchen");
        bt_Suche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_SucheActionPerformed(evt);
            }
        });

        cb_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_searchActionPerformed(evt);
            }
        });

        ta_Note.setColumns(20);
        ta_Note.setRows(5);
        jScrollPane2.setViewportView(ta_Note);

        cb_Tags.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_TagsActionPerformed(evt);
            }
        });

        jLabel5.setText("Titel der Notiz");

        jLabel6.setText("Tag suche");

        bt_logout.setText("Logout");
        bt_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_logoutActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel8.setText("Meine Notizen durchsuchen und anzeigen");

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_Tags, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_search, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                        .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_Suche, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_logout, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35))
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cb_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(7, 7, 7)
                        .addComponent(cb_Tags, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bt_Suche, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(184, 184, 184))
        );

        jTabbedPane1.addTab("Anzeigen", jInternalFrame2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cb_TagsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_TagsActionPerformed

    }//GEN-LAST:event_cb_TagsActionPerformed

    private void cb_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_searchActionPerformed
        String saveNotiz = null;
        String notizID = (String) cb_search.getSelectedItem();
        System.out.println(notizID);

        if (notizID != null && !notizID.isEmpty()) {
            saveNotiz = notizID;
            fetchAndDisplayNoteData(notizID, SteuerungJKS.Username);
        } else if (saveNotiz != notizID) {
            notizID = (String) cb_search.getSelectedItem();
            System.out.println(notizID);

            if (notizID != null && !notizID.isEmpty()) {
                saveNotiz = notizID;
                fetchAndDisplayNoteData(notizID, null);
            }
        } else if (saveNotiz == notizID) {
            ta_Note.setText("");
        }
    }

    private void fetchAndDisplayNoteData(String notizID, String userID) {
        String selectN = "SELECT Notiz.Titel, Kategorie.Kategorien_name, Notiz.Inhalt, Tag.Bezeichnung "
                + "FROM Notiz "
                + "JOIN Kategorie ON Notiz.KategorieID = Kategorie.KategorieID "
                + "JOIN notiz_tag ON Notiz.NotizID = notiz_tag.NotizID "
                + "JOIN Tag ON notiz_tag.TagID = Tag.TagID "
                + "WHERE Notiz.Titel = ?"
                + (userID != null ? " AND Notiz.UserID = ?" : "");

        try (ResultSet result = userID != null
                ? db.executeSelectP(selectN, notizID, userID)
                : db.executeSelectP(selectN, notizID)) {

            if (result.next()) {
                String titel = result.getString("Titel");
                String kategorie = result.getString("Kategorien_name");
                String notiz = result.getString("Inhalt");
                String tags = result.getString("Bezeichnung");

                // Daten in einen String zusammenfassen
                String dataString = String.format("Titel: %s               Kategorie: %s               Tags: %s%n%nNotiz: %s",
                        titel, kategorie, tags, notiz);

                // Textbereich setzen
                ta_Note.setText(dataString);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GUI_HauptmenueJKS.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_cb_searchActionPerformed

    private void bt_SucheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_SucheActionPerformed
        try {
            // Die ausgewählte NotizID aus der Combobox erhalten
            String search = (String) cb_Tags.getSelectedItem(); // Assuming you have the Tag Bezeichnung in cb_Tags
            System.out.println(search);

            // SQL-Abfrage
            String selectN = "SELECT Notiz.Titel, Kategorie.Kategorien_name, Notiz.Inhalt, Tag.Bezeichnung "
                    + "FROM Notiz "
                    + "JOIN Kategorie ON Notiz.KategorieID = Kategorie.KategorieID "
                    + "JOIN notiz_tag ON Notiz.NotizID = notiz_tag.NotizID "
                    + "JOIN Tag ON notiz_tag.TagID = Tag.TagID "
                    + "WHERE Tag.Bezeichnung LIKE ?"
                    + "AND Notiz.UserID = ?";

            populateTitleComboBox(selectN, search, SteuerungJKS.Username);

        } catch (SQLException ex) {
            Logger.getLogger(GUI_HauptmenueJKS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void populateTitleComboBox(String query, String parameter ,String UID) throws SQLException {
        DefaultComboBoxModel<String> titelComboBoxModel = new DefaultComboBoxModel<>();

        try (ResultSet result = db.executeSelectP(query, parameter, UID)) {
            while (result.next()) {
                String titel = result.getString("Titel");
                titelComboBoxModel.addElement(titel); // Add each title to the combobox model
            }
        }

        cb_search.setModel(titelComboBoxModel); // Set the model to the combobox

    }//GEN-LAST:event_bt_SucheActionPerformed

    private void cb_schlagwortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_schlagwortActionPerformed
    }//GEN-LAST:event_cb_schlagwortActionPerformed

    private void cb_KategorieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_KategorieActionPerformed
    }//GEN-LAST:event_cb_KategorieActionPerformed

    private void tf_TitelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_TitelActionPerformed
    }//GEN-LAST:event_tf_TitelActionPerformed

    private void bt_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_addActionPerformed
        String titel = tf_Titel.getText();
        Object kategorie = cb_Kategorie.getSelectedItem(); // To get the selected item instead of index
        Object schlagwort = cb_schlagwort.getSelectedItem(); // To get the selected item instead of index
        String notiz = ta_Notiz.getText();

        String kategorieString = String.valueOf(kategorie);
        String schlagwortString = String.valueOf(schlagwort);

        // Print the values for debugging
        System.out.println("Titel: " + titel);
        System.out.println("Kategorie: " + kategorieString);
        System.out.println("Schlagwort: " + schlagwortString);
        System.out.println("Notiz: " + notiz);

        try {
            int kategorieId = getKategorieID(db, kategorieString);
            int schlagwortId = getSchlagwortID(db, schlagwortString);

            // Check if the title already exists
            String checkTitleQuery = "SELECT 1 FROM Notiz WHERE Titel = ?";
            try (ResultSet titleResult = db.executeSelectP(checkTitleQuery, titel)) {
                if (!titleResult.next()) {
                    // Title does not exist, proceed with insertion
                    String insertQuery = "INSERT INTO Notiz (Titel, Inhalt, KategorieID, Erstellungsdatum, UserID) VALUES (?, ?, ?, ?, ?)";
                    java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
                    int insertedId = db.executeInsert(insertQuery, titel, notiz, kategorieId, currentDate, SteuerungJKS.Username);
                    System.out.println(insertedId);
                    System.out.println("---------------------------------");

                    String insertTagQuery = "INSERT INTO notiz_tag (NotizID, TagID) VALUES (?, ?)";
                    int effected = db.executeInsertR(insertTagQuery, insertedId, schlagwortId);
                    System.out.println(effected);
                    System.out.println("--------------------------------");
                    loadNotizen();

                    String query = "SELECT NotizID FROM Notiz ORDER BY NotizID";
                    try (ResultSet resultC = db.executeSelect(query)) {
                        while (resultC.next()) {
                            int NotizID = resultC.getInt("NotizID");
                            System.out.println(NotizID);
                            System.out.println("---------");
                        }
                    }
                } else {
                    System.out.println("Dieser Titel wird bereits verwendet. Bitte wählen Sie einen anderen.");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(GUI_HauptmenueJKS.class.getName()).log(Level.SEVERE, "SQL Exception", ex);
        }
    }

    private static int getKategorieID(DBVerbindung db, String kategorieString) throws SQLException {
        String selectQk = "SELECT KategorieID FROM Kategorie WHERE Kategorien_name = ?";
        try (ResultSet result = db.executeSelectP(selectQk, kategorieString)) {
            if (result.next()) {
                return result.getInt("KategorieID");
            }
        }
        throw new SQLException("Kategorie not found: " + kategorieString);
    }

    private static int getSchlagwortID(DBVerbindung db, String schlagwortString) throws SQLException {
        String selectQs = "SELECT TagID FROM Tag WHERE Bezeichnung = ?";
        try (ResultSet result = db.executeSelectP(selectQs, schlagwortString)) {
            if (result.next()) {
                return result.getInt("TagID");
            }
        }
        throw new SQLException("Tag not found: " + schlagwortString);
    }//GEN-LAST:event_bt_addActionPerformed

    private void bt_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_logoutActionPerformed
        SteuerungJKS.hauptmenueSchließen();
        SteuerungJKS.Username = "";
        System.out.println(SteuerungJKS.Username);
        System.out.println("logout");
        clear();
        SteuerungJKS.login.setVisible(true);
    }//GEN-LAST:event_bt_logoutActionPerformed

    private void clear() {
        // Clear all text fields and combo boxes
        tf_Titel.setText("");
        ta_Notiz.setText("");
        cb_Kategorie.setSelectedIndex(-1); // Clear selection
        cb_schlagwort.setSelectedIndex(-1); // Clear selection
        cb_search.setSelectedIndex(-1); // Clear selection
        cb_Tags.setSelectedIndex(-1); // Clear selection

        // Clear the combo box models for Notizen
        cb_search.setModel(new DefaultComboBoxModel<>());
        ta_Note.setText("");
        SteuerungJKS.hauptmenueLoeschen();
        System.out.println("Alle Eingaben wurden gelöscht, Notizen wurden entfernt.");
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
            // Set the look and feel
            javax.swing.UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            System.err.println("Failed to initialize FlatDarkLaf");
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        try {
            javax.swing.UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            System.err.println("FlatDarkLaf konnte nicht initialisiert werden.");
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI_HauptmenueJKS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_Suche;
    private javax.swing.JButton bt_add;
    private javax.swing.JButton bt_logout;
    private javax.swing.JComboBox<String> cb_Kategorie;
    private javax.swing.JComboBox<String> cb_Tags;
    private javax.swing.JComboBox<String> cb_schlagwort;
    private javax.swing.JComboBox<String> cb_search;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea ta_Note;
    private javax.swing.JTextArea ta_Notiz;
    private javax.swing.JTextField tf_Titel;
    // End of variables declaration//GEN-END:variables
}

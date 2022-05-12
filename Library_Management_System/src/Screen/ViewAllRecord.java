/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Screen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bulentoral
 */
public class ViewAllRecord extends javax.swing.JFrame {

    DefaultTableModel model;

    public ViewAllRecord() {
        initComponents();
        setIssueBookDetailsToTable();

    }

    public void setIssueBookDetailsToTable() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from issue_book_details");

            while (rs.next()) {
                String ID = rs.getString("id");
                String bookName = rs.getString("book_name");
                String studentName = rs.getString("student_name");
                String issueDate = rs.getString("issue_date");
                String due_date = rs.getString("due_date");
                String status = rs.getString("status");

                Object[] obj = {ID, bookName, studentName, issueDate, due_date, status};
                model = (DefaultTableModel) table_issueBook_details.getModel();
                model.addRow(obj);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void clearTable() {

        DefaultTableModel model = (DefaultTableModel) table_issueBook_details.getModel();
        model.setRowCount(0);

    }

    // to fetch the record using date fields
    public void search() {

        java.util.Date uFromDate = date_fromDate.getDatoFecha();
        java.util.Date uToDate = date_toDate.getDatoFecha();

        Long l1 = uFromDate.getTime();
        long l2 = uToDate.getTime();

        java.sql.Date fromDate = new java.sql.Date(l1);
        java.sql.Date toDate = new java.sql.Date(l2);

        try {

            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM issue_book_details where issue_date BETWEEN ? AND ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setDate(1, fromDate);
            pst.setDate(2, toDate);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                while (rs.next()) {
                    String ID = rs.getString("id");
                    String bookName = rs.getString("book_name");
                    String studentName = rs.getString("student_name");
                    String issueDate = rs.getString("issue_date");
                    String due_date = rs.getString("due_date");
                    String status = rs.getString("status");

                    Object[] obj = {ID, bookName, studentName, issueDate, due_date, status};
                    model = (DefaultTableModel) table_issueBook_details.getModel();
                    model.addRow(obj);
                    System.out.println("girdi");
                    System.out.println("ID");
                }
                

            } else {
                JOptionPane.showMessageDialog(this, "No Record Found!");
            }

        } catch (Exception e) {
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        date_fromDate = new rojeru_san.componentes.RSDateChooser();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        date_toDate = new rojeru_san.componentes.RSDateChooser();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_issueBook_details = new rojeru_san.complementos.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 28)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel12.setText("   View All Record");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, 370, 110));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 7, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, 460, 7));

        date_fromDate.setColorBackground(new java.awt.Color(255, 51, 51));
        date_fromDate.setColorForeground(new java.awt.Color(255, 51, 51));
        date_fromDate.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        date_fromDate.setPlaceholder("Select Issue Date");
        jPanel1.add(date_fromDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 310, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Issue Date :");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 110, 30));

        jLabel19.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Due Date :");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 180, 110, 30));

        date_toDate.setColorBackground(new java.awt.Color(255, 51, 51));
        date_toDate.setColorForeground(new java.awt.Color(255, 51, 51));
        date_toDate.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        date_toDate.setPlaceholder("Select Due Date");
        jPanel1.add(date_toDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 180, 310, -1));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle1.setText("All");
        rSMaterialButtonCircle1.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 170, 140, 60));

        jLabel2.setBackground(new java.awt.Color(255, 51, 51));
        jLabel2.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("X");
        jLabel2.setOpaque(true);
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1380, 0, 100, 50));

        jPanel3.setBackground(new java.awt.Color(255, 51, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel1.setText("Back");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 50));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle2.setText("Search");
        rSMaterialButtonCircle2.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 170, 140, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1480, 280));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_issueBook_details.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                " ID", "Book Name", "Student Name", "Issue Date", "Due Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_issueBook_details.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        table_issueBook_details.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        table_issueBook_details.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        table_issueBook_details.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        table_issueBook_details.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        table_issueBook_details.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        table_issueBook_details.setIntercellSpacing(new java.awt.Dimension(0, 0));
        table_issueBook_details.setRowHeight(40);
        table_issueBook_details.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_issueBook_detailsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_issueBook_details);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 1380, 330));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 1480, 580));

        setSize(new java.awt.Dimension(1481, 857));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void table_issueBook_detailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_issueBook_detailsMouseClicked


    }//GEN-LAST:event_table_issueBook_detailsMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
        clearTable();
        setIssueBookDetailsToTable();
        
        
        

    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked

        HomePage home = new HomePage();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        if(date_fromDate.getDatoFecha()!= null && date_toDate.getDatoFecha()!= null){
            clearTable();
            search();
        }
        else{
            JOptionPane.showMessageDialog(this, "Please Select Date");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewAllRecord().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.componentes.RSDateChooser date_fromDate;
    private rojeru_san.componentes.RSDateChooser date_toDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojeru_san.complementos.RSTableMetro table_issueBook_details;
    // End of variables declaration//GEN-END:variables
}
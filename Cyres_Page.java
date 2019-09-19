package Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */


public class Cyres_Page extends javax.swing.JFrame {

    /**
     * Creates new form Cyres_Page
     */
    String uname;
    Connection conn = null;
    PreparedStatement pst =null;
    ResultSet rs =null;
    
    
    public Cyres_Page(){
        initComponents();
        conn=Conn.getConnection();
        DefaultTableModel model = new DefaultTableModel(new String[]{"DOI", "PaperName", "Domain","Citations","P_DOP","Conference_Name"}, 0);
        
        try {
            String q="SELECT * FROM login.papers";
            PreparedStatement pst = conn.prepareStatement(q);
            ResultSet rs = pst.executeQuery();
            while(rs.next())
            {
                int DOI = rs.getInt(1);
                String pname = rs.getString(2);
                String domain = rs.getString(3);
                int citations = rs.getInt(4);
                String P_DOP = rs.getString(5);
                String conf =rs.getString(6);
                model.addRow(new Object[]{DOI,pname,domain,citations,P_DOP,conf});
            }
            
            jTable2.setModel(model);
            
            } catch (Exception e) {
            e.printStackTrace();
        }
        
       
        
        String sql ="select *  from login.user where Username='"+gbl.username+"';";
        int id=0,citations=0,h_index=0;
        String dept =null;
        
        try
        {
            
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next())
            {
                id=rs.getInt(1);
                dept=rs.getString(4);
                citations=rs.getInt(6);
                h_index=rs.getInt(7);
                
            }
            UserName.setText(gbl.username);
            uid.setText(""+id);
            department.setText(dept);
            Citations.setText(""+citations);
            H_index.setText(""+h_index);
            
                        
        }
        catch(Exception e)
        {
            e.printStackTrace();
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
        jLabel1 = new javax.swing.JLabel();
        lbl1 = new javax.swing.JLabel();
        seach_paper_button = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        mypublicbutton = new javax.swing.JButton();
        myrefer_button = new javax.swing.JButton();
        journal_button = new javax.swing.JButton();
        txt1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        c1 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        Citations = new javax.swing.JTextField();
        H_index = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        UserName = new javax.swing.JTextField();
        uid = new javax.swing.JTextField();
        department = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Nirmala UI", 1, 36)); // NOI18N
        jLabel1.setText("C Y R E S");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, -1, -1));

        lbl1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl1.setText("Search for papers --->");
        jPanel1.add(lbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, 195, 35));

        seach_paper_button.setBackground(new java.awt.Color(0, 255, 255));
        seach_paper_button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        seach_paper_button.setText("Search");
        seach_paper_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seach_paper_buttonActionPerformed(evt);
            }
        });
        jPanel1.add(seach_paper_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 190, 130, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("User Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 69, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("ID");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, -1, -1));

        mypublicbutton.setBackground(new java.awt.Color(255, 204, 204));
        mypublicbutton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mypublicbutton.setForeground(new java.awt.Color(0, 0, 204));
        mypublicbutton.setText("MY PUBLICATIONS");
        mypublicbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mypublicbuttonActionPerformed(evt);
            }
        });
        jPanel1.add(mypublicbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, 37));

        myrefer_button.setBackground(new java.awt.Color(255, 204, 204));
        myrefer_button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        myrefer_button.setForeground(new java.awt.Color(255, 102, 0));
        myrefer_button.setText("MY REFERENCES");
        myrefer_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myrefer_buttonActionPerformed(evt);
            }
        });
        jPanel1.add(myrefer_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 169, 40));

        journal_button.setBackground(new java.awt.Color(255, 204, 204));
        journal_button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        journal_button.setForeground(new java.awt.Color(51, 204, 0));
        journal_button.setText("JOURNALS");
        journal_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                journal_buttonActionPerformed(evt);
            }
        });
        jPanel1.add(journal_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 169, 33));

        txt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt1ActionPerformed(evt);
            }
        });
        jPanel1.add(txt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 140, 193, 35));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Department");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Citations");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 63, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("H_index");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        c1.setBackground(new java.awt.Color(102, 255, 255));
        c1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        c1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BY DOI", "BY NAME", "BY DOMAIN", " " }));
        c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c1ActionPerformed(evt);
            }
        });
        jPanel1.add(c1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 90, 190, 35));
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 90, -1, -1));

        Citations.setEditable(false);
        jPanel1.add(Citations, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 63, -1));

        H_index.setEditable(false);
        jPanel1.add(H_index, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 50, -1));
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 160, -1, -1));

        UserName.setEditable(false);
        UserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserNameActionPerformed(evt);
            }
        });
        jPanel1.add(UserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 70, -1));

        uid.setEditable(false);
        jPanel1.add(uid, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 40, -1));

        department.setEditable(false);
        jPanel1.add(department, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 70, -1));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "DOI", "Paper Name", "Domain", "Citations", "P_DOP", "Conference_Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 620, 190));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 562));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mypublicbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mypublicbuttonActionPerformed
        // TODO add your handling code here:
        new MyPublications().setVisible(true);
    }//GEN-LAST:event_mypublicbuttonActionPerformed

    private void seach_paper_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seach_paper_buttonActionPerformed
    if(c1.getSelectedIndex()==0){
        gbl.t1_r1=Integer.parseInt(txt1.getText());
        gbl.choice=0;}
    else if(c1.getSelectedIndex()==1){
            gbl.t1_r2=txt1.getText();
          
            gbl.choice=1;}
    else if(c1.getSelectedIndex()==2){
            
             gbl.t1_r3=txt1.getText();
             gbl.choice=2;   }
    else JOptionPane.showMessageDialog(rootPane,"INCORRECT CHOICE");
        
        
              
                // TODO add your handling code here:
        new Search_paper().setVisible(true);
    }//GEN-LAST:event_seach_paper_buttonActionPerformed

    private void myrefer_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myrefer_buttonActionPerformed
        // TODO add your handling code here:
        new MyReferences().setVisible(true);
    }//GEN-LAST:event_myrefer_buttonActionPerformed

    private void journal_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_journal_buttonActionPerformed
        // TODO add your handling code here:
        new Journals().setVisible(true);
    }//GEN-LAST:event_journal_buttonActionPerformed

    private void c1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c1ActionPerformed
        if(c1.getSelectedIndex()==0)
        lbl1.setText("ENTER DOI ");
        else if(c1.getSelectedIndex()==1){
            lbl1.setText("ENTER PAPER NAME ");}
            //gbl.t1_r2=txt1.getText();}
        else if(c1.getSelectedIndex()==2)
        {lbl1.setText("ENTER DOMAIN ");}
             //gbl.t1_r3=txt1.getText();
        
        // TODO add your handling code here:
    }//GEN-LAST:event_c1ActionPerformed

    private void UserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserNameActionPerformed

    private void txt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txt1ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        
        
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        int index = jTable2.getSelectedRow();
        System.out.println(""+index);
        gbl.t1_r4=(int)model.getValueAt(index, 3);
        gbl.ref_citations=gbl.t1_r4;
        gbl.ref_id=(int)model.getValueAt(index, 0);
        gbl.ref_name=model.getValueAt(index, 1).toString();
        gbl.ref_domain=model.getValueAt(index, 2).toString();
        gbl.ref_jname=model.getValueAt(index, 5).toString();
        gbl.ref_DOP=model.getValueAt(index,4).toString();
        System.out.println(""+gbl.t1_r4);
        gbl.t1_r4++;
        model.setValueAt(gbl.t1_r4, index,3);
        new MyReferences().setVisible(false);
         
    }//GEN-LAST:event_jTable2MouseClicked

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
            java.util.logging.Logger.getLogger(Cyres_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cyres_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cyres_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cyres_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cyres_Page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Citations;
    private javax.swing.JTextField H_index;
    private javax.swing.JTextField UserName;
    private javax.swing.JComboBox<String> c1;
    private javax.swing.JTextField department;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton journal_button;
    private javax.swing.JLabel lbl1;
    private javax.swing.JButton mypublicbutton;
    private javax.swing.JButton myrefer_button;
    private javax.swing.JButton seach_paper_button;
    private javax.swing.JTextField txt1;
    private javax.swing.JTextField uid;
    // End of variables declaration//GEN-END:variables
}
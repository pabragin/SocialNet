/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import ServiceLayer.ReadXML;
import ServiceLayer.ReadXML.LengthCity;
import business.User;
import java.util.ArrayList;

/**
 *
 * @author Brasha
 */
public class AboutUserJPanel extends javax.swing.JPanel {

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelID = new javax.swing.JLabel();
        jLabelFName = new javax.swing.JLabel();
        jLabelLName = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabelCity = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLabelAbout = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabelLength = new javax.swing.JLabel();

        jLabelID.setText("ID");

        jLabelFName.setText("Name");

        jLabelLName.setText("LName");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("ID пользователя:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Имя:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Фамилия:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Город:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("О пользователе:");

        jLabelCity.setText("City");

        jLabelAbout.setColumns(20);
        jLabelAbout.setEditable(false);
        jLabelAbout.setRows(5);
        jScrollPane1.setViewportView(jLabelAbout);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("До пользователя:");

        jLabelLength.setText("length");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelLName)
                                    .addComponent(jLabelFName)
                                    .addComponent(jLabelID)
                                    .addComponent(jLabelCity)))
                            .addComponent(jLabel8)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelLength)))
                        .addGap(0, 54, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelID)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabelFName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabelLName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabelCity))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelLength))
                .addContainerGap(27, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextArea jLabelAbout;
    private javax.swing.JLabel jLabelCity;
    private javax.swing.JLabel jLabelFName;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelLName;
    private javax.swing.JLabel jLabelLength;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

     /**
     * Creates new form NewJPanel
     */
    public AboutUserJPanel() {
        initComponents();
        setBounds(10,20,220,250);
        jLabel1.setVisible(false);
        jLabelLength.setVisible(false);
    }
    
    public void addContent(User user)
    {
        jLabelID.setText(String.valueOf(user.getID()));
        jLabelFName.setText(user.getFirstName());
        jLabelLName.setText(user.getLastName());
        jLabelCity.setText(user.getCity());
        jLabelAbout.setText(user.getAbout());
        jLabel1.setVisible(false);
        jLabelLength.setVisible(false);
    }
    
    public void addLength(User current, User view)
    {
        ReadXML rxml = new ReadXML();
        if(rxml.lengthExist(current, view))
        {
            jLabelLength.setText(String.valueOf(rxml.getLength(current, view)) + "км");
            jLabel1.setVisible(true);
            jLabelLength.setVisible(true);
        }
    }
}
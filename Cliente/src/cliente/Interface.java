/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.awt.event.KeyEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Humberto Lugo Aguilar
 */
public class Interface extends javax.swing.JFrame{
    
    //Un socket es la combinacion de una dir ip con un puerto.
    private Socket socket;
    
    
    /*Canales de comunicacion "espacio de memoria entre usuario/servidor.
      canal entrada, canal salida
      bits*/
    private InputStream inputStream;
    private OutputStream outputStream;
    
    //variables primitivas de java
    private DataInputStream entradaDatos;
    private DataOutputStream salidaDatos;
    
    
    String comando="", ejecutar ="", nickname ="";
    boolean envioNickname = false;
    
    public Interface() {
        initComponents();
        
        
         
      
    }
    
   

    
    public void conexion(int puerto, String host, String nickname){
        /* host=ip puerto=puerto al que se conectara  */
        try {
            socket = new Socket(host, puerto);
            this.nickname = nickname;
            lbNick.setText(this.nickname);
            startThread();
        } catch (IOException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    public void recibeDatos(){
        
        try {
            inputStream = socket.getInputStream();
            entradaDatos = new DataInputStream(inputStream);
            //System.out.println("RECIBEDATOS INTERFACE"+entradaDatos.readUTF());
            
            agregarMsg(entradaDatos.readUTF());
        } catch (IOException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    
    public void enviaDatos(){
        
        try {
            outputStream = socket.getOutputStream();
            salidaDatos = new DataOutputStream(outputStream);
            
            salidaDatos.writeUTF(comando+"/"+ejecutar);
            salidaDatos.flush();
             System.out.println("Se envio esto: "+comando+"/"+ejecutar);
            
        } catch (IOException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
   
    public void startThread(){
        System.out.println(inputStream);
        
        Thread hiloServer = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    recibeDatos();
                    
                    
                }
                
            }
        });
        hiloServer.start();   
    }
    
    public void agregarMsg(String msg){
        
        if(txtAreaMsg.getText().equals("")){
            txtAreaMsg.setText(msg);
            txtMsg.setText("");
        }else{
            txtAreaMsg.append("\n"+msg);
            txtMsg.setText("");
            
        
        }
        
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaMsg = new javax.swing.JTextArea();
        btnEnviar = new javax.swing.JButton();
        txtMsg = new javax.swing.JTextField();
        lTittle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbNick = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtAreaMsg.setColumns(20);
        txtAreaMsg.setRows(5);
        txtAreaMsg.setFocusable(false);
        jScrollPane1.setViewportView(txtAreaMsg);

        btnEnviar.setText("Send");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        txtMsg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMsgActionPerformed(evt);
            }
        });
        txtMsg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMsgKeyPressed(evt);
            }
        });

        lTittle.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        lTittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lTittle.setText("TPA SimpleChat!");

        jLabel1.setText("Wellcome: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtMsg)
                        .addGap(18, 18, 18)
                        .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
            .addComponent(lTittle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(lbNick, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbNick, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lTittle)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
      
      
       if(envioNickname == false){
           this.comando = "nick";
           this.ejecutar = this.nickname;
           enviaDatos();
           
           envioNickname = true;
       }
       
       this.comando="msg";
       
       this.ejecutar = txtMsg.getText();
        enviaDatos();
        
        if(txtAreaMsg.getText().equals("")){
            txtAreaMsg.setText("You: "+txtMsg.getText());
            txtMsg.setText("");
        }else{
            txtAreaMsg.append("\nYou: "+txtMsg.getText());
            txtMsg.setText("");
            
        
        }
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void txtMsgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMsgActionPerformed
        
        
    }//GEN-LAST:event_txtMsgActionPerformed

    private void txtMsgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMsgKeyPressed
        //System.out.println(KeyEvent.VK_ENTER);
        //System.out.println(evt.getKeyCode());
        if(KeyEvent.VK_ENTER == evt.getKeyCode()){
            btnEnviar.doClick();
        }
    }//GEN-LAST:event_txtMsgKeyPressed

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
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new Interface().setVisible(true);
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lTittle;
    private javax.swing.JLabel lbNick;
    private javax.swing.JTextArea txtAreaMsg;
    private javax.swing.JTextField txtMsg;
    // End of variables declaration//GEN-END:variables

    

    
}

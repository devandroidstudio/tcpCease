/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package abc2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.text.Normalizer;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

/**
 *
 * @author vomin
 */
public class frmClient extends javax.swing.JFrame {

    /**
     * Creates new form frmClient
     */
    static Socket client;
    static ObjectOutputStream objectOutputStream;
    static OutputStream outputStream;
    static ObjectInputStream objectInputStream;
//    static DataInputStream dataInputStream;
//    static DataOutputStream dataOutputStream;
    static Ceasar ceasar = new Ceasar();
    static Pattern pattern = Pattern.compile("^[0-9]{1,5}+$", Pattern.CASE_INSENSITIVE);
    static Pattern pattern2 = Pattern.compile("^[a-zA-Z \\s]+$", Pattern.CASE_INSENSITIVE);
    public frmClient() {
        initComponents();
    }

    public boolean checkDigit(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                txtEnter.setText("");
                return false;
            }

        }
        return true;
    }

    public String removeAccent(String s) {

        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        System.out.println(temp);
        System.out.println(pattern.matcher(temp).replaceAll(""));
        return pattern.matcher(temp).replaceAll("");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fcPath = new javax.swing.JFileChooser();
        txtEnter = new javax.swing.JTextField();
        btnSend = new javax.swing.JButton();
        txtkey = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAShow = new javax.swing.JTextArea();
        txtPath = new javax.swing.JTextField();
        btnPath = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtEnter.setText("nguyen van a");

        btnSend.setText("Send");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        txtkey.setText("3");

        txtAShow.setColumns(20);
        txtAShow.setRows(5);
        jScrollPane2.setViewportView(txtAShow);

        btnPath.setText("Path");
        btnPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPathActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(txtkey, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSend))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(txtPath, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(btnPath)))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPath))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEnter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSend)
                    .addComponent(txtkey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        // TODO add your handling code here:

        try {
//            while (!txtEnter.getText().isEmpty()) {                
//              
//            }
            String str = "";
            str = removeAccent(txtEnter.getText().replace("\\s+", " ").trim());
            System.out.println(str);
            int key = Integer.parseInt(txtkey.getText().trim());
            if (checkDigit(str) && pattern2.matcher(str).find() && key >= 1 && key <= 25) {
//                int key = 0;
//                key = Integer.parseInt(txtkey.getText().trim());
                ceasar.Nhap(str, key);
//            System.out.println(ceasar.MaHoa());
                String tcode = ceasar.MaHoa();
            System.out.println("tcode: "+tcode);
                Texts t = new Texts(tcode, key);
                ceasar.clean();
                objectOutputStream.writeObject(t);
                objectOutputStream.flush();
                txtEnter.setText("");
                System.out.println(t.getStr());
              
            } else {
                JOptionPane.showMessageDialog(this, "Vui long nhap lai");
            }

//            dataOutputStream.writeUTF(str);
//            dataOutputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnSendActionPerformed

    private void btnPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPathActionPerformed
        // TODO add your handling code here:
        this.fcPath.setVisible(true);
        if (this.fcPath.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                txtPath.setText(fcPath.getSelectedFile().getCanonicalPath());
                if (!txtPath.getText().isEmpty()) {
                    FileReader fr = new FileReader(new File(txtPath.getText().trim()));
                       BufferedReader br = new BufferedReader(fr);
                       String line = "";
                       while (true) {
                            line = br.readLine();
                           if(line.isEmpty())
                           {
                               break;
                           }
                           System.out.println(line);
                        
                         txtEnter.setText(txtEnter.getText() + " " +line);
                         
                       
                    }
                      
                }

            } catch (Exception e) {
                
            }
        }


    }//GEN-LAST:event_btnPathActionPerformed

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
            java.util.logging.Logger.getLogger(frmClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmClient().setVisible(true);
            }
        });

        try {
            client = new Socket("localhost", 8888);

            outputStream = client.getOutputStream();
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectInputStream = new ObjectInputStream(client.getInputStream());
            while (true) {                
                 List<Texts> listOfText = (List<Texts>) objectInputStream.readObject();
            listOfText.forEach((txt) -> txtAShow.setText(txtAShow.getText().trim() + "\n" + " Chu : " + txt.getStr() + " lan xuat hien: " + txt.getKey()));
                
            }
//           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPath;
    private javax.swing.JButton btnSend;
    private javax.swing.JFileChooser fcPath;
    private javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JTextArea txtAShow;
    private static javax.swing.JTextField txtEnter;
    private javax.swing.JTextField txtPath;
    private javax.swing.JTextField txtkey;
    // End of variables declaration//GEN-END:variables
}
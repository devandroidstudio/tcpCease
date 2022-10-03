/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package abc2;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author vomin
 */
public class frmServer extends javax.swing.JFrame {

    /**
     * Creates new form frmServer
     */
    static ServerSocket serverSocket;
    static Socket client;
    static ObjectInputStream objectInputStream;
    static ObjectOutputStream objectOutputStream;
    static Ceasar ceasar = new Ceasar();
    static DataInputStream dataInputStream;

    public frmServer() {
        initComponents();
    }

    private static List<Texts> countCharInArray(String str) {
          List<Texts> listText = new ArrayList<>();
                int count = 0;

                Map<String, Integer> map = new HashMap<String, Integer>();

                

                System.out.println(str);
                char temp;
                char[] ch = str.toCharArray();//abc => [a,b,c]
                System.out.println("ky tu" + Arrays.toString(ch));
                for (char c : ch) {

                    for (int i = 0; i < ceasar.GiaiMa().length(); i++) {
                        System.out.println(ceasar.GiaiMa());
                        temp = ceasar.GiaiMa().charAt(i);
                        System.out.println(temp);
                        if (temp == c) {
                            count++;

                        }
                    }
                    map.put(String.valueOf(c), count);
                    count = 0;
                }
                for (String key : map.keySet()) {
                    System.out.println(key + "" + map.get(key));
                    listText.add(new Texts(key, map.get(key)));
                }
                return listText;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        txtAShow = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtAShow.setColumns(20);
        txtAShow.setRows(5);
        txtAShow.setFocusable(false);
        jScrollPane2.setViewportView(txtAShow);

        jLabel1.setText("Thong tin nhan tu client");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws Exception {
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
            java.util.logging.Logger.getLogger(frmServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmServer().setVisible(true);
            }
        });

        try {

            serverSocket = new ServerSocket(8888);
            client = serverSocket.accept();
            System.out.println("Server have been connected with client");
            objectInputStream = new ObjectInputStream(client.getInputStream());
            objectOutputStream = new ObjectOutputStream(client.getOutputStream());
            while (true) {
                Texts t = (Texts) objectInputStream.readObject();
                System.out.println(t.getStr());
                ceasar.WirteData(t.getStr(), t.getKey());
                if(!t.getStr().isEmpty())
                {
                    txtAShow.setText(txtAShow.getText()+ "\n" + "Chuoi moi");
                }
                txtAShow.setText(txtAShow.getText() + "\n" + "Chuoi ma hoa: " + t.getStr() + " and key:  " + t.getKey());
                txtAShow.setText(txtAShow.getText() + "\n" + "Chuoi giai ma: " + ceasar.GiaiMa() + " and key:  " + t.getKey());
                
                objectOutputStream.writeObject(countCharInArray(ceasar.GiaiMa().replace(" ", "")));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JTextArea txtAShow;
    // End of variables declaration//GEN-END:variables
}

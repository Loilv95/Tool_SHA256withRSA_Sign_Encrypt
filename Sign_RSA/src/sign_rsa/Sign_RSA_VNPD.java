/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sign_rsa;

import java.security.KeyFactory;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

/**
 *
 * @author levietloi
 */
public class Sign_RSA_VNPD extends javax.swing.JFrame {

    /**
     * Creates new form Sign_RSA_VNPD
     */
    public Sign_RSA_VNPD() {
	initComponents();
	btnDecrypt.setEnabled(false);
	
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnEncrypt = new javax.swing.JButton();
        btnDecrypt = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        txtPrivateKey = new javax.swing.JTextField();
        txtPublicKey = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tool Sign SHA256withRSA");
        setBackground(new java.awt.Color(255, 255, 204));
        setResizable(false);

        jLabel1.setText("Data sign:");

        btnEncrypt.setText("Encrypt_RSA");
        btnEncrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncryptActionPerformed(evt);
            }
        });

        btnDecrypt.setText("Decrypt_RSA");

        jLabel2.setText("Private Key:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel3.setText("Public Key: ");

        txtData.setFont(new java.awt.Font("Lucida Bright", 0, 13)); // NOI18N

        txtPrivateKey.setFont(new java.awt.Font("Lucida Bright", 0, 13)); // NOI18N

        txtPublicKey.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N

        jLabel4.setText("Encrypt/Decrypt");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(38, 38, 38)
                            .addComponent(txtData))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(30, 30, 30)
                            .addComponent(txtPrivateKey, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(30, 30, 30)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnEncrypt)
                                    .addGap(43, 43, 43)
                                    .addComponent(btnDecrypt))
                                .addComponent(txtPublicKey, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPrivateKey, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPublicKey, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDecrypt)
                    .addComponent(btnEncrypt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEncryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncryptActionPerformed
	jTextArea1.setText("");
	String dataSign = txtData.getText();
	String privateKey = txtPrivateKey.getText();
	String encryptKey = encryptRSA(dataSign, privateKey);
	//jTextArea1.setColumns(20); set số cột mặc định, nếu lớn hơn chiều rộng thì thanh cuộn ngang sẽ xuất hiện mặc dù không có text
//        jTextArea1.setLineWrap(true); //thiết lập tự động xuống dòng => Thanh cuộn ngang sẽ không bao giờ xuất hiện nhưng từ bị ngắt.
        //jTextArea1.setRows(5); set số dòng mặc định, nếu hơn chiều cao thì thanh cuộn dọc sẽ xuất hiện mặc dù không có text
//        jTextArea1.setWrapStyleWord(true);//thiết lập khi hết dòng sẽ ngắt từ, không phải ngắt ký tự như chỉ dùng setLineWrap(true);
	jTextArea1.append("Encrypt: " + encryptKey );
	
    }//GEN-LAST:event_btnEncryptActionPerformed
    
    public static String encryptRSA(String data, String privateKey) {
	try {

	    String realPK = privateKey.replaceAll("-----END PRIVATE KEY-----", "")
			    .replaceAll("-----BEGIN PRIVATE KEY-----", "").replaceAll("\n", "").replaceAll(" ", "");
	    
	    byte[] b1 = Base64.getDecoder().decode(realPK);
	    PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(b1);
	    KeyFactory kf = KeyFactory.getInstance("RSA");

	    Signature rsa = Signature.getInstance("SHA256withRSA");
	    rsa.initSign(kf.generatePrivate(spec));
	    rsa.update(data.getBytes());

    //			BASE64Encoder encoder = new BASE64Encoder();

	    byte[] encodedBytes = Base64.getEncoder().encode(rsa.sign());
	    System.out.println("encodedBytes: " + new String(encodedBytes));
    //	byte[] decodedBytes = Base64.getDecoder().decode(encodedBytes);
    //	System.out.println("decodedBytes " + new String(decodedBytes));

	    return new String(encodedBytes);
	} catch (Exception e) {
		System.out.println(e);
	}
	return "";
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
	} catch (ClassNotFoundException ex) {
	    java.util.logging.Logger.getLogger(Sign_RSA_VNPD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (InstantiationException ex) {
	    java.util.logging.Logger.getLogger(Sign_RSA_VNPD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (IllegalAccessException ex) {
	    java.util.logging.Logger.getLogger(Sign_RSA_VNPD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (javax.swing.UnsupportedLookAndFeelException ex) {
	    java.util.logging.Logger.getLogger(Sign_RSA_VNPD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	//</editor-fold>

	/* Create and display the form */
	java.awt.EventQueue.invokeLater(new Runnable() {
	    public void run() {
		new Sign_RSA_VNPD().setVisible(true);
	    }
	});
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDecrypt;
    private javax.swing.JButton btnEncrypt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtPrivateKey;
    private javax.swing.JTextField txtPublicKey;
    // End of variables declaration//GEN-END:variables
}

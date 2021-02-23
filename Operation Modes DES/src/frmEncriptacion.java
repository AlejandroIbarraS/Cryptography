import java.util.*;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
/**
 *
 * @author Alex Ibarra
 */
public class frmEncriptacion extends javax.swing.JFrame {
    File fichero;
    int tamCabecera = 54; //Tamaño cabecera bmp es 54 bytes
    byte [] data = null;
    byte [] cabecera = new byte[tamCabecera];
    byte [] datos=null;
    byte [] resultado=null;
    byte [] llave = null;
    String nombre;
            
            
    /**
     * Creates new form frmEncriptacion
     */
    public frmEncriptacion() {
        initComponents();
        cboModoDescifrado.setVisible(false);
        txtVector.setEnabled(false);
        rdbVector.setVisible(false);
        txtVector.setVisible(false);
        lblVector.setVisible(false);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtRutaEntrada = new javax.swing.JTextField();
        cboOperacion = new javax.swing.JComboBox();
        btnBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblFrase = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnEjecutar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtLlave = new javax.swing.JTextField();
        cboModoCifrado = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        cboModoDescifrado = new javax.swing.JComboBox();
        rdbVector = new javax.swing.JRadioButton();
        lblVector = new javax.swing.JLabel();
        txtVector = new javax.swing.JTextField();
        lblMensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtRutaEntrada.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(txtRutaEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 650, 40));

        cboOperacion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cboOperacion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cifrar", "Descifrar" }));
        cboOperacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboOperacionActionPerformed(evt);
            }
        });
        getContentPane().add(cboOperacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 250, 50));

        btnBuscar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 130, 160, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("MODOS DE OPERACIÓN CON DES");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, -1, 40));

        lblFrase.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblFrase.setText("Introduce la frase llave:");
        getContentPane().add(lblFrase, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Ingrese la ruta del archivo:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        btnSalir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 520, 160, 40));

        btnEjecutar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnEjecutar.setText("Ejecutar");
        btnEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjecutarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEjecutar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 520, 160, 40));

        btnLimpiar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 520, 160, 40));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 520, 40, 60));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Selecciona la operación a realizar:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, -1, -1));

        txtLlave.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(txtLlave, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 820, 40));

        cboModoCifrado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cboModoCifrado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ECB", "CBC", "CFB", "OFB", "Todos" }));
        cboModoCifrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboModoCifradoActionPerformed(evt);
            }
        });
        getContentPane().add(cboModoCifrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 240, 250, 50));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Seleccionar modo de operacion:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, -1, -1));

        cboModoDescifrado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cboModoDescifrado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ECB", "CBC", "CFB", "OFB" }));
        cboModoDescifrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboModoDescifradoActionPerformed(evt);
            }
        });
        getContentPane().add(cboModoDescifrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 240, 250, 50));

        rdbVector.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rdbVector.setText("Ingresar vector inicial (usado para cifrar dos veces con OFB)");
        rdbVector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbVectorActionPerformed(evt);
            }
        });
        getContentPane().add(rdbVector, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 410, -1, 30));

        lblVector.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblVector.setText("Introduzca la frase del vector (8 carácteres):");
        getContentPane().add(lblVector, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, -1, 20));

        txtVector.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(txtVector, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 460, 480, 40));

        lblMensaje.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblMensaje.setText("El vector inicial se genera automáticamente, ¡No te preocupes!");
        getContentPane().add(lblMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 450, -1, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("C:\\Users\\alexi\\Desktop"));
        int seleccion = fileChooser.showOpenDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION){
           fichero = fileChooser.getSelectedFile();
           txtRutaEntrada.setText(fichero.getPath());
           nombre=fichero.getAbsolutePath().replace(".bmp","");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutarActionPerformed
        //Ejecucion de cifrado o descifrado
        obtenerDatosImagen();
        
        if(txtLlave.getText().length()<8){
            JOptionPane.showMessageDialog(this, "La llave debe tener al menos 8 caracteres","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(txtVector.getText().length()!=8 && rdbVector.isSelected() && cboOperacion.getSelectedIndex()==0 && cboModoCifrado.getSelectedIndex()==3){
            JOptionPane.showMessageDialog(this, "El vector inicial debe tener longitud de 8","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
            //Se obtienen los bits de la llave
        llave = txtLlave.getText().getBytes();
        //Se verifica la opción del usuario
        if (cboOperacion.getSelectedIndex() == 0) {
            //Cifrado
            switch (cboModoCifrado.getSelectedIndex()) {
                case 0:
                    cifrarECB();
                    break;
                case 1:
                    cifrarCBC();
                    break;
                case 2:
                    cifrarCFB();
                    break;
                case 3:
                    cifrarOFB();
                    break;
                case 4:
                    cifrarECB();
                    cifrarCBC();
                    cifrarCFB();
                    cifrarOFB();
                    break;
            }
            JOptionPane.showMessageDialog(this, "Cifrado exitoso", "Éxito", 1);
        } else {
            //Descifrado
            switch (cboModoDescifrado.getSelectedIndex()) {
                case 0:
                    descifrarECB();
                    break;
                case 1:
                    descifrarCBC();
                    break;
                case 2:
                    descifrarCFB();
                    break;
                case 3:
                    descifrarOFB();
                    break;
            }
            JOptionPane.showMessageDialog(this, "Descifrado exitoso", "Éxito", 1);
        }  
    }//GEN-LAST:event_btnEjecutarActionPerformed

   
    private void cifrarECB(){
        try{
            Cipher cifradorDES;
            byte[] cifrado;
            //Se obtiene el cifrador DES con el modo ECB
            cifradorDES = Cipher.getInstance("DES/ECB/NoPadding");
            //cifradorDES = Cipher.getInstance("DES/ECB/PKCS5Padding");
            //Se genera la llave a partir de los bytes que ingresa el usuario 
            KeySpec ks = new DESKeySpec(llave);
            SecretKeyFactory kf = SecretKeyFactory.getInstance("DES");
            SecretKey llaveSecreta = kf.generateSecret(ks);
            //Se coloca el cifrador en modo de cifrado
            cifradorDES.init(Cipher.ENCRYPT_MODE, llaveSecreta);
            //Se cifran los datos
            cifrado = cifradorDES.doFinal(datos);
            //Se juntan los datos cifrados con la cabecera de los archivos BMP
            //resultado = new byte[cabecera.length + datos.length];
            resultado = new byte[cabecera.length + cifrado.length];
            System.arraycopy(cabecera, 0, resultado, 0, cabecera.length);
            System.arraycopy(cifrado, 0, resultado, cabecera.length, cifrado.length);
            //Se genera el archivo
            escribirDatosImagen(nombre+"_ecb.bmp",resultado);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private void descifrarECB(){
        try{
            Cipher cifradorDES;
            //Se obtiene el cifrador DES con el modo ECB
            cifradorDES = Cipher.getInstance("DES/ECB/NoPadding");
            //cifradorDES = Cipher.getInstance("DES/ECB/PKCS5Padding");
            //Se genera la llave a partir de los bytes que ingresa el usuario 
            KeySpec ks = new DESKeySpec(llave);
            SecretKeyFactory kf = SecretKeyFactory.getInstance("DES");
            SecretKey llaveSecreta = kf.generateSecret(ks);
            //Se coloca el cifrador en modo de descifrado
            cifradorDES.init(Cipher.DECRYPT_MODE, llaveSecreta);
            //Se descifran los datos
            byte[] descifrado = cifradorDES.doFinal(datos);
            //Se juntan los datos descifrados con la cabecera de los archivos BMP
            resultado = new byte[cabecera.length + descifrado.length];
            System.arraycopy(cabecera, 0, resultado, 0, cabecera.length);
            System.arraycopy(descifrado, 0, resultado, cabecera.length, descifrado.length);
            //Se genera el archivo
            escribirDatosImagen(nombre+"_Decb.bmp",resultado);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    private void cifrarCBC(){
        try{
            Cipher cifradorDES;
            byte[] cifrado;
            byte[] vectorInicial;
            //Se obtiene el cifrador DES con el modo CBC
            cifradorDES = Cipher.getInstance("DES/CBC/NoPadding");
            //Se genera la llave a partir de los bytes que ingresa el usuario 
            KeySpec ks = new DESKeySpec(llave);
            SecretKeyFactory kf = SecretKeyFactory.getInstance("DES");
            SecretKey llaveSecreta = kf.generateSecret(ks);
            //Se coloca el cifrador en modo de cifrado
            cifradorDES.init(Cipher.ENCRYPT_MODE, llaveSecreta);
            //Se obtiene el vector inicial generado AUTOMATICAMENTE
            vectorInicial = cifradorDES.getIV();
            //Se cifran los datos
            cifrado = cifradorDES.doFinal(datos);
            //Se juntan los datos cifrados con la cabecera de los archivos BMP y se incluye el vector inicial al final
            resultado = new byte[cabecera.length + cifrado.length+vectorInicial.length];
            System.arraycopy(cabecera, 0, resultado, 0, cabecera.length);
            System.arraycopy(cifrado, 0, resultado, cabecera.length, cifrado.length);
            System.arraycopy(vectorInicial, 0, resultado, cabecera.length + cifrado.length, vectorInicial.length);
            //Se genera el archivo
            escribirDatosImagen(nombre+"_cbc.bmp",resultado);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private void descifrarCBC(){
        try{
            Cipher cifradorDES;
            byte[] vectorInicial = new byte [8];
            byte[] datosDescifrar = new byte [datos.length-8];
            //Se obtiene el cifrador DES con el modo CBC
            cifradorDES = Cipher.getInstance("DES/CBC/NoPadding");
            //Se obtiene el vector inicial
            System.arraycopy(datos, datos.length-8, vectorInicial, 0, vectorInicial.length);
            //Se obtienen los bytes a cifrar eliminando el vector inicial que se agrega en el cifrado
            System.arraycopy(datos, 0, datosDescifrar, 0, datosDescifrar.length);
            //Se especifican lso parametros del algoritmo, es decir, el vector inicial
            AlgorithmParameterSpec parametrosAlgoritmo = new IvParameterSpec(vectorInicial);
            //Se genera la llave a partir de los bytes que ingresa el usuario 
            KeySpec ks = new DESKeySpec(llave);
            SecretKeyFactory kf = SecretKeyFactory.getInstance("DES");
            SecretKey llaveSecreta = kf.generateSecret(ks);
            //Se coloca el cifrador en modo de descifrado añadiendo el vector inicial que ahora si se especficia
            cifradorDES.init(Cipher.DECRYPT_MODE, llaveSecreta, parametrosAlgoritmo);
            //Se descifran los datos
            byte[] descifrado = cifradorDES.doFinal(datos);
            //Se juntan los datos descifrados con la cabecera de los archivos BMP
            resultado = new byte[cabecera.length + descifrado.length];
            System.arraycopy(cabecera, 0, resultado, 0, cabecera.length);
            System.arraycopy(descifrado, 0, resultado, cabecera.length, descifrado.length);
            //Se genera el archivo
            escribirDatosImagen(nombre+"_Dcbc.bmp",resultado);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    private void cifrarCFB(){
        try{
            Cipher cifradorDES;
            byte[] cifrado;
            byte[] vectorInicial;
            //Se obtiene el cifrador DES con el modo CFB
            cifradorDES = Cipher.getInstance("DES/CFB56/NoPadding");
            //cifradorDES = Cipher.getInstance("DES/CFB/PKCS5Padding");
            //Se genera la llave a partir de los bytes que ingresa el usuario 
            KeySpec ks = new DESKeySpec(llave);
            SecretKeyFactory kf = SecretKeyFactory.getInstance("DES");
            SecretKey llaveSecreta = kf.generateSecret(ks);
            //Se coloca el cifrador en modo de cifrado
            cifradorDES.init(Cipher.ENCRYPT_MODE, llaveSecreta);
            //Se obtiene el vector inicial generado AUTOMATICAMENTE
            vectorInicial = cifradorDES.getIV();
            //Se cifran los datos
            cifrado = cifradorDES.doFinal(datos);
            //Se juntan los datos cifrados con la cabecera de los archivos BMP y se incluye el vector inicial al final
            resultado = new byte[cabecera.length + cifrado.length+vectorInicial.length];
            System.arraycopy(cabecera, 0, resultado, 0, cabecera.length);
            System.arraycopy(cifrado, 0, resultado, cabecera.length, cifrado.length);
            System.arraycopy(vectorInicial, 0, resultado, cabecera.length + cifrado.length, vectorInicial.length);
            //Se genera el archivo
            escribirDatosImagen(nombre+"_cfb.bmp",resultado);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private void descifrarCFB(){
        try{
            Cipher cifradorDES;
            byte[] vectorInicial = new byte [8];
            byte[] datosCifrar = new byte [datos.length-8];
            //Se obtiene el cifrador DES con el modo CBC
            cifradorDES = Cipher.getInstance("DES/CFB56/NoPadding");
            //Se obtiene el vector inicial
            System.arraycopy(datos, datos.length-8, vectorInicial, 0, vectorInicial.length);
            //Se obtienen los bytes a cifrar eliminando el vector inicial que se agrega en el cifrado
            System.arraycopy(datos, 0, datosCifrar, 0, datosCifrar.length);
            //Se especifican lso parametros del algoritmo, es decir, el vector inicial
            AlgorithmParameterSpec parametrosAlgoritmo = new IvParameterSpec(vectorInicial);
            //Se genera la llave a partir de los bytes que ingresa el usuario 
            KeySpec ks = new DESKeySpec(llave);
            SecretKeyFactory kf = SecretKeyFactory.getInstance("DES");
            SecretKey llaveSecreta = kf.generateSecret(ks);
            //Se coloca el cifrador en modo de descifrado añadiendo el vector inicial que ahora si se especficia
            cifradorDES.init(Cipher.DECRYPT_MODE, llaveSecreta, parametrosAlgoritmo);
            //Se descifran los datos
            byte[] descifrado = cifradorDES.doFinal(datos);
            
           
            //Se juntan los datos descifrados con la cabecera de los archivos BMP
            resultado = new byte[cabecera.length + descifrado.length];
            System.arraycopy(cabecera, 0, resultado, 0, cabecera.length);
            System.arraycopy(descifrado, 0, resultado, cabecera.length, descifrado.length);
            //Se genera el archivo
            escribirDatosImagen(nombre+"_Dcfb.bmp",resultado);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    private void cifrarOFB(){
        try{
            Cipher cifradorDES;
            byte[] cifrado;
            byte[] vectorInicial;
            //Se obtiene el cifrador DES con el modo CFB
            cifradorDES = Cipher.getInstance("DES/OFB/NoPadding");
            //cifradorDES = Cipher.getInstance("DES/OFB/PKCS5Padding");
            //Se genera la llave a partir de los bytes que ingresa el usuario 
            KeySpec ks = new DESKeySpec(llave);
            SecretKeyFactory kf = SecretKeyFactory.getInstance("DES");
            SecretKey llaveSecreta = kf.generateSecret(ks);
            //Se especifican lso parametros del algoritmo, es decir, el vector inicial
            if(rdbVector.isSelected()){
                vectorInicial = txtVector.getText().getBytes();
                AlgorithmParameterSpec parametrosAlgoritmo = new IvParameterSpec(vectorInicial);
                //Se coloca el cifrador en modo de cifrado
                cifradorDES.init(Cipher.ENCRYPT_MODE, llaveSecreta, parametrosAlgoritmo);
            }else{
                cifradorDES.init(Cipher.ENCRYPT_MODE, llaveSecreta);
                //Se obtiene el vector inicial generado AUTOMATICAMENTE
                vectorInicial = cifradorDES.getIV();
            }
            //Se cifran los datos
            cifrado = cifradorDES.doFinal(datos);
            //Se juntan los datos cifrados con la cabecera de los archivos BMP y se incluye el vector inicial al final
            resultado = new byte[cabecera.length + cifrado.length+vectorInicial.length];
            System.arraycopy(cabecera, 0, resultado, 0, cabecera.length);
            System.arraycopy(cifrado, 0, resultado, cabecera.length, cifrado.length);
            System.arraycopy(vectorInicial, 0, resultado, cabecera.length + cifrado.length, vectorInicial.length);
            //Se genera el archivo
            escribirDatosImagen(nombre+"_ofb.bmp",resultado);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private void descifrarOFB(){
        try{
            Cipher cifradorDES;
            byte[] vectorInicial = new byte [8];
            byte[] datosCifrar = new byte [datos.length-8];
            //Se obtiene el cifrador DES con el modo CBC
            cifradorDES = Cipher.getInstance("DES/OFB/NoPadding");
            //cifradorDES = Cipher.getInstance("DES/OFB/PKCS5Padding");
            //Se obtiene el vector inicial
            System.arraycopy(datos, datos.length-8, vectorInicial, 0, vectorInicial.length);
            //Se obtienen los bytes a cifrar eliminando el vector inicial que se agrega en el cifrado
            System.arraycopy(datos, 0, datosCifrar, 0, datosCifrar.length);
            //Se especifican lso parametros del algoritmo, es decir, el vector inicial
            AlgorithmParameterSpec parametrosAlgoritmo = new IvParameterSpec(vectorInicial);
            //Se genera la llave a partir de los bytes que ingresa el usuario 
            KeySpec ks = new DESKeySpec(llave);
            SecretKeyFactory kf = SecretKeyFactory.getInstance("DES");
            SecretKey llaveSecreta = kf.generateSecret(ks);
            //Se coloca el cifrador en modo de descifrado añadiendo el vector inicial que ahora si se especficia
            cifradorDES.init(Cipher.DECRYPT_MODE, llaveSecreta, parametrosAlgoritmo);
            //Se descifran los datos
            byte[] descifrado = cifradorDES.doFinal(datos);
            //Se juntan los datos descifrados con la cabecera de los archivos BMP
            resultado = new byte[cabecera.length + descifrado.length];
            System.arraycopy(cabecera, 0, resultado, 0, cabecera.length);
            System.arraycopy(descifrado, 0, resultado, cabecera.length, descifrado.length);
            //Se genera el archivo
            escribirDatosImagen(nombre+"_Dofb.bmp",resultado);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    
    
    public void escribirDatosImagen(String path, byte [] datos){
        try{
            Files.write(Paths.get(path),datos);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    
    public void obtenerDatosImagen(){
        try{
            data = Files.readAllBytes(Paths.get(fichero.getAbsolutePath()));
            datos = new byte[data.length-54];
            System.arraycopy(data, 54, datos, 0, datos.length);
            System.arraycopy(data, 0, cabecera, 0, tamCabecera);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    
    
    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        cboOperacion.setSelectedIndex(0);
        lblFrase.setText("Introduce la frase llave:");
        txtLlave.setText("");
        cboModoCifrado.setVisible(true);
        cboModoCifrado.setSelectedIndex(0);
        cboModoDescifrado.setVisible(false);
        cboModoDescifrado.setSelectedIndex(0);
        cboModoCifrado.setVisible(true);
        cboModoDescifrado.setSelectedIndex(0);
        rdbVector.setSelected(false);
        rdbVector.setVisible(false);
        txtVector.setVisible(false);
        lblVector.setVisible(false);
        lblMensaje.setVisible(true);
        
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void cboOperacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboOperacionActionPerformed
        // TODO add your handling code here:
        if(cboOperacion.getSelectedIndex()==0){
            lblFrase.setText("Introduce la frase llave:");
            cboModoCifrado.setVisible(true);
            cboModoDescifrado.setVisible(false);
            if(cboModoCifrado.getSelectedIndex()==3){
                rdbVector.setSelected(false);
                rdbVector.setVisible(true);
                txtVector.setVisible(true);
                lblVector.setVisible(true);
                lblMensaje.setVisible(false);
            }else{
                rdbVector.setVisible(false);
                txtVector.setVisible(false);
                lblVector.setVisible(false);
                lblMensaje.setVisible(true);
            }
        }
        else{
            lblFrase.setText("Introduce la frase llave:");
            cboModoCifrado.setVisible(false);
            cboModoDescifrado.setVisible(true);
            txtVector.setEnabled(false);
            rdbVector.setVisible(false);
            txtVector.setVisible(false);
            lblVector.setVisible(false);
            rdbVector.setSelected(false);
            lblMensaje.setVisible(true);
        }
    }//GEN-LAST:event_cboOperacionActionPerformed

    private void cboModoCifradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboModoCifradoActionPerformed
        // TODO add your handling code here:
        if(cboModoCifrado.getSelectedIndex()==3){
            rdbVector.setSelected(false);
            txtVector.setEnabled(false);
            rdbVector.setVisible(true);
            txtVector.setVisible(true);
            lblVector.setVisible(true);
            lblMensaje.setVisible(false);
        }else{
            rdbVector.setVisible(false);
            txtVector.setVisible(false);
            lblVector.setVisible(false);
            lblMensaje.setVisible(true);
        }
    }//GEN-LAST:event_cboModoCifradoActionPerformed

    private void cboModoDescifradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboModoDescifradoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboModoDescifradoActionPerformed

    private void rdbVectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbVectorActionPerformed
        // TODO add your handling code here:
        if(rdbVector.isSelected()){
            txtVector.setEnabled(true);
        }else{
            txtVector.setEnabled(false);
        }
    }//GEN-LAST:event_rdbVectorActionPerformed

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
            java.util.logging.Logger.getLogger(frmEncriptacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmEncriptacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmEncriptacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmEncriptacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmEncriptacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEjecutar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cboModoCifrado;
    private javax.swing.JComboBox cboModoDescifrado;
    private javax.swing.JComboBox cboOperacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblFrase;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblVector;
    private javax.swing.JRadioButton rdbVector;
    private javax.swing.JTextField txtLlave;
    private javax.swing.JTextField txtRutaEntrada;
    private javax.swing.JTextField txtVector;
    // End of variables declaration//GEN-END:variables
}

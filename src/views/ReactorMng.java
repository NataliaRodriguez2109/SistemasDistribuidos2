/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import nuclearPlant.comunications.Message;
import nuclearPlant.elements.Reactor;

/**
 *
 * @author Jesus David Otero
 */
public class ReactorMng extends javax.swing.JPanel {

    private Reactor reactor;
    private int pos ;
    ImageIcon iconOn = new ImageIcon("src/Images/on.png");
    ImageIcon iconOff = new ImageIcon("src/Images/off.png");
    ImageIcon carga = new ImageIcon("src/Images/carga.png");
    ImageIcon descarga = new ImageIcon("src/Images/descarga.png");
    ImageIcon logo = new ImageIcon("src/Images/logo.png");
    AdmConsole padre;
    
    /**
     * Creates new form ReactorMng
     */
    public ReactorMng(Reactor reactor, int pos, AdmConsole padre) {
        initComponents();
        this.padre = padre;
        this.reactor = reactor;
        this.pos = pos;
        onOff.setIcon(iconOff);
        labelCarga.setIcon(carga);
        labelDescarga.setIcon(descarga);
        labelLogo.setIcon(logo);
        initialize(reactor);
    }

    public int getPos() {
        return pos;
    }
    
    
    
    public void initialize(Reactor reactor){
        pbCarga.setValue(reactor.getCharge());
        pbCarga.setString(reactor.getCharge() + "%");
        txtEstado.setText(reactor.getState().getLabel());
        if(reactor.getState().getLabel().equals("Dañado")){
            pbCarga.setString("!");
            pbCarga.setValue(0);
            txtEstado.setText(reactor.getState().getLabel());
            onOff.setEnabled(false);
            btncargar.setEnabled(false);
            btndescargar.setEnabled(false);
            txtCarga.setEditable(false);
            txtDescarga.setEditable(false);
            txtEstado.setForeground(Color.red);
            pbCarga.setForeground(Color.red);
            btnReparar.setEnabled(true);
        }
        if(reactor.isSwitchedOn()){
            onOff.setIcon(iconOn);
        }else {
            onOff.setIcon(iconOff);
        }
    }
    

    public Reactor getReactor() {
        return reactor;
    }

    public void setReactor(Reactor reactor) {
        this.reactor = reactor;
        initialize(reactor);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelReactor = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btncargar = new javax.swing.JButton();
        btndescargar = new javax.swing.JButton();
        txtCarga = new javax.swing.JTextField();
        txtDescarga = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        pbCarga = new javax.swing.JProgressBar();
        onOff = new javax.swing.JToggleButton();
        jLabel7 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        labelCarga = new javax.swing.JLabel();
        labelDescarga = new javax.swing.JLabel();
        btnReparar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnAtras = new javax.swing.JButton();
        labelLogo = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(750, 460));
        setLayout(null);

        panelReactor.setBackground(new java.awt.Color(255, 209, 1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Acciones en reactor");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Carga");

        btncargar.setText("Cargar");
        btncargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncargarActionPerformed(evt);
            }
        });

        btndescargar.setText("Descargar");
        btndescargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndescargarActionPerformed(evt);
            }
        });

        jLabel5.setText("%");

        pbCarga.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pbCarga.setForeground(new java.awt.Color(0, 0, 0));
        pbCarga.setToolTipText("");
        pbCarga.setStringPainted(true);

        onOff.setForeground(new java.awt.Color(255, 255, 255));
        onOff.setBorderPainted(false);
        onOff.setContentAreaFilled(false);
        onOff.setOpaque(true);
        onOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onOffActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Estado");

        txtEstado.setEditable(false);
        txtEstado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtEstado.setForeground(new java.awt.Color(51, 255, 0));
        txtEstado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEstado.setName("Funcional"); // NOI18N
        txtEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstadoActionPerformed(evt);
            }
        });

        btnReparar.setText("Reparar");
        btnReparar.setEnabled(false);
        btnReparar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRepararActionPerformed(evt);
            }
        });

        jLabel6.setText("%");

        btnAtras.setText("Atrás");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelReactorLayout = new javax.swing.GroupLayout(panelReactor);
        panelReactor.setLayout(panelReactorLayout);
        panelReactorLayout.setHorizontalGroup(
            panelReactorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
            .addGroup(panelReactorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelReactorLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(panelReactorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(labelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelReactorLayout.createSequentialGroup()
                            .addGap(260, 260, 260)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(40, 40, 40)
                            .addComponent(onOff, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelReactorLayout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(pbCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelReactorLayout.createSequentialGroup()
                            .addGap(310, 310, 310)
                            .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelReactorLayout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(panelReactorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(panelReactorLayout.createSequentialGroup()
                                    .addComponent(btndescargar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(20, 20, 20)
                                    .addComponent(labelDescarga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(panelReactorLayout.createSequentialGroup()
                                    .addComponent(btncargar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(20, 20, 20)
                                    .addComponent(labelCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panelReactorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelReactorLayout.createSequentialGroup()
                                    .addComponent(txtCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(160, 160, 160)
                                    .addComponent(jLabel7)
                                    .addGap(20, 20, 20)
                                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelReactorLayout.createSequentialGroup()
                                    .addComponent(txtDescarga, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(240, 240, 240)
                                    .addComponent(btnReparar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        panelReactorLayout.setVerticalGroup(
            panelReactorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
            .addGroup(panelReactorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelReactorLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(labelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)
                    .addGroup(panelReactorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(onOff, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(23, 23, 23)
                    .addGroup(panelReactorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btncargar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(20, 20, 20)
                    .addGroup(panelReactorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btndescargar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelDescarga, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDescarga, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnReparar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(50, 50, 50)
                    .addGroup(panelReactorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelReactorLayout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(pbCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(30, 30, 30)
                    .addComponent(btnAtras)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        add(panelReactor);
        panelReactor.setBounds(0, 0, 750, 460);
    }// </editor-fold>//GEN-END:initComponents

    private void btncargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncargarActionPerformed
        try{
            if(Integer.parseInt(txtCarga.getText()) < 0) {
                JOptionPane.showMessageDialog(null, "El valor ingresado no es válido", "Error", JOptionPane.INFORMATION_MESSAGE);
            }else {
                reactor.chargeReactor(Integer.parseInt(txtCarga.getText()));
                initialize(reactor);
                if(reactor.getCharge()>100){
                    JOptionPane.showMessageDialog(null, "¡Se ha dañado el reactor!", "Error", JOptionPane.ERROR_MESSAGE);
                    initialize(reactor);
                }
            }
        }
        catch(NumberFormatException e){
            if(reactor.isSwitchedOn()==false){
                JOptionPane.showMessageDialog(null, "Debe encender el reactor e ingresar un valor", "Error: campo vacío", JOptionPane.ERROR_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(null, "Debe ingresar un valor", "Error: campo vacío", JOptionPane.ERROR_MESSAGE);
            }

        }
        txtCarga.setText(null);
    }//GEN-LAST:event_btncargarActionPerformed

    private void btndescargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndescargarActionPerformed
        try{
            if(Integer.parseInt(txtDescarga.getText()) < 0) {
                JOptionPane.showMessageDialog(null, "El valor ingresado no es válido", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                reactor.dischargeReactor(Integer.parseInt(txtDescarga.getText()));
                initialize(reactor);
            }
        }catch(NumberFormatException e){
            if(reactor.isSwitchedOn()==false){
                JOptionPane.showMessageDialog(null, "Debe encender el reactor e ingresar un valor", "Error: campo vacío", JOptionPane.ERROR_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(null, "Debe ingresar un valor", "Error: campo vacío", JOptionPane.ERROR_MESSAGE);
            }

        }
        txtDescarga.setText(null);
    }//GEN-LAST:event_btndescargarActionPerformed

    private void onOffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onOffActionPerformed

        if (onOff.isSelected()){
            String contenido[] = new String[4];
            contenido[0] = ""+pos;
            contenido[1] = "encender";
            contenido[3] = "";
            padre.getAdmm().emit(new Message(contenido));
        }
        else {
            String contenido[] = new String[4];
            contenido[0] = ""+pos;
            contenido[1] = "apagar";            
            contenido[3] = "";
            padre.getAdmm().emit(new Message(contenido));
        }
    }//GEN-LAST:event_onOffActionPerformed

    private void txtEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstadoActionPerformed

    }//GEN-LAST:event_txtEstadoActionPerformed

    private void btnRepararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRepararActionPerformed
        reactor.repair();
        reactor.setCharge(0);
        txtEstado.setText(reactor.getState().getLabel());
        initialize(reactor);
        JOptionPane.showMessageDialog(null, "Reactor reparado", "Hecho!", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnRepararActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        
    }//GEN-LAST:event_btnAtrasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnReparar;
    private javax.swing.JButton btncargar;
    private javax.swing.JButton btndescargar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel labelCarga;
    private javax.swing.JLabel labelDescarga;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JToggleButton onOff;
    private javax.swing.JPanel panelReactor;
    private javax.swing.JProgressBar pbCarga;
    private javax.swing.JTextField txtCarga;
    private javax.swing.JTextField txtDescarga;
    private javax.swing.JTextField txtEstado;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanas;

import com.mycompany.videoclub.proyecto.Gestor;
import com.mycompany.videoclub.proyecto.Pelicula;
import com.mycompany.videoclub.proyecto.Cliente;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
/**
 *
 * @author cesar
 */
public class Catalogo extends javax.swing.JFrame {

    private Gestor videoClub;
    private Cliente cliente;
           
    /**
     * Creates new form Catalogo
     * @param club
     * @param client
     */
    public Catalogo(Gestor club, Cliente client) 
    {
        initComponents();
        this.setLocationRelativeTo(null);
        videoClub = club;
        cliente = client;
        agregarListaPelis();
        tusaldo();
    }
    private void agregarListaPelis(){
        ArrayList<String> pelis = videoClub.obtenerNombresPeliculas();
        
        for(int i = 0; i < pelis.size(); i++){
            combo.addItem(pelis.get(i));
        }
    }
    private void tusaldo(){
        
        jLabeltusaldo.setText("Su saldo es: "+cliente.getSaldo()+ " CREDITOS ");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        combo = new javax.swing.JComboBox<>();
        botonverinfo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtdatos = new javax.swing.JTextArea();
        botonvolver = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        labelinfo = new javax.swing.JLabel();
        txtrating = new javax.swing.JTextField();
        botonfiltrar = new javax.swing.JButton();
        jLabeltusaldo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        combo.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        combo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });

        botonverinfo.setText("INFO");
        botonverinfo.setBorder(new javax.swing.border.MatteBorder(null));
        botonverinfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonverinfoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        jLabel1.setText("CATALOGO");

        txtdatos.setColumns(20);
        txtdatos.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtdatos.setRows(5);
        txtdatos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(txtdatos);

        botonvolver.setText("VOLVER");
        botonvolver.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        botonvolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonvolverActionPerformed(evt);
            }
        });

        jButton3.setText("Arrendar");
        jButton3.setBorder(new javax.swing.border.MatteBorder(null));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        labelinfo.setText("Filtrar por rating (1-5):");

        botonfiltrar.setText("Filtrar");
        botonfiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonfiltrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botonvolver)
                        .addGap(14, 14, 14))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(botonverinfo, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(170, 170, 170)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelinfo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtrating, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botonfiltrar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(216, 216, 216)
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addComponent(jLabeltusaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabeltusaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelinfo)
                            .addComponent(txtrating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonfiltrar))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(botonverinfo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(botonvolver)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
        
        
        
    }//GEN-LAST:event_comboActionPerformed

    private void botonverinfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonverinfoActionPerformed
        
        //ArrayList<String> pelis = videoClub.obtenerNombresPeliculas();
        
        int indice = combo.getSelectedIndex();  
        String nombrepeli  = "aux";
        
        /*
        for(int i = 0; i <= indice; i++){
            nombrepeli = pelis.get(i);
        }
        */
        
        nombrepeli = combo.getItemAt(indice);
        
        Pelicula peli = videoClub.buscarPeliculaPorNombre(nombrepeli);
        //txtdatos.setText("\n \n \n \n \n"+peli.getTitulo()+peli.getGenero() +peli.getSinopsis() +peli.getExistencias() +peli.getRating() +peli.getPrecioArriendo());
        
        txtdatos.setLineWrap(true);  // Habilita el ajuste de línea
        txtdatos.setWrapStyleWord(false);// Desactiva el ajuste de palabra
        txtdatos.setText(
        "Título: " + peli.getTitulo() + "\n" +
        "Año: "+peli.getYear() +"\n"+
        "Género: " + peli.getGenero() + "\n" +
        "Sinopsis: " + peli.getSinopsis() + "\n" +
        "Existencias: " + peli.getExistencias() + "\n" +
        "Rating: " + peli.getRating() + "\n" +
        "Precio de Arriendo: " + peli.getPrecioArriendo());
         

    }//GEN-LAST:event_botonverinfoActionPerformed

    private void botonvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonvolverActionPerformed
        // TODO add your handling code here:
        ClienteNormal volver = new ClienteNormal(videoClub,cliente);
        volver.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_botonvolverActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        ArrayList<String> pelis = videoClub.obtenerNombresPeliculas();
        
        int indice = combo.getSelectedIndex();  
        String nombrepeli  = "NOSEBUCO";
        
        for(int i = 0; i <= indice; i++){
            nombrepeli = pelis.get(i);
        }
        
        Pelicula peli = videoClub.buscarPeliculaPorNombre(nombrepeli);
        
        int i = JOptionPane.showConfirmDialog(this, "Seguro que quiere arrendar"); 
        if (i == 0)
        {
            if(cliente.getSaldo()<peli.getPrecioArriendo())
            {
                JOptionPane.showMessageDialog(this, "Saldo insuficiente");
            }else{
                if(cliente.arrendarPelicula(videoClub, nombrepeli)){
                    JOptionPane.showMessageDialog(this, "Agregada a mis peliculas");
                    tusaldo();
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "No quedan existencias de la película");
                }
            }  
        }
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void botonfiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonfiltrarActionPerformed
        
        
        double rating = Double.parseDouble(txtrating.getText());
        ArrayList<Pelicula> peliculas = videoClub.buscarPeliculasPorRating(rating);
        
        combo.removeAllItems();
        
        for(int i = 0; i < peliculas.size(); i++){
            combo.addItem(peliculas.get(i).getTitulo());
        }
        
        
    }//GEN-LAST:event_botonfiltrarActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonfiltrar;
    private javax.swing.JButton botonverinfo;
    private javax.swing.JButton botonvolver;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabeltusaldo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelinfo;
    private javax.swing.JTextArea txtdatos;
    private javax.swing.JTextField txtrating;
    // End of variables declaration//GEN-END:variables
}

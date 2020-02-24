package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class Principal extends javax.swing.JFrame {

    private final Connection conn = new Conexao().getConexao();
    private PreparedStatement ps;
    private ResultSet rs;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Evento e;
    DefaultListModel<Evento> modelDia = new DefaultListModel<>();
    DefaultListModel<Evento> modelAtrasados = new DefaultListModel<>();

    /**
     * Construtor da View. Realiza as tarefas iniciais.
     */
    public Principal() {
        initComponents();
        iniciaCampos();
        listarEventos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        calendario = new com.toedter.calendar.JCalendar();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaDoDia = new javax.swing.JList<>();
        btnNovoEvento = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnApagar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtData = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtObservacoes = new javax.swing.JTextPane();
        btnCancelar = new javax.swing.JButton();
        btnGravar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtHora = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TODO List");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        calendario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        calendario.setTodayButtonVisible(true);
        calendario.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                calendarioPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(calendario, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(calendario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
        );

        listaDoDia.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaDoDia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaDoDiaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaDoDia);

        btnNovoEvento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnNovoEvento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/7687_16x16.png"))); // NOI18N
        btnNovoEvento.setMnemonic('N');
        btnNovoEvento.setText("Novo Evento");
        btnNovoEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoEventoActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/8427_16x16.png"))); // NOI18N
        btnEditar.setMnemonic('E');
        btnEditar.setText("Editar");
        btnEditar.setEnabled(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnApagar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnApagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/9371_16x16.png"))); // NOI18N
        btnApagar.setMnemonic('A');
        btnApagar.setText("Apagar");
        btnApagar.setEnabled(false);
        btnApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalhes do Evento"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Data:");

        txtData.setEnabled(false);
        txtData.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Descrição:");

        txtDescricao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDescricao.setEnabled(false);
        txtDescricao.setNextFocusableComponent(txtObservacoes);
        txtDescricao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDescricaoFocusGained(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Observações:");

        txtObservacoes.setEnabled(false);
        jScrollPane2.setViewportView(txtObservacoes);

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/7695_16x16.png"))); // NOI18N
        btnCancelar.setMnemonic('C');
        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGravar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/8439_16x16.png"))); // NOI18N
        btnGravar.setMnemonic('G');
        btnGravar.setText("Gravar");
        btnGravar.setEnabled(false);
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Horário:");

        try {
            txtHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtHora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHora.setEnabled(false);
        txtHora.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtHora.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtHoraFocusGained(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGravar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCancelar, btnGravar});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCancelar)
                        .addComponent(btnGravar)
                        .addComponent(jLabel1)
                        .addComponent(jLabel4)
                        .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 37, Short.MAX_VALUE)
                                .addComponent(btnNovoEvento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnApagar)
                                .addGap(0, 58, Short.MAX_VALUE))
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnApagar, btnEditar, btnNovoEvento});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNovoEvento)
                            .addComponent(btnEditar)
                            .addComponent(btnApagar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void calendarioPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_calendarioPropertyChange
        if (evt.getPropertyName().equals("calendar")) {
            listarEventos();
        }
    }//GEN-LAST:event_calendarioPropertyChange

    private void btnNovoEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoEventoActionPerformed
        iniciaCampos();
        habilitaCampos();
    }//GEN-LAST:event_btnNovoEventoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        habilitaCampos();
        btnGravar.setText("Atualizar");
    }//GEN-LAST:event_btnEditarActionPerformed

    private void txtHoraFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHoraFocusGained
        txtHora.selectAll();
    }//GEN-LAST:event_txtHoraFocusGained

    private void txtDescricaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescricaoFocusGained
        txtDescricao.selectAll();
    }//GEN-LAST:event_txtDescricaoFocusGained

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        iniciaCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        if (btnGravar.getText().equalsIgnoreCase("Gravar")) {
            gravar();
        } else {
            if (btnGravar.getText().equalsIgnoreCase("Atualizar")) {
                atualizar(modelDia.getElementAt(listaDoDia.getSelectedIndex()));
            }
        }
        iniciaCampos();
        listarEventos();
    }//GEN-LAST:event_btnGravarActionPerformed

    private void btnApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Deseja apagar esse registro?", "Confirmação", JOptionPane.YES_NO_OPTION) == 0) {
            apagar(modelDia.getElementAt(listaDoDia.getSelectedIndex()));
            iniciaCampos();
            listarEventos();
        }
    }//GEN-LAST:event_btnApagarActionPerformed

    private void listaDoDiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaDoDiaMouseClicked
        try {
            detalhar(modelDia.getElementAt(listaDoDia.getSelectedIndex()));
            btnApagar.setEnabled(true);
            btnEditar.setEnabled(true);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Nenhum registro para selecionar...");
        }
    }//GEN-LAST:event_listaDoDiaMouseClicked

    /**
     * Método main
     * Não existe tratamento para argumentos enviados.
     * @param args 
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new Principal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApagar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGravar;
    private javax.swing.JButton btnNovoEvento;
    private com.toedter.calendar.JCalendar calendario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<Evento> listaDoDia;
    private com.toedter.calendar.JDateChooser txtData;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JFormattedTextField txtHora;
    private javax.swing.JTextPane txtObservacoes;
    // End of variables declaration//GEN-END:variables

    /**
     * Define os parâmetros iniciais dos campos e botões
     */
    private void iniciaCampos() {

        btnNovoEvento.setEnabled(true);
        btnApagar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnEditar.setEnabled(false);
        btnGravar.setEnabled(false);

        btnGravar.setText("Gravar");

        txtData.setEnabled(false);
        txtDescricao.setEnabled(false);
        txtHora.setEnabled(false);
        txtObservacoes.setEnabled(false);

        txtData.setDate(null);
        txtDescricao.setText("");
        txtHora.setText("");
        txtObservacoes.setText("");

        btnNovoEvento.requestFocus();
        
        listaDoDia.setEnabled(true);
        listaDoDia.setSelectedIndex(-1);

    }

    /**
     * Altera a View quando um registro é selecionado.
     */
    private void habilitaCampos() {
        btnNovoEvento.setEnabled(false);
        btnEditar.setEnabled(false);
        btnApagar.setEnabled(false);
        txtData.setEnabled(true);
        txtDescricao.setEnabled(true);
        txtHora.setEnabled(true);
        txtObservacoes.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnGravar.setEnabled(true);
        listaDoDia.setEnabled(false);
        listaDoDia.setSelectedIndex(-1);

        txtData.setDate(calendario.getDate());
        txtHora.requestFocus();
        txtHora.selectAll();
    }

    /**
     * Lista os eventos do dia selecionado no calendário
     */
    private void listarEventos() {
        try {
            modelDia.clear();
            ps = conn.prepareStatement("SELECT * FROM eventos WHERE data = ? ORDER BY hora");
            ps.setString(1, sdf.format(calendario.getDate()));
            rs = ps.executeQuery();
            while (rs.next()) {
                e = new Evento();
                e.setDataEvento(strToDate(rs.getString("data")));
                e.setHora(strToLocalTime(rs.getString("hora")));
                e.setId(rs.getInt("id"));
                e.setObservacoes(rs.getString("observacoes"));
                e.setTitulo(rs.getString("titulo"));
                modelDia.addElement(e);
            }
            rs.close();
            ps.close();
            listaDoDia.setModel(modelDia);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar os eventos do dia.\n\n" + ex.getMessage());
        }
    }

    /**
     * Grava um novo evento no banco de dados
     */
    private void gravar() {
        String sql = "INSERT INTO eventos (data, hora, titulo, observacoes) VALUES (?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, dateToStrUS(txtData.getDate()));
            ps.setString(2, txtHora.getText());
            ps.setString(3, txtDescricao.getText());
            ps.setString(4, txtObservacoes.getText());
            ps.executeUpdate();
            ps.close();
            System.out.println("Registro salvo com sucesso!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar os dados:\n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    /**
     * Deleta o evento selecionado do banco de dados
     * @param e 
     */
    private void apagar(Evento e) {
        String sql = "DELETE FROM eventos WHERE id = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, e.getId());
            ps.executeUpdate();
            ps.close();
            System.out.println("Registro removido com sucesso!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar ao remover o registro:\n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    /**
     * Atualiza o registro do banco com os dados novos.
     * @param e 
     */
    private void atualizar(Evento e) {
        String sql = "UPDATE eventos SET data=?, hora=?, titulo=?, observacoes=? WHERE id=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, dateToStrUS(e.getDataEvento()));
            ps.setString(2, txtHora.getText());
            ps.setString(3, txtDescricao.getText());
            ps.setString(4, txtObservacoes.getText());
            ps.setInt(5, e.getId());
            ps.executeUpdate();
            ps.close();
            System.out.println("Registro atualizado com sucesso!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar os dados:\n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    /**
     * Pega o evento selecionado na lista e exibe os dados
     * @param e 
     */
    private void detalhar(Evento e) {
        txtData.setDate(e.getDataEvento());
        txtHora.setText(localTimeToStr(e.getHora()));
        txtDescricao.setText(e.getTitulo());
        txtObservacoes.setText(e.getObservacoes());
        btnGravar.setText("Atualizar");
    }

    /**
     * Converte a data informada em uma string de data no formato BR: yyyy-mm-dd
     *
     * @param data
     * @return
     */
    private String dateToStrUS(Date data) {
        return new SimpleDateFormat("yyyy-MM-dd").format(data);
    }

    /**
     * Converte a data informada na string para java.util.date
     *
     * @param data
     * @return
     */
    private Date strToDate(String data) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(data);
    }

    /**
     * Converte a LocalTime informada em String de hora hh:mm
     *
     * @param hora
     * @return
     */
    private String localTimeToStr(LocalTime hora) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        return hora.format(dtf);
    }

    /**
     * Converte a String hora para LocalTime
     *
     * @param hora
     * @return
     */
    private LocalTime strToLocalTime(String hora) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        return LocalTime.parse(hora, dtf);
    }

}

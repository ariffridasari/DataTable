/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.DepartmentController;
import controllers.EmployeeController;
import controllers.LocationController;
import daos.GeneralDAO;
import icontrollers.IDepartmentController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Department;
import models.Employee;
import models.Location;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author Arif Fridasari
 */
public class JIDepartment extends javax.swing.JInternalFrame {

    DefaultTableModel model = new DefaultTableModel();
    SessionFactory factory = HibernateUtil.getSessionFactory();

    GeneralDAO<Department> dAO = new GeneralDAO<>(factory, Department.class);
    IDepartmentController idc = new DepartmentController(factory);

    /**
     * Creates new form JIDepartment
     */
    public JIDepartment() {
        initComponents();
        showTableDepartment();
        getManager();
        getLoc();
        nomor();
    }

    public Object nomor() {
        Object[] no = new Object[1];
        int baris = model.getRowCount();
        for (int i = 0; i < baris; i++) {
            String No = String.valueOf(i + 1);
            model.setValueAt(No + ".", i, 0);
        }
        return no;
    }

    public void getManager() {
        for (Employee emp : new EmployeeController(factory).getAll()) {

            if (emp.getId() == null) {
                cmbManager.addItem("");
            } else {
                cmbManager.addItem(emp.getId() + "-" + emp.getLastName());
            }
        }
    }

    public void getLoc() {
        for (Location location : new LocationController(factory).getAll()) {
            cmbLocal.addItem(location.getId() + "-" + location.getCity());

        }
    }

    public void resetTextDepartment() {
        txtDepartment_Id.setText("");
        txtDepartment_Name.setText("");
        cmbManager.setSelectedIndex(0);
        cmbLocal.setSelectedIndex(0);
//        txtManager_id.setText("");
//        txtLocation_id.setText("");
        txtDepartment_Id.setEditable(true);
        btnInsertDepartment.setEnabled(true);
    }

    public void showTableDepartment() {
        DefaultTableModel model = (DefaultTableModel) tableDepartment.getModel();
        Object[] row = new Object[5];
        List<Department> department = new ArrayList<>();
        department = idc.getAll();
        for (int i = 0; i < department.size(); i++) {
            row[0] = i + 1;
            row[1] = department.get(i).getId();
            row[2] = department.get(i).getName();
            if (department.get(i).getManager() == null) {
                row[3] = "";
            } else {
                row[3] = department.get(i).getManager().getLastName();
            }
            if (department.get(i).getLocation().getCity() == null) {
                row[4] = "";
            } else {
                row[4] = department.get(i).getLocation().getCity();
            }

            model.addRow(row);
        }
    }

    public void showTableDepartment(String s) {
        DefaultTableModel model = (DefaultTableModel) tableDepartment.getModel();
        Object[] row = new Object[5];
        List<Department> department = new ArrayList<>();
        department = idc.search(s);
        for (int i = 0; i < department.size(); i++) {
            row[0] = nomor();
            row[1] = department.get(i).getId();
            row[2] = department.get(i).getName();
            row[3] = department.get(i).getManager().getId();
            row[4] = department.get(i).getLocation().getCity();
            model.addRow(row);
        }
    }

    public void updateTableDepartment() {
        DefaultTableModel model = (DefaultTableModel) tableDepartment.getModel();
        model.setRowCount(0);
        showTableDepartment();
    }

    public void updateTableDepartment(String s) {
        DefaultTableModel model = (DefaultTableModel) tableDepartment.getModel();
        model.setRowCount(0);
        if (s == "") {
            showTableDepartment();
        }
        showTableDepartment(s);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        txtDepartmentSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDepartment = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtDepartment_Id = new javax.swing.JTextField();
        txtDepartment_Name = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        btnInsertDepartment = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbManager = new javax.swing.JComboBox<>();
        cmbLocal = new javax.swing.JComboBox<>();

        txtDepartmentSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDepartmentSearchActionPerformed(evt);
            }
        });
        txtDepartmentSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDepartmentSearchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDepartmentSearchKeyTyped(evt);
            }
        });

        tableDepartment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Id", "Name", "Manager", "Location"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableDepartment.setName(""); // NOI18N
        tableDepartment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDepartmentMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableDepartment);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Search");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDepartmentSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 25, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDepartmentSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setText("Department");

        jLabel2.setText("ID ");

        txtDepartment_Id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDepartment_IdActionPerformed(evt);
            }
        });

        txtDepartment_Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDepartment_NameActionPerformed(evt);
            }
        });

        jLabel3.setText("Name");

        btnUpdate.setText("UPDATE");
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateMouseClicked(evt);
            }
        });
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnInsertDepartment.setText("INSERT");
        btnInsertDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertDepartmentActionPerformed(evt);
            }
        });

        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnClear.setText("CLEAR");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jLabel4.setText("Manager");

        jLabel6.setText("Location");

        cmbManager.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manager" }));
        cmbManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbManagerActionPerformed(evt);
            }
        });

        cmbLocal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Location" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtDepartment_Name, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDepartment_Id, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                            .addComponent(cmbManager, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbLocal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnInsertDepartment)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClear)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDepartment_Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDepartment_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbManager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertDepartment)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnClear))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDepartmentSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDepartmentSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDepartmentSearchActionPerformed

    private void txtDepartmentSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDepartmentSearchKeyReleased
        updateTableDepartment(txtDepartmentSearch.getText());
    }//GEN-LAST:event_txtDepartmentSearchKeyReleased

    private void txtDepartmentSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDepartmentSearchKeyTyped

    }//GEN-LAST:event_txtDepartmentSearchKeyTyped

    private void tableDepartmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDepartmentMouseClicked
        DefaultTableModel model = (DefaultTableModel) tableDepartment.getModel();
        int SelectRowIndex = tableDepartment.getSelectedRow();

        txtDepartment_Id.setEditable(false);
        btnInsertDepartment.setEnabled(false);
        txtDepartment_Id.setText(model.getValueAt(SelectRowIndex, 1).toString());
        txtDepartment_Name.setText(model.getValueAt(SelectRowIndex, 2).toString());
        cmbManager.setSelectedItem(model.getValueAt(SelectRowIndex, 3).toString());
        cmbLocal.setSelectedItem(model.getValueAt(SelectRowIndex, 4).toString());
//        txtManager_id.setText(model.getValueAt(SelectRowIndex, 2).toString());
//        txtLocation_id.setText(model.getValueAt(SelectRowIndex, 3).toString());
    }//GEN-LAST:event_tableDepartmentMouseClicked

    private void txtDepartment_IdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDepartment_IdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDepartment_IdActionPerformed

    private void txtDepartment_NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDepartment_NameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDepartment_NameActionPerformed

    private void btnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseClicked

    }//GEN-LAST:event_btnUpdateMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String dprt = cmbManager.getSelectedItem().toString();
        String lctn = cmbLocal.getSelectedItem().toString();
        dprt = dprt.substring(0, dprt.indexOf("-"));
        lctn = lctn.substring(0, lctn.indexOf("-"));
        int confirm = JOptionPane.showConfirmDialog(this, "Kamu yakin mau memperbarui data?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, idc.save(txtDepartment_Id.getText(), txtDepartment_Name.getText(), dprt, lctn));
            updateTableDepartment();
            resetTextDepartment();
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnInsertDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertDepartmentActionPerformed
        String dprt = cmbManager.getSelectedItem().toString();
        String lctn = cmbLocal.getSelectedItem().toString();
        dprt = dprt.substring(0, dprt.indexOf("-"));
        lctn = lctn.substring(0, lctn.indexOf("-"));
        int confirm = JOptionPane.showConfirmDialog(this, "Kamu yakin mau menambah data?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, idc.save(txtDepartment_Id.getText(), txtDepartment_Name.getText(), dprt, lctn));
            updateTableDepartment();
            resetTextDepartment();
        }
    }//GEN-LAST:event_btnInsertDepartmentActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Kamu yakin mau menghapus data?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, idc.delete(txtDepartment_Id.getText()));
            updateTableDepartment();
            resetTextDepartment();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        resetTextDepartment();
    }//GEN-LAST:event_btnClearActionPerformed

    private void cmbManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbManagerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbManagerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsertDepartment;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbLocal;
    private javax.swing.JComboBox<String> cmbManager;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableDepartment;
    private javax.swing.JTextField txtDepartmentSearch;
    private javax.swing.JTextField txtDepartment_Id;
    private javax.swing.JTextField txtDepartment_Name;
    // End of variables declaration//GEN-END:variables
}

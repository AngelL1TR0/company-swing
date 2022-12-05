package org.iesfm.forms;

import org.iesfm.service.CompanyService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepartmentListForm {
    public JPanel mainPanel;
    private JTable departmentTable;
    private JButton addButton;
    private JButton dropButton;
    private JScrollPane tableScrollPane;
    private JPanel buttonsPanel;
    private CompanyService companyService;

    public DepartmentListForm(CompanyService companyService) {
        DepartmentTableModel departmentTableModel = new DepartmentTableModel(companyService.getDepartments());
        this.departmentTable.setModel(departmentTableModel);

        dropButton.addActionListener(e -> {
            int selectedRow = departmentTable.getSelectedRow();
            String selectedDepartment = departmentTableModel.getDepartment(selectedRow).getName();
            if (companyService.delete(selectedDepartment)) {
                departmentTableModel.setDepartments(companyService.getDepartments());
                departmentTableModel.fireTableDataChanged();
                JOptionPane.showMessageDialog(mainPanel, "Departamento eliminado");

            } else {
                JOptionPane.showMessageDialog(mainPanel, "No se ha podido eliminar el departamento");
            }
        });

        //Despues de muchos intentos
        // no se actualiza la tabla
        // sin volver a pulsar el boton de departamentos

        addButton.addActionListener(e -> {
            Window frame12 = SwingUtilities.windowForComponent(mainPanel);
            JDialog dialog = new JDialog(frame12, "Añadir departamento", Dialog.ModalityType.DOCUMENT_MODAL);
            AddDepartmentForm addDepartment1 = new AddDepartmentForm(companyService);
            dialog.setContentPane(addDepartment1.mainPanel);
            dialog.pack();
            dialog.setVisible(true);

        });
    }
}
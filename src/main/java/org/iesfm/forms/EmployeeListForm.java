package org.iesfm.forms;

import org.iesfm.service.CompanyService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeListForm {
    public JPanel mainPanel;
    private JTable employeeTable;
    private JButton addButton;
    private JButton dropButton;
    private JScrollPane tableScrollPane;
    private JPanel buttonsPanel;
    private CompanyService companyService;

    public EmployeeListForm(CompanyService companyService) {
        EmployeesTableModel employeeTableModel = new EmployeesTableModel(companyService.getEmployees());
        this.employeeTable.setModel(employeeTableModel);

        dropButton.addActionListener(e -> {
            int selectedRow = employeeTable.getSelectedRow();
            String selectedEmployee = employeeTableModel.getEmployee(selectedRow).getNif();
            if (companyService.deleteEmployee(selectedEmployee)) {
                employeeTableModel.setEmployees(companyService.getEmployees());
                employeeTableModel.fireTableDataChanged();
                JOptionPane.showMessageDialog(mainPanel, "Empleado eliminado");

            } else {
                JOptionPane.showMessageDialog(mainPanel, "No se ha podido eliminar el empleado");
            }
        });


        //Despues de muchos intentos
        // no se actualiza la tabla
        // sin volver a pulsar el boton de empleados
        addButton.addActionListener(e -> {
            Window frame1 = SwingUtilities.windowForComponent(mainPanel);
            JDialog dialog = new JDialog(frame1, "Añadir empleado", Dialog.ModalityType.DOCUMENT_MODAL);
            AddEmployeeForm addEmployee1 = new AddEmployeeForm(companyService);
            dialog.setContentPane(addEmployee1.mainPanel);
            dialog.pack();
            dialog.setVisible(true);

        });
    }
}

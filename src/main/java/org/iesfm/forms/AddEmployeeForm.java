package org.iesfm.forms;

import org.iesfm.entity.Employee;
import org.iesfm.service.CompanyService;

import javax.swing.*;
import java.awt.*;

public class AddEmployeeForm {
    public JPanel mainPanel;
    private JTextField nifTf;
    private JTextField nameTf;
    private JTextField surnameTf;
    private JTextField roleTf;
    private JTextField departmentIdTf;
    private JButton addButton;
    private JLabel nifLabel;
    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JLabel roleLabel;
    private JLabel departmentIdLabel;

    private CompanyService companyService;

    public AddEmployeeForm(CompanyService companyService) {
        addButton.addActionListener(
                e -> {
                    try {
                        String nif = nifTf.getText();
                        String name = nameTf.getText();
                        String surname = surnameTf.getText();
                        String role = roleTf.getText();
                        int departmentId = Integer.parseInt(departmentIdTf.getText());
                        Employee employee = new Employee(nif, name, surname, role, departmentId);

                        boolean created = companyService.addEmployee(employee);
                        if (created) {
                            Window dialog = SwingUtilities.windowForComponent(mainPanel);
                            dialog.dispose();
                        } else {
                            JOptionPane.showMessageDialog(mainPanel, "No se ha creado el empleado.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(mainPanel, "Debe meter un número en la casilla Id Departamento.");

                    }
                }
        );
    }
}

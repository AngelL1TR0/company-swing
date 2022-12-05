package org.iesfm.forms;

import org.iesfm.entity.Department;
import org.iesfm.service.CompanyService;

import javax.swing.*;
import java.awt.*;

public class AddDepartmentForm {
    public JPanel mainPanel;
    private JTextField idTf;
    private JTextField nameTf;
    private JTextField floorNumberTF;
    private JButton addButton;
    private JLabel idLabel;
    private JLabel nameLabel;
    private JLabel floorNumberLabel;

    private CompanyService companyService;

    public AddDepartmentForm(CompanyService companyService) {
        addButton.addActionListener(
                e -> {
                    try {
                        int id = Integer.parseInt(idTf.getText());
                        String name = nameTf.getText();
                        int floorNumber = Integer.parseInt(floorNumberTF.getText());
                        Department department = new Department(id, name, floorNumber);

                        boolean created = companyService.add(department);
                        if (created) {
                            Window dialog = SwingUtilities.windowForComponent(mainPanel);
                            dialog.dispose();
                        } else {
                            JOptionPane.showMessageDialog(mainPanel, "No se ha creado el departamento.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(mainPanel, "Debe meter un número en la casillas Id Departamento y número de planta.");

                    }
                }
        );
    }
}

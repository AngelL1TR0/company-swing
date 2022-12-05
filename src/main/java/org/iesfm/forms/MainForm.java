package org.iesfm.forms;

import org.iesfm.service.CompanyService;

import javax.swing.*;
import java.awt.*;

public class MainForm {
        private JPanel mainPanel;
        private JButton empleadosButton;
        private JButton departamentosButton;
        private CompanyService companyService = new CompanyService();

        public MainForm(JFrame frame) {
            frame.setContentPane(mainPanel);
            createMenuBar(frame);
            showEmployees();
            empleadosButton.addActionListener(e -> {
                showEmployees();
            });
            departamentosButton.addActionListener(e -> {
                showDepartments();
            });
        }

        public void createMenuBar(JFrame frame) {
            JMenuBar menuBar = new JMenuBar();
            JMenu employeeMenu = new JMenu("Menú Empleado");
            menuBar.add(employeeMenu);
            JMenuItem addEmployee = new JMenuItem("Añadir Empleado");
            employeeMenu.add(addEmployee);
            JMenu departmentMenu = new JMenu("Menú Departamento");
            menuBar.add(departmentMenu);
            JMenuItem addDepartment = new JMenuItem("Añadir Departamento");
            departmentMenu.add(addDepartment);

            //Para ver lo añadido volver a pulsar el boton de empleado o departamento
            addEmployee.addActionListener(e -> {
                Window frame1 = SwingUtilities.windowForComponent(mainPanel);
                JDialog dialog = new JDialog(frame1, "Añadir empleado", Dialog.ModalityType.DOCUMENT_MODAL);
                AddEmployeeForm addEmployee1 = new AddEmployeeForm(companyService);
                dialog.setContentPane(addEmployee1.mainPanel);
                dialog.pack();
                dialog.setVisible(true);
            });
            addDepartment.addActionListener(e -> {
                Window frame12 = SwingUtilities.windowForComponent(mainPanel);
                JDialog dialog = new JDialog(frame12, "Añadir departamento", Dialog.ModalityType.DOCUMENT_MODAL);
                AddDepartmentForm addDepartment1 = new AddDepartmentForm(companyService);
                dialog.setContentPane(addDepartment1.mainPanel);
                dialog.pack();
                dialog.setVisible(true);
            });

            frame.setJMenuBar(menuBar);
        }

        private void showDepartments() {
            deleteCenter(mainPanel);
            DepartmentListForm showDepartments = new DepartmentListForm(companyService);;
            mainPanel.add(showDepartments.mainPanel, BorderLayout.CENTER);
            mainPanel.repaint();
            mainPanel.revalidate();
        }

        public void deleteCenter(JPanel panel) {
            BorderLayout layout = (BorderLayout) panel.getLayout();
            Component panelToDelete = layout.getLayoutComponent(BorderLayout.CENTER);
            if (panelToDelete != null) {
                panel.remove(panelToDelete);
            }
        }

        private void showEmployees() {
            deleteCenter(mainPanel);
            EmployeeListForm showEmployees = new EmployeeListForm(companyService);
            mainPanel.add(showEmployees.mainPanel, BorderLayout.CENTER);
            mainPanel.repaint();
            mainPanel.revalidate();
        }

        public static void main(String[] args) {
            JFrame frame = new JFrame();
            frame.setVisible(true);
            frame.setBounds(400,400,500,600);
            var form = new MainForm(frame);
            frame.repaint();
            frame.revalidate();
        }
    }

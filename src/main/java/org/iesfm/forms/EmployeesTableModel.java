package org.iesfm.forms;

import org.iesfm.entity.Employee;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class EmployeesTableModel extends AbstractTableModel {

    private enum EmployeeTableColumns{

        Nif("NIF"),
        Name("Nombre"),
        Surname("Apellidos"),
        Role("Rol"),
        DepartmentId("Id Dept");

        final String header;

        EmployeeTableColumns(String header) {
            this.header = header;
        }
    }

    private List<Employee> employees;

    public EmployeesTableModel(List<Employee> employees) {
        this.employees = employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public int getRowCount() {
        return employees.size();
    }

    @Override
    public int getColumnCount() {
        return EmployeeTableColumns.values().length;
    }

    @Override
    public String getColumnName(int column) {
        return EmployeeTableColumns.values()[column].header;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Employee employee = employees.get(rowIndex);
        switch (EmployeeTableColumns.values()[columnIndex]){
            case Nif:
                return employee.getNif();
            case Name:
                return employee.getName();
            case Surname:
                return employee.getSurname();
            case Role:
                return employee.getRole();
            case DepartmentId:
                return employee.getDepartmentId();
            default:
                throw new RuntimeException("No existe la columna " + columnIndex);
        }
    }
    public void add(Employee employee) {
        employees.add(employee);
    }

    public void delete(int selectedRow) {
        employees.remove(selectedRow);
    }

    public Employee getStudent(int index) {
        return employees.get(index);
    }
}

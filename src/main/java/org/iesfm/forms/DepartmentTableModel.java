package org.iesfm.forms;

import org.iesfm.entity.Department;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class DepartmentTableModel extends AbstractTableModel {

    private enum DepartmentTableColumns{
        ID("ID"),
        Name("Nombre"),
        FloorNumber("Piso");

        final String header;

        DepartmentTableColumns(String header) {
            this.header = header;
        }
    }

    private List<Department> departments;

    public DepartmentTableModel(List<Department>departments){
        super();
        this.departments = departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    @Override
    public int getRowCount() {
        return departments.size();
    }

    @Override
    public int getColumnCount() {
        return DepartmentTableColumns.values().length;
    }

    @Override
    public String getColumnName(int column) {
        return DepartmentTableColumns.values()[column].header;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Department department = departments.get(rowIndex);
        switch (DepartmentTableColumns.values()[columnIndex]){
            case ID:
                return department.getId();
            case Name:
                return department.getName();
            case FloorNumber:
                return department.getFloorNumber();
            default:
                throw new RuntimeException("No existe la columna " + columnIndex);
        }
    }

    public Department getDepartment(int index) {
        return departments.get(index);
    }

}

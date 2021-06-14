package utils;

import javax.swing.table.DefaultTableModel;

public class SedistaTableModel extends DefaultTableModel {
    private boolean[][] editable_cells;

    public SedistaTableModel(Object[] columnNames, int rowCount) {
        super(columnNames, rowCount);
        this.editable_cells = new boolean[5][7];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return this.editable_cells[row][column];
    }

    public void setCellEditable(int row, int col, boolean value) {
        this.editable_cells[row][col] = value;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex != 0)
            return Boolean.class;
        else
            return String.class;
    }

    public boolean[][] getEditable_cells() {
        return editable_cells;
    }
}

package utils;

import aplikacija.Singleton;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class SedistaTableModelListener implements TableModelListener {

    @Override
    public void tableChanged(TableModelEvent e) {
        int row = e.getFirstRow();
        int column = e.getColumn();
        if (column > 0) {
            SedistaTableModel model = (SedistaTableModel) e.getSource();
            Boolean checked = (Boolean) model.getValueAt(row, column);
            int sediste = row*6+column;
            if (checked) {
                if (model.isCellEditable(row, column)) {
                    Singleton.getInstance().getRezervisanaSedista().add(sediste);
                }
            } else {
                Singleton.getInstance().getRezervisanaSedista().remove(sediste);
            }
        }
    }
}

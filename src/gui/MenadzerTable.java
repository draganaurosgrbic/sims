package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Korisnik;

public class MenadzerTable extends AbstractTableModel {

	private String[] columnNames = { "Korisnicko ime", "Lozinka" };
	private List<Korisnik> managers;

	public MenadzerTable(List<Korisnik> managers) {
		super();
		this.managers = managers;
	}

	@Override
	public int getRowCount() {
		return this.managers.size();
	}

	@Override
	public int getColumnCount() {
		return this.columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Korisnik user = this.managers.get(rowIndex);
		if (columnIndex == 0)
			return user.getKorisnickoIme();
		return user.getLozinka();
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public String getColumnName(int column) {
		return this.columnNames[column];
	}

}

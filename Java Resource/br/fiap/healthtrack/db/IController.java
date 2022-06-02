package br.fiap.healthtrack.db;

public interface IController {	
	public void append();
	public void edit();
	public boolean loadData();
	public boolean post();
	public boolean next();
	public boolean first();
	public boolean findAll(int rowNum);
}

package beans;

public class Transformador {

	private int id;
	private Zona zona;
    private List<Cliente> clientes;
    
    public Transformador() {
    	this.clientes = new ArrayLists<Cliente>()	;
    }
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}

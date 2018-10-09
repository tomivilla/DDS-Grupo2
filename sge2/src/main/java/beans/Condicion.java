package beans;

import regla.IOperador;
import regla.iCondicion;

public class Condicion implements iCondicion{
	private int id;
	private int valor;
	private IOperador operador;
    
	private Double valorReferencia;

    public Condicion(IOperador operador, Double valorReferencia) {
        this.operador = operador;
        this.valorReferencia = valorReferencia;
    }

    @Override
    public boolean evaluar(Double valor) {
        return operador.chequear(valor, this.valorReferencia);
    }
	
	public Condicion(){
		this.setValor(-1);
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public void recibirEstado(int estadoObserver) {
		this.setValor(estadoObserver);	
	}

	@Override
	public boolean cumple(Dispositivo unDispositivo) {
		// TODO Auto-generated method stub
		return false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public IOperador getOperador() {
		return operador;
	}

	public void setOperador(IOperador operador) {
		this.operador = operador;
	}

	public Double getValorReferencia() {
		return valorReferencia;
	}

	public void setValorReferencia(Double valorReferencia) {
		this.valorReferencia = valorReferencia;
	}

	
}

package regla;

import dispositivo.Dispositivo;

public class Condicion implements iCondicion{
	int valor;
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
}

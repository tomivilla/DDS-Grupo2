package regla;

import dispositivo.Dispositivo;

public class Condicion implements iCondicion{
	int valor;
	
	public Condicion(){
		this.setValor(-1);
	}
	@Override
	public boolean cumple(Dispositivo unDispositivo) {
		// TODO Auto-generated method stub
		return false;
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
}

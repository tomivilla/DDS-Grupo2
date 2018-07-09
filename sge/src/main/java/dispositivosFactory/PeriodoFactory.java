package dispositivosFactory;

import java.util.ArrayList;
import java.util.List;

import dispositivo.Periodo;

public class PeriodoFactory {
	private static PeriodoFactory periodoFactory;

	private PeriodoFactory(){
		
	}

	public static PeriodoFactory getInstance() {
	    if (periodoFactory == null) {
	    	periodoFactory = new PeriodoFactory();
	    }
	    return periodoFactory;
	}
	
	public Periodo periodo1Hora(){
		
		return  new Periodo(1526680200,1526683800);//1 Hora
	}
	
	public List<Periodo> periodos24Horas(){
		return crearNPeriodos(24);
	}
	public List<Periodo> periodos15Horas(){
		return crearNPeriodos(15);
	}
	public List<Periodo> periodos10Horas(){
		return crearNPeriodos(10);
	}
	public List<Periodo> crearNPeriodos(int CantidadDePeriodos){
		int i=0;
		List<Periodo> periodos = new ArrayList<Periodo>();
		while (i<=CantidadDePeriodos){
			periodos.add(this.periodo1Hora());
			i++;
		}
		return periodos;
	}
}

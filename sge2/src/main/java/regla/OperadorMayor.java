package regla;

public class OperadorMayor implements IOperador {


    @Override
    public boolean chequear(Double valor, Double valorReferencia) {
        return valor.doubleValue() > valorReferencia.doubleValue();
    }
}

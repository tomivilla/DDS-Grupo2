package regla;

public class OperadorIgual implements IOperador {
    @Override
    public boolean chequear(Double valor, Double valorReferencia) {
        return valor.doubleValue() == valorReferencia.doubleValue();
    }
}

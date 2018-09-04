package regla;

public class OperadorMenor implements IOperador {
    @Override
    public boolean chequear(Double valor, Double valorReferencia) {
        return valor.doubleValue() < valorReferencia.doubleValue();
    }
}

package regla;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dispositivo.Dispositivo;

public class ReglasManager {
	private static ReglasManager instance = null;

    public static ReglasManager getInstance() {
        if (instance == null) {
            instance = new ReglasManager();
        }
        return instance;
    }

    private Map<Dispositivo, List<Regla>> reglas;

    private ReglasManager() {
        this.reglas = new HashMap<>();
    }

    public void registrarReglas(Dispositivo dispositivo, List<Regla> reglas) {
        this.reglas.put(dispositivo, reglas);
    }

    public List<Regla> getReglasParaDispositivo(Dispositivo dispositivo) {
        return this.reglas.get(dispositivo);
    }
}

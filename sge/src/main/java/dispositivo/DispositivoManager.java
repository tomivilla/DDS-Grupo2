package dispositivo;

import java.util.HashSet;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import regla.Regla;
import regla.ReglasManager;


//OBSERVER de Dispositivo (para disparar chequeo de reglas ante cambios de mediciones)
public class DispositivoManager implements Observer {
 private static DispositivoManager instance = null;
 private final Set<Dispositivo> dispositivos;

 public static DispositivoManager getInstance() {
     if (instance == null) {
         instance = new DispositivoManager();
     }
     return instance;
 }

 private DispositivoManager() {
     this.dispositivos = new HashSet<>();
 }

 public void registrarDispositivo(Dispositivo dispositivo) {
     dispositivos.add(dispositivo);
     dispositivo.addObserver(this);
 }

 @Override
 public void update(Observable o, Object arg) {
     if (o instanceof Dispositivo) {
         this.handleDispositivoUpdate((Dispositivo) o);
     }
 }

 // Se llama cuando un dispositivos se actualizo (medicion de sensores)
 private void handleDispositivoUpdate(Dispositivo dispositivo) {
     List<Regla> reglas = ReglasManager.getInstance().getReglasParaDispositivo(dispositivo);

     // disparar las reglas asociadas
     reglas.stream().forEachOrdered(Regla::evaluar);
 }
}
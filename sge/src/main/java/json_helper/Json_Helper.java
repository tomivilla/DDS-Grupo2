package json_helper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import Estado.AhorroDeEnergia;
import Estado.Apagado;
import Estado.Encendido;
import Estado.Estado;
import dispositivo.Dispositivo;
<<<<<<< HEAD:sge/src/main/java/json_helper/Json_Helper.java
import dispositivo.DispositivoEstandar;
import dispositivo.DispositivoInteligente;
import dispositivo.Periodo;
=======
import dispositivo.*;
>>>>>>> ad5562c5626f5fd8ccb55447eff972eba8ce5610:TPDDS-Grupo8/sge/src/main/java/json_helper/Json_Helper.java
import sensor.Sensor;
import sensor.SensorDeMovimiento;
import sensor.SensorHumedad;
import sensor.SensorIntensidadLuminica;
import sensor.SensorTemperatura;
import sge_ui.Categoria;
import sge_ui.Cliente;

//Clase para adaptar elementos JSON a objetos nuestros
public class Json_Helper {
	
	public static String readFile(String file) throws IOException {
	    BufferedReader reader = new BufferedReader(new FileReader (file));
	    String         line = null;
	    StringBuilder  stringBuilder = new StringBuilder();
	    String         ls = System.getProperty("line.separator");

	    try {
	        while((line = reader.readLine()) != null) {
	            stringBuilder.append(line);
	            stringBuilder.append(ls);
	        }

	        return stringBuilder.toString();
	    } finally {
	        reader.close();
	    }
	}
	
	public static List<Cliente> JsonToCliente(String path) throws IOException{
		
		String json1 = Json_Helper.readFile(path);
		JsonParser parser = new JsonParser();
		List<Cliente> clientes = new ArrayList<Cliente>();
		// Obtengo el primer ObjetoJason
	   	JsonObject gsonObj1 = parser.parse(json1).getAsJsonObject();
	   	// Obtengo el array clientes
	   	JsonArray gsonArr = gsonObj1.get("clientes").getAsJsonArray();
		
	
	    // Itero el array de clientes
	    for (JsonElement obj : gsonArr) {
	
	        // Obtengo el objeto Cliente
	        JsonObject gsonObj = obj.getAsJsonObject();
	
	        // Obtengo las primitivas del cliente
	        String unNombre = gsonObj.get("nombre").getAsString();
	        String unNmbUsuario = gsonObj.get("nombre_de_usuario").getAsString();
	        String unaContrasena = gsonObj.get("contrasena").getAsString();
	        String unTipoDoc = gsonObj.get("tipoDoc").getAsString(); 
	        String unNumDoc = gsonObj.get("numDoc").getAsString();
	        int unTelefono = gsonObj.get("telefono").getAsInt();
	        String unDomicilio = gsonObj.get("domicilio").getAsString();
	        int unaFecha = gsonObj.get("fecha").getAsInt();
	        Categoria unaCategoria = new Categoria(0,0,0.0,0.0);
	        
	        // Obtengo el array de dispositivos
	        JsonArray dispositivo_s = gsonObj.get("dispositivos").getAsJsonArray();
	        List<Dispositivo> listDispositivo = new ArrayList<Dispositivo>();
	        
	        // Itero el array de dispositivos
	        for (JsonElement disp : dispositivo_s) {
	        	
	        	// Obtengo el objeto Dispositivo
	        	JsonObject di = disp.getAsJsonObject();
	        	
	        	// Obtengo las primitivas del Dispositivo
	        	String nombre_generico = di.get("nombre_generico").getAsString();
	            double consumoKWHora = di.get("consumoKWHora").getAsDouble();
	            int horasEncendido = di.get("horasEncendido").getAsInt();
	            DispositivoEstandar dispositivo = new DispositivoEstandar(nombre_generico,consumoKWHora,horasEncendido); 
	        	listDispositivo.add(dispositivo);
	        }
	        
	        JsonArray dispositivos_i = gsonObj.get("dispositivos_i").getAsJsonArray();
	        	        
	        // Itero el array de dispositivos
	        for (JsonElement disp : dispositivos_i) {
	        	
	        	// Obtengo el objeto Dispositivo
	        	JsonObject dis = disp.getAsJsonObject();
	        	
	        	// Obtengo las primitivas del Dispositivo
	        	String nombre_generico = dis.get("nombre_generico").getAsString();
	            double consumoKWHora = dis.get("consumoKWHora").getAsDouble();
	            String estado = dis.get("estado").getAsString();
	            Estado objEstado = seleccionarEstado(estado);
	            //String actuador = dis.get("actuador").getAsString();
	            
	            JsonArray sensores = dis.get("sensores").getAsJsonArray();
	            List<Sensor> listaDeSensores= new ArrayList<Sensor>();
	            for (JsonElement sens : sensores){
	            	JsonObject sen = sens.getAsJsonObject();
	            	
	            	// Obtengo las primitivas del Sensor
	            	int valor = sen.get("valor").getAsInt();
	            	String magnitud = sen.get("magnitud").getAsString();
	            	Sensor sensor = generarSensor(valor,magnitud);
	            	listaDeSensores.add(sensor);
	            }
	            JsonArray periodos = dis.get("periodos").getAsJsonArray();
	            List<RegistroConsumo> listaDePeriodos= new ArrayList<RegistroConsumo>();
	            for (JsonElement peri : periodos){
	            	JsonObject per = peri.getAsJsonObject();
	            	
	            	// Obtengo las primitivas del Sensor
	            	long inicio = per.get("inicio").getAsLong();
	            	long fin = per.get("fin").getAsLong();
	            	RegistroConsumo periodo = new RegistroConsumo(inicio,fin);
	            	listaDePeriodos.add(periodo);
	            }
	            
	            //Actuador objActuador = seleccionarActuador(actuador);
	            DispositivoInteligente dispositivo = new DispositivoInteligente(nombre_generico,consumoKWHora,objEstado,listaDeSensores,listaDePeriodos); 
	        	listDispositivo.add(dispositivo);
	        }
	        
	        //Instancio el cliente
	        clientes.add(new Cliente(unNombre,unNmbUsuario,unaContrasena,unTipoDoc,unNumDoc,unTelefono,unDomicilio,unaFecha,unaCategoria,listDispositivo));
	    }
	    
	    //Retorno el listado de clientes que obtuve del Jason
		return clientes;
	}

	private static Estado seleccionarEstado(String estado) {
		if(estado.equals("Encendido")){
			return Encendido.getInstance();
		}
		else{
			if(estado.equals("ModoAhorro")){
				return AhorroDeEnergia.getInstance();
			}
			else{
				return Apagado.getInstance();
			}
		}
	}
	private static Sensor generarSensor(int valor, String magnitud){
		Sensor sensor=null;
		switch (magnitud){
		case "°C": sensor = new SensorTemperatura(valor,magnitud);
		break;
		case "%": sensor = new SensorHumedad(valor,magnitud);
		break;
		case "lumenes": sensor = new SensorIntensidadLuminica(valor,magnitud);
		break;
		case "Movimiento": sensor = new SensorDeMovimiento(valor,magnitud);
		break;
		}
		return sensor;
	} 
}

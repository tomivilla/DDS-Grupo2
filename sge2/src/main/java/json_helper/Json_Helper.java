package json_helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import Estado.AhorroDeEnergia;
import Estado.Apagado;
import Estado.Encendido;
import beans.Categoria;
import beans.Cliente;
import beans.DispositivoEstandar;
import beans.DispositivoInteligente;
import beans.Documento;
import beans.Estado;
import beans.Periodo;
import beans.Sensor;
import beans.Transformador;
import beans.Zona;
import sensor.SensorDeMovimiento;
import sensor.SensorHumedad;
import sensor.SensorIntensidadLuminica;
import sensor.SensorTemperatura;

//Clase para adaptar elementos JSON a objetos nuestros
public class Json_Helper {
	
	public String readFile(String file) throws IOException {
		
		InputStream is = getClass().getResourceAsStream(file);
		
	    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
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
	
	public List<Cliente> JsonToCliente (String path) throws IOException{
		List<Cliente> clientes = new ArrayList<Cliente>();
		Json_Helper jsonHelper = new Json_Helper();
		Gson gson = new Gson();
		
		String json1 = jsonHelper.readFile(path);
		JsonParser parser = new JsonParser();
		JsonObject gsonObj1 = parser.parse(json1).getAsJsonObject();
		JsonArray gsonArr = gsonObj1.get("clientes").getAsJsonArray();
		
		Type listType = new TypeToken<ArrayList<Cliente>>(){}.getType();
		clientes = gson.fromJson(gsonArr.toString(), listType);
		
		return clientes;
	}
	
	public static List<Cliente> JsonToClientes(String path) throws IOException{
		
		String json1 = Json_Helper.readFile(path);
		JsonParser parser = new JsonParser();
		List<Cliente> clientes = new ArrayList<Cliente>();
		//Obtengo el primer ObjetoJason
	   	JsonObject gsonObj1 = parser.parse(json1).getAsJsonObject();
	   	//Obtengo el array clientes
	   	JsonArray gsonArr = gsonObj1.get("clientes").getAsJsonArray();
		
	
	    //Itero el array de clientes
	    for (JsonElement obj : gsonArr) {
	
	        //Obtengo el objeto Cliente
	        JsonObject gsonObj = obj.getAsJsonObject();
	
	        //btengo las primitivas del cliente
	        String unNombre = gsonObj.get("nombre").getAsString();
	        String unNmbUsuario = gsonObj.get("nombre_de_usuario").getAsString();
	        String unaContrasena = gsonObj.get("contrasena").getAsString();
	       
	        int id_documento = 0;
	        
	        JsonObject id_i = gsonObj.get("documento").getAsJsonObject();
	        //for (JsonElement id : id_i) {
	        	
	        	//Obtengo el objeto Dispositivo
	        	//JsonObject di_doc = id.getAsJsonObject();
	        	
	        	//Obtengo las primitivas del Dispositivo
	        	id_documento = id_i.get("id").getAsInt();
	        //}
	        Documento id_posta = new Documento();
	        id_posta.setId(id_documento);
	        String unNumDoc = gsonObj.get("numDoc").getAsString();
	        int unTelefono = gsonObj.get("telefono").getAsInt();
	        String unDomicilio = gsonObj.get("domicilio").getAsString();
	        
	        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");
	   	 
	    	Date unaFecha = new Date();
			try {
				unaFecha = dateFormat.parse(gsonObj.get("fecha").getAsString());
			} catch (ParseException e) {
				e.printStackTrace();
			}
	        Categoria unaCategoria = new Categoria(0,0,0,0.0,0.0);
	        
	        //Obtengo el array de dispositivos
	        JsonArray dispositivo_s = gsonObj.get("dispositivosEstandar").getAsJsonArray();
	        List<DispositivoInteligente> listDispositivoInteligente = new ArrayList<DispositivoInteligente>();
	        List<DispositivoEstandar> listDispositivoEstandar = new ArrayList<DispositivoEstandar>();
	        //Itero el array de dispositivos
	        for (JsonElement disp : dispositivo_s) {
	        	
	        	//Obtengo el objeto Dispositivo
	        	JsonObject di = disp.getAsJsonObject();
	        	
	        	//Obtengo las primitivas del Dispositivo
	        	Long id = di.get("id").getAsLong();
	        	String nombre_generico = di.get("nombre_generico").getAsString();
	            double consumoKWHora = di.get("consumoKWHora").getAsDouble();
	            int horasEncendido = di.get("horasEncendido").getAsInt();
	            DispositivoEstandar dispositivo = new DispositivoEstandar(id, nombre_generico,consumoKWHora,horasEncendido, false); 
	            listDispositivoEstandar.add(dispositivo);
	        }
	        
	        JsonArray dispositivos_i = gsonObj.get("dispositivosInteligentes").getAsJsonArray();
	        	        
	        //Itero el array de dispositivos
	        for (JsonElement disp : dispositivos_i) {
	        	
	        	//Obtengo el objeto Dispositivo
	        	JsonObject dis = disp.getAsJsonObject();
	        	
	        	//Obtengo las primitivas del Dispositivo
	        	Long id = dis.get("id").getAsLong();
	        	String nombre_generico = dis.get("nombre_generico").getAsString();
	            double consumoKWHora = dis.get("consumoKWHora").getAsDouble();
	            String estado = dis.get("estado").getAsString();
	            Estado objEstado = seleccionarEstado(estado);
	            //String actuador = dis.get("actuador").getAsString();
	            
	            JsonArray sensores = dis.get("sensores").getAsJsonArray();
	            List<Sensor> listaDeSensores= new ArrayList<Sensor>();
	            for (JsonElement sens : sensores){
	            	JsonObject sen = sens.getAsJsonObject();
	            	
	            	//Obtengo las primitivas del Sensor
	            	int valor = sen.get("valor").getAsInt();
	            	String magnitud = sen.get("magnitud").getAsString();
	            	Sensor sensor = generarSensor(valor,magnitud);
	            	listaDeSensores.add(sensor);
	            }
	            JsonArray periodos = dis.get("periodos").getAsJsonArray();
	            List<Periodo> listaDePeriodos= new ArrayList<Periodo>();
	            for (JsonElement peri : periodos){
	            	JsonObject per = peri.getAsJsonObject();
	            	
	            	//Obtengo las primitivas del Sensor
	            	long inicio = per.get("inicio").getAsLong();
	            	long fin = per.get("fin").getAsLong();
	            	Periodo periodo = new Periodo(inicio,fin);
	            	listaDePeriodos.add(periodo);
	            }
	            
	            //Actuador objActuador = SGE.getInstance().seleccionarActuador(actuador);
	            DispositivoInteligente dispositivo = new DispositivoInteligente(id, nombre_generico,consumoKWHora,objEstado, true,listaDeSensores,listaDePeriodos); 
	            listDispositivoInteligente.add(dispositivo);
	        }
	        
	        //Instancio el cliente
	        clientes.add(new Cliente(unNombre,unNmbUsuario,unaContrasena,id_posta,unNumDoc,unTelefono,unDomicilio,unaFecha,unaCategoria,listDispositivoEstandar,listDispositivoInteligente));
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
	
	public List<Transformador> jsonToTransformadores(String path) throws IOException{
		Json_Helper jsonHelper = new Json_Helper();
		String json1 = jsonHelper.readFile(path);
		JsonParser parser = new JsonParser();
		List<Transformador> transformadores = new ArrayList<Transformador>();
		//Obtengo el primer ObjetoJason
	   	JsonArray gsonObj1 = parser.parse(json1).getAsJsonArray();

	   	for (JsonElement obj : gsonObj1) {
	   		
	        //Obtengo el objeto Cliente
	        JsonObject gsonObj = obj.getAsJsonObject();
	
	        //Obtengo las primitivas del cliente
	        Transformador transformador = new Transformador();
	        transformador.setId(gsonObj.get("id").getAsLong());
	        transformador.setLatitud(gsonObj.get("latitud").getAsDouble());
	        transformador.setLongitud(gsonObj.get("longitud").getAsDouble());
	        transformador.setZona(gsonObj.get("zona").getAsInt());
	        
	        transformadores.add(transformador);

	   	}
	   	
	   	return transformadores;
	}
	
	public List<Zona> jsonToZonas(String path) throws IOException{
		Json_Helper jsonHelper = new Json_Helper();
		String json1 = jsonHelper.readFile(path);
		JsonParser parser = new JsonParser();
		List<Zona> zonas = new ArrayList<Zona>();
		//Obtengo el primer ObjetoJason
	   	JsonArray gsonObj1 = parser.parse(json1).getAsJsonArray();

	   	for (JsonElement obj : gsonObj1) {
	   		
	        //Obtengo el objeto Cliente
	        JsonObject gsonObj = obj.getAsJsonObject();
	
	        //Obtengo las primitivas del cliente
	        Zona zona = new Zona();
	        zona.setNombre(gsonObj.get("nombre").getAsString());
	        zona.setId(gsonObj.get("id").getAsInt());
	        zona.setLatitud(gsonObj.get("latitud").getAsDouble());
	        zona.setLongitud(gsonObj.get("longitud").getAsDouble());
	        zona.setRadio(gsonObj.get("radio").getAsDouble());
	        zona.setTransformadores(new ArrayList<Transformador>());
	        
	        zonas.add(zona);

	   	}
	   	
	   	return zonas;
	}
}

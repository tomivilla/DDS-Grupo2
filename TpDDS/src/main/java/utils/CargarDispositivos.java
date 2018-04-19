package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import beans.Dispositivo;

public class CargarDispositivos {

	
	public static List<Dispositivo> cargarDispositivos(String nombreArchivo){
		
		Gson gson = new Gson();
		List<Dispositivo> dispositivos = null;
		Type listType = new TypeToken<ArrayList<Dispositivo>>(){}.getType();
		
		try {
			String json = ArchivosHelper.leerArchivo(nombreArchivo);
			
			dispositivos = gson.fromJson(json, listType);
			
			return dispositivos;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dispositivos;
		
		
	}
}

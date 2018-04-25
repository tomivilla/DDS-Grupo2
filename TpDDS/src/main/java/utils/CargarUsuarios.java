package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import beans.Usuario;
import beans.UsuariosResponse;

public class CargarUsuarios {

	public static UsuariosResponse cargarUsuarios(String nombreArchivo){
		
		Gson gson = new Gson();
		UsuariosResponse usuarios = new UsuariosResponse();
//		Type listType = new TypeToken<ArrayList<Usuario>>(){}.getType();
		
		try {
			String json = ArchivosHelper.leerArchivo(nombreArchivo);
			
			usuarios = gson.fromJson(json, UsuariosResponse.class);
			
			return usuarios;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuarios;
		
		
	}
	
}

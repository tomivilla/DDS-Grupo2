package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ArchivosHelper {

	public static String leerArchivo (String nombreArchivo) throws FileNotFoundException, IOException{
		
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String contenido = "";
        
        try {
			// Apertura del fichero y creacion de BufferedReader
			archivo = new File (nombreArchivo);
			fr = new FileReader (archivo);
			br = new BufferedReader(fr);
 
			// Lectura del fichero
			System.out.println("Leyendo el contendio del archivo.txt");
			String linea;
			while((linea=br.readLine())!=null)
				contenido += linea;
        }
        catch(Exception e){
           e.printStackTrace();
        }finally{
           // En el finally cerramos el fichero, para asegurarnos
           // que se cierra tanto si todo va bien como si salta 
           // una excepcion.
           try{
              if( null != fr ){
                 fr.close();
              }
              return contenido;
           }catch (Exception e2){
              e2.printStackTrace();
           }
        }
		return contenido;
    }
}

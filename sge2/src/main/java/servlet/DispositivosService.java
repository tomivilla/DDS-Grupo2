package servlet;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import beans.Dispositivo;
import json_helper.HibernateProxyTypeAdapter;
import persistencia.DBHelper;
import request.DispositivoRequest;

@RestController
@RequestMapping("/dispositivos")
public class DispositivosService {
	DBHelper dbhelper = new DBHelper();
	
	@RequestMapping(method = POST, path= "/crear/dispPosible")
    public String nuevoDispositivo(@RequestBody DispositivoRequest dispReq) {
    	String nombre = dispReq.getNombre();
    	Double consumo = dispReq.getConsumo();
    	boolean esInteligente = dispReq.isInteligente();
    	boolean esBajoConsumo = dispReq.isBajoConsumo();
    	
    	Long idDisp = -1L;
    	
    	try {
    		Dispositivo disp = new Dispositivo(null, nombre, consumo, esInteligente, esBajoConsumo);
    		
    		idDisp = dbhelper.storeDispositivoPosible(disp);
			
		} catch (Exception e) {
			return "ups";
		}
    	
    	GsonBuilder b = new GsonBuilder();
    	b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
    	
    	Gson gson = b.create();
    	
    	try {
    		Dispositivo dispGrabado = dbhelper.getDispositivoPosibleById(idDisp);
    		
    		return gson.toJson(dispGrabado);
		} catch (Exception e) {
			return "ups";
		} 
    	
    }

}

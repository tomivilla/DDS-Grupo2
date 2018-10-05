package servlet;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import beans.Administrador;
import beans.Usuario;
import json_helper.HibernateProxyTypeAdapter;
import persistencia.DBHelper;
import request.LoginRequest;

@RestController
@RequestMapping("/login")
public class Login {
	DBHelper dbhelper = new DBHelper();

    
    @RequestMapping(method = POST)
    public String login(@RequestBody LoginRequest loginReq) {
    	String username = loginReq.getUsername();
    	String password = loginReq.getPassword();
    	boolean esAdmin = loginReq.isAdmin();
    	
    	GsonBuilder b = new GsonBuilder();
    	b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
    	
    	Gson gson = b.create();
    	
    	Usuario usu;
    	
    	try {
    		if (esAdmin) {
    			usu = dbhelper.loginAdmin(username, password);
			}else {
				usu = dbhelper.loginCliente(username, password);
			}
			
			if (usu.getId() != null) {
			    return gson.toJson(usu);
			}
		} catch (Exception e) {
			return "ups";
		} 
    	
    	return "ups";
    }

}

package servlet;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import beans.Administrador;
import persistencia.DBHelper;
import request.LoginRequest;

@RestController
@RequestMapping("/api/login")
public class Login {
	DBHelper dbhelper;

    
    @RequestMapping(method = POST)
    public String login(@RequestBody LoginRequest loginReq) {
    	String username = loginReq.getUsername();
    	String password = loginReq.getPassword();
    	
    	Administrador adm = dbhelper.loginAdmin(username, password);
    	
    	if (adm.getId() != null) {
            return adm.getNombre();
        } 
    	
    	return "ups";
    }

}

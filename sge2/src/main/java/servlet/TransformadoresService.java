package servlet;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import beans.Transformador;
import persistencia.DBHelper;

@RestController
@RequestMapping("/transformadores")
public class TransformadoresService {
	DBHelper dbhelper = new DBHelper();
	
	@RequestMapping(method = GET)
	public String traerTransformadores() {
    	
		List<Transformador> transformadores;
		Gson gson = new Gson();
		
		try {
			transformadores = dbhelper.listTransformadores();
			return gson.toJson(transformadores);
			
		} catch (Exception e) {
			return "ups";
		}

    
    }

}

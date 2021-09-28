package es.cic.bootcamp.individual14_final.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import es.cic.bootcamp.individual14_final.model.TipoMedida;
import es.cic.bootcamp.individual14_final.service.TipoMedidaService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/inicio")
public class InicioController {

	@Autowired
	private TipoMedidaService tipoMedidaService;
	
	public void setConectorService(TipoMedidaService tipoMedidaService) {
		this.tipoMedidaService = tipoMedidaService;
	}
	
	@PostMapping("/rellenarTablas")
    public ResponseEntity<HttpStatus> crearListaInicial() {

        if (tipoMedidaService.findAll().isEmpty()) {
            TipoMedida tipoMedida1 = new TipoMedida("Presion", "Pascales");
            TipoMedida tipoMedida2 = new TipoMedida("Temperatura", "Kelvin");
            TipoMedida tipoMedida3 = new TipoMedida(".Temperatura", "Grados Celsius");
            
            tipoMedidaService.create(tipoMedida1);
            tipoMedidaService.create(tipoMedida2);
            tipoMedidaService.create(tipoMedida3);
        }

        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }
	
}

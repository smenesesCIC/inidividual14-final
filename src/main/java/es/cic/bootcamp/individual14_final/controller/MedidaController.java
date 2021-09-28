package es.cic.bootcamp.individual14_final.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import es.cic.bootcamp.individual14_final.model.TipoMedida;
import es.cic.bootcamp.individual14_final.service.TipoMedidaService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/conexiones")
public class MedidaController {

	@Autowired
	private TipoMedidaService tipoMedidaService;
	
	public void setConectorService(TipoMedidaService tipoMedidaService) {
		this.tipoMedidaService = tipoMedidaService;
	}
	
	@PostMapping(path = "/lista")
	public ResponseEntity <List<TipoMedida>> findAll(){
		List<TipoMedida> tipoMedida = tipoMedidaService.findAll();
		return new ResponseEntity<List<TipoMedida>>(tipoMedida, HttpStatus.OK);
	}

	@GetMapping("/detalle/{id}")
	@ResponseBody
	public TipoMedida findById(@PathVariable(name = "id") Long id) {
		return tipoMedidaService.findById(id);
	}


	@PostMapping("/detalle")
	public Long create(@Valid @RequestBody TipoMedida tipoMedida) {
		return tipoMedidaService.create(tipoMedida);
	}
	
	@PutMapping("/detalle")
	@ResponseBody
	public TipoMedida update(@Valid @RequestBody TipoMedida tipoMedida) {
		return tipoMedidaService.update(tipoMedida);
	}
	
	@DeleteMapping("/detalle/{id}")
	public void deleteById(@PathVariable (name = "id") Long id) {
		tipoMedidaService.deleteById(id);
	}

}

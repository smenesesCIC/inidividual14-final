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

import es.cic.bootcamp.individual14_final.model.Medida;
import es.cic.bootcamp.individual14_final.service.MedidaService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/instancias")
public class TipoMedidaController {

	@Autowired
	private MedidaService medidaService;
	
	public void setInstanciaService(MedidaService medidaService) {
		this.medidaService = medidaService;
	}
	
	@PostMapping(path = "/lista")
	public ResponseEntity <List<Medida>> findAll(){
		List<Medida> medida = medidaService.findAll();
		return new ResponseEntity<List<Medida>>(medida, HttpStatus.OK);
	}

	@GetMapping("/detalle/{id}")
	@ResponseBody
	public Medida findById(@PathVariable(name = "id") Long id) {
		return medidaService.findById(id);
	}

	@PostMapping("/detalle")
	public Long create(@Valid @RequestBody Medida medida) {
		return medidaService.create(medida);
	}
	
	@PutMapping("/detalle")
	@ResponseBody
	public Medida update(@Valid @RequestBody Medida medida) {
		return medidaService.update(medida);
	}
	
	@DeleteMapping("/detalle/{id}")
	public void deleteById(@PathVariable (name = "id") Long id) {
		medidaService.deleteById(id);
	}

}

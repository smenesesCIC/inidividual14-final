package es.cic.bootcamp.individual14_final.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.cic.bootcamp.individual14_final.exception.IdNoValidoException;
import es.cic.bootcamp.individual14_final.exception.RegistroNoExisteException;
import es.cic.bootcamp.individual14_final.exception.RegistroYaCreadoException;
import es.cic.bootcamp.individual14_final.model.Medida;
import es.cic.bootcamp.individual14_final.repository.MedidaRepository;

@Service
public class MedidaService {
	
	private static final String ID_NO_VALIDO = "El id introducido no es válido";
	
	private static final String REGISTRO_NO_EXISTE = "El registro introducido no existe";
	
	@Autowired
	private MedidaRepository medidaRepository;
	
	public Long create(Medida medida) {
		
		if(medida.getId() != null) {
			throw new RegistroYaCreadoException("El registro introducido ya existe");
		}
		
		return medidaRepository.save(medida).getId();
	}
	
	public Medida findById(Long id) {
		
		if(id <= 0) {
			throw new IdNoValidoException(ID_NO_VALIDO);
		}
		
		Optional<Medida> optional = medidaRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			throw new RegistroNoExisteException(REGISTRO_NO_EXISTE);
		}
	}
	
	public List<Medida> findAll(){
		
		List<Medida> medidas = new ArrayList<>();
		medidaRepository.findAll()
			.forEach(medidas::add);
			
		return medidas;
	}
	
	public Medida update(Medida medida) {
		
		if(medida.getId() == null) {
			throw new RegistroNoExisteException(REGISTRO_NO_EXISTE);
		}
		
		if(medida.getId() <= 0) {
			throw new IdNoValidoException(ID_NO_VALIDO);
		}
		
		Optional<Medida> optional = medidaRepository.findById(medida.getId());
		if(optional.isEmpty()) {
			throw new RegistroNoExisteException(REGISTRO_NO_EXISTE);
		}
		
		return medidaRepository.save(medida);
		
	}
	
	public void deleteById(Long id) {
		
		if(id <= 0) {
			throw new IdNoValidoException(ID_NO_VALIDO);
		}
		
		Optional<Medida> optional = medidaRepository.findById(id);
		if(optional.isPresent()) {
			medidaRepository.deleteById(id);
		}else {
			throw new RegistroNoExisteException(REGISTRO_NO_EXISTE);
		}
		
	}

}

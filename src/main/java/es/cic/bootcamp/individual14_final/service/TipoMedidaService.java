package es.cic.bootcamp.individual14_final.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.cic.bootcamp.individual14_final.exception.IdNoValidoException;
import es.cic.bootcamp.individual14_final.exception.RegistroNoExisteException;
import es.cic.bootcamp.individual14_final.exception.RegistroYaCreadoException;
import es.cic.bootcamp.individual14_final.model.TipoMedida;
import es.cic.bootcamp.individual14_final.repository.TipoMedidaRepository;

@Service
public class TipoMedidaService {
	
	private static final String ID_NO_VALIDO = "El id introducido no es válido";
	
	private static final String REGISTRO_NO_EXISTE = "El registro introducido no existe";
	
	@Autowired
	private TipoMedidaRepository tipoMedidaRepository;
	
	public Long create(TipoMedida tipoMedida) {
		
		if(tipoMedida.getId() != null) {
			throw new RegistroYaCreadoException("El registro introducido ya existe");
		}
		
		return tipoMedidaRepository.save(tipoMedida).getId();
	}
	
	public TipoMedida findById(Long id) {
		
		if(id <= 0) {
			throw new IdNoValidoException(ID_NO_VALIDO);
		}
		
		Optional<TipoMedida> optional = tipoMedidaRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			throw new RegistroNoExisteException(REGISTRO_NO_EXISTE);
		}
	}
	
	public List<TipoMedida> findAll(){
		
		List<TipoMedida> tipoMedidas = new ArrayList<>();
		tipoMedidaRepository.findAll()
			.forEach(tipoMedidas::add);
			
		return tipoMedidas;
	}
	
	public TipoMedida update(TipoMedida tipoMedida) {
		
		if(tipoMedida.getId() == null) {
			throw new RegistroNoExisteException(REGISTRO_NO_EXISTE);
		}
		
		if(tipoMedida.getId() <= 0) {
			throw new IdNoValidoException(ID_NO_VALIDO);
		}
		
		Optional<TipoMedida> optional = tipoMedidaRepository.findById(tipoMedida.getId());
		if(optional.isEmpty()) {
			throw new RegistroNoExisteException(REGISTRO_NO_EXISTE);
		}		
		
		return tipoMedidaRepository.save(tipoMedida);
		
	}
	
	public void deleteById(Long id) {
		
		if(id <= 0) {
			throw new IdNoValidoException(ID_NO_VALIDO);
		}
		
		Optional<TipoMedida> optional = tipoMedidaRepository.findById(id);
		if(optional.isPresent()) {
			tipoMedidaRepository.deleteById(id);
		}else {
			throw new RegistroNoExisteException(REGISTRO_NO_EXISTE);
		}
		
	}

}

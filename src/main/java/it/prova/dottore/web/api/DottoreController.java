package it.prova.dottore.web.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.prova.dottore.dto.DottoreDTO;
import it.prova.dottore.model.Dottore;
import it.prova.dottore.service.DottoreService;
import it.prova.dottore.web.api.exception.DottoreNotFoundException;
import it.prova.dottore.web.api.exception.IdNotNullForInsertException;

@RestController
@RequestMapping("/api/dottore")
public class DottoreController {

	@Autowired
	private DottoreService service;
	
	@GetMapping
	public List<DottoreDTO> getAll(){
		return DottoreDTO.createDottoreDTOListFromModelList(service.listAllElements());
	}
	
	@GetMapping("/{id}")
	public DottoreDTO getOne(@PathVariable(value = ("id"),required = true) Long id) {
		return DottoreDTO.buildDottoreDTOFromModel(service.caricaSingoloElemento(id));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DottoreDTO createNew(@Valid @RequestBody DottoreDTO dottoreInput) {
		if (dottoreInput.getId() != null) {
			throw new IdNotNullForInsertException("Non è ammesso fornire un id per la creazione");
		}
		Dottore dottoreInserito = service.inserisciNuovo(dottoreInput.buildModel());
		return DottoreDTO.buildDottoreDTOFromModel(dottoreInserito);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(required = true)Long id) {
		Dottore dottoreToRemove = service.caricaSingoloElemento(id);
		if (dottoreToRemove == null) {
			throw new DottoreNotFoundException("Dottore non trovato");
		}
		service.elimina(id);
	}
	
	@PutMapping("/{id}")
	public DottoreDTO update(@Valid @RequestBody DottoreDTO dottoreInput,@PathVariable(required = true)Long id) {
		Dottore dottoreToUpdate= service.caricaSingoloElemento(id);
		if (dottoreToUpdate == null) {
			throw new DottoreNotFoundException("Dottore non trovato");
		}
		dottoreInput.setId(id);
		Dottore dottoreAggiornato = service.aggiorna(dottoreInput.buildModel());
		return DottoreDTO.buildDottoreDTOFromModel(dottoreAggiornato);
	} 
}

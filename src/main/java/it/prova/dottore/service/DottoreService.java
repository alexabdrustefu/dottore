package it.prova.dottore.service;

import java.util.List;

import org.springframework.data.domain.Page;

import it.prova.dottore.model.Dottore;


public interface DottoreService {

	public List<Dottore> listAllElements();

	public Dottore caricaSingoloElemento(Long id);

	public Dottore aggiorna(Dottore dottoreInstance);

	public Dottore inserisciNuovo(Dottore dottoreInstance);

	public void elimina(Long id);

	public Page<Dottore> findByExampleWithPagination(Dottore example, Integer pageNo, Integer pageSize, String sortBy);

	
}
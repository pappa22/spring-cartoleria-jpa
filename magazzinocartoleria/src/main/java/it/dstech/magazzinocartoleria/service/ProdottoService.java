package it.dstech.magazzinocartoleria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.dstech.magazzinocartoleria.model.Prodotto;
import it.dstech.magazzinocartoleria.repository.ProdottoRepository;

@Service
@Transactional
public class ProdottoService {
	@Autowired ProdottoRepository repo;
	
	public void save(Prodotto prodotto) {
		
		repo.save(prodotto);
	}
	
	public List<Prodotto> listAll() {
		return (List<Prodotto>) repo.findAll();
	}
	
	public Prodotto get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	public List<Prodotto> search(String keyword) {
		return repo.search(keyword);
	}
}

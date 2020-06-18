package it.dstech.magazzinocartoleria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.dstech.magazzinocartoleria.model.Prodotto;

public interface ProdottoRepository extends CrudRepository<Prodotto, Long> {
	
	@Query(value = "SELECT p FROM Prodotto p WHERE p.nome LIKE '%' || :keyword || '%'"
			+ " OR p.quantita LIKE '%' || :keyword || '%'"
			+ " OR p.categoria LIKE '%' || :keyword || '%'")
	public List<Prodotto> search(@Param("keyword") String keyword);
}

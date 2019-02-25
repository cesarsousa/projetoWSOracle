package br.com.coti.repository;

import java.util.Date;
import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.coti.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	
	public Usuario findByNumero(String numero);
	
	@Query("select obj from Usuario as obj where obj.dataCadastro >= :dataCadastro")
	List<Usuario> findAllWithDataCadastroAfter (@Param("dataCadastro") Date dataCadastro);

}

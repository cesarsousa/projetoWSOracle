package br.com.coti.controller;

import java.util.Date;
import java.util.List;

import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.coti.entity.Usuario;
import br.com.coti.repository.UsuarioRepository;

@CrossOrigin(origins="*", maxAge=3600)
@Controller
public class ControllerUsuario {
	
	@Autowired
	private UsuarioRepository dao;
	
	@PostMapping(value="usuario")
	public ResponseEntity<Usuario> create(@RequestBody Usuario user) {
		
		try {
			dao.save(user);
			return ResponseEntity.ok(user);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
		
	}
	
	@GetMapping(value="usuario")
	public ResponseEntity<List<Usuario>> lista() {
		
		List<Usuario> listagem = null;
		listagem =(List<Usuario>) dao.findAll();
		return ResponseEntity.ok(listagem); 
		
	}
	
	@GetMapping(value="usuario/{numero}")
	public ResponseEntity<Usuario> findByNumero(@PathVariable("numero") String numero) {
		
		try {
			Usuario resposta = dao.findByNumero(numero);
			return ResponseEntity.ok(resposta); 
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		} 
		
	}
	
	@PostMapping(value="dataCadastro")
	public ResponseEntity<List<Usuario>> findByDate(
			@RequestParam("dataCadastro") 
			@DateTimeFormat(iso=DateTimeFormat.ISO.DATE) Date dataCadastro) {
				
		try {
			
			List<Usuario> resposta = dao.findAllWithDataCadastroAfter(dataCadastro);
			return ResponseEntity.ok(resposta); 
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		} 
		
	}
	
	

}

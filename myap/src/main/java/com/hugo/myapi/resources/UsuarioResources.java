package com.hugo.myapi.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import com.hugo.myapi.domain.Usuarios;
import com.hugo.myapi.service.UsuariosService;



@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResources {
	
	@Autowired
	private UsuariosService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuarios> findById(@PathVariable Integer id){
		Usuarios obj = this.service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<Usuarios>> findAll(){
		List<Usuarios> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	@PutMapping(value = "/{id}")
	public ResponseEntity<Usuarios> update(@PathVariable Integer id, @RequestBody Usuarios obj){
		Usuarios newObj = service.update(id, obj);
		return ResponseEntity.ok().body(newObj);
				
	}
	@PostMapping
	public ResponseEntity<Usuarios> create(@RequestBody Usuarios obj){
		 Usuarios newObj = service.create(obj);
		 URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		 return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping( value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}


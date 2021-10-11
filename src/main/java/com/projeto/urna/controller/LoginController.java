package com.projeto.urna.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.urna.dto.LoginDTO;
import com.projeto.urna.form.CadastroLoginForm;
import com.projeto.urna.form.LoginForm;
import com.projeto.urna.model.Login;
import com.projeto.urna.repository.LoginRepository;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginRepository loginRepository;

	@CrossOrigin	
	@PostMapping
	public ResponseEntity<Object> acessar(@RequestBody LoginForm loginForm) {
		List<Login> usuarios = loginRepository.findByUsuario(loginForm.getUsuario());
		
		if (usuarios.size() != 0) {
			if (usuarios.get(0).getSenha().equals(loginForm.getSenha())) {
				LoginDTO loginDTO = new LoginDTO(new Date(), true);
				return ResponseEntity.ok().body(loginDTO);
			}
		}
		
		return ((BodyBuilder) ResponseEntity.notFound()).body(new LoginDTO(new Date(), false));
	}

	@CrossOrigin
	@PostMapping("/cadastro")
	public ResponseEntity<Object> cadastrar(@RequestBody CadastroLoginForm cadastroLoginForm) {
		List<Login> usuarios = loginRepository.findByUsuario(cadastroLoginForm.getUsuario());
		if (usuarios.size() == 0) {
			Login login = cadastroLoginForm.converter();
			return ResponseEntity.ok().body(loginRepository.save(login));
		}
		return ResponseEntity.status(409).body("Usuário existente!");
	}
}

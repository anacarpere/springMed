package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.usuario.DadosAutenticacao;
import med.voll.api.domain.usuario.Usuario;
import med.voll.api.infra.security.DadosTokenJWT;
import med.voll.api.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {


//Essa classe que chama a classe AutenticaçãoService, e precisa de configuração para ser injetada
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin( @RequestBody @Valid DadosAutenticacao dados){
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());

        //Quando o controller, o proprio Spring encontra o Service e encontra o método que usa o repository. esse objeto representa a autenticação e tem o usuário logado
        var authentication = manager.authenticate(authenticationToken);

        //Na hora de fazer o cast o Spring sabe que é um usuário pq implementamos o UserDetails
        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));

    }

}

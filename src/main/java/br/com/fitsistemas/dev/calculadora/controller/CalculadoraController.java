package br.com.fitsistemas.dev.calculadora.controller;

import br.com.fitsistemas.dev.calculadora.model.ParametrosParaSoma;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

@RestController
public class CalculadoraController {

    @GetMapping("/")
    public ModelAndView Index(){
        return  new ModelAndView("Index");
    }

    @PostMapping("/verificaNumero/")
    public String VerificaNumero(Integer numero, HttpServletRequest request ){
         numero = Integer.parseInt(request.getParameter("number"));
        if(numero % 2 == 0) {
            String Par = "O número "+numero+" é PAR";
            return Par;
        }
        String impar = "O número "+numero+" é IMPAR";
        return  impar;
    }

    @GetMapping("/apiRest")
    public String ApiRest(){
        return "OK";
    }

    @PostMapping(value = "/fazerSomaDeDoisNumeros/")
    public String fazerSomaDeDoisNumeros(@RequestHeader("login")String login,@RequestHeader("senha") String senha, @RequestBody ParametrosParaSoma parametros) {
            String validaLogin = "suka";
            String validaSenha = "123";
        if(validaLogin.equals(login) && validaSenha.equals(senha)) {
            String resultado = Integer.toString(parametros.getNumero1() + parametros.getNumero2());
            return "O resultado da SOMA é: " + resultado;
        }
        return "Login ou senha inválido";
    }
}

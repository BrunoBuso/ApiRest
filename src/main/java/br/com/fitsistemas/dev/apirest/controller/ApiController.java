package br.com.fitsistemas.dev.apirest.controller;
import br.com.fitsistemas.dev.apirest.model.ApiModel;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ApiController  {

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

    @PostMapping(value = "/fazerLogin/")
    public String fazerLogin(@RequestHeader("login")String login,@RequestHeader("senha") String senha, @RequestBody ApiModel model) {
            String validaLogin = "suka";
            String validaSenha = "123";
        if(validaLogin.equals(login) && validaSenha.equals(senha)) {
            String result = Integer.toString(model.getNum1() + model.getNum2());
            return "O resultado da SOMA é: " + result;
        }
        return "Login ou senha inválido";
    }
}

package com.surprise.neppo.controller;

import com.surprise.neppo.model.RegisterPersonModel;
import com.surprise.neppo.model.ResultModel;
import com.surprise.neppo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    ResultModel resultModel;

    @Autowired
    PersonRepository personRepository;

    @RequestMapping(value = "/register.html", method = RequestMethod.GET)
    public ModelAndView register(){

        return new ModelAndView("register");
    }

    @RequestMapping (value = "/consultPerson.html", method = RequestMethod.GET)
    public  ModelAndView consultPerson(){

        return new ModelAndView("consultPerson");
    }

    @RequestMapping(value = "/savePerson", method = RequestMethod.POST)
    public @ResponseBody ResultModel savePerson(@RequestBody RegisterPersonModel registerPersonModel){
        try{
             personRepository.save(registerPersonModel);

             resultModel.setCodigo(1);
             resultModel.setMensagem("Success registering person");
        }
        catch (Exception e){
            resultModel.setCodigo(0);
            resultModel.setMensagem("error when inserting person"+e.getMessage());
        }

        return  resultModel;

    }

    @RequestMapping(value ="/consultPerId/{id}", method = RequestMethod.GET)
    public @ResponseBody RegisterPersonModel consultPerId(@PathVariable int d){

        return personRepository.consultPerId(d);
    }
    @RequestMapping(value = "/consultAll", method = RequestMethod.GET)
    public @ResponseBody List<RegisterPersonModel> consultALl(){

        return personRepository.consultAll();
    }
    @RequestMapping(value="/validar/{login}", method = RequestMethod.GET)
    public @ResponseBody RegisterPersonModel logar(@PathVariable String login){

        return personRepository.logar(login);
    }
}

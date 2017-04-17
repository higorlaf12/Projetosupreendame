package com.surprise.neppo.controller;

import com.surprise.neppo.model.ResultModel;
import com.surprise.neppo.model.SavingModel;
import com.surprise.neppo.repository.SavingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/saving")
public class SavingController {

    @Autowired
    ResultModel resultModel;;

    @Autowired
    SavingRepository savingRepository;

    @RequestMapping(value = "/registrar", method = RequestMethod.GET)
    public ModelAndView regitrar(){

        return new ModelAndView("regitrar");
    }

    @RequestMapping(value = "/consultarDados", method = RequestMethod.GET)
    public ModelAndView consultarDados(){

        return new ModelAndView("consultarDados");
    }

    @RequestMapping(value = "/editarDados/{id}", method = RequestMethod.GET)
    public ModelAndView editarDados(@PathVariable int id){

        SavingModel savingModel = savingRepository.consultarPorId(id);

        return new ModelAndView("editarDados","SavingModel", savingModel);
    }

    @RequestMapping(value = "/removerDados/{id}", method = RequestMethod.DELETE)
    public @ResponseBody void removerDados(@PathVariable int id){

        savingRepository.remuve(id);
    }

    @RequestMapping(value = "/salvarDados", method = RequestMethod.POST)
    public @ResponseBody ResultModel salvarDados(@RequestBody SavingModel savingModel){

        try{
            savingRepository.savee(savingModel);

            resultModel.setCodigo(1);
            resultModel.setMensagem("Success registering person");
        }
        catch (Exception e){
            resultModel.setCodigo(0);
            resultModel.setMensagem("error when inserting person"+e.getMessage());
        }

        return  resultModel;

    }

    @RequestMapping(value = "/editarDados", method = RequestMethod.POST)
    public @ResponseBody ResultModel editarDados(@RequestBody SavingModel savingModel){

        try{
            savingRepository.changee(savingModel);

            resultModel.setCodigo(1);
            resultModel.setMensagem("Success editing person");
        }
        catch(Exception e){
            resultModel.setCodigo(0);
            resultModel.setMensagem("Error editing person");
        }
        return resultModel;
    }

    @RequestMapping(value = "/consultarPorId/{id}", method = RequestMethod.GET)
    public @ResponseBody  SavingModel consultarPorId(@PathVariable int id){

        return savingRepository.consultarPorId(id);
    }

    @RequestMapping(value = "/consultarTodos", method = RequestMethod.GET)
    public @ResponseBody List<SavingModel> consultarTodos(){

        return savingRepository.consultarTodos();
    }
}

package ru.gb.Homework6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.Homework6.models.Characters;
import ru.gb.Homework6.models.Result;
import ru.gb.Homework6.services.ServiceApi;
@Controller
@RequestMapping("/rikky")
public class ControllerAPI {
    @Autowired
    private ServiceApi serviceApi;

    @GetMapping("")
    public String getCharacters(Model model)
    {
        Characters allCharacters = serviceApi.getAllCharacters();

        model.addAttribute("results",allCharacters.getResults());
        model.addAttribute("info",allCharacters.getInfo());
        return "list.html";
    }
    @GetMapping("/page/{page}")
    public String getCharactersOnPage(@PathVariable int page,Model model)
    {
        Characters allCharacters = serviceApi.getAllCharacters(page);

        model.addAttribute("results",allCharacters.getResults());
        model.addAttribute("info",allCharacters.getInfo());

        model.addAttribute("page",page);

        return "list.html";
    }
    @GetMapping("/person/{id}")
    public String getPerson(@PathVariable int id,Model model)
    {
        Result result = serviceApi.getSingleCharacter(id);
        model.addAttribute("result",result);

        return "person.html";
    }
}

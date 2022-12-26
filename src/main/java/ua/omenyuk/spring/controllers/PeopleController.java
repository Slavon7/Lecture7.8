package ua.omenyuk.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.omenyuk.spring.dao.PersonList;

/**
 * @author Omenyuk Vyacheslav
  */

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonList personList;

    public PeopleController(PersonList personList) {
        this.personList = personList;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("people", personList.getPeople());
        return "people/index";
    }
}

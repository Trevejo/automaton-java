package com.example.automatodoc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AutomatonController {
  private final CPFAutomaton cpfAutomaton = new CPFAutomaton(); // Instância do autômato

  @GetMapping("/")
  public String index(Model model) {
    return "index";
  }

  @PostMapping("/processCPF")
  @ResponseBody
  public String processCPF(@RequestParam("inputValue") String inputValue) {

    System.out.println("inputValue: " + inputValue);
    boolean result = cpfAutomaton.validateCPF(inputValue);
    return String.valueOf(result);
  }
}

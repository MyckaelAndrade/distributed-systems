package com.and.CalculadoraTsi2025.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.and.CalculadoraTsi2025.service.CalculadoraService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller // Anotação para um controller tradicional
public class CalculadoraController {
    @Autowired // Injeta a Instância automaticamente
    private CalculadoraService calculadoraService;

    // Método para exibir a página da calculadora
    @GetMapping("/calculadora")
    public String calculadoraPagina() {
        return "calculadora"; // retorna o nome do arquivo html
    }

    // Método Post para processar o formulário de cálculo
    @PostMapping("/calculadora")
    public String calculando(
            @RequestParam double num1,
            @RequestParam double num2,
            @RequestParam String operacao,
            Model model) { // Model usado para enviar os dados para view
        try {
            double resultado = calculadoraService.calcular(num1, num2, operacao);
            model.addAttribute("resultado", "Resultado: " + resultado);
        } catch (IllegalArgumentException e) {
            model.addAttribute("resultado", "Erro: " + e.getMessage());
        }
        return "calculadora"; // Retorna para a página com o resultado
    }

    // POST para o formulário de operações ARITMÉTICAS
    @PostMapping("/calcular/aritmetica")
    public String aritmetica(
            @RequestParam double num1,
            @RequestParam double num2,
            @RequestParam String operacao,
            Model model) {
        try {
            double resultado = calculadoraService.calcular(num1, num2, operacao);
            model.addAttribute("resultadoAritmetico", "Resultado: " + resultado);
        } catch (IllegalArgumentException e) {
            model.addAttribute("resultadoAritmetico", "Erro: " + e.getMessage());
        }
        return "calculadora";
    }

    // POST para o formulário de operações UNITÁRIAS
    @PostMapping("/calcular/unaria")
    public String unaria(
            @RequestParam double num,
            @RequestParam String operacao,
            Model model) {
        try {
            String resultado = calculadoraService.calcularUnario(num, operacao);
            model.addAttribute("resultadoUnario", "Resultado: " + resultado);
        } catch (IllegalArgumentException e) {
            model.addAttribute("resultadoUnario", "Erro: " + e.getMessage());
        }
        return "calculadora";
    }

    // POST para o formulário de operações CONSTANTES
    @PostMapping("/calcular/constante")
    public String constante(@RequestParam String operacao, Model model) {
        if ("pi".equals(operacao)) {
            model.addAttribute("resultadoConstante", "PI: " + Math.PI);
        }
        return "calculadora";
    }
}
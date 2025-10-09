package com.and.CalculadoraTsi2025.service;

import org.springframework.stereotype.Service;

@Service // Anotação que marca essa classe como um serviço do Spring
public class CalculadoraService {
    public double calcular(double num1, double num2, String operacao) {
        return switch (operacao) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> {
                if (num2 == 0) {
                    throw new IllegalArgumentException("Não tem como dividir por 0 ;-;");
                }
                yield num1 / num2;
            }
            default -> throw new IllegalArgumentException("Operação Inválida: " + operacao);
        };
    }
    public String calcularUnario(double num, String operacao) {
        return switch (operacao) {
            case "sqrt" -> String.valueOf(Math.sqrt(num)); // Raiz Quadrada
            case "cbrt" -> String.valueOf(Math.cbrt(num)); // Raiz Cúbica
            case "pow10" -> String.valueOf(Math.pow(10, num)); // 10 elevado a X
            case "toBinary" -> {
                if (num != (long) num) { // Verifica se o número não é inteiro
                    throw new IllegalArgumentException("Conversão para binário funciona apenas com inteiros.");
                }
                yield Long.toBinaryString((long) num); // Converte para Binário
            }
            case "factorial" -> {
                if (num < 0 || num != (long) num) {
                    throw new IllegalArgumentException("Fatorial é definido apenas para inteiros não-negativos.");
                }
                yield String.valueOf(fatorial((long) num)); // Fatorial
            }
            default -> throw new IllegalArgumentException("Operação inválida: " + operacao);
        };
    }
    private long fatorial(long n) {
        if (n == 0) {
            return 1;
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}

package com.example.demo2401;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public String hello() {
        System.out.println("Entrada: /hello");
        String output = "Hola, mundo!";
        System.out.println("Salida: " + output);
        return output;
    }

    @GetMapping("/reverse")
    public String reverseString(@RequestParam("input") String input) {
        System.out.println("Entrada: /reverse?input=" + input);
        StringBuilder reversed = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed.append(input.charAt(i));
        }
        String output = reversed.toString();
        System.out.println("Salida: " + output);
        return output;
    }

    // operación para eliminar las vocales de un string
    @GetMapping("/remove-vowels")
    public String removeVowels(@RequestParam("input") String input) {
        System.out.println("Entrada: /remove-vowels?input=" + input);
        String output = input.replaceAll("[aeiouAEIOU]", "");
        System.out.println("Salida: " + output);
        return output;
    }

    @GetMapping("/is-palindrome")
    public boolean isPalindrome(@RequestParam("input") String input) {
        String reversed = new StringBuilder(input).reverse().toString();
        return input.equals(reversed);
    }

    
}
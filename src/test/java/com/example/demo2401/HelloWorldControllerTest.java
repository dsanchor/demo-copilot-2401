package com.example.demo2401;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(HelloWorldController.class)
public class HelloWorldControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHello() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hola, mundo!"));
    }

    @Test
    public void testReverseString() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/reverse").param("input", "hello"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("olleh"));
    }

    @Test
    public void testReverseEmptyString() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/reverse").param("input", ""))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(""));
    }

    @Test
    public void testReverseSpecialCharacters() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/reverse").param("input", "h3ll0!"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("!0ll3h"));
    }

    @Test
    public void testRemoveVowels() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/remove-vowels").param("input", "hello"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("hll"));
    }

    @Test
    public void testRemoveVowelsEmptyString() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/remove-vowels").param("input", ""))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(""));
    }

    @Test
    public void testRemoveVowelsSpecialCharacters() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/remove-vowels").param("input", "h3ll0!"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("h3ll0!"));
    }

    @Test
    public void testIsPalindrome() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/is-palindrome").param("input", "madam"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().string("true"));
        
        mockMvc.perform(MockMvcRequestBuilders.get("/is-palindrome").param("input", "hello"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().string("false"));
        
        mockMvc.perform(MockMvcRequestBuilders.get("/is-palindrome").param("input", "racecar"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().string("true"));
    }

    @Test
    public void testIsPalindromeEmptyString() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/is-palindrome").param("input", ""))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().string("true"));
    }
    
}
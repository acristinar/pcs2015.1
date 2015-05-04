/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lucianna
 */

import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
import pwd.CheckStrength;

@RunWith(Parameterized.class)
public class TestPassword {
    private final String password;
    private final String result;
    private final Object strength;
      
    public TestPassword(String password, String result, Object strength) {
        this.password = password;
        this.strength = strength;
        this.result = result;
    }
    
    @Parameters
    public static Collection<Object[]> inicializar() {
        return Arrays.asList(new Object[][] {
            { "    ", "password is empty", null },
            { "", "password is empty", null },
            { "null", "password is empty", null },
            { "password", "EASY", 0 },
            { "0", "EASY", 0 },
            { "0123", "EASY", 0 },
            { "09876", "EASY", 0 },
            { "a", "EASY", 0 },
            { "aaabbb", "EASY", 0 },
            { "aaaa", "EASY", 0 },
            { "123123", "EASY", 0 },
            { "ababab", "EASY", 0 },
            { "20151010", "EASY", 0 },
            { "aaa", "EASY", 0 },
            { "qwer", "EASY", 0 },
            { "asdfghjkl", "EASY", 0 },
            { "zxcvbnm", "EASY", 0 },
            { "iloveyou", "EASY", 0 }, 
            { "abc123", "EASY", 1 },
            { "abcde(", "EASY", 1 },
            { "abcdefghijklmno", "EASY", 1 },
            { "abcdeA", "EASY", 2 },
            { "ABCDEFGHIJKLMNOPQRSTUVWXYZ", "EASY", 2 },
            { "adobe123", "EASY", 3 },
            { "abcdeAB", "EASY", 3 }, 
            { "aAB1(", "MIDIUM", 4 },
            { "abcdeA(", "MIDIUM", 5 },
            { "abcdeA(*", "MIDIUM", 6 },
            { "8a5bB*!", "STRONG", 7 },
            { "8a5bB*!-", "STRONG", 8 },
            { "8a5bB*!-@", "STRONG", 9 },
            { "8a5bB0*!-@", "VERY_STRONG", 10 },
            { "8a5bBCDA1*!-", "VERY_STRONG", 11 },
            { "8a5beBCDA1*!-", "VERY_STRONG", 12 },
            { "8a5bBCDA1A@m*!-?", "EXTREMELY_STRONG", 13 },
            { "8a5bBC DA1A @m*!-?", "EXTREMELY_STRONG", 14 }, 
        }
       );
    }

    @Test
    public void teste() throws Exception {
        try {
            int pontuacaoObitdo = CheckStrength.checkPasswordStrength(password);
            String classificaçãoObtido = CheckStrength.getPasswordLevel(password);
            
            System.out.println("Senha: " + password + " - Classificação esperado: " + result);
            System.out.println("Classificação obtido: " + classificaçãoObtido);
            System.out.println("Pontuação esperado: " + strength + " - Pontuação obtido: " + pontuacaoObitdo);
           
            assertEquals(result, classificaçãoObtido);
            assertEquals(strength, pontuacaoObitdo);
            
        } catch(Exception e) {
            System.out.println("Senha: " + password + " - Classificação esperado: " + result);
            System.out.println("Classificação obtido: " + e.getMessage());
            
            assertEquals(result, e.getMessage());
        } 
       
    }
}

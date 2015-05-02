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
            { "1", "EASY", 0 },
            { "0", "EASY", 0 },
            { "0123", "EASY", 0 },
            { "a", "EASY", 0 },
            { "aaa", "EASY", 0 },
            
        }
       );
    }

    @Test
    public void teste() throws Exception {
        try {
            System.out.println("Senha: " + password + " - Classificação esperado: " + result);
            System.out.println("Classificação obtido: " + CheckStrength.getPasswordLevel(password));
            System.out.println("Pontuação esperado: " + strength + " - Pontuação obtido: " + CheckStrength.checkPasswordStrength(password));
           
            assertEquals(result, CheckStrength.getPasswordLevel(password));
            assertEquals(strength, CheckStrength.checkPasswordStrength(password));
       
        } catch(Exception e) {
            System.out.println("Classificação obtido: " + e.getMessage());
            assertEquals(result, e.getMessage());
        }
        
    }
}

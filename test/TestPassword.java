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
      
    public TestPassword(String password, String result) {
        this.password = password;
        this.result = result;
    }
    
    @Parameters
    public static Collection<Object[]> inicializar() {
        return Arrays.asList(new Object[][] {
            { "    ", "password is empty" },
            { "", "password is empty" },
            { "null", "password is empty" },
        }
       );
    }

    @Test
    public void teste() throws Exception {
        try {
        System.out.println("Senha: " + password + " - Resultado esperado: " + result);
        assertEquals(result, CheckStrength.getPasswordLevel(password));
        }  catch(Exception e) {
            assertEquals(result, e.getMessage());
        }
        
    }
}

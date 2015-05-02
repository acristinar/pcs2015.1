/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lucianna
 */

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
import pwd.CheckStrength;

@RunWith(Parameterized.class)
public class TestCountLetter {
    private String password;
    private int type;
    private int result;
    private int NUM = 1;
    private int SMALL_LETTER = 2;
    private int CAPITAL_LETTER = 3;
    private int OTHER_CHAR = 4;
      
    public TestCountLetter(String password, int type, int result) {
        this.password = password;
        this.type = type;
        this.result = result;
    }
    
    @Parameters
    public static Collection<Object[]> inicializar() {
        return Arrays.asList(new Object[][] {
            { "aaa", 1, 0 },
            { "aaa", 2, 3 },
            { "aaa", 3, 0 },
            { "aaa", 4, 0 },
            { "AAABB01", 1, 2 },
            { "AAABB01", 2, 0 },
            { "AAABB01", 3, 5 },
            { "AAABB01", 4, 0 },
            { "011123", 1, 6 },
            { "011123", 2, 0 },
            { "011123", 3, 0 },
            { "011123", 4, 0 },
            { "*´-].!a01cN", 1, 2 },
            { "*´-].!a01cN", 2, 2 },
            { "*´-].!a01cN", 3, 1 },
            { "*´-].!a01cN", 4, 6 },
            { "10", 4, 6 },
        }
       );
    }
    
    @Test
    public void teste() throws Exception {
        
        try {
            Class params[] = {String.class, int.class};

            Method methodCountLetter = CheckStrength.class.getDeclaredMethod("countLetter", params);
            methodCountLetter.setAccessible(true);

            System.out.println("Senha: " + password + " - Tipo de caracter: " + type + " - Resultado esperado: " + result);
            System.out.println("Resultado obtido: " + methodCountLetter.invoke(CheckStrength.class, password, type));

            assertEquals(result, methodCountLetter.invoke(CheckStrength.class, password, type));
            
        } catch (NoSuchMethodException e) {
            System.out.println(e.getMessage());
        }
        
    }

}

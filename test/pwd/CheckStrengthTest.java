/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pwd;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 *
 * @author Amanda
 */
@RunWith(value = Parameterized.class)
public class CheckStrengthTest {
    
    public char c;
    public int result;
    
    private static final int NUM = 1;
    private static final int SMALL_LETTER = 2;
    private static final int CAPITAL_LETTER = 3;
    private static final int OTHER_CHAR = 4;

    public CheckStrengthTest(char c, int result) {
        this.c = c;
        this.result = result;
    }
    
    @Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
            {'a',SMALL_LETTER},
            {'A',CAPITAL_LETTER},
            {'b',SMALL_LETTER},
            {'B',CAPITAL_LETTER},
            {'0',NUM},
            {'9',NUM},
            {'*',OTHER_CHAR},
            {'z',SMALL_LETTER},
            {'Z',CAPITAL_LETTER},
            {'y',SMALL_LETTER},
            {'Y',CAPITAL_LETTER},
        });
    
    }

    /**
     * Test of checkCharacterType method, of class CheckStrength.
     * @throws java.lang.Exception
     */
    @Test
    public void test() throws Exception {
        try {
            System.out.println("Caracter: " + c + " - Resultado esperado: " + result);
            assertEquals(result, CheckStrength.checkCharacterType(c));
        }catch(Exception e){
            assertEquals(result, e.getMessage());
        }
        
    }
}

   
    


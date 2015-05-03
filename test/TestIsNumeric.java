/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static pwd.StringUtils.isNumeric;

/**
 *
 * @author Amanda
 */
@RunWith(Parameterized.class)
public class TestIsNumeric {
    
    String str;
    boolean result;

    public TestIsNumeric(String str, boolean result) {
        this.str = str;
        this.result = result;
    }
    
    @Parameters
    public static Collection<Object[]> inicializar() {
        return Arrays.asList(new Object[][] {
            {"597413", true},
            {"a1111", false},
            {"111&1a", false},
            {"0%16",false},
        }
       );
    }
    
    @Test
    public void teste() throws Exception {
         try {
            System.out.println("String: " + str + " - Resultado esperado: " + result);
            System.out.println("Resultado obtido: " + isNumeric(str));
           
            assertEquals(result, isNumeric(str));
       
        } catch(Exception e) {
            System.out.println("Resultado obtido: " + e.getMessage());
            assertEquals(result, e.getMessage());
        }
    }

}

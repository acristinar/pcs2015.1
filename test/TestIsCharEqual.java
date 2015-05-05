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
import static pwd.StringUtils.verifyIsCharEqual;

/**
 *
 * @author Amanda
 */
@RunWith(Parameterized.class)
public class TestIsCharEqual {
    
    String str;
    boolean result;

    public TestIsCharEqual(String str, boolean result) {
        this.str = str;
        this.result = result;
    }
    
    @Parameters
    public static Collection<Object[]> inicializar() {
        return Arrays.asList(new Object[][] {
            {"aaa", true},
            {"aab", false},
            {"baa", false},
            {"abab",false},
            {"****",true},
            {"2222", true},
            {"1aaa1",false},
            {"11a11",false}
        }
       );
    }
    
    @Test
    public void teste() throws Exception {
         try {
            System.out.println("String: " + str + " - Resultado esperado: " + result);
            System.out.println("Resultado obtido: " + verifyIsCharEqual(str));
           
            assertEquals(result, verifyIsCharEqual(str));
       
        } catch(Exception e) {
            System.out.println("Resultado obtido: " + e.getMessage());
            assertEquals(result, e.getMessage());
        }
    }
}

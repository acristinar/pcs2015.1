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
import static pwd.StringUtils.verifyIsNull;

/**
 *
 * @author Amanda
 */
@RunWith(Parameterized.class)
public class TestEqualsNull {
    
    String str;
    boolean result;

    public TestEqualsNull(String str, boolean result) {
        this.str = str;
        this.result = result;
    }
    
    @Parameters
    public static Collection<Object[]> inicializar() {
        return Arrays.asList(new Object[][] {
            {null, true},
            {"null", true},
            {"  ", true},
            {"",true},
            {" ", true},
            {"_", false},
            {"_null", false},
            {"null_",false}
        }
       );
    }
    
    @Test
    public void teste() throws Exception {
         try {
            System.out.println("String: " + str + " - Resultado esperado: " + result);
            System.out.println("Resultado obtido: " + verifyIsNull(str));
           
            assertEquals(result, verifyIsNull(str));
       
        } catch(Exception e) {
            System.out.println("Resultado obtido: " + e.getMessage());
            assertEquals(result, e.getMessage());
        }
    }
}

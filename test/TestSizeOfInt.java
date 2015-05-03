/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static pwd.StringUtils.sizeOfInt;

/**
 *
 * @author Amanda
 */
@RunWith(Parameterized.class)
public class TestSizeOfInt {
    
    public int x;
    public int result;

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    public TestSizeOfInt(int x, int result) {
        this.x = x;
        this.result = result;
    }
    
    @Parameters
    public static Collection<Object[]> inicializar() {
        return Arrays.asList(new Object[][] {
            {0,1},
            {1, 1},
            {22, 2},
            {335, 3},
            {4468, 4},
            {67913, 5},
            {562314, 6},
            {7831659, 7},
            {26987456, 8},
            {999999998, 9},
            {999999998, 10} //forçando erro para ver se teste passa
        }
       );
    }
    
    
    @Test
    public void teste() throws Exception {
        try {
            System.out.println("Número inteiro: " + x + " - Tamanho esperado: " + result);
            System.out.println("Tamanho obtido: " + sizeOfInt(x));
           
            assertEquals(result, sizeOfInt(x));
       
        } catch(Exception e) {
            System.out.println("Tamanho obtido: " + e.getMessage());
            assertEquals(result, e.getMessage());
        }
        
    }
}

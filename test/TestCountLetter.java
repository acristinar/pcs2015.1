/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lucianna
 */

import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import pwd.StringUtils;

public class TestCountLetter {
    private String password;
    private String type[] = {"NUM", "SMALL_LETTER", "CAPITAL_LETTER", "OTHER_CHAR"};
    private Map<String, Integer> result = new HashMap<>();
    private Map<String, Integer> expected = new HashMap<>();

    @Test
    public void teste() {
        password = "a1a!!a02bNN*&#";
        result.put(type[0], 3);
        result.put(type[1], 4);
        result.put(type[2], 2);
        result.put(type[3], 5);
        
        expected = StringUtils.quantLetter(password);
        
        for(int i = 0; i < result.size(); i++ ) {
            System.out.println("Senha: " + password + " - Tipo de caracter: " + type[i] + " - Resultado esperado: " + result.get(type[i]));
            System.out.println("Resultado obtido: " + expected.get(type[i]));
            assertEquals(result.get(type[i]), expected.get(type[i]));
        }
    }
}
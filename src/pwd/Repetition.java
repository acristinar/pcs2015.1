/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pwd;

/**
 *
 * @author Amanda
 */
public class Repetition {
    private Character caracter;
    private Integer count;

    public Repetition(Character letra) {
        this.caracter = caracter;
        count = 1;
    }

    public Character getCaracter() {
        return caracter;
    }

    public Integer getCount(){
        return count;
    }

    public void incrementCount() {
        count++;
    }
    
    public int compareTo(Repetition that) {
        int comparacao = that.count.compareTo(this.count);
        if(comparacao == 0){
            comparacao = this.caracter.compareTo(that.caracter);
        }
        return comparacao;
    }

    @Override
    public String toString() {
        return caracter.toString();
    }
}

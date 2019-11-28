/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mat;

/**
 *
 * @author Leonardo
 */
public class MultiplicacaoEscalar extends OperacaoBinaria<Expressao<Escalar>, Expressao<Escalar>, Expressao<Escalar>> {
    public MultiplicacaoEscalar(Expressao<Escalar> arg1, Expressao<Escalar> arg2){
        super(arg1, arg2);
    }
    
    public Escalar calcular(){        
        return new Escalar(super.arg1.calcular().getValor() * super.arg2.calcular().getValor());
    }
    
    public int getTipo(){
        return 1;
    }
    
}

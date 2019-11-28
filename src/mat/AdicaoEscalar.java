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
public class AdicaoEscalar extends OperacaoBinaria<Expressao<Escalar>, Expressao<Escalar>, Expressao<Escalar>>{
    
    public AdicaoEscalar(Expressao<Escalar> arg1, Expressao<Escalar> arg2){
        super(arg1, arg2);
    }
    
    @Override
    public Escalar calcular(){
        Escalar esc1 = (Escalar) super.arg1.calcular();
        Escalar esc2 = (Escalar) super.arg2.calcular();
    
        Escalar escResult = new Escalar(esc1.getValor() + esc2.getValor());
        return escResult;
    }
    
    public int getTipo(){
        return 1;
    }
}

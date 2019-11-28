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
public abstract class OperacaoBinaria <T1 extends Expressao, T2 extends Expressao, R extends Expressao> extends Expressao <R>{
    protected T1 arg1;
    protected T2 arg2;
    
    public OperacaoBinaria(T1 arg1, T2 arg2){
        //Validações
        if(arg1 == null || arg2 == null)
            throw new IllegalArgumentException("Argumento incorreto");
        
        //Atribuindo
        this.arg1 = arg1;
        this.arg2 = arg2;  
    }

    @Override
    public abstract R calcular();
    
}

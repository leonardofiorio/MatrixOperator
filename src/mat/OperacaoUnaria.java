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
public abstract class OperacaoUnaria <T extends Expressao, R extends Expressao> extends Expressao <R> {
    protected T arg;
    
    public OperacaoUnaria(T arg){
        if(arg == null)
            throw new IllegalArgumentException("Argumento inválido!");
            
        this.arg = arg;
    }
    
    public abstract T getArgumento();
    
}

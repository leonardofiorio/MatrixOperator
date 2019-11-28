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
public class NegacaoEscalar extends OperacaoUnaria<Expressao<Escalar>, Expressao<Escalar>> {
    public NegacaoEscalar(Expressao<Escalar> arg){
        super(arg);
    }

    @Override
    public Expressao<Escalar> getArgumento() {
        return super.arg;
    }

    @Override
    public Expressao<Escalar> calcular() {
         return new Escalar((-1) * this.getArgumento().calcular().getValor());        
    }
    
    public int getTipo(){
        return 1;
    }
    
}

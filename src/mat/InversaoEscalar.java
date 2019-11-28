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
public class InversaoEscalar extends OperacaoUnaria<Expressao<Escalar>, Expressao<Escalar>> {
    public InversaoEscalar(Expressao<Escalar> arg){
        super(arg);        
    }

    @Override
    public Expressao<Escalar> getArgumento() {
        return super.arg;
    }

    @Override
    public Expressao<Escalar> calcular() {
        return new Escalar(Math.pow(this.getArgumento().calcular().getValor(), -1));            
    }

    public int getTipo(){
        return 1;
    }

   
   
}

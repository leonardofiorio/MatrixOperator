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
public class NegacaoMatricial extends OperacaoUnaria<Expressao<Matriz>, Expressao<Matriz>>{
    public NegacaoMatricial(Expressao<Matriz> arg){
        super(arg);
    }

    @Override
    public Expressao<Matriz> getArgumento() {
        return super.arg;
    }

    @Override
    public Expressao<Matriz> calcular() {
        Expressao<Matriz> mat = super.arg.calcular();
        for(int i = 0; i < mat.calcular().linhas(); i++){
            for(int j = 0; j < mat.calcular().linhas(); j++){
                mat.calcular().setValor(i, j, (-1) * mat.calcular().getValor(i, j));
            }
        }
        return mat;
    }
    
    public int getTipo(){
        return 2;
    }
    
}

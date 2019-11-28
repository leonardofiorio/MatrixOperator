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
public class AdicaoMista extends OperacaoBinaria<Expressao<Escalar>, Expressao<Matriz>, Expressao<Matriz>>{
    
    public AdicaoMista(Expressao<Escalar> arg1, Expressao<Matriz> arg2){
        super(arg1, arg2);
    }

    @Override
    public Matriz calcular() {
        Escalar num = (Escalar) super.arg1.calcular();
        Matriz mat = (Matriz) super.arg2.calcular();
        
        Matriz matResult = new Matriz(mat.linhas(), mat.colunas());
        for(int i = 0; i < mat.linhas() ;i++){
            for(int j = 0; j < mat.colunas() ; j++){
                matResult.setValor(i, j, mat.getValor(i, j) + num.getValor());
            }
        }
        return matResult;
    }
    
    public int getTipo(){
        return 2;
    }
}

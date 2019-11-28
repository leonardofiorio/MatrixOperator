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
public class AdicaoMatricial extends OperacaoBinaria<Expressao<Matriz>, Expressao<Matriz>, Expressao<Matriz>>{
    
    public AdicaoMatricial(Expressao<Matriz> arg1, Expressao<Matriz> arg2){
        super(arg1, arg2);
    }
    
    public Matriz calcular(){
        Matriz mat1 = super.arg1.calcular();
        Matriz mat2 = super.arg2.calcular();
    
        Matriz matResult = new Matriz(mat1.linhas(), mat1.colunas());
        for(int i = 0; i < mat1.linhas() ;i++){
            for(int j = 0; j < mat1.colunas() ; j++){
                matResult.setValor(i,j,mat1.getValor(i, j) + mat2.getValor(i, j));
            }
        }
        return matResult; 
    }
    
    public int getTipo(){
        return 2;
    }
    
}

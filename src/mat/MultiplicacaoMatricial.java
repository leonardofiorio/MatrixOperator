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
public class MultiplicacaoMatricial extends OperacaoBinaria<Expressao<Matriz>, Expressao<Matriz>, Expressao<Matriz>> {
    
    public MultiplicacaoMatricial(Expressao<Matriz> arg1, Expressao<Matriz> arg2){
        super(arg1, arg2);
    }

    @Override
    public Expressao<Matriz> calcular() {
        Matriz mat1 = super.arg1.calcular();
        Matriz mat2 = super.arg1.calcular();
        
        if(mat1.colunas() != mat2.linhas())
            throw new IllegalArgumentException("O número de colunas da primeira matríz é diferente do número de linhas da segunda!");
        
        Matriz resultado = new Matriz(mat1.linhas(), mat2.colunas());
                
        for(int i = 0; i < mat1.linhas(); i++){
            for(int j = 0; j < mat2.colunas(); j++){
                for(int cont = 0; cont < resultado.colunas(); cont++){
                    resultado.setValor(i, j, resultado.getValor(i, j) + mat1.getValor(i, cont) * mat2.getValor(cont, j));
                }
            }
        }
        return resultado;        
    }
    
    public int getTipo(){
        return 2;
    }
    
}

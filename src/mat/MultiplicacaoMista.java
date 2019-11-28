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
public class MultiplicacaoMista extends OperacaoBinaria<Expressao<Matriz>, Expressao<Escalar>, Expressao<Matriz>>{
    
    public MultiplicacaoMista(Expressao<Matriz> arg1, Expressao<Escalar> arg2){
        super(arg1, arg2);
    }
    
    public Matriz calcular(){
        Matriz matriz = super.arg1.calcular();
        Escalar escalar = super.arg2.calcular();
        Matriz resultado = new Matriz(matriz.linhas(), matriz.colunas());
        
        for(int i = 0; i < matriz.linhas(); i++){
            for(int j = 0; j < matriz.colunas(); j++){
                resultado.setValor(i, j, escalar.getValor() * matriz.getValor(i, j));
            }
        }
        return resultado;        
    }
    
    public int getTipo(){
        return 2;
    }
    
}

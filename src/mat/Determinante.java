/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mat;

import java.util.ArrayList;

/**
 *
 * @author Leonardo
 */
public class Determinante extends OperacaoUnaria<Expressao<Matriz>, Expressao<Escalar>>{
    
    public Determinante(Expressao<Matriz> arg){
        super(arg);
    }
    
    private double calcDet(Expressao<Matriz> mat){
        int lin = mat.calcular().linhas();
        int col = mat.calcular().colunas();

        double aux = 0;
        
        // Para matrizes 1X1
        if(lin == 1 && col == 1)
            return mat.calcular().getValor(0, 0);
        
        //Para matrizes 2X2
        if(lin == 2 && col == 2){
            aux = mat.calcular().getValor(0, 0) * mat.calcular().getValor(1, 1);
            aux = aux - mat.calcular().getValor(1, 0) * mat.calcular().getValor(0, 1);
            return aux;
        }
        
        //Para matrizes maiores        
        for(int cont = 0; cont < col; cont++){
            ArrayList<Double> novoElems = new ArrayList<>();
            for(int i = 0; i < lin ; i++){
                for(int j = 0; j < col ; j++){
                    if((i == 0 && j == cont) || (i == 0 && j != cont) || (i != 0 && j==cont)){} else{
                        novoElems.add(mat.calcular().getValor(i, j));
                    }
                }
            }

            int contador = 0;
            Expressao<Matriz> novaMat = new Matriz(lin - 1, col - 1);
            for(int i = 0; i < lin - 1 ; i++){
                for(int j =0; j < col - 1; j++){
                    novaMat.calcular().setValor(i, j, novoElems.get(contador));
                    contador++;
                }
            }
            aux += (Math.pow(-1, 2 + cont) * (mat.calcular().getValor(0, cont)) * (this.calcDet(novaMat)));             
        }
        return aux;
    }
    
    @Override
    public Escalar calcular(){
        Matriz mat = (Matriz) this.getArgumento();
        return new Escalar(calcDet(mat));
    }

    @Override
    public Expressao<Matriz> getArgumento() {
        return super.arg;
    }
    
    public int getTipo(){
        return 1;
    }
}

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
public class SolucaoDeSistema extends OperacaoUnaria<Expressao<Matriz>, Expressao<Matriz>> {

    public SolucaoDeSistema(Expressao<Matriz> arg){
        super(arg);        
    }
    
    @Override
    public Expressao<Matriz> getArgumento() {
        return super.arg;
    }

    @Override
    public Matriz calcular() {
        Matriz matriz = (Matriz) this.getArgumento();
        
        //Montando a matriz separando a última coluna.
        Matriz matrizOriginal = new Matriz(matriz.linhas(), matriz.colunas() - 1);
        for(int i = 0; i < matrizOriginal.linhas(); i++){
            for(int j = 0; j < matrizOriginal.colunas(); j++){
                matrizOriginal.setValor(i, j, matriz.getValor(i, j));
            }
        }
            
        //Calculando determinante da matriz inicial
        Determinante determinanteOriginal = new Determinante(matrizOriginal);
        double detOriginal = determinanteOriginal.calcular().getValor();
        
        //Declaração do vetor que vai armazenar as soluções
        double[] aux = new double[matriz.colunas() - 1];
        
        for(int i = 0; i < matrizOriginal.colunas(); i++){
            Matriz matrizTemp = new Matriz(matriz.linhas(), matriz.colunas() - 1);
            
            //Gerando matrízes da regra de Cramer
            for(int j = 0; j < matrizTemp.linhas(); j++){
                for(int k = 0; k < matrizTemp.colunas(); k++){
                    if(i == k)
                        matrizTemp.setValor(j, k, matriz.getValor(j, matriz.colunas() - 1));
                    else    
                        matrizTemp.setValor(j, k, matriz.getValor(j, k));
                }
            }
            Determinante detMatrizTemp = new Determinante(matrizTemp);
            aux[i] = (detMatrizTemp.calcular().getValor()) / detOriginal;
        }
        Matriz solucao = new Matriz(aux.length, 1);
        for(int i = 0; i < aux.length; i++){
            solucao.setValor(i, 0, aux[i]);
        }
        return solucao;
    }
    
    public int getTipo(){
        return 2;
    }
}

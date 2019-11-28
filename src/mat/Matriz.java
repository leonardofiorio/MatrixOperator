/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mat;

import java.text.DecimalFormat;

/**
 *
 * @author Leonardo
 */
public class Matriz extends Expressao {
    private double[][] valores;
    
    
    public Matriz(int linhas, int colunas){
        //Validações
        if(linhas <= 0)
            throw new IllegalArgumentException("Quantidade de linhas inválida!");
        if(colunas <=0)
            throw new IllegalArgumentException("Quantidade de colunas inválida!");
        
        //Instanciando uma matriz com os tamanhos informados
        this.valores = new double[linhas][colunas];
    }
    
    //Método retorna quantidade de linhas
    public int linhas(){
        return this.valores.length;
    }
    
    
    //Método retornar a quantidade de colunas
    public int colunas(){
        return this.valores[0].length;
    }
    
    //Método para pegar um determinado valor na matriz
    public double getValor(int lin, int col){
        //Validações
        if(lin < 0)
            throw new IllegalArgumentException("Linha inválida!");
        if(col <0)
            throw new IllegalArgumentException("Coluna inválida!");
        
        return this.valores[lin][col];
    }
    
    public void setValor(int lin, int col, double valor){
        //Validações
        if(lin < 0)
            throw new IllegalArgumentException("Linha inválida!");
        if(col <0)
            throw new IllegalArgumentException("Coluna inválida!");            
        
        //Inserindo novo valor
        this.valores[lin][col] = valor;
    }
    
    @Override
    public Matriz calcular(){
        //Retonar própria instância da classe
        return this;
    }
    
    @Override
    public int getTipo(){
        return 2;
    }
    
    public String toString(){
        DecimalFormat formatar = new DecimalFormat();
        formatar.setMinimumFractionDigits(4);
        formatar.setMaximumFractionDigits(4);
        
        String retorno = "M " + this.linhas() + " " + this.colunas() + " ";
        for(int i = 0; i < this.linhas(); i++){
            for(int j = 0; j < this.colunas(); j++){
                retorno += formatar.format(this.getValor(i, j)) + " ";
            }
        }
        retorno += System.lineSeparator();
        retorno = retorno.replaceAll(",",".");
        return retorno;
    }
    
}

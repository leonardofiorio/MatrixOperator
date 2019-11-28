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
public class Escalar extends Expressao {
     private double valor;
    
    public Escalar(double valor){ 
        this.valor = valor;        
    }
    
    public double getValor(){
        return this.valor;
    }
    
    public void setValor(double valor){
        this.valor = valor;
    }
    
     @Override
    public Escalar calcular(){
        //Retonar própria instância da classe 
        return this;
    }
    
    @Override
    public int getTipo(){
        return 1;
    }
    
    public String toString(){
        DecimalFormat formatar = new DecimalFormat();
        formatar.setMinimumFractionDigits(4);
        formatar.setMaximumFractionDigits(4);
        String retorno = "E " + formatar.format(this.valor).replaceAll(",",".");
        retorno += System.lineSeparator(); 
        return retorno;
    }
}

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
public abstract class Expressao <R extends Expressao>{
    public abstract R calcular();
    public abstract int getTipo();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import mat.AdicaoEscalar;
import mat.AdicaoMatricial;
import mat.AdicaoMista;
import mat.Determinante;
import mat.Escalar;
import mat.Expressao;
import mat.InversaoEscalar;
import mat.Matriz;
import mat.MultiplicacaoEscalar;
import mat.MultiplicacaoMatricial;
import mat.MultiplicacaoMista;
import mat.NegacaoEscalar;
import mat.NegacaoMatricial;
import mat.SolucaoDeSistema;

/**
 *
 * @author Leonardo
 */
public class TrabalhoFinal {
    private static Map<String, Expressao> variaveis = new HashMap<String, Expressao>();
    
    public static Expressao avaliarExpressao(String aux){
        aux = aux.replaceAll(" ", ""); //Removendo espaços 
        
        //Analisando as presenças de símbolos
        for(int i = 0; i < aux.length(); i++){
            if(aux.charAt(i) == '('){      
                int qtdParesParenteses = 1;
                int j = i+1;
                
                while(qtdParesParenteses > 0 && j < aux.length()){
                    if(aux.charAt(j) == '('){
                        qtdParesParenteses++;
                    } else if(aux.charAt(j) == ')'){
                        qtdParesParenteses--;
                    }
                    j++;
                }
                
                //Separando operador
                char operador = ' ';
                String novoOp2 = aux.substring(j, aux.length());
                boolean alterouOperador = false;
                for(int k = 0; k < novoOp2.length(); k++){
                    if(!alterouOperador && (novoOp2.charAt(k) == '+' || novoOp2.charAt(k) == '-' || 
                            novoOp2.charAt(k) == '*' || novoOp2.charAt(k) == '/')){
                        alterouOperador = true;
                        operador = novoOp2.charAt(k);
                        novoOp2 = novoOp2.substring(k+1, novoOp2.length());
                    }
                }
                
                if(novoOp2.length() != 0){
                    Expressao op1 = avaliarExpressao(aux.substring(i+1, j-1)); 
                    Expressao op2 = avaliarExpressao(novoOp2);
                    if(operador == '+'){
                        if((op1.getTipo() == 1) && (op2.getTipo() == 1)){        
                            AdicaoEscalar adicao = new AdicaoEscalar(op1, op2);
                            Escalar retorno = adicao.calcular();
                            return retorno;
                        }else if(((op1.getTipo() == 2) && (op2.getTipo() == 1)) || ((op1.getTipo() == 1) && (op2.getTipo() == 2))){        
                            AdicaoMista adicao;
                            if(op1.getTipo() == 1 && op2.getTipo() == 2 )
                                 adicao = new AdicaoMista(op1, op2);
                            else
                            adicao = new AdicaoMista(op2, op1);
                            Matriz retorno = adicao.calcular();
                            return retorno;
                        }else if((op1.getTipo() == 2) && (op2.getTipo() == 2)){
                            AdicaoMatricial adicao = new AdicaoMatricial(op1, op2);
                            Matriz retorno = (Matriz) adicao.calcular();
                            return retorno;
                        }
                    }
                    if(operador == '-'){
                        if((op1.getTipo() == 1) && (op2.getTipo() == 1)){
                            NegacaoEscalar negacao = new NegacaoEscalar(op2);
                            op2 = negacao.calcular();
                            AdicaoEscalar adicao = new AdicaoEscalar(op1, op2);
                            Escalar retorno = adicao.calcular();
                            return retorno;
                        }else if((op1.getTipo() == 2) && (op2.getTipo() == 1)) {
                            NegacaoEscalar negacao = new NegacaoEscalar(op2);
                            op2 = negacao.calcular();
                            AdicaoEscalar adicao = new AdicaoEscalar(op1, op2);
                            Escalar retorno = adicao.calcular();
                            return retorno;
                        } else if ((op1.getTipo() == 1) && (op2.getTipo() == 2)){
                            NegacaoMatricial negacao = new NegacaoMatricial(op2);
                            op2 = negacao.calcular();
                            AdicaoEscalar adicao = new AdicaoEscalar(op1, op2);
                            Escalar retorno = adicao.calcular();
                            return retorno;                
                        }else if((op1.getTipo() == 2) && (op2.getTipo() == 2)){
                            NegacaoMatricial negacao = new NegacaoMatricial(op2);
                            op2 = negacao.calcular();
                            AdicaoMatricial adicao = new AdicaoMatricial(op1, op2);
                            Matriz retorno = (Matriz) adicao.calcular();
                            return retorno;
                        }
                    }
                    if(operador == '*'){
                        if((op1.getTipo() == 1) && (op2.getTipo() == 1)){        
                            MultiplicacaoEscalar adicao = new MultiplicacaoEscalar(op1, op2);
                            Escalar retorno = adicao.calcular();
                            return retorno;
                        }else if(((op1.getTipo() == 2) && (op2.getTipo() == 1)) || ((op1.getTipo() == 1) && (op2.getTipo() == 2))){        
                            MultiplicacaoMista multiplicacao; 
                            if(op1.getTipo() == 1 && op2.getTipo() == 2)
                                  multiplicacao =  new MultiplicacaoMista(op1, op2);
                            else
                                  multiplicacao = new MultiplicacaoMista(op2, op1);
                            Matriz retorno = multiplicacao.calcular();
                            return retorno;
                        }else if((op1.getTipo() == 2) && (op2.getTipo() == 2)){
                            MultiplicacaoMatricial multiplicacao = new MultiplicacaoMatricial(op1, op2);
                            Matriz retorno = (Matriz) multiplicacao.calcular();
                            return retorno;
                        }
                    }
                    if(operador == '/'){
                        if((op1.getTipo() == 1) && (op2.getTipo() == 1)){        
                            AdicaoEscalar adicao = new AdicaoEscalar(op1, op2);
                            Escalar retorno = adicao.calcular();
                            return retorno;
                        }
                    }
                }else{
                    return avaliarExpressao(aux.substring(i+1, j-1));
                }
            } else if(aux.charAt(i) == '+'){ // Análise da Soma
                int tamanho = aux.length();
                String antes = aux.substring(0, i );
                String depois = aux.substring(i + 1 , tamanho);
                Expressao op1 = avaliarExpressao(antes);
                Expressao op2 = avaliarExpressao(depois);
                if((op1.getTipo() == 1) && (op2.getTipo() == 1)){        
                    AdicaoEscalar adicao = new AdicaoEscalar(op1, op2);
                    Escalar retorno = adicao.calcular();
                    return retorno;
                }else if(((op1.getTipo() == 2) && (op2.getTipo() == 1)) || ((op1.getTipo() == 1) && (op2.getTipo() == 2))){  
                    AdicaoMista adicao;
                    if(op1.getTipo() == 1 && op2.getTipo() == 2 )
                        adicao = new AdicaoMista(op1, op2);
                    else
                        adicao = new AdicaoMista(op2, op1); 
                    Matriz retorno = (Matriz) adicao.calcular();
                    return retorno;
                }else if((op1.getTipo() == 2) && (op2.getTipo() == 2)){
                    AdicaoMatricial adicao = new AdicaoMatricial(op1, op2);
                    Matriz retorno = (Matriz) adicao.calcular();
                    return retorno;
                }
            } else if(aux.charAt(i) == '-'){ // Análise da Subtração
                int tamanho = aux.length();
                String antes = aux.substring(0, i );
                String depois = aux.substring(i + 1 , tamanho);
                Expressao op1 = avaliarExpressao(antes);
                Expressao op2 = avaliarExpressao(depois);
                if((op1.getTipo() == 1) && (op2.getTipo() == 1)){
                    NegacaoEscalar negacao = new NegacaoEscalar(op2);
                    op2 = negacao.calcular();
                    AdicaoEscalar adicao = new AdicaoEscalar(op1, op2);
                    Escalar retorno = adicao.calcular();
                    return retorno;
                }else if((op1.getTipo() == 2) && (op2.getTipo() == 1)) {
                    NegacaoEscalar negacao = new NegacaoEscalar(op2);
                    op2 = negacao.calcular();
                    AdicaoEscalar adicao = new AdicaoEscalar(op1, op2);
                    Escalar retorno = adicao.calcular();
                    return retorno;
                } else if ((op1.getTipo() == 1) && (op2.getTipo() == 2)){
                    NegacaoMatricial negacao = new NegacaoMatricial(op2);
                    op2 = negacao.calcular();
                    AdicaoEscalar adicao = new AdicaoEscalar(op1, op2);
                    Escalar retorno = adicao.calcular();
                    return retorno;                
                }else if((op1.getTipo() == 2) && (op2.getTipo() == 2)){
                    NegacaoMatricial negacao = new NegacaoMatricial(op2);
                    op2 = negacao.calcular();
                    AdicaoMatricial adicao = new AdicaoMatricial(op1, op2);
                    Matriz retorno = (Matriz) adicao.calcular();
                    return retorno;
                }
            } else if(aux.charAt(i) == '*'){ // Análise da Multiplicação
                int tamanho = aux.length();
                String antes = aux.substring(0, i );
                String depois = aux.substring(i + 1 , tamanho);
                Expressao op1 = avaliarExpressao(antes);
                Expressao op2 = avaliarExpressao(depois);
                if((op1.getTipo() == 1) && (op2.getTipo() == 1)){        
                    MultiplicacaoEscalar multiplicacao = new MultiplicacaoEscalar(op1, op2);
                    Escalar retorno = multiplicacao.calcular();
                    return retorno;
                }else if(((op1.getTipo() == 2) && (op2.getTipo() == 1)) || ((op1.getTipo() == 1) && (op2.getTipo() == 2))){        
                    MultiplicacaoMista multiplicacao; 
                    if(op1.getTipo() == 1 && op2.getTipo() == 2)
                          multiplicacao =  new MultiplicacaoMista(op1, op2);
                    else
                          multiplicacao = new MultiplicacaoMista(op2, op1);
                    Matriz retorno = multiplicacao.calcular();
                    return retorno;
                }else if((op1.getTipo() == 2) && (op2.getTipo() == 2)){
                    MultiplicacaoMatricial multiplicacao = new MultiplicacaoMatricial(op1, op2);
                    Matriz retorno = (Matriz) multiplicacao.calcular();
                    return retorno;
                }
            } else if(aux.charAt(i) == '/'){ // Análise da divisão
                int tamanho = aux.length();
                String antes = aux.substring(0, i );
                String depois = aux.substring(i + 1 , tamanho);
                Expressao op1 = avaliarExpressao(antes);
                Expressao op2 = avaliarExpressao(depois);
                if((op1.getTipo() == 1) && (op2.getTipo() == 1)){
                    InversaoEscalar inversao = new InversaoEscalar(op2);
                    op2 = inversao.calcular();
                    MultiplicacaoEscalar multiplicacao = new MultiplicacaoEscalar(op1, op2);
                    Escalar retorno = multiplicacao.calcular();
                    return retorno;
                }              
            } else if(aux.charAt(0) == 'd' && aux.charAt(1) == 'e' && aux.charAt(2) == 't' && aux.charAt(3) == '(' && 
                aux.charAt(aux.length() - 1) == ')'){            
                String novoAux = aux.substring(4, aux.length() - 1);
                Determinante det = new Determinante(avaliarExpressao(novoAux));
                Escalar determinante = det.calcular();
                return determinante;
            } else if(aux.charAt(0) == 's' && aux.charAt(1) == 'o' && aux.charAt(2) == 'l' && aux.charAt(3) == '(' && 
                aux.charAt(aux.length() - 1) == ')'){ 
                String novoAux = aux.substring(4, aux.length() - 1);
                SolucaoDeSistema solucaoSistema = new SolucaoDeSistema(avaliarExpressao(novoAux));
                Matriz resultado = solucaoSistema.calcular();
                return resultado;
            }         
        }     
        
        if(!variaveis.containsKey(aux)){
            aux.trim();
            Escalar retorno = new Escalar(Double.valueOf(aux));
            return retorno;
        }else{
            //Buscando variáveis 
            Expressao variavel = variaveis.get(""+aux.charAt(0)); //Buscando no Map de variáveis a varíavel correspondente ao ID 
            if(variavel.getTipo() == 1){
                Escalar retorno = (Escalar) variaveis.get(""+aux.charAt(0));
                return retorno;
            } else if(variavel.getTipo() == 2){
                Matriz retorno = (Matriz) variaveis.get(""+aux.charAt(0));
                return retorno;
            }
        }
        return null;
    }
    
    
    public static void main(String[] args) {
        try{
            //Declarando leitura de arquivo
            FileReader arquivoEntrada = new FileReader(args[0]);
            FileWriter arquivoSaida = new FileWriter(args[1]);
            BufferedReader bufferEntrada = new BufferedReader(arquivoEntrada);
            BufferedWriter bufferSaida = new BufferedWriter(arquivoSaida);
            StringTokenizer token = new StringTokenizer(bufferEntrada.readLine());
           
            
            //  ----------  Verificando quantidade de variáveis a serem declaradas -------------
            int qtdVariaveis = Integer.parseInt(token.nextToken());
            
            //Analisando cada linha(variável) e instanciando.
            for(int i = 0; i < qtdVariaveis; i++){
                String declaracao = bufferEntrada.readLine(); //Ler cada variável
                StringTokenizer declaracaoToken = new StringTokenizer(declaracao); 
                int qtdElementos = declaracaoToken.countTokens();

                if(declaracaoToken.nextToken().equals("E")){
                    // Para o caso de ser um escalar
                    String id = declaracaoToken.nextToken();
                    Expressao<Escalar> esc = new Escalar(Double.parseDouble(declaracaoToken.nextToken()));
                    variaveis.put(id, esc);
                } else {
                    // Para o caso de ser uma matriz
                    String id = declaracaoToken.nextToken();
                    int lin = Integer.parseInt(declaracaoToken.nextToken());
                    int col = Integer.parseInt(declaracaoToken.nextToken());
                    Matriz matriz = new Matriz(lin, col);
                    
                    //Lendo valores e preenchendo o objeto
                    int posLin = 0;
                    int posCol = 0;
                    
                    for(int j = 0 ; j < lin ; j++){
                        for(int k = 0; k < col ; k++){
                           matriz.setValor(j, k, Double.parseDouble(declaracaoToken.nextToken())); 
                        }
                    }
                     
                    variaveis.put(id, matriz);
                }
            }
            
            //  ----------  Verificando quantidade de expressões a serem analisadas -------------
            int qtdExpressoes = Integer.parseInt(bufferEntrada.readLine());
            
            for(int j = 0; j < qtdExpressoes; j++){
                String exp = bufferEntrada.readLine();
                Expressao resultado = avaliarExpressao(exp);
                switch(resultado.getTipo()){ //Analisando qual tipo de retorno da operação
                    case 2:
                        Matriz resultadoMatriz = (Matriz) resultado;
                        bufferSaida.write(resultadoMatriz.toString());
                        bufferSaida.flush();
                        break;
                    case 1:
                        Escalar resultadoEscalar = (Escalar) resultado;
                        bufferSaida.write(resultadoEscalar.toString());
                        bufferSaida.flush();
                        System.out.println(resultadoEscalar.getValor());
                        break;    
                }
            }
            
         
        }catch (FileNotFoundException ex){
            System.err.println("Erro - Arquivo não encontrado!");
        } catch (IOException ex){
            System.err.println(ex.getMessage());
        } catch (NumberFormatException ex){
            System.err.println(ex.getMessage());
        } 

        } 
    }
    

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Gigo
 */
public class InstancesCreator {
    String resultado = "";
    
    public InstancesCreator(){
        
    }
    
    private int restricoesGerais(int dimensao) {
        int qtdRestricoes = 0;
        String br = System.getProperty("line.separator");
        int j;
        String temp = br;
        
        for(int i = 1; i <= dimensao*dimensao; i++){
            if(i % dimensao == 0){
                temp += i+" 0";
                resultado += temp;
                qtdRestricoes++;
                temp = br;
            }else{
                temp += i+" ";
            }
        }
        
        //Percorre cada casa do tabuleiro
        for (int i = 1; i <= dimensao * dimensao; i++) {
            //horizontal para frente
            j = i;
            while (true) {
                if (i % dimensao != 0) {
                    j++;
                    resultado += br + -i + " " + -j + " 0";
                    qtdRestricoes++;
                    if (j % dimensao == 0) {
                        break;
                    }
                } else {
                    break;
                }
            }

            //horizontal para tras
            j = i;
            while (true) {
                j--;
                if (j % dimensao == 0) {
                    break;
                }
                resultado += br + -i + " " + -j + " 0";
                qtdRestricoes++;
            }

            //vertical para baixo
            j = i;
            while (j + dimensao <= dimensao * dimensao) {
                j += dimensao;
                resultado += br + -i + " " + -j + " 0";
                qtdRestricoes++;
            }

            //vertical para cima
            j = i;
            while (j - dimensao >= 1) {
                j -= dimensao;
                resultado += br + -i + " " + -j + " 0";
                qtdRestricoes++;
            }

            //diagonal para direita e para baixo
            j = i;
            while (true) {
                j = j + dimensao + 1;
                if (j > dimensao * dimensao || i % dimensao == 0) {
                    break;
                } else if (j % dimensao == 0) {
                    resultado += br + -i + " " + -j + " 0";
                    qtdRestricoes++;
                    break;
                } else {
                    resultado += br + -i + " " + -j + " 0";
                    qtdRestricoes++;
                }
            }

            //diagonal para esquerda e para cima
            j = i;
            while (true) {
                j = j - (dimensao + 1);
                if (j < 1 || i % dimensao == 1) {
                    break;
                } else if (j % dimensao == 1) {
                    resultado += br + -i + " " + -j + " 0";
                    qtdRestricoes++;
                    break;
                } else {
                    resultado += br + -i + " " + -j + " 0";
                    qtdRestricoes++;
                }
            }

            //diagonal para esquerda e para baixo
            j = i;
            while (true) {
                j = j + (dimensao - 1);
                if (j > dimensao * dimensao || i % dimensao == 1) {
                    break;
                } else if (j % dimensao == 1) {
                    resultado += br + -i + " " + -j + " 0";
                    qtdRestricoes++;
                    break;
                } else {
                    resultado += br + -i + " " + -j + " 0";
                    qtdRestricoes++;
                }
            }

            //diagonal para direita e para cima
            j = i;
            while (true) {
                j = j - (dimensao - 1);
                if (j < 1 || i % dimensao == 0) {
                    break;
                } else if (j % dimensao == 0) {
                    resultado += br + -i + " " + -j + " 0";
                    qtdRestricoes++;
                    break;
                } else {
                    resultado += br + -i + " " + -j + " 0";
                    qtdRestricoes++;
                }
            }
        }
        return qtdRestricoes;
    }

    public String criarInstancia(int dimensao) {
        try {
            FileWriter arquivoGlucose = new FileWriter("C:\\Users\\morei\\AppData\\Local\\Packages\\CanonicalGroupLimited.UbuntuonWindows_79rhkp1fndgsc\\LocalState\\rootfs\\home\\marcelo\\glucose-syrup-4.1\\simp\\instancia" + dimensao + "x" + dimensao + ".txt");
            PrintWriter printerGlucose = new PrintWriter(arquivoGlucose);
            
            FileWriter arquivoZchaff = new FileWriter("C:\\Users\\morei\\AppData\\Local\\Packages\\CanonicalGroupLimited.UbuntuonWindows_79rhkp1fndgsc\\LocalState\\rootfs\\home\\marcelo\\zchaff64\\instancia" + dimensao + "x" + dimensao + ".txt");
            PrintWriter printerZchaff = new PrintWriter(arquivoZchaff);
            
            int qtdRestricoes = restricoesGerais(dimensao);
            
            printerGlucose.print("p cnf " + dimensao * dimensao + " " + qtdRestricoes);
            printerGlucose.print(resultado);
            
            printerZchaff.print("p cnf " + dimensao * dimensao + " " + qtdRestricoes);
            printerZchaff.print(resultado);
            
            resultado = "";
            
            arquivoGlucose.close();
            arquivoZchaff.close();
        } catch (IOException ex) {
            return ex.getMessage();
            
        }
        return "Sucesso!";
    }
}

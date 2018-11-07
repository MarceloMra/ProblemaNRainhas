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
    
    public boolean criarInstancia(int dimensao){
        try {
            FileWriter arquivo = new FileWriter("C:\\Users\\morei\\AppData\\Local\\Packages\\CanonicalGroupLimited.UbuntuonWindows_79rhkp1fndgsc\\LocalState\\rootfs\\home\\marcelo\\glucose-syrup-4.1\\simp\\instancia"+dimensao+"x"+dimensao+".txt");
            PrintWriter printer = new PrintWriter(arquivo);
            int j;
            //Percorre cada casa do tabuleiro
            for(int i = 1; i <= dimensao * dimensao; i++){
                //horizontal para frente
                j = i;
                while(true){
                    if(i%dimensao != 0){
                        j++;
                        printer.println(-i +" "+ -j);
                        if(j%dimensao == 0){
                            break;
                        }
                    }else{
                        break;
                    }
                }
                
                //horizontal para tras
                j = i;
                while(true){
                    j--;
                    if(j%dimensao == 0){
                        break;
                    }
                    printer.println(-i +" "+ -j);
                }
                
                //vertical para baixo
                j = i;
                while(j+dimensao <= dimensao*dimensao){
                    j += dimensao;
                    printer.println(-i +" "+ -j);
                }
                
                //vertical para cima
                j = i;
                while(j-dimensao >= 1){
                    j -= dimensao;
                    printer.println(-i +" "+ -j);
                }
                
                //diagonal para direita e para baixo
                j=i;
                while(true){
                    j = j + dimensao + 1;
                    if(j > dimensao*dimensao || i%dimensao == 0){
                        break;
                    }else if(j%dimensao == 0){
                        printer.println(-i +" "+ -j);
                        break;
                    }else{
                        printer.println(-i +" "+ -j);
                    }
                }
                
                //diagonal para esquerda e para cima
                j=i;
                while(true){
                    j = j - (dimensao + 1);
                    if(j < 1 || i%dimensao == 1){
                        break;
                    }else if(j%dimensao == 1){
                        printer.println(-i +" "+ -j);
                        break;
                    }else{
                        printer.println(-i +" "+ -j);
                    }
                }
                
                //diagonal para esquerda e para baixo
                j=i;
                while(true){
                    j = j + (dimensao - 1);
                    if(j > dimensao*dimensao || i%dimensao == 1){
                        break;
                    }else if(j%dimensao == 1){
                        printer.println(-i +" "+ -j);
                        break;
                    }else{
                        printer.println(-i +" "+ -j);
                    }
                }
                
                //diagonal para direita e para cima
                j=i;
                while(true){
                    j = j - (dimensao - 1);
                    if(j < 1 || i%dimensao == 0){
                        break;
                    }else if(j%dimensao == 0){
                        printer.println(-i +" "+ -j);
                        break;
                    }else{
                        printer.println(-i +" "+ -j);
                    }
                }
            }

            arquivo.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }
}

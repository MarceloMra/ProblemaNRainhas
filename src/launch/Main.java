/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package launch;

import java.util.Scanner;
import model.*;
/**
 *
 * @author Gigo
 */
public class Main {
    public static void main(String[] args) {
        int opc = 0, dimensao;
        Scanner dado = new Scanner(System.in);
        
        //Menu
        do{
            do{
                System.out.println("-----> MENU");
                System.out.println(" 1 - Criar arquivo de instância");
                System.out.println(" 0 - Fechar Programa");
                System.out.println("Digite a opção desejada: ");
                opc = dado.nextInt();
            }while(opc < 0 || opc > 1);
            
            switch(opc){
                case 1:
                    InstancesCreator criador = new InstancesCreator();
                    
                    do{
                        System.out.println("Digite a dimensão do tabuleiro: ");
                        dimensao = dado.nextInt();
                    }while(dimensao < 4);
                    
                    System.out.println("... Criando [instancia"+dimensao+"x"+dimensao+".txt] ...");                    
                    criador.criarInstancia(dimensao);
                    break;
            }
        }while(opc != 0);
    }
}

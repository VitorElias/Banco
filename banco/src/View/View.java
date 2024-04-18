package View;

import Controller.Control;
import javax.swing.JOptionPane;

public class View {


    private int op = 0;
    private Control controler = new Control();

    public void View() {


        do {

         try {   

            op = Integer.parseInt(JOptionPane.showInputDialog(null, "SISTEMA DE BANCO \n\n SEJA BEM VINDO \n\n  1- Criar Conta \n 2 - Deletar Conta \n 3 - Alterar informações \n 4 - Fazer saque \n 5 - Depositar \n 6 - Sair"));
             
            switch(op) {

                case 1: 
                    
                    String msg = JOptionPane.showInputDialog(null,"A conta é Conta Empresarial ou Poupança?");
                    msg = msg.toLowerCase();

                    int numero = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o numero da conta:"));
                    String nome = JOptionPane.showInputDialog(null,"Digite o nome do titular da conta:");
                    double saldo = Double.parseDouble(JOptionPane.showInputDialog(null,"Digite o saldo da conta: "));

                
                    controler.criarConta(msg,numero,nome,saldo);

                case 2:

                    int conta = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o numero da conta"));
                
                    controler.deletarConta(conta);

                    JOptionPane.showMessageDialog(null,"Conta deletada!!");
                
                case 3 : 
                
                   

            }

         }catch(java.lang.NumberFormatException e) {

            JOptionPane.showMessageDialog(null,"Erro , Informação invalida!!!!");
         }

       

        } while (op != 6);

    }
}

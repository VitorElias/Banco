package Controller;

import Model.*;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Control {

    private ArrayList<Conta> conta;

    public Control() {

    }

    public void criarConta(String msg, int numero, String nome, double saldo) {

        if(msg.equals("poupanca") || msg.equals("poupança")) {

            double taxa = Double.parseDouble(JOptionPane.showInputDialog(null,"Digite a taxa de juros:"));
            conta.add(new Poupança(taxa,numero,saldo,nome));

        }else {

            double limiteEmprestimo = Double.parseDouble(JOptionPane.showInputDialog(null,"Digite o limite de emprestimo da empresa:"));
            conta.add(new ContaEmpresarial(numero,saldo,nome,limiteEmprestimo));
        }
    }

    public void deletarConta(int numero) {

        for(Conta conta : this.conta) {

            if(conta.getNumero() == numero) {

                this.conta.remove(conta);
                return;
                
            }
        }
    }
    
}

package View;

import Controller.Control;
import javax.swing.JOptionPane;

public class View {

    private int op = 0;
    private Control controler = new Control();

    public void View() {

        do {

            try {

                Object[] options = { "Criar Conta", "Deletar Conta", "Mostrar informações", "Fazer saque", "Depositar",
                        "opções adicionais", "Sair" };
                op = JOptionPane.showOptionDialog(
                        null,
                        "Escolha uma opção",
                        "Sistema de banco",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        options,
                        options[0]) + 1;

                switch (op) {

                    case 1:

                        String msg = JOptionPane.showInputDialog(null, "A conta é Conta Empresarial ou Poupança?");
                        msg = msg.toLowerCase();

                        int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero da conta:"));
                        String nome = JOptionPane.showInputDialog(null, "Digite o nome do titular da conta:");
                        double saldo = Double
                                .parseDouble(JOptionPane.showInputDialog(null, "Digite o saldo da conta: "));

                        controler.criarConta(msg, numero, nome, saldo);
                        break;

                    case 2:

                        int conta = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero da conta"));

                        controler.deletarConta(conta);

                        JOptionPane.showMessageDialog(null, "Conta deletada!!");
                        break;

                    case 3:

                        int c = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero da conta"));

                        JOptionPane.showMessageDialog(null, controler.retornarInformacao(c));

                        break;

                    case 4:

                        int c2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero da conta"));

                        double saq = Double
                                .parseDouble(JOptionPane.showInputDialog(null, " Digite o valor do saque: "));

                        JOptionPane.showMessageDialog(null, controler.saque(c2, saq));

                        break;

                    case 5:

                        int c3 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero da conta"));

                        double dep = Double
                                .parseDouble(JOptionPane.showInputDialog(null, " Digite o valor do deposito: "));

                        JOptionPane.showMessageDialog(null, controler.depositar(c3, dep));
                        break;

                    case 6:

                        Object[] options2 = { "atualizar taxa de juros", "realizar emprestimo",
                                "voltar ao menu principal" };

                        int op2 = JOptionPane.showOptionDialog(
                                null,
                                "Escolha uma opção",
                                "Sistema de banco",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.PLAIN_MESSAGE,
                                null,
                                options2,
                                options2[0]) + 1;

                        switch (op2) {

                            case 1:

                                int c4 = Integer
                                        .parseInt(JOptionPane.showInputDialog(null, "Digite o numero da conta"));

                                JOptionPane.showMessageDialog(null, controler.atualizarJuros(c4));
                                break;

                            case 2:

                                int c5 = Integer
                                        .parseInt(JOptionPane.showInputDialog(null, "Digite o numero da conta"));

                                double v = Double.parseDouble(JOptionPane.showInputDialog(null,"Valor do emprestimo:"));        

                                JOptionPane.showMessageDialog(null, controler.RealizarEmprestimo(c5,v));
                                break;

                            case 3:
                                break;

                            default:

                                JOptionPane.showMessageDialog(null, "Erro digite uma informação valida!");

                        }

                        break;

                    case 7:

                        JOptionPane.showMessageDialog(null, "Saindo do programa");
                        break;

                    default:

                        JOptionPane.showMessageDialog(null, "ERRO DIGITE UM NUMERO VALIDO!!");
                        break;

                }

            } catch (java.lang.NumberFormatException e) {

                JOptionPane.showMessageDialog(null, "Erro , Informação invalida!!!!");

            } catch (RuntimeException e) {

                JOptionPane.showMessageDialog(null, e.getMessage());
            }

        } while (op != 7);

    }
}
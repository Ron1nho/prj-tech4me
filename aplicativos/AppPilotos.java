package aplicativos;

import classes.Aeronave;
import classes.Pessoa;
import classes.Piloto;

import java.io.IOException;
import java.util.Scanner;

public class AppPilotos {
    public static void main(String[] args) throws InterruptedException, IOException {
        final int MAX_ELEMENTOS = 20;
        int opcao, qtdCadastrados = 0, index = 0;
        Pessoa[] pilotos = new Pessoa[MAX_ELEMENTOS];
        Scanner in = new Scanner(System.in);
        int EspacoPadrao = MAX_ELEMENTOS;
        int EspacoDisponivel = EspacoPadrao;
        Boolean trava = true;
        Pessoa p1 = new Piloto();

        do {
            System.out.println("\n****\nMENU\n****\n");
            System.out.println("1 - Cadastrar piloto");
            System.out.println("2 - Listar pilotos cadastrados");
            System.out.println("3 - Localizar piloto pelo CPF");
            System.out.println("4 - Aumentar espaço de armazenamento");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = in.nextInt();
            in.nextLine(); // Tira o ENTER que ficou na entrada na instrução anterior

            if (opcao == 1) {

                if (EspacoDisponivel <= 0) {
                    System.out.println("\nNão há espaço para cadastrar novos pilotos.");
                    voltarMenu(in);
                    continue;

                    // Se não tem mais espaço no vetor, caio fora
                } else if (qtdCadastrados == MAX_ELEMENTOS) {
                    System.out.println("\nNão há espaço para cadastrar novos pilotos.");
                    voltarMenu(in);
                    continue;
                }

                // Cadastre seu piloto aqui
                String n; // nome
                String c; // cpf
                String b; // breve
                String m; // matricula

                do {
                    System.out.println("\nNome(Max 30 caracteres)");
                    n = in.nextLine();
                    if (n.length() <= 0 || n.length() > 30) {
                        System.out.println("\nNome invalido!!");
                    } else {
                        break;
                    }
                } while (trava);

                do {
                    System.out.println("\n CPF: ");
                    c = in.nextLine();
                    if (c.length() < 11 && c.length() > 11) {
                        System.out.println("CPF: INVALIDO!!!");
                    } else {
                        break;
                    }
                } while (trava);

                do {
                    System.out.println("\nBrevê");
                    b = in.nextLine();
                    if (b.length() < 1) {
                        System.out.println("\nBrevê invalido!!");
                    } else {
                        break;
                    }
                } while (trava);

                do {
                    System.out.println("\nMatricula");
                    m = in.nextLine();
                    if (m.length() < 1) {
                        System.out.println("\nMatricula invalido!!");
                    } else {
                        break;
                    }
                } while (trava);
                qtdCadastrados++;

                System.out.println("\nPiloto cadastrado com sucesso.");
                voltarMenu(in);

            } else if (opcao == 2) {

                // Se não tem ninguém cadastrado no vetor, caio fora
                if (qtdCadastrados == 0) {
                    System.out.println("\nNão há motoristas cadastrados para exibir.");
                    voltarMenu(in);
                    continue;
                } else {
                    System.out.println("\nPilotos cadastrados atualmente: " + qtdCadastrados);
                }

                // Exiba os pilotos aqui

                while (index != qtdCadastrados) {

                    System.out.printf(
                            "\n\nPiloto %s:|| nome: %s cpf: %s breve: %s matricula: %s",
                            (index + 1),
                            pilotos[index].getNome(), pilotos[index].getCpf(),
                            pilotos[index].getPiloto().getBreve(), pilotos[index].getPiloto().getMatricula());
                }

                voltarMenu(in);

            } else if (opcao == 3) {

                // A FAZER /*xxx*/

            } else if (opcao == 4) {

                int NovoEspaço = 0;
                System.out.printf("\nQuantidade cadastrada: %s\nEspaço maximo: %s", qtdCadastrados, EspacoPadrao);
                System.out.println("\n--------------------------------------");
                System.out.println("Para quanto de espaço deseja aumentar?");
                NovoEspaço = in.nextInt();
                in.nextLine();

                // A FAZER

            } else if (opcao != 0) {
                System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);

        System.out.println("Fim do programa!");

        in.close();
    }

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        // Limpa toda a tela, deixando novamente apenas o menu
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");

        System.out.flush();
    }
}
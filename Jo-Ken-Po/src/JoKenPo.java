import java.util.*;

public class JoKenPo {
    /*
    (1) Pedra / (2) Papel / (3) Tesoura

    Perspectiva do usuário:
    Pedra:
    1 vs 1 = 0 EMPATE
    1 vs 2 = -1 MÁQUINA
    1 vs 3 = -2 USER

    Papel:
    2 vs 2 = 0 EMPATE
    2 vs 1 = 1 USER
    2 vs 3 = -1 MÁQUINA

    Tesoura:
    3 vs 3 = 0 EMPATE
    3 vs 1 = 2 MÁQUINA
    3 vs 2 = 1 USER

    RESUMO: USER (-2, 1) MÁQUINA (-1, 2)
    */

    public static void main(String[] args) {
        System.out.println("(1) pedra, (2) papel ou (3) tesoura?");

        int pontuacaoUser = 0;
        int pontucaoMaquina = 0;

        int count = 0;
        while (count < 5) {
            count++; //count = count + 1;
            System.out.println("Partida " + count);

            Scanner scan = new Scanner(System.in);
            System.out.print("Sua escolha: ");
            int inputUser = scan.nextInt();

            if (inputUser > 3 || inputUser < 1) {
                System.out.println("Amada, faça a escolha correta! 1, 2 ou 3. Ponto para Máquina!");
                pontucaoMaquina = pontucaoMaquina + 1; //pontucaoMaquina++
                continue;
            }

            String escolhaUsuario = "";
            switch (inputUser) {
                case (1):
                    escolhaUsuario = "pedra";
                    break;
                case (2):
                    escolhaUsuario = "papel";
                    break;
                case (3):
                    escolhaUsuario = "tesoura";
                    break;
                default:
                    System.out.println("Valor Invalido!");
                    break;
            }

            Random random = new Random();
            int inputMaquina = random.nextInt(3) + 1;

            String escolhaMaquina = "";
            switch (inputMaquina) {
                case (1):
                    escolhaMaquina = "pedra";
                    break;
                case (2):
                    escolhaMaquina = "papel";
                    break;
                case (3):
                    escolhaMaquina = "tesoura";
                    break;
                default:
                    System.out.println("Valor Invalido!");
                    break;
            }

            int game = inputUser - inputMaquina;

            if (game == 0) {
                System.out.println(escolhaUsuario + " vs " + escolhaMaquina + ": EMPATE!");
            } else if (game == -1 || game == 2) {
                System.out.println(escolhaUsuario + " vs " + escolhaMaquina + ": MÁQUINA!");
                pontucaoMaquina++;
            } else {
                System.out.println(escolhaUsuario + " vs " + escolhaMaquina + ": USER!");
                pontuacaoUser++;
            }
            System.out.println();
        }
        System.out.println("---------------------------------------");
        System.out.println("Pontuação total: User = " + pontuacaoUser + " vs Máquina = " + pontucaoMaquina);

        /*String vencedor = pontuacaoUser > pontucaoMaquina ? "USER" : "MAQUINA";
        System.out.println("VENCEDOR: " + vencedor);*/

        if(pontucaoMaquina > pontuacaoUser) System.out.println("VENCEDOR = MÁQUINA");
        else if (pontucaoMaquina < pontuacaoUser) System.out.println("VENCEDOR = USER");
        else System.out.println("EMPATE!");

    }

}

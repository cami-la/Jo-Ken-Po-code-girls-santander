import java.util.Random;
import java.util.Scanner;
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
public class JoKenPo {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scan = new Scanner(System.in);

        System.out.println("(1) pedra, (2) papel ou (3) tesoura?");

        int pontuacaoUser = 0;
        int pontuacaoMaquina = 0;

        int count = 0;
        while(count < 5) {
            count++;
            System.out.print("Partida " + count + ": ");

            int inputUser = scan.nextInt();
            if(inputUser > 3 || inputUser < 1) {
                System.out.println("Amada, valor é 1, 2 ou 3. Ponto para a MÁQUINA!");
                pontuacaoMaquina++;
                continue;
            }

            String escolhaUser = "";
            switch (inputUser) {
                case (1): escolhaUser = "pedra"; break;
                case (2): escolhaUser = "papel"; break;
                case (3): escolhaUser = "tesoura"; break;
                default:
                    System.out.println("Valor inválido!"); break;
            }

            int inputMaquina = random.nextInt(3) + 1;

            String escolhaMaquina = "";
            switch (inputMaquina) {
                case (1): escolhaMaquina = "pedra"; break;
                case (2): escolhaMaquina = "papel"; break;
                case (3): escolhaMaquina = "tesoura"; break;
                default:
                    System.out.println("Valor inválido!"); break;
            }

            int game = inputUser - inputMaquina;

            if (game == 0) {
                System.out.println(escolhaUser + " vs " + escolhaMaquina + ": EMPATE!");
            } else if(game == -1 || game == 2) {
                System.out.println(escolhaUser + " vs " + escolhaMaquina + ": MÁQUINA!");
                pontuacaoMaquina++;
            } else {
                System.out.println(escolhaUser + " vs " + escolhaMaquina + ": USER!");
                pontuacaoUser++;
            }
        }
        System.out.println("---------------------------------------");
        System.out.println("Pontuação total: User = " + pontuacaoUser + " vs Máquina = " + pontuacaoMaquina);

        //String vencedor = pontuacaoUser > pontuacaoMaquina ? "USER" : "MÁQUINA";
        //System.out.println("Vencedor: " + vencedor);

        if (pontuacaoMaquina > pontuacaoUser) System.out.println("Vencedor: MÁQUINA");
        else if (pontuacaoMaquina < pontuacaoUser) System.out.println("Vencedor: USER");
        else System.out.println("Vencedor: EMPATE");

        System.out.println("*********** FIM DE JOGO ***********");

    }
}

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

        int user = 0;
        int maquina = 0;

        int count = 0;
        while(count < 5) {
            count++;
            System.out.print("Partida " + count + ": ");

            int inputUser = scan.nextInt();
            if(inputUser > 3 || inputUser < 1) {
                System.out.println("Amada, valor é 1, 2 ou 3. Ponto para a MÁQUINA!");
                maquina++;
                continue;
            }

            int inputMaquina = random.nextInt(3) + 1;

            int game = inputUser - inputMaquina;

            if (game == 0) {
                System.out.println(inputUser + " vs " + inputMaquina + ": EMPATE!");
            } else if(game == -1 || game == 2) {
                System.out.println(inputUser + " vs " + inputMaquina + ": MÁQUINA!");
                maquina++;
            } else {
                System.out.println(inputUser + " vs " + inputMaquina + ": USER!");
                user++;
            }
        }
        System.out.println("---------------------------------------");
        System.out.println("Pontuação total: User = " + user + " vs Máquina = " + maquina);
        System.out.println("*********** FIM DE JOGO ***********");

    }
}

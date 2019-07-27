import java.util.Scanner;

/**
 * 変更点：
 * Chip の数をベットするのではなく、ポイントをいくら掛けるかという様に作っています。
 */
public class Trump_Main {
    public static void main(String[] args) {
        BigOrSmall game = new BigOrSmall();
        System.out.println(game.status());
        Card firstCard = game.draw();
        System.out.println(game.showCurrentCard(firstCard));

        //here
        //System.out.println("Betするチップの数を入力してください（半角1-20）");
        Scanner scanner = new Scanner(System.in);
        //boolean validChip = false;
//        int bet = 0;
//
//        while(!validChip){
//            String input = scanner.next();
//            if(game.validateBet(input)){
//                bet = Integer.parseInt(input);
//                validChip = true;
//            }
//        }
        int point = bet;
        //here

        game.setScore(game.getScore()-bet);

        boolean play = true;
        boolean validBigOrSmall = false;
        boolean win = false;
        while (play){
            System.out.println(game.showCurrentCard(firstCard));
            System.out.println("Bigger[0] or Smaller[1] 選択");
            int bigOrSmall = 0;
            while (!validBigOrSmall){
                String bigOrSmallInput = scanner.next();
                if (game.validateInput(bigOrSmallInput, "Bigger[0] or Smaller[1] を入力してください！")){
                    bigOrSmall = Integer.parseInt(bigOrSmallInput);
                    validBigOrSmall = true;
                }
            }
            Card card2 = game.draw();

            //Big
            if (bigOrSmall==0){
                //win
                game.showProcess(firstCard, card2, "Bigger", point);
                if (game.judgeBig(firstCard, card2)){
                    point = game.win(point);
                    win = true;
                }
                //lose
                else{
                    if (game.lost()) win = false;
                }
            }
            //small
            else{
                game.showProcess(firstCard,card2, "Smaller", point);
                //win
                if (game.judgeSmall(firstCard, card2)){
                    point = game.win(point);
                    win = true;
                }
                //lose
                else{
                    //subtract the chips from on hand
                    if (game.lost()) {
                        win = false;
                        point = bet;
                    }
                }
            }
            int cont = 0;
            boolean contValid = false;
            while (!contValid){
                String contInput = scanner.next();
                if (game.validateInput(contInput, "0:continue OR 1:not continue を入力してください！")){
                    cont = Integer.parseInt(contInput);
                    contValid = true;
                }
            }
            if (cont==0){
                firstCard = card2;
                validBigOrSmall = false;
                if (!win) game.setScore(game.getScore()-bet);
                continue;
            }
            else{
                //add chips into on hand
                if (win) {
                    game.setScore(game.getScore() + point);
                }
                play = false;
            }
        }
        game.setChips(game.getScore());
        System.out.println("*****現在のチップ数*****");
        System.out.println(game.status());
    }
}

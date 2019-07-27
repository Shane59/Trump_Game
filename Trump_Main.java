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

        int bet = game.getBet();
        int point = bet;

        game.setScore(game.getScore()-bet);

        boolean play = true;
        boolean win = false;
        while (play){
            System.out.println(game.showCurrentCard(firstCard));
            int bigOrSmall = game.getBigOrSmallInput();
            Card card2 = game.draw();

            //Big
            // TODO :: Use enum for Big vs Small
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

            // TODO :: Make this method return a boolean (ex. game.shouldContinueToNextRound())
            int cont = game.getContInput();
            if (cont==0){
                firstCard = card2;
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

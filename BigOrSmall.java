import java.util.*;

public class BigOrSmall {
    private Chip chip = new Chip(0,0);
    private Trump trump = new Trump();

    //private Card card = new Card();

    public BigOrSmall(){
        chip.setChip10(10);
    }

    public Card draw(){
        Card temp = trump.draw();
        return temp;
    }

    public boolean judgeSmall(Card card1, Card card2){
        if (card1.getNum()>card2.getNum()){
            //win
            return true;
        }
        else if(card1.getNum()<card2.getNum()){
            //lose
            return false;
        }
        else{
            //when both num are the same
            String suit1 = card1.getSuit();
            String suit2 = card2.getSuit();
            return compareSuitesSmall(suit1, suit2);
        }
    }
    public boolean judgeBig(Card card1, Card card2){
        if (card1.getNum()>card2.getNum()){
            //lose
            return false;
        }
        else if(card1.getNum()<card2.getNum()){
            //win
            return true;
        }
        else{
            String suit1 = card1.getSuit();
            String suit2 = card2.getSuit();
            //when both num are the same
            return compareSuitesBig(suit1, suit2);
        }
    }

    public boolean compareSuitesBig(String card1, String card2){
        if(card1.equals("Spade") && ((card2.equals("Heart") || card2.equals("Diamond") || card2.equals("Club")))){
            //lose
            return false;
        }
        else if(card1.equals("Heart") && (card2.equals("Diamond") || card2.equals("Club"))){
            return false;
        }
        else if(card1.equals("Heart") && card2.equals("Spade")){
            return true;
        }
        else if(card1.equals("Diamond") && card2.equals("Club")){
            return false;
        }
        else if(card1.equals("Diamond") && (card2.equals("Heart") || card2.equals("Spade"))){
            return true;
        }
        else if(card1.equals("Club")){
            return true;
        }
        return false;
    }

    public boolean compareSuitesSmall(String card1, String card2){
        //delete this later
        if(card1.equals("Spade") && ((card2.equals("Heart") || card2.equals("Diamond") || card2.equals("Club")))){
            //lose
            return true;
        }
        else if(card1.equals("Heart") && (card2.equals("Diamond") || card2.equals("Club"))){
            return true;
        }
        else if(card1.equals("Heart") && card2.equals("Spade")){
            return false;
        }
        else if(card1.equals("Diamond") && card2.equals("Club")){
            return true;
        }
        else if(card1.equals("Diamond") && (card2.equals("Heart") || card2.equals("Spade"))){
            return false;
        }
        else if(card1.equals("Club")){
            return false;
        }

        return false;
    }

    public boolean validateBet(String input){
        int bet = 0;
        try{
            bet = Integer.parseInt(input);
            //when bet is out of the range
            if(bet>20 || bet<1){
                System.out.println("Your input is out of range!");
                System.out.println("半角英数字の1-20を入力してください。");
                return false;
            }
            else{
                //check if the chips are more than on hand
                int onHand = chip.getScore();
                if(bet>onHand){
                    System.out.println("Betが持っているチップより多いいです。");
                    System.out.println("もう一度入力してください。");
                    return false;
                }
            }
        }
        catch (Exception e){
            System.out.println("invalid input data!");
            System.out.println("半角英数字の1-20を入力してください。");
            return false;
        }
        return true;
    }

    public boolean validateInput(String input, String message) {
        int bigOrSmall = 0;
        try{
            bigOrSmall = Integer.parseInt(input);
            if(bigOrSmall != 0 && bigOrSmall != 1){
                System.out.println(message);
                return false;
            }
            else{
                return true;
            }
        }
        catch (Exception e){
            System.out.println("Invalid data!");
            System.out.println(message);
            return false;
        }
    }

    public String compareTwo(int num1, int num2){
        String ans = "";
        if (num1>num2){
            ans = "smaller";
        }
        else if (num1<num2) {
            ans = "bigger";
        }
        else{
            ans = "Same...\nスーツの違いで判断します「スペード」 > 「ハート」 > 「ダイヤ」 > 「クラブ」）";
        }
        return ans;
    }

    public int getBet(){
        Scanner scanner = new Scanner(System.in);
        boolean validChip = false;
        int bet = 0;

        while(!validChip){
            String input = scanner.next();
            if(this.validateBet(input)){
                bet = Integer.parseInt(input);
                validChip = true;
            }
        }
        //int point = bet;
        //game.setScore(game.getScore()-bet);
        return bet;
    }

    public void showProcess(Card card1, Card card2, String bigOrSmall, int bet){
        System.out.println("*****Bigger or Smaller*****");
        System.out.println("Bet数：" + bet);
        System.out.println("あなたの選択："+ bigOrSmall);
        System.out.println("現在のカード："+card1);
        System.out.println("引いたカード："+card2);

        System.out.println(card2+"は"+card1+"より"+compareTwo(card1.getNum(), card2.getNum()));
        System.out.println("***************************");
    }

    public boolean isLost(int score){
        if (score<=0){
            return true;
        }
        else{
            return false;
        }
    }

    public int win(int point){
        System.out.println("You won!");
        point *= 2;
        System.out.println("チップを"+point+"枚を獲得しました。");
        System.out.println("獲得したチップ"+point+"枚でBigger or Smaller\n" +
                "を続けますか？yes[0] or no[1]");
        return point;
    }

    public boolean lost(){
        System.out.println("You lost :(");
        System.out.println("*******現在のチップ枚数*******");
        chip.setChips(chip.getScore());
        System.out.println(this.status());
        if (!this.isLost(chip.getScore())){
            System.out.println("ゲームを続けますか？yes[0] or no[1]");
            return true;
        }
        else{
            System.out.println("Game Over..;(");
            System.exit(0);
        }
        return false;
    }

    public String showCurrentCard(Card card){
        return "********************\n現在のカード："+card+
                "\n********************";
    }

    public int getScore(){
        return chip.getScore();
    }

    public void setScore(int score){
        if (score<0){
            chip.setScore(0);
        }
        else{
            chip.setScore(score);
        }
    }

    public String status(){
        return ("Total: "+chip.getScore()+"[10]"+chip.getChip10()+" [1]"+chip.getChip1());
    }

    public String toString(){
        return "";
    }

    public void setChips(int total){
        this.chip.setChips(total);
    }
}

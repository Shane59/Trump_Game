public class Chip {
    private int chip10;
    private int chip1;
    private int score;

    public Chip(int chip10, int chip1){
        this.chip10 = chip10;
        this.chip1 = chip1;
        this.score = chip10*10 + chip1;
    }

    public int getChip10() {
        return chip10;
    }

    public int getChip1() {
        return chip1;
    }

    public int getScore() {
        //setChips(this.score);
        return this.score;
    }

    public void setChip10(int chip) {
        this.chip10 = chip;
        setScore(getChip10()*10+getChip1());
    }
    public void setChips(int total) {
        int ten = total/10;
        int ones = total%10;
        this.chip1 = ones;
        this.chip10 = ten;
    }

    public void setChip1(int chip1) {
        this.chip1 = chip1;
    }

    public void setScore(int score) {
        if (score<0){
            this.score = 0;
        }
        else{
            this.score = score;
        }
    }
}

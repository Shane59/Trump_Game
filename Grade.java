public class Grade {
    private String name;
    private int score;

    public Grade(String name, int score){
        this.name = name;
        this.score = score;
    }

    public String judge(){
        if(this.score>=90){
            return this.name+": AA";
        }
        else if(this.score>=80){
            return this.name+": A";
        }
        else if(this.score>=70){
            return this.name+": B";
        }
        else if(this.score>=60){
            return this.name+": C";
        }
        else{
            return this.name+": F";
        }
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

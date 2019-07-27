public class Chips {
    private int num;    // チップの数

    public Chips(int num) {
        this.num = num;
    }

    // チップの数を増減
    void change(int num) {
        this.num += num;
    }

    public int getNum(){
        return this.num;
    }
    public void setNum(int num){
        this.num=num;
    }

}

public class Chips_Main {
    public static void main(String[] args) {
        Chips chips = new Chips(100);

        // チップを10増やす
        chips.change(10);
        // 現在のチップ数を表示
        System.out.println(chips.getNum());
    }
}
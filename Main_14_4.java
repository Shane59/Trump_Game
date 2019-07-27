import java.util.Scanner;

public class Main_14_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookShelf list1 = new BookShelf();
        System.out.println("現在所持している一覧＝＝＝＝＝＝＝＝");
        list1.showList();

        System.out.println("新しい書籍を追加しますか？ [Yes or No]");
        String add = scanner.next();
        while (add.equals("Yes")){
            System.out.println("新しい本を追加します。");
            System.out.println("書籍名を入力してください。");
            String title = scanner.nextLine();
            System.out.println("価格を入力してください。");
            int price = scanner.nextInt();
            System.out.println("著者名を入力してください。");
            String author = scanner.nextLine();
            Book newBook = new Book(title, price, author);
            list1.add(newBook);
            System.out.println("繰り返し、書籍を追加しますか？ [Yes or No]");
            add = scanner.next();
        }
        System.out.println(list1.showList());

    }
}

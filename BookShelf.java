

public class BookShelf {
    private Book[] list = new Book[5];
    private int size = 0;

    public boolean add(Book book){
        if(this.size==5){
            System.out.println("いっぱいです。。。");
            return false;
        }
        else{
            if(size>0){
                for (Book check: list){
                    if(book.getName().equals(check.getName())){
                        System.out.println("同じ書籍があるので、追加されませんでした。");
                        return false;
                    }
                    else{
                        list[size] = book;
                        size++;
                        System.out.println("登録に成功しました。");
                        return true;
                    }
                }
            }
            else{
                list[size] = book;
                size++;
                System.out.println("登録に成功しました。");
                return true;
            }

        }
        return false;
    }

    public Object[] getList() {
        return list;
    }

    public Object getItem(int index){
        return this.list[index].toString();
    }

    public int getSize() {
        return size;
    }

    public String showList(){
        String ans = "";
        if(this.size==0){
            System.out.println("所持している本がありません");
            System.out.println("＝＝＝＝＝＝＝＝＝＝＝＝＝");
        }
        else{
            for (int i=0; i<this.getSize(); i++) {
                ans += this.list[i].toString() + "\n";
            }
        }
        return ans;
    }

    @Override
    public String toString(){
        String ans = "";
        for (int i=0; i<this.getSize(); i++){
            if(this.getSize()-1!=i){
                ans += this.getItem(i)+
                        "/";
            }
            else{
                ans += this.getItem(i);
            }
        }
        return ans;
    }
}

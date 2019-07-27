public class Book {
    private String name;
    private int price;
    private String author;

    public Book(String name, int price, String author){
        this.name = name;
        this.price = price;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String toString(){
        return "書名："+this.name + "/価格：" + this.price + "/著書名：" + this.author;
    }
}

public class Grade_Main {
    public static void main(String[] args) {
        Grade p1 = new Grade("Ito", 60);
        Grade p2 = new Grade("Suzuki", 88);
        Grade p3 = new Grade("Sato", 40);
        Grade p4 = new Grade("Nakayama", 74);
        Grade p5 = new Grade("Ikeda", 95);
        Grade p6 = new Grade("Ikeyama", 80);
        
        System.out.println(p1.judge());
        System.out.println(p2.judge());
        System.out.println(p3.judge());
        System.out.println(p4.judge());
        System.out.println(p5.judge());
        System.out.println(p6.judge());
    }

}

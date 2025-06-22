public class OPPS {
    public static void main(String[] args) {
        Pen p1 = new Pen();
        p1.changeColor("blue");
        p1.changeTip(5);
        System.out.println(p1.color);
        System.out.println(p1.tip);

        p1.color = "red";
        p1.tip = 10;
        System.out.println(p1.color);
        System.out.println(p1.tip);

        BankAccount myAcc = new BankAccount();
        myAcc.username = "manjula";
        myAcc.setPassword("hello");
    }
}

class Pen {
    String color;
    int tip;

    void changeColor(String newColor) {
        color = newColor;
    }

    void changeTip(int newTip) {
        tip = newTip;
    }
}

class BankAccount {
    public String username;
    private String password;

    public void setPassword(String pwd) {
        password = pwd;
    }
}
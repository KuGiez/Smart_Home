import java.util.Scanner;
public class Terminal {
    static private byte session = -1;
    private String version = "Version 1.0 Alpha Java-Powered terminal emulator";
    private String owner = "-Made by: Jakub Gryz-";
    private String ascii =  "▒▒▄▀▀▀▀▀▄▒▒▒▒▒▄▄▄▄▄▒▒▒\n" +
                            "▒▐░▄░░░▄░▌▒▒▄█▄█▄█▄█▄▒\n" +
                            "▒▐░▀▀░▀▀░▌▒▒▒▒▒░░░▒▒▒▒\n" +
                            "▒▒▀▄░═░▄▀▒▒▒▒▒▒░░░▒▒▒▒\n" +
                            "▒▒▐░▀▄▀░▌▒▒▒▒▒▒░░░▒▒▒▒";

    Scanner typeTerm = new Scanner(System.in);

    Terminal (){
        session++;
        start();
    }

    void info(){
        System.out.println("____________________________________________");
        System.out.println();
        System.out.println(version);
        System.out.println(ascii);
        System.out.println();
        System.out.println(owner);
        System.out.println();
        System.out.println();
        System.out.println("Terminal session opened on: tty"+this.session);
        System.out.println();
        System.out.println();
    }

    void start(){
        info();
        System.out.println();
        while(true){
            System.out.print("Enter your login: ");
            String login = typeTerm.nextLine();
            if(login.equals("root")){
                System.out.print("Enter your password: ");
                String password = typeTerm.nextLine();
                if(password.equals("novell")){
                    System.out.println("Logged in as 'root'");
                    system();
                    System.out.println();
                    System.out.println("tty" + this.session + " crashed due to missing code or firmware in system-terminal.sys");
                    System.out.println("Rerunning new console session.");
                    break;
                }
                else {
                    System.out.println("<WARNING> Wrong password. Try again");
                }
            }
        }
    }

    void system(){
        while(true) {
            System.out.print("home> $ ");
            String command = typeTerm.nextLine();
            if(command.equals("time")){
                System.out.println("Current time is: " + Clock.getGodzina() + ":" + Clock.getMinuty() + ":00");
            }
        }
    }
}
    
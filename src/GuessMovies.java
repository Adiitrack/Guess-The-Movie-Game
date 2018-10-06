import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
public class GuessMovies {
    public static void main(String[] args) throws Exception {
        File file=new File("movilist.txt");
        Scanner scanner=new Scanner(file);
        int total=0;
        ArrayList list1 = new ArrayList();
        while(scanner.hasNextLine()){
            String line=scanner.nextLine();
            list1.add(line);
            total+=line.split("\n").length;
        }
        int name=(int)(Math.random()*total)  +1;
        //System.out.println(name);
        //System.out.println(list1);
        //System.out.println(list1.get(name-1));

        //system choosen movies name Mname
        StringBuilder Mname= new StringBuilder();
        Mname.append(list1.get(name-1));
        //System.out.println(Mname.length());

        // user input movies name
        StringBuilder user =new StringBuilder();
        int i=0;
        while(i!= Mname.length()) {
            user.append(" ");
            i+=1;
        }
        System.out.println(user);
        System.out.println("Guess The Movie Name");

        //user input char by char;
        Scanner scan= new Scanner(System.in);
        StringBuilder userchar=new StringBuilder();
        for(int j=10;j>0;){
            if(Mname.toString().equals(user.toString())){
                System.out.println("You Win");
                System.out.println("you have guess "+ Mname + " Correctly");
                break;
            }
            System.out.println("You are Guessing : "+user+ "");
            char latter=scan.next().toLowerCase().charAt(0);
            //userchar.append(latter);
            for(i=0;i<Mname.length();i+=1){
               if(Mname.toString().toLowerCase().charAt(i)==latter) {
                   //System.out.println(Mname.toString().toLowerCase().charAt(i));
                   if(user.toString().charAt(i)==' ') {
                       user.replace(i, i + 1, Character.toString(latter));
                       break;
                   }
               }
                if(i==Mname.length()-1){
                    j-=1;
                    for(int k=userchar.length(); k>=0; k -= 1){
                        if(/*(userchar.toString().toLowerCase().charAt(k)!=latter) & */(k==0)){
                            //System.out.println("code here" +k+ "");
                            userchar.append(latter);
                            //System.out.println("you have gussed "+ userchar.length()+ " Wrong letters " + userchar);
                            break;
                        }
                    }

                }
            }
            System.out.println("you have gussed "+ userchar.length()+ " Wrong letters " + userchar);

        }
    }
}

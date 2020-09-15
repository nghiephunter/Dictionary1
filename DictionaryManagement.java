import java.util.Scanner;

public class DictionaryManagement extends Dictionary{
    public void insertFromCommandline(){
        int n;
        System.out.println("Nhap so luong tu: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            String a, b;
            Scanner sc1 = new Scanner(System.in);
            Scanner sc2 = new Scanner(System.in);
            a = sc1.nextLine();
            b = sc2.nextLine();
            Word w = new Word(a, b);
            container.add(w);
        }
    }
    public void showAllWords(){
        System.out.println("No" + "    | EngLish" + "      | Vietnamese");
        int i = 1;
        for(Word w : container){
            System.out.println(i + "    | " + w.getWord_target() + "       | " + w.getWord_explain());
            i++;
        }
    }
}

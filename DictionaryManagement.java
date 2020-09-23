import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class DictionaryManagement extends Dictionary {
    public void insertFromCommandline() {
        int n;
        System.out.println("Nhap so luong tu: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String a, b;
            Scanner sc1 = new Scanner(System.in);
            Scanner sc2 = new Scanner(System.in);
            a = sc1.nextLine();
            b = sc2.nextLine();
            Word w = new Word(a, b);
            container.add(w);
        }
    }

    public void insertFromFile() {
        Vector<String> vt = new Vector<String>();
        String fileName = "C:\\Users\\ADMIN\\Documents\\JavaProjects\\Dictionary\\src\\test.txt";
        // duong dan tuyet doi
        File file = new File(fileName);
        Scanner sc;
        try {
            sc = new Scanner(file).useDelimiter("[\n\t]+");
            while (sc.hasNext()) {
                String line = sc.next();
                vt.add(line);
            }

            for (int i = 0; i < vt.size(); i += 2) {
                Word w = new Word();
                w.setWord_target(vt.get(i));
                w.setWord_explain(vt.get(i + 1));
                container.add(w);
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void showAllWords() {
        String a = "No";
        String b = "| English";
        String c = "| Vietnamese";
        // System.out.println("No" + " | EngLish" + " | Vietnamese");
        System.out.printf("%-5s %-20s %-15s", a, b, c);
        System.out.println();
        int i = 1;
        for (Word w : container) {
            String s = "| " + w.getWord_target();
            String k = "| " + w.getWord_explain();
            System.out.printf("%-5s %-20s %s\n", i, s, k);
            // System.out.println(i + "| " + w.getWord_target() + "| " +
            // w.getWord_explain());
            i++;
        }
    }

    public void dictionaryLookup() {
        int select = 0;
        Scanner sc = new Scanner(System.in);
        while (select != 3) {
            System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-");
            System.out.println("Tra tu: ");
            System.out.println("1: " + "Tieng anh -> Tieng Viet");
            System.out.println("2: " + "Tieng Viet -> Tieng Anh");
            System.out.println("3: Thoat");
            select = sc.nextInt();
            if (select == 1) {
                System.out.println("**************************");
                System.out.print("Nhap tu: ");
                Scanner sc1 = new Scanner(System.in);
                String str;
                str = sc1.nextLine();
                System.out.println(str);
                int key = 0;
                for (Word w : container) {
                    if (w.getWord_target().equals(str)) {
                        key = 1;
                        System.out.println("Ket qua: ");
                        System.out.println(w.getWord_target() + " -> " + w.getWord_explain());
                        break;
                    }
                }
                if (key == 0) {
                    System.out.println("!!! Khong tim thay tu");
                }
                System.out.println("**************************");

            } else if (select == 2) {
                System.out.print("Nhap tu: ");
                Scanner sc2 = new Scanner(System.in);
                String str2;
                str2 = sc2.nextLine();
                System.out.println(str2);
                int key2 = 0;
                for (Word k : container) {
                    if (k.getWord_explain().contains(str2)) {
                        System.out.println(str2 + " -> " + k.getWord_target());
                        key2 = 1;
                        break;
                    }
                }
                if (key2 == 0) {
                    System.out.println("!!! Khong tim thay tu");
                }
                System.out.println("**************************");
            }

        }

    }

    public void DictionaryChange() {
        int select1 = 0;
        Scanner scan = new Scanner(System.in);
        while (select1 != 4) {
            System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-");
            System.out.println("Thay doi du lieu: ");
            System.out.println("1: " + "Them tu vao database");
            System.out.println("2: " + "Sua tu trong database");
            System.out.println("3: " + "Xoa tu khoi database");
            System.out.println("4: " + "Thoat");
            select1 = scan.nextInt();
            if (select1 == 1) {
                Scanner sc = new Scanner(System.in);
                String eng, viet;
                System.out.println("Nhap 2 tu: ");
                System.out.println("English: ");
                eng = sc.nextLine();
                System.out.println("Vietnamese: ");
                viet = sc.nextLine();
                Word e = new Word(eng, viet);
                container.add(e);
            } else if (select1 == 2) {
                String fix, change;
                Scanner scann = new Scanner(System.in);
                System.out.println("Nhap tu muon sua: ");
                fix = scann.nextLine();
                System.out.println(fix);
                int key3 = 0;
                for (Word w : container) {
                    Scanner scaan = new Scanner(System.in);
                    if (w.getWord_target().equals(fix)) {
                        System.out.println("Nhap nghia thay the: ");
                        change = scaan.nextLine();
                        w.setWord_explain(change);
                        key3 = 1;
                        break;
                    }
                }
                if (key3 == 0) {
                    System.out.println("Khong tim thay tu can sua!");
                }
            } else if (select1 == 3) {
                int flag_del = 0;
                Scanner scr = new Scanner(System.in);
                String delete;
                System.out.println("Nhap tu muon xoa: ");
                delete = scr.nextLine();
                for (Word i : container) {
                    if (i.getWord_target().equals(delete)) {
                        container.remove(container.indexOf(i));
                        // day la remove 1pt, update remove nhieu phan tu bang removeIf
                        System.out.println("Xoa thanh cong!");
                        flag_del = 1;
                        break;
                    }
                }
                if (flag_del == 0) {
                    System.out.println("Khong tim thay tu de xoa!");
                }

            }
        }

    }

    public void dictionarySearch() {
        int select2 = 0;
        while (select2 != 3) {
            System.out.println("**************************");
            System.out.println("Tra tu gan dung: ");
            System.out.println("1: Tieng Viet");
            System.out.println("2: Tieng Anh");
            System.out.println("3: Thoat");
            int key4;
            Scanner scan1 = new Scanner(System.in);
            key4 = scan1.nextInt();
            if (key4 == 1) {
                String str_search;
                System.out.println("Nhap tu can tra: ");
                Scanner scan2 = new Scanner(System.in);
                str_search = scan2.nextLine();
                for (Word i : container) {
                    if (i.getWord_explain().contains(str_search)) {
                        System.out.println(i.getWord_target() + " -> " + i.getWord_explain());
                    }
                }
            } else if (key4 == 2) {
                String str_search1;
                System.out.println("Nhap tu can tra: ");
                Scanner scan3 = new Scanner(System.in);
                str_search1 = scan3.nextLine();
                for (Word i : container) {
                    if (i.getWord_target().contains(str_search1)) {
                        System.out.println(i.getWord_target() + " -> " + i.getWord_explain());
                    }
                }

            }
        }

    }

    public void dictionaryExportToFile() {
        // String fileName = "data.txt";
        // BufferedWriter bw = null;
        // FileWriter fw = null;
        // try {
        //     String dat = "name of love";
        //     File file = new File(fileName);
        //     if (!file.exists()) {
        //         file.createNewFile();
        //     }
        //     fw = new FileWriter(file.getAbsoluteFile(), true);
        //     bw = new BufferedWriter(fw);
        //     bw.write(dat);
        //     System.out.println("Xong");

        // } catch (Exception e) {
        //     // TODO: handle exception
        //     e.printStackTrace();
        // }
        try {
            FileWriter fw = new FileWriter("data.txt");
            for(Word i : container){
                fw.write(i.getWord_target());
                fw.write("\t");
                fw.write(i.getWord_explain());
                fw.write("\n");
            }
            fw.close();
        } catch (Exception e) {
            //TODO: handle exception
        }

    }

}

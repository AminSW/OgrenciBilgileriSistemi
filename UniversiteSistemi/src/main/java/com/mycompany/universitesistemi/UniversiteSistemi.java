package com.mycompany.universitesistemi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;



public class UniversiteSistemi {
    
    public static Ogrenci OgrenciEkle() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ogrencinin ismi: ");
        String isim = scanner.nextLine();
        System.out.println("Ogrencinin sinifi: ");
        int sinif = Integer.valueOf(scanner.nextLine());
        
        System.out.println("Ogrencinin bolumu");
        String   bolumSec = scanner.nextLine();
        Bolumler bolum    = null;
        
        switch (bolumSec) {
            case "ceng":
                System.out.println("Ogrencinin egitim aldigi dili girin: ");
                String dil = scanner.nextLine();
                
                System.out.println("Ogrencinin notlarini sirayla girin: ");
                String[] notlar = scanner.nextLine().split(" ");
                
                int firstP  = Integer.valueOf(notlar[0]);                
                int secondP = Integer.valueOf(notlar[1]);
                int thirdP  = Integer.valueOf(notlar[2]);
                int fourthP = Integer.valueOf(notlar[3]);
                int fifthP  = Integer.valueOf(notlar[4]);
                
                bolum = new CompEng(dil, firstP, secondP, thirdP, fourthP, fifthP);

                break;
            default:
                throw new AssertionError();
        }
        Ogrenci ogrenci = new Ogrenci(isim, bolum, sinif);
        return ogrenci;
    }

    public static void ListeyeAl(List<Ogrenci> list) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileInputStream("dosya.txt"));
        } catch (FileNotFoundException ex) {
            System.out.println("Dosya Bulunamadi");
        }
        
        scanner.useDelimiter("\n");
        
        while (scanner.hasNext()) {     
            
            String[] values = scanner.next().split("");
            String isim  = values[0];
            int    sinif = Integer.valueOf(values[8]); 
            Bolumler bolum = null;
            
            switch (values[1]) {
                case "ceng":
                    bolum = new CompEng(values[2], Integer.valueOf(values[3]), Integer.valueOf(values[4]), Integer.valueOf(values[5]), Integer.valueOf(values[6]), Integer.valueOf(values[7]));
                    break;
                default:
                    throw new AssertionError();
            }
            Ogrenci ogrenci = new Ogrenci(isim, bolum, sinif);
            list.add(ogrenci);
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            FileOutputStream fos = new FileOutputStream("dosya.txt");
        } catch (FileNotFoundException ex) {
            System.out.println("Dosya Acilamadi");
        }
        
        List <Ogrenci> liste = new ArrayList<>();
        
        ListeyeAl(liste);
        
        String islemler = "1.islem: Ogrenci ekle\n"
                + "2.islem: Ogrencileri goruntule\n"
                + "3.islem: Ogrencini goruntule \n";
        
        while (true) {            
            
            System.out.println("Ana Sayfa");
            System.out.println("_____________________________________________\n"+
                    islemler
                              +"_____________________________________________");
            String islem = scanner.nextLine();
            
            switch (islem) {
                case "1":
                    Ogrenci ogrenci = OgrenciEkle();
                    
                    break;
                default:
                    throw new AssertionError();
            }
            
        }
    }
}

package com.mycompany.universitesistemi;

import java.util.HashMap;

public class Bolumler {
    private HashMap<String,Integer> DandP;
    private String[]                dersler;
    private String                  language;
    private double                  ortalama;
    private int[]                   puanlar;
    private double                  katkiPayi;

    public Bolumler(String lang, int firstP, int secondP, int thirdP, int forthP, int fivthP) {
        this.language = lang;
        this.puanlar  = new int[]{firstP, secondP, thirdP, forthP, fivthP};
        setOrtalama(firstP, secondP, thirdP, forthP, fivthP);
        
    }
    
    
    
    public HashMap<String, Integer> getDandP() {
        return DandP;
    }

    public void setDandP(int [] puanlar, String[] dersler) {
        DandP = new HashMap<>();
        for(int a = 0; a < puanlar.length; a++){
            DandP.put(dersler[a], puanlar[a]);
        }
    }
    

    
    public String[] getDersler() {
        return dersler;
    }

    public void setDersler(String[] dersler) {
        this.dersler = dersler;
    }
    
    
    
    public void DersleriGoster(){
        System.out.println("1."+dersler[0]+"\n"
                + "2."+dersler[1]+"\n"
                + "3."+dersler[2]+"\n"
                + "4."+dersler[3]+"\n"
                + "5."+dersler[4]+"\n");
    }
    
    public void NotlariGoster() {
        System.out.println("1." + dersler[0] + ": " + puanlar[0] + "\n"
                         + "2." + dersler[1] + ": " + puanlar[1] + "\n"
                         + "3." + dersler[2] + ": " + puanlar[2] + "\n"
                         + "4." + dersler[3] + ": " + puanlar[3] + "\n"
                         + "5." + dersler[4] + ": " + puanlar[4] + "\n");
    }

    
    
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
        setKatkiPayi(language);
    }

    
    
    public double getOrtalama() {
        return ortalama;
    }

    public void setOrtalama( int firstP, int secondP, int thirdP, int forthP, int fivthP) {
        this.ortalama = (double)(firstP+secondP+thirdP+forthP+fivthP)/5;;
    }

    
    
    public int[] getPuanlar() {
        return puanlar;
    }

    public void setPuanlar(int[] puanlar) {
        this.puanlar = puanlar;
    }

    
    
    public double getKatkiPayi() {
        return katkiPayi;
    }

    public void setKatkiPayi(String lang) {
        if (lang.equals("eng")) {
            katkiPayi = 1.2;
        }
        else{
            katkiPayi = 1.0;
        }
    }
    
    
    
    
}

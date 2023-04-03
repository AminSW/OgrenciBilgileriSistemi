package com.mycompany.universitesistemi;
import java.util.Comparator;

class EnAzBursAlan implements Comparator<Ogrenci>{

    @Override
    public int compare(Ogrenci o1, Ogrenci o2) {
       
        if(o1.getBurs() > o2.getBurs()){
            return 1;
        }
        else if(o1.getBurs() < o2.getBurs()){
            return -1;
        }
        return 0;
    }
    
}

class EnCoxBursAlan implements Comparator<Ogrenci>{

    @Override
    public int compare(Ogrenci o1, Ogrenci o2) {
       
        if(o1.getBurs() > o2.getBurs()){
            return -1;
        }
        else if(o1.getBurs() < o2.getBurs()){
            return 1;
        }
        return 0;
    }
    
}

class EnDusukOrtalama implements Comparator<Ogrenci>{

    @Override
    public int compare(Ogrenci o1, Ogrenci o2) {
       
        if(o1.getBolum().getOrtalama() > o2.getBolum().getOrtalama()){
            return 1;
        }
        else if(o1.getBolum().getOrtalama() < o2.getBolum().getOrtalama()){
            return -1;
        }
        return 0;
    }
    
}

class EnYuksekOrtalama implements Comparator<Ogrenci>{

    @Override
    public int compare(Ogrenci o1, Ogrenci o2) {
       
        if(o1.getBolum().getOrtalama() > o2.getBolum().getOrtalama()){
            return -1;
        }
        else if(o1.getBolum().getOrtalama() < o2.getBolum().getOrtalama()){
            return 1;
        }
        return 0;
    }
    
}


public class Ogrenci {
    
    private String   isim;
    private Bolumler bolum;
    private int      sinif;
    private double   burs;

    public Ogrenci(String isim, Bolumler bolum, int sinif) {
        this.isim  = isim;
        this.bolum = bolum;
        this.sinif = sinif;
        setBurs(sinif, bolum.getKatkiPayi(), bolum.getOrtalama());
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }
    
    

    public Bolumler getBolum() {
        return bolum;
    }

    public void setBolum(Bolumler bolum) {
        this.bolum = bolum;
    }

    
    
    public int getSinif() {
        return sinif;
    }

    public void setSinif(int sinif) {
        this.sinif = sinif;
        setBurs(sinif, burs, bolum.getOrtalama());
    }

    
    
    
    public double getBurs() {
        return burs;
    }

    public void setBurs(int sinif, double katkiPayi, double ortalama) {
        this.burs = (double)50*(sinif*katkiPayi*ortalama);
    }
    
    
    
    public void ortalamaDegis(int firstP, int secondP, int thirdP, int forthP, int fivthP) {
        bolum.setOrtalama(firstP, secondP, thirdP, forthP, fivthP);
        setBurs(sinif, burs, bolum.getOrtalama());
    }
    
    public void EgitimDiliniDegistir(String lang) {
        bolum.setLanguage(lang);
        bolum.setKatkiPayi(bolum.getLanguage());
        setBurs(sinif, bolum.getKatkiPayi(), bolum.getOrtalama());
    }
    
    
}

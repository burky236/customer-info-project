/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final1;

import java.util.ArrayList;

/**
 *
 * @author Burak Kacmaz
 */
public class CustomerInfo {
    //tanımlanması istenen adSoyad ve telefon Stringleri ve adres arraylisti
    private String adSoyad;
    private String adres;
    private ArrayList <String> telNo;
    
    public CustomerInfo() //parametresiz constructor
    {
    }
    
    public CustomerInfo(String theadSoyad, String theadres, ArrayList<String> thetelNo) //parametreli consturctor
    {
        adSoyad = theadSoyad;
        adres = theadres;
        telNo = thetelNo;
    }
    
    
    /**
     * @return the adSoyad
     */
    public String getAdSoyad() {
        return adSoyad;
    }

    /**
     * @param adSoyad the adSoyad to set
     */
    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    /**
     * @return the adres
     */
    public String getAdres() {
        return adres;
    }

    /**
     * @param adres the adres to set
     */
    public void setAdres(String adres) {
        this.adres = adres;
    }


    /**
     * @return the telNo
     */
    public ArrayList <String> getTelNo() {
        return telNo;
    }

    /**
     * @param telNo the telNo to set
     */
    public void setTelNo(ArrayList <String> telNo) {
        this.telNo = telNo;
    }

    
    @Override
    public String toString() {//Çıktıların yazdırılmasını duzenlemek icin
        String musteri = (" Ad Soyad: " + adSoyad + " " + "Adres: " + adres + " " + "Telefon Numarası: " );
        
        ArrayList <String> telNos = getTelNo();
        
        int i = 0;
        
        while(i < telNos.size()){
            musteri += telNos.get(i)+ ", ";
            i++;
        }
        
        return musteri;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Burak Kacmaz
 */
public class Final1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DoublyLinkedList dLL = new DoublyLinkedList();
        Scanner scan = new Scanner(System.in);
        
        Scanner fileIn = null;        
        
        //Hata olusursa dosya okunmaz, eger hata yoksa dosyadan okuma yapilir
        try
        {                      
            fileIn = new Scanner(                     
            new FileInputStream("customer.txt"));  
        } 
        catch (FileNotFoundException a) 
        {         
            System.out.println("Dosya bulunamadi.");
            System.exit(0);         
        }
        
        String lines;
        //Satir sayisi bitmedikce okuma yapilir
        while (fileIn.hasNext())
        {
            lines = fileIn.nextLine();
            String[] temp = lines.split(","); //ayrac olarak virgul tanimlandi
            String adSoyad = temp [0];
            String adres = temp [1];
            
            ArrayList<String> telNos = new ArrayList<String>();
            
            int i = 0;
            while(i < temp.length-2){
                telNos.add(temp[i+2]);
                i++;
            }
            //alinan bilgiler ile once customer oradan da dLL'e ekleme yapildi
            CustomerInfo customer = new CustomerInfo(adSoyad,adres,telNos);
            dLL.add(customer); 
        }
        fileIn.close();
        
        System.out.println("İşlem yapılmamış ikili bağlı liste yazdırılıyor:");
        dLL.bastanYazdir();
        
        //Yeni musteri bilgilerinin girildigi kisim
        System.out.println("Ekleme icin ad soyad giriniz: ");
        String adSoyad = scan.nextLine();
        
        System.out.println("Ekleme icin adres giriniz: ");
        String adres = scan.nextLine();
        
        ArrayList<String> telNos = new ArrayList<String>();
        System.out.println("Telefon numarası giriniz: 'Bitti' yazilana kadar numara girilebilir.");
        
        boolean cont = true;
        //bitti yazilmadikca numaraya ekleme yapilir
        while(cont) 
        {
            String numara = scan.nextLine();
            if (numara.equals("Bitti")){
                cont = false;
            }
            else{
                telNos.add(numara);
            }     
        }
        
        //eklenen bilgilerle customer olusturma
        CustomerInfo customerYeni = new CustomerInfo(adSoyad, adres, telNos);
        dLL.add(customerYeni);System.out.println("\nEkleme Yapildiktan Sonra Liste: ");
        dLL.bastanYazdir();//ekleme yapildiktan sonra yeni hal
        
        //Silinecek customer isim ve soyismi
        System.out.println("\nSilinecek musteri adi ve soyadi: "); 
        String silinecekCust = scan.nextLine();
        dLL.delete(silinecekCust);//Silme methodu
        
        //En son hali A'dan Z'ye ve Z'den A'ya yazdirildi.
        System.out.println("\nListenin Son Hali: (A'dan Z'ye ve Z'den A'ya)");
        
        //Alfabetik sirada yazdırma islemi
        System.out.println("\nA'dan Z'ye musteriler: ");
        dLL.bastanYazdir();//Bastan yazdirma
        
        //Alfabetik siranin tersine yazdırma islemi
        System.out.println("\nZ'den A'ya musteriler: ");
        dLL.sondanYazdir();//Tersten yazdirma islemi
    }
}

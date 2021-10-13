/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final1;

/**
 *
 * @author Burak Kacmaz
 */
public class DoublyLinkedList {

    private class Node {
        //Node icin tanimlanan elemanlar
        CustomerInfo customer;
        Node previous;
        Node next;

        public Node() {
            next = null;
            previous = null;
            customer = null;
        }

        public Node(Node newNext, Node newPrevious, CustomerInfo newCustomer) {
            next = newNext;
            previous = newPrevious;
            customer = newCustomer;
        }
    }

    Node head;
    Node tail;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    public DoublyLinkedList(Node aHead, Node aTail) {
        head = aHead;
        tail = aTail;
    }
    
    Node info = null;
    public void bastanYazdir() {//diziyi baştan yazdırma.
        if (head == null) {//eğer başlangıç değeri yoksa hata vermemesi için yazıldı.
            return;
        }
        info = head;
        
        while (info != null) {
            System.out.println(info.customer);
            info = info.next;
        }
    }
    public void sondanYazdir() {//diziyi sondan yazdırma.
        if (tail == null) {//eğer kuyruk değeri yoksa hata vermemesi için yazıldı.
            return;
        }
        
        info = tail;
        
        while (info != null) {
            System.out.println(info.customer);
            info = info.previous;
        }
    }
    //Listeye ekleme yapilan method
    public void add(CustomerInfo customer)
    {
        Node Node = new Node(); 
        Node.customer = customer;
        

        if (!bosMu())
        {
            String[] adSoyadDizi = customer.getAdSoyad().split(" "); 
            String SoyadAyrik = adSoyadDizi[adSoyadDizi.length - 1];

            Node nextly = head;
            boolean cont = true;
            while (cont) {
                String[] nextlyAdSoyadDizi = nextly.customer.getAdSoyad().split(" ");
                String nextlySoyad = nextlyAdSoyadDizi[nextlyAdSoyadDizi.length - 1];

                int compare = SoyadAyrik.compareTo(nextlySoyad);

                if (compare <= 0) 
                {
                    Node previous = nextly.previous;
                    if (previous == null)
                    {
                        nextly.previous = Node;
                        
                        if (nextly.next == head)
                        {
                            nextly.next = null;
                            tail = nextly;
                        }
                        Node.next = nextly;
                        Node.previous = null;
                        head = Node;
                    } else
                    {
                        previous.next = Node;
                        nextly.previous = Node;
                        Node.next = nextly;
                        Node.previous = previous;
                    }

                    cont = false;
                } else
                {
                    if (nextly.next == null)
                    {
                        nextly.next = Node;
                        Node.previous = nextly;
                        Node.next = null;
                        tail = Node;

                        cont = false;
                    } else
                    {
                        nextly = nextly.next;
                    }
                }

            }
        } else
        {
            Node.previous = null;
            head = Node;
            Node.next = head;
        }
    }
    
    //Isim ve soyismi girilen customeri listeden silme
    public boolean delete(String adSoyad)
    {
        if (!bosMu())
        {
        boolean cont = true; 
        Node nextly = head;
        
        while(cont) 
        {
            int compare = adSoyad.compareTo(nextly.customer.getAdSoyad()); 
            
            if (compare == 0)  
            {
                if (nextly == head)
                {
                    if (nextly.next==null)
                    {
                        head = null;
                        tail = null;
                    }
                    else if(nextly.next == head)
                    {
                        head = null;
                    }
                    else
                    {
                        Node after = nextly.next;
                        after.previous = null;

                        head = after;
                    }
                }
                else if(nextly == tail)
                {
                    if (nextly.previous==null)
                    {
                        head = null;
                        tail = null;
                    }
                    else
                    {
                        Node before = nextly.previous; 
                        before.next = null;
                        tail = before;
                    }
                }
                else
                {
                    Node after = nextly.next;
                    Node before = nextly.previous;
                    
                    before.next = after;
                    after.previous = before;
                }

                return true;
            }
            else
            {
                if (nextly != tail)
                    nextly = nextly.next;
                else 
                    cont = false;
            }
        }
        return false;
        }
        else{
            return false;
        }

        
    }
    //bos olma durumunu kontrol eden method
    public boolean bosMu() 
    {
        return head == null;
    }
}

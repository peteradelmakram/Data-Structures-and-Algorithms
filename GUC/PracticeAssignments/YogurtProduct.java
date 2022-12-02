package PracticeAssignments;
import java.time.LocalDate;

import PriorityQueues.PriorityQueue;

public class YogurtProduct implements Comparable {
    int ID;
    double price;
    LocalDate date;

    public YogurtProduct(int ID, double price, LocalDate date){
        this.ID = ID;
        this.price = price;
        this.date = date;
    }

    public int compareTo(Object o) {
        LocalDate expiryDate = ((YogurtProduct) o).date;
        return this.date.compareTo(expiryDate);
    }
}

class Supermarket{
    PriorityQueue products;

    public Supermarket(int size){
        products = new PriorityQueue(size);
    }

    public void addProd(YogurtProduct x){
        if(products.isFull()) return;
        products.insert(x);
    }

    public double newPrice(int ID){
        ObjStack stack = new ObjStack(products.size());
        int size = products.size();
        double discount = 0.5;
        YogurtProduct curr = null;

        for(int i = 0; i < size; i++){
            curr = (YogurtProduct) products.remove();
            if(curr.ID == ID){
                break;
            }

            if(!stack.isEmpty()){
                if(!((YogurtProduct) stack.top()).date.equals(curr.date)){
                    discount -= 0.05;
                }
            }

            stack.push(curr);
        }
        discount = 1 - discount;

        double newPrice = curr.price * discount;

        while(!stack.isEmpty()){
            products.insert((YogurtProduct) stack.pop());
        }

        return newPrice;
    }

    public static void main(String[] args) {
        YogurtProduct p1 = new YogurtProduct(1,2.0,LocalDate.of(2014,10,30));
        YogurtProduct p2 = new YogurtProduct(2,3.0, LocalDate.of(2014,10,27));
        YogurtProduct p3 = new YogurtProduct(3,8.0,LocalDate.of(2014,10,26));
        YogurtProduct p4 = new YogurtProduct(4,4.0,LocalDate.of(2014,10,27));
        YogurtProduct p5 = new YogurtProduct(5,5.0,LocalDate.of(2014,10,27));
        YogurtProduct p6 = new YogurtProduct(6,6.0,LocalDate.of(2014,10,26));
        Supermarket s = new Supermarket(6);
        s.addProd(p1);
        s.addProd(p2);
        s.addProd(p3);
        s.addProd(p4);
        s.addProd(p5);
        s.addProd(p6);
        System.out.println(s.newPrice(4));
    }
}

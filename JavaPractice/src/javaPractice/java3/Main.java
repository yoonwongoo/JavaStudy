package javaPractice.java3;

public class Main {
    public static void main(String[] args) {
   /*     Jacket jacket = new Jacket();
        ClosetOne one = new ClosetOne();
        one.setJacket(jacket);
        one.getJacket();



        Pants pants = new Pants();
        ClosetTwo two = new ClosetTwo();
        two.setPants(pants);
        two.getPants();*/



       /* Jacket jacket = new Jacket();
        ClosetOne one = new ClosetOne();
        one.setJacket(jacket);
        형변환 Jacket j = (Jacket) one.getJacket();*/



        Pants pants = new Pants();
        Jacket jacket = new Jacket();


        GClosetThree<Pants> GPants= new GClosetThree<Pants>();
        GPants.setClothes(pants);
        GPants.getClothes();//형변환이 일어나지않음.

        GClosetThree<Jacket> GJacket = new GClosetThree<Jacket>();
        GJacket.setClothes(jacket);
        GJacket.getClothes();//형변환이 일어나지않음.
    }

}

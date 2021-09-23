package javaPractice.java3;

public class GClosetThree<T extends Clothes> {

    private T clothes;

    public T getClothes() {
        return clothes;
    }

    public void setClothes(T clothes) {
        this.clothes = clothes;
    }

    @Override
    public String toString() {
        return clothes.toString();
    }
}

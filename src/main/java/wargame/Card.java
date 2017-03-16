package wargame;

/**
 * Created by Jen on 3/15/2017.
 */
public class Card {

    private int value;
    private String displayValue;

    public Card(int value, String displayValue){
        this.value = value;
        this.displayValue = displayValue;
    }

    public int getValue() {
        return value;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    @Override
    public String toString() {
        return "Card{" +
                "value=" + value +
                ", displayValue='" + displayValue + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        return value == card.value;
    }

    @Override
    public int hashCode() {
        return value;
    }
}

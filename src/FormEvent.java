import java.util.EventObject;

public class FormEvent extends EventObject {

    private float tempMin;
    private float tempMax;
    private float temperatura;
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public FormEvent(Object source) {
        super(source);
    }

    public FormEvent(Object source, Float tempMin, Float tempMax, Float temperatura) {
        super(source);

        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.temperatura = temperatura;
    }


    public float getTempMin() {
        return tempMin;
        //cheat sheet

    }

    public void setTempMin(float tempMin) {
        this.tempMin = tempMin;
    }

    public float getTempMax() {
        return tempMax;
    }

    public void setTempMax(float tempMax) {
        this.tempMax = tempMax;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }
}

public final class Keyboard {

    private final  String type;
    private final  double weight;
    private final  isLightKeyboard isLightKeyboard;

    public Keyboard(String type, isLightKeyboard isLightKeyboard, double weight) {
        this.type = type;
        this.isLightKeyboard = isLightKeyboard;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public String getType() {
        return type;
    }

    public isLightKeyboard getIsLightKeyboard() {
        return isLightKeyboard;
    }


}

public final class StorageOfInformation {

    private final  int volume;
    private final  double weight;
    private final  StorageType type;

    public StorageOfInformation(StorageType type, int volume, double weight) {
        this.type = type;
        this.volume = volume;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public int getVolume() {
        return volume;
    }

    public StorageType getType() {
        return type;
    }
}

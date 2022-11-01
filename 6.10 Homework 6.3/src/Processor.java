public final class Processor {

    private final double frequency;

    private final  int cores;
    private final String vendor;
    private final double weight;

    public Processor(double frequency, int cores, String vendor, double weight) {
        this.frequency = frequency;
        this.cores = cores;
        this.vendor = vendor;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public double getFrequency() {
        return frequency;
    }

    public int getCores() {
        return cores;
    }

    public String getVendor() {
        return vendor;
    }
}

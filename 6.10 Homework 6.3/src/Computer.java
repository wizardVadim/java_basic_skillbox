public class Computer {

    private final Processor processor;
    private final RAM ram;
    private final StorageOfInformation storageOfInformation;
    private final Screen screen;
    private final Keyboard keyboard;
    private final String vendor;
    private final String name;

    private double totalWeight;

    //======================================================================

    public Computer(Processor processor,
                    RAM ram,
                    StorageOfInformation storageOfInformation,
                    Screen screen,
                    Keyboard keyboard, String vendor, String name) {
        this.processor = processor;
        this.ram = ram;
        this.storageOfInformation = storageOfInformation;
        this.screen = screen;
        this.keyboard = keyboard;
        this.vendor = vendor;
        this.name = name;
    }


    //=============================================================== totalWeight

    public void totalWeight() {

        final double processorWeight = processor.getWeight();
        final double ramWeight = ram.getWeight();
        final double storageOfInformationWeight = storageOfInformation.getWeight();
        final double screenWeight = screen.getWeight();
        final double keyboardWeight = keyboard.getWeight();

        totalWeight = processorWeight +
                ramWeight +
                storageOfInformationWeight +
                screenWeight +
                keyboardWeight;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    //=============================================================== toString

    public String toString (){
        return getName()+ "\n" +


                getVendor() + "\n" + "\n" +


                getProcessor() + "\n" +
                "Производитель: " + getProcessor().getVendor() + "\n" +
                "Кол-во ядер: " + getProcessor().getCores() + "\n" +
                "Частота: " + getProcessor().getFrequency() + "GHz" + "\n" +
                "Вес: " + getProcessor().getWeight() + " kg" + "\n" + "\n" +


                getRam()+ "\n" +
                "Тип: " + getRam().getType() + "\n" +
                "Объем: " + getRam().getVolume() + " GB" + "\n" +
                "Вес: " + getRam().getWeight() + " kg" + "\n" + "\n" +


                getStorageOfInformation()+ "\n" +
                "Тип: " + getStorageOfInformation().getType() + "\n" +
                "Объем: " + getStorageOfInformation().getVolume() + "GB" + "\n" +
                "Вес: " + getStorageOfInformation().getWeight() + " kg" + "\n" + "\n" +


                getScreen()+ "\n" +
                "Тип: " + getScreen().getType() + "\n" +
                "Диагональ: " + getScreen().getDiagonal() + " cm" + "\n" +
                "Вес: " + getScreen().getWeight() + " kg" + "\n" + "\n" +


                getKeyboard() + "\n" +
                "Тип: " + getKeyboard().getType() + "\n" +
                "Есть подсветка? " + getKeyboard().getIsLightKeyboard() + "\n" +
                "Вес: " + getKeyboard().getWeight() + " kg" + "\n" + "\n";
    }

    //=============================================================== Getters

    public Processor getProcessor() {
        return processor;
    }

    public RAM getRam() {
        return ram;
    }

    public StorageOfInformation getStorageOfInformation() {
        return storageOfInformation;
    }

    public Screen getScreen() {
        return screen;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public String getVendor() {
        return vendor;
    }

    public String getName() {
        return name;
    }

    //==================================================================== Setters

    public Computer setProcessor(Processor processor) {
        return new Computer(processor, ram, storageOfInformation, screen, keyboard, vendor, name);
    }

    public Computer setRAM(RAM ram) {
        return new Computer(processor, ram, storageOfInformation, screen, keyboard, vendor, name);
    }

    public Computer setStorageOfInformation(StorageOfInformation storageOfInformation) {
        return new Computer(processor, ram, storageOfInformation, screen, keyboard, vendor, name);
    }

    public Computer setScreen(Screen screen) {
        return new Computer(processor, ram, storageOfInformation, screen, keyboard, vendor, name);
    }

    public Computer setKeyboard(Keyboard keyboard) {
        return new Computer(processor, ram, storageOfInformation, screen, keyboard, vendor, name);
    }
}

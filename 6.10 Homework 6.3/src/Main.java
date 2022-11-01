public class Main {

    public static void main(String[] args) {
        Processor processor = new Processor(4.5, 8, "Intel", 0.2);
        RAM ram = new RAM("DDR4", 16, 0.5);
        StorageOfInformation storageOfInformation =new StorageOfInformation(StorageType.SSD, 1024, 0.4);
        Screen screen = new Screen(20.5, ScreenType.IPS, 5);
        Keyboard keyboard = new Keyboard("Mechanical", isLightKeyboard.YES, 0.8);


        Computer computer = new Computer(processor,
                ram,
                storageOfInformation,
                screen,
                keyboard,
                "DEXP",
                "TOTALLY SUPER PC");

        System.out.println(computer.toString());

        computer.totalWeight();

        System.out.println("Общий вес: " + computer.getTotalWeight() + " kg");

    }

}

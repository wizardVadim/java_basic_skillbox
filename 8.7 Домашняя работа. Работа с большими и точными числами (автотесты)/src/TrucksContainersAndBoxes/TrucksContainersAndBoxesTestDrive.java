package TrucksContainersAndBoxes;

public class TrucksContainersAndBoxesTestDrive {
    public static void main(String[] args) {

        Box box = new Box(105);
        box.calculationCountContainerAndTrack();
        box.sendMessage();

        Box box1 = new Box(27);
        box1.calculationCountContainerAndTrack();
        box1.sendMessage();



    }
}

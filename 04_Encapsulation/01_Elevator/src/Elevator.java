public class Elevator {

    private int currentFloor = 1;

    private int minFloor;

    private int maxFloor;

    private int blockedFloor;


    public Elevator(int minFloor, int maxFloor){
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public Elevator(int minFloor, int maxFloor, int blockedFloor){
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
        this.blockedFloor = blockedFloor;
    }


    public int getCurrentFloor() {
        return currentFloor;
    }

    public void moveDown() {
        currentFloor = currentFloor > minFloor ? currentFloor - 1 : currentFloor;
    }

    public void moveUp() {
        currentFloor = currentFloor < maxFloor ? currentFloor + 1 : currentFloor;
    }

    public void move(int floor) {
        if (floor < minFloor || floor > maxFloor) {
            System.out.println("Ошибка, такого этажа не существует");
        } else if(floor == blockedFloor) {

            System.out.println("Простите, этаж недоступен");

        } else if (currentFloor < floor) {
            while(currentFloor != floor){
                moveUp();
                System.out.println(getCurrentFloor());
            }

        } else if (currentFloor > floor) {
            while (currentFloor != floor) {
                moveDown();
                System.out.println(getCurrentFloor());
            }
        }

        }

}

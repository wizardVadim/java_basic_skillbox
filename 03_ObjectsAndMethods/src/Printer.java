public class Printer {

    private String queue;
    private int pendingPagesCount = 0;
    private int totalPendingPagesCount = 0;

    public Printer() {
        queue = "Список документов: ";
    }

    public void append(String text) {
        append(text, null, 1);
    }

    public void append(String text, String name) {
        append(text, name, 1);
    }

    public void append(String text, String name, int page) {
        boolean error = false;

        queue = queue + "\n" + name + "\n" + text + "\n" +
                "Кол-во страниц: " + page;
        pendingPagesCount = pendingPagesCount + page;
    }





    public void clear() {
        queue = "";
    }

    public void print() {

        if (queue.isEmpty()) {
            System.out.println("Очередь на печать не присутствует");
        } else {
            System.out.println(queue);
            totalPendingPagesCount = totalPendingPagesCount + pendingPagesCount;
            clear();
            pendingPagesCount = 0;
            System.out.println(getTotalPendingPagesCount());
        }
    }

    public int getPendingPagesCount() {
        return pendingPagesCount;
    }

    public int getTotalPendingPagesCount() {
        return totalPendingPagesCount;
    }

    public void printTotalPendingPagesCount() {
        System.out.println(getTotalPendingPagesCount());
    }
}

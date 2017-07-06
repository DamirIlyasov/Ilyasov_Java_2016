package interfaces;

public abstract class Room {
    private Bed bed;
    private Chair chair;
    private Table table;
    private Color color;

    public Room(Bed bed, Chair chair, Table table, Color color) {
        this.bed = bed;
        this.chair = chair;
        this.table = table;
        this.color = color;
    }

    public void printContent() {
        System.out.println("Цвет обоев в комнате: " + color.getName() + '\n' +
                "Размер кровати: " + bed.getSize() + '\n' +
                "Размер cтола: " + table.getSize() + '\n' +
                "Размер стула: " + chair.getSize());
    }
}

package model;

public class ViewMode {
    private int id;
    private String name;

    public ViewMode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ViewMode() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

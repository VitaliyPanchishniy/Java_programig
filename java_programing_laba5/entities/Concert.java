package entities;

public class Concert {
    private String title;

    public Concert(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Концерт{" + "Назва='" + title + '\'' + '}';
    }
}

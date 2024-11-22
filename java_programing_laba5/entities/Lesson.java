package entities;

import java.time.LocalDateTime;

public class Lesson implements Comparable<Lesson> {
    private String title;
    private LocalDateTime dateTime;

    public Lesson(String title, LocalDateTime dateTime) {
        this.title = title;
        this.dateTime = dateTime;
    }

    @Override
    public int compareTo(Lesson other) {
        return this.dateTime.compareTo(other.dateTime);
    }

    @Override
    public String toString() {
        return "Заняття{" + "Назва='" + title + '\'' + ", Дата і час=" + dateTime + '}';
    }
}

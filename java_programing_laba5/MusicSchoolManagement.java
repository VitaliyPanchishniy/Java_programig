import entities.Student;
import entities.Lesson;
import entities.Concert;

import java.util.*;
import java.time.LocalDateTime;

public class MusicSchoolManagement {
    private Map<Integer, Student> students = new HashMap<>();
    private TreeSet<Lesson> schedule = new TreeSet<>();
    private List<Concert> concerts = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        MusicSchoolManagement system = new MusicSchoolManagement();
        system.run();
    }

    public void run() {
        int choice;
        do {
            System.out.println("\n=== Система управління музичною школою ===");
            System.out.println("1. Управління учнями");
            System.out.println("2. Управління розкладом занять");
            System.out.println("3. Управління концертами");
            System.out.println("4. Вихід");
            System.out.print("Оберіть опцію: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Споживаємо символ нового рядка

            switch (choice) {
                case 1 -> manageStudents();
                case 2 -> manageLessons();
                case 3 -> manageConcerts();
                case 4 -> System.out.println("Програма завершена.");
                default -> System.out.println("Неправильний вибір. Спробуйте ще раз.");
            }
        } while (choice != 4);
    }

    private void manageStudents() {
        int choice;
        do {
            System.out.println("\n=== Управління учнями ===");
            System.out.println("1. Додати учня");
            System.out.println("2. Переглянути всіх учнів");
            System.out.println("3. Оновити інформацію про учня");
            System.out.println("4. Видалити учня");
            System.out.println("5. Назад");
            System.out.print("Оберіть опцію: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> System.out.println("Повернення до головного меню...");
                default -> System.out.println("Неправильний вибір. Спробуйте ще раз.");
            }
        } while (choice != 5);
    }

    private void addStudent() {
        System.out.print("Введіть ID учня: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Введіть ім'я учня: ");
        String name = scanner.nextLine();
        System.out.print("Введіть вік учня: ");
        int age = scanner.nextInt();

        if (students.containsKey(id)) {
            System.out.println("Учень з таким ID вже існує.");
        } else {
            students.put(id, new Student(id, name, age));
            System.out.println("Учня успішно додано.");
        }
    }

    private void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("Список учнів порожній.");
        } else {
            System.out.println("\nСписок учнів:");
            students.values().forEach(System.out::println);
        }
    }

    private void updateStudent() {
        System.out.print("Введіть ID учня, якого потрібно оновити: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        if (!students.containsKey(id)) {
            System.out.println("Учня з таким ID не знайдено.");
            return;
        }
        System.out.print("Введіть нове ім'я учня: ");
        String name = scanner.nextLine();
        System.out.print("Введіть новий вік учня: ");
        int age = scanner.nextInt();

        students.put(id, new Student(id, name, age));
        System.out.println("Інформацію про учня оновлено.");
    }

    private void deleteStudent() {
        System.out.print("Введіть ID учня, якого потрібно видалити: ");
        int id = scanner.nextInt();
        if (students.remove(id) != null) {
            System.out.println("Учня успішно видалено.");
        } else {
            System.out.println("Учня з таким ID не знайдено.");
        }
    }

    private void manageLessons() {
        System.out.println("\n=== Управління розкладом ===");
        System.out.println("1. Додати заняття");
        System.out.println("2. Переглянути розклад");
        System.out.print("Оберіть опцію: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> {
                System.out.print("Введіть назву заняття: ");
                String title = scanner.nextLine();
                System.out.print("Введіть дату і час (у форматі YYYY-MM-DDTHH:MM): ");
                String dateTimeStr = scanner.nextLine();
                LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr);
                schedule.add(new Lesson(title, dateTime));
                System.out.println("Заняття додано до розкладу.");
            }
            case 2 -> {
                System.out.println("\nРозклад занять:");
                schedule.forEach(System.out::println);
            }
            default -> System.out.println("Неправильний вибір.");
        }
    }

    private void manageConcerts() {
        System.out.println("\n=== Управління концертами ===");
        System.out.println("1. Додати концерт");
        System.out.println("2. Переглянути список концертів");
        System.out.print("Оберіть опцію: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> {
                System.out.print("Введіть назву концерту: ");
                String title = scanner.nextLine();
                concerts.add(new Concert(title));
                System.out.println("Концерт додано.");
            }
            case 2 -> {
                System.out.println("\nСписок концертів:");
                concerts.forEach(System.out::println);
            }
            default -> System.out.println("Неправильний вибір.");
        }
    }
}

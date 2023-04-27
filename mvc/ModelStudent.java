import java.time.LocalDate;

public class ModelStudent {
    private static long count = 0;
    public int MAX_LENGTH_NAME = 10;

    private Long id;
    private String name;
    private LocalDate updatedDate;

    public boolean save() {
        if (name.length() <= MAX_LENGTH_NAME) {
            this.updatedDate = LocalDate.now();
            return true;
        }
        return false;
    }

    public ModelStudent(String name, LocalDate updatedDate) {
        this.id = ++count;
        this.name = name;
        this.updatedDate = updatedDate;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public LocalDate getUpdatedDate() {
        return this.updatedDate;
    }

    public void setUpdatedDate(LocalDate updatedDate) {
        this.updatedDate = updatedDate;
    }
}

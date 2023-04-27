import java.time.LocalDate;

public class ControllerStudent {
    private ModelStudent model;
    private ViewStudent view;

    public void initial() {
        model = new ModelStudent("unknown", LocalDate.of(2023, 2, 12));
        view = ViewStudent.getView();
    }

    public void showDetail() {
        view.showDetailPage(model);
    }

    public void rename(String newName) {
        model.setName(newName);
    }

    // ...

    public void save() {
        boolean isSuccess = model.save();
        if (isSuccess) {
            view.showUpdatedPage(model);
        } else {
            view.showErrorMessage("Unable to create user with name's length greater than " + model.MAX_LENGTH_NAME);
        }
    }
}

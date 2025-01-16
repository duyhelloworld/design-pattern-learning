import java.util.ArrayList;
import java.util.List;

// ViewModel đóng vai trò là Subject
public class ViewModel {
    private List<Observer> observers = new ArrayList<>();
    private String data;

    // Đăng ký Observer (thường là các Activity hoặc Fragment)
    public void attach(Observer observer) {
        observers.add(observer);
    }

    // Gỡ bỏ Observer
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    // Thông báo tất cả các Observer
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(data);
        }
    }

    // Cập nhật dữ liệu và thông báo
    public void setData(String data) {
        this.data = data;
        notifyObservers();
    }

    public String getData() {
        return data;
    }
}

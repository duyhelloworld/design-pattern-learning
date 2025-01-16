// SecondActivity đóng vai trò là một Observer
public class SecondActivity implements Observer {
    @Override
    public void update(String data) {
        System.out.println("SecondActivity cập nhật giao diện với dữ liệu: " + data);
    }
}

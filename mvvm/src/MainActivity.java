// MainActivity đóng vai trò là một Observer (người nghe tin)
public class MainActivity implements Observer {
    @Override
    public void update(String data) {
        System.out.println("MainActivity cập nhật giao diện với dữ liệu: " + data);
    }
}
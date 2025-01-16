// Observer Interface

import java.time.LocalDateTime;

interface Observer {
    void update(String data);
}

// Main Class để mô phỏng hoạt động
public class ObserverPatternAndroidDemo {
    public static void main(String[] args) {
        ViewModel viewModel = new ViewModel();

        Observer mainActivity = new MainActivity();
        Observer secondActivity = new SecondActivity();

        // Đăng ký các Activity làm Observer
        viewModel.attach(mainActivity);
        viewModel.attach(secondActivity);

        // Cập nhật dữ liệu lần 1
        System.out.println("Cập nhật dữ liệu lần 1: " + LocalDateTime.now());
        viewModel.setData("""
                    \t1. iPhone 15 Pro Max - Giá: $1199\n
                    \t2. Samsung Galaxy S23 Ultra - Giá: $1299
                """);

        // Gỡ bỏ một Activity
        viewModel.detach(mainActivity);
        System.out.println("Gỡ bỏ thành công mainActivity");

        // Cập nhật dữ liệu lần 2
        System.out.println("Cập nhật dữ liệu lần 2:" + LocalDateTime.now());
        viewModel.setData("""
                \t- Giảm giá 20% cho đơn hàng trên $500.
                \t- Miễn phí vận chuyển cho tất cả đơn hàng đến hết ngày 31/12.
                """);
    }
}

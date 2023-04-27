import java.util.LinkedList;
import java.util.List;

public class Service implements Accessor {

    private User user;
    private List<Monitor> monitors = new LinkedList<>();

    public Service(String email, String ip) {
        user = new User(email, ip);
    }

    public String getUserName() {
        return this.user.email;
    }

    @Override
    public void add(Monitor monitor) {
        if (monitors.add(monitor)) {
            System.out.println("Add success " + monitor.getClass().getName() + ".service");
        }
    }

    @Override
    public void remove(Monitor monitor) {
        if (monitors.remove(monitor)) {
            System.out.println("Remove success " + monitor.getClass().getName() + ".service");
        }
    }

    @Override
    public void notifyToAllMonitor() {
        for (Monitor monitor : monitors) {
            monitor.update(user);
        }
    }
    
    public void changeConnectionStatus(Login_Status status) {
        System.out.println("\nChanged user status. " + user.status + " -> " + status);
        user.status = status;
        notifyToAllMonitor();
    }

    // Mock method. In real, we will call a list blocked IP / email not signed up from database
    private boolean isInvalidIP() {
        return user.ip.equals("192.168.0.1");
    }

    private boolean isValidEmail() {
        return user.email.equalsIgnoreCase("duyhelloworld@mail.com");
    }

    private boolean isExpiredAccount() {
        return user.email.equalsIgnoreCase("expired@mail.com") || user.status == Login_Status.EXPIRED;
    }

    public void login() {
        if (isInvalidIP()) {
            user.status = Login_Status.INVALID;
        } else if (isExpiredAccount()) {
            user.status = Login_Status.EXPIRED;
        } else if (isValidEmail() && !isInvalidIP()) {
            user.status = Login_Status.SUCCESS;
        } else {
            user.status = Login_Status.FAILURE;
        }
        notifyToAllMonitor();

        if (user.status == Login_Status.SUCCESS && isValidEmail() && !isExpiredAccount() && !isInvalidIP()) {
            System.out.println("Logged as " + user.email);
        }
    }
}

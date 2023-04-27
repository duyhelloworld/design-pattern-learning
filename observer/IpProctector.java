public class IpProctector implements Monitor {
    @Override
    public void update(User user) {
        if (user.status == Login_Status.INVALID) {
            System.out.println("Account invalid, blocked " + user.ip);
        }
    }
}

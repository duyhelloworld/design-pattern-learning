public class IpProctector implements Monitor {
    @Override
    public void update(User user) {
        if (user.status == LoginStatus.INVALID) {
            System.out.println("Account invalid, blocked " + user.ip);
        }
    }
}

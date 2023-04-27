public class Mailer implements Monitor {
    @Override
    public void update(User user) {
        if (user.status == Login_Status.EXPIRED) {
            System.out.println("Sent a mail to expired account : " + user.email);
        }
    }
}
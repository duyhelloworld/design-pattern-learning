public class Logger implements Monitor {

    @Override
    public void update(User user) {
        if (user.status == null || user.status != Login_Status.INVALID) {
            System.out.println("Wrote log for user : " + user.email + "\t" + user.ip);
        }
    }
    
}

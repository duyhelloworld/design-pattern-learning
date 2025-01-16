public class User {
    String email;
    String ip;
    LoginStatus status;
    
    public User(String email, String ip) {
        this.email = email;
        this.ip = ip;
    }
}
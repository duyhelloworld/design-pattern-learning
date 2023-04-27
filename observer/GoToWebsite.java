public class GoToWebsite {
    private static Service newAccount(String email, String ip) {
        Service ser = new Service(email, ip);
        ser.add(new Logger());
        ser.add(new IpProctector());
        ser.add(new Mailer());
        System.out.println("______________________________\nAccount " + ser.getUserName() + " created.");
        return ser;
    }
    public static void main(String[] args) {
        Service acc1 = newAccount("expired@mail.com", "123.25.12.0");
        acc1.login();

        Service acc2 = newAccount("ip-blocked@mail.com", "192.168.0.1");
        acc2.login();
        
        Service acc3 = newAccount("duyhelloworld@mail.com", "120.03.2.103");
        acc3.login();
        
        acc3.changeConnectionStatus(Login_Status.EXPIRED);
        acc3.login();
        
        // But, when we unlock for acc 2, we must remove acc2 IP from blocked list
        // acc2.changeConnectionStatus(Login_Status.SUCCESS);
        // acc2.login();
        // The result is IP blocked, acc2 cannot login
    }
}

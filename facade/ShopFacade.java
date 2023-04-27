import services.AccountService;
import services.EmailService;
import services.PaymentService;
import services.ShippingService;
import services.SmsService;

public class ShopFacade {
    private final static ShopFacade shop = new ShopFacade();

    private AccountService accountService;
    private PaymentService paymentService;
    private ShippingService shippingService;
    private SmsService smsService;
    private EmailService emailService;

    private ShopFacade() {
        accountService = new AccountService();
        paymentService = new PaymentService();
        shippingService = new ShippingService();
        smsService = new SmsService();
        emailService = new EmailService();
    };

    public static ShopFacade getInstance() {
        return shop;
    }

    public void buyByPayPalWithFreeShip(String email) {
        accountService.getMail(email);
        paymentService.payByPayPal();
        emailService.sendMail(email);
        shippingService.freeShip();
    }

    public void buyByCashingWithExpressShip(String email, String numberPhone) {
        accountService.getMail(email);
        accountService.getNumberPhone(numberPhone);
        paymentService.payByCashing();
        emailService.sendMail(email);
        smsService.sendSms(numberPhone);
        shippingService.freeShip();
    }

    /*
     * Other methods : ....
     */
}
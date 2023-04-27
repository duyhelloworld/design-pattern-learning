# Facade - make a simpler "interface"

## What's Facade Pattern?
- In an application, we often have to work on lots of object, which will have a close relationship later. 
If you use them with business logic, import some library... your code will be abstruse, difficult for maintaining and expansion. (This is 'tight coupling' code.)

- Facade Pattern in structural pattern. It provide a unified interface to a set of interfaces in a subsystem. Facade defines a higher-level interface that makes the subsystem easier to use.

- This pattern can be confused with [Adapter Pattern](), but each pattern has its purpose. Facade allow encapsuling source code for easier interact with other source.

## UML
<!-- ![](/facade/facade_uml.png) -->

## How to implement it?
- Facade often implement `Client` layer by `Singleton`.
> Account service
```java
package services;

public class AccountService {
    public void getMail(String email) {
        System.out.println("Get account from " + email);
    }

    public void getNumberPhone(String numberPhone) {
        System.out.println("Get account from " + numberPhone);
    }

}
```
> Email Service
```java
package services;

public class EmailService {
    public void sendMail(String email){
        System.out.println("Send mail to " + email);
    }
}
```
> Payment Service
```java
package services;

public class PaymentService {
    public void payByPayPal() {
        System.out.println("Paid by PayPal");
    }

    public void payByEBankin() {
        System.out.println("Paid by E-Banking");
    }

    public void payByMasterCard() {
        System.out.println("Paid by MasterCard");
    }

    public void payByCashing() {
        System.out.println("Paid by Cashing");
    }
}
```

> Shipping Service
```java
package services;

public class ShippingService {
    public void freeShip() {
        System.out.println("Free Shipping");
    }
    
    public void standardShip() {
        System.out.println("Standard Shipping");
    }
    
    public void expressShip() {
        System.out.println("Express Shipping");
    }
}
```

```java
package services;

public class SmsService {
    public void sendSms(String mobilePhone){
        System.out.println("Send SMS to " + mobilePhone);
    }    
}
```

> `Facade Shop`
```java
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
```

> Shop's application
```java
public class Shop {
    public static void main(String[] args) {
        ShopFacade shopFacade = ShopFacade.getInstance();

        shopFacade.buyByCashingWithExpressShip("mailtruong@huce.edu.vn", "012345678");
        
        System.out.println();
        shopFacade.buyByPayPalWithFreeShip("email@email");
    }
}
```

## Result
<!-- ![](/facade/result_facade.png) -->

## Usage
- When you want to provide simple interface to a complex sub-system.
- When several dependencies exist between clients and the implementation classes of an abstraction.
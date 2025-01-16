# Observer - Do you miss something interesting which happening?

# What's Observer Pattern?
- The Observer Pattern define a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.
- It provide a solution for the case : some object need to be notified frequently about all changes happen in the other object.
- Benefit : increase extensibility, reusability and loose coupling between Observer and Subject (Define in UML)

# Case
- In a Big Tech, Our system need to tracking user data when they access to our website. 
- When a user login, we must write log, checking IP address, block if their access is unknown... If their account expired, we must send a notification to their mail, set status to EXPIRED in database.
# UML 
![](/observer/observer_uml.png)

# Code example
```java
public enum LoginStatus {
    SUCCESS, FAILURE, INVALID, EXPIRED
}
```

```java
public class User {
    String email;
    String ip;
    LoginStatus status;
    
    public User(String email, String ip) {
        this.email = email;
        this.ip = ip;
    }
}
```

```java
public interface Monitor {
    void update(User user);
}
```

```java
public class Logger implements Monitor {
    @Override
    public void update(User user) {
        if (user.status == null || user.status != LoginStatus.INVALID) {
            System.out.println("Wrote log for user : " + user.email + "\t" + user.ip);
        }
    } 
}

public class Mailer implements Monitor {
    @Override
    public void update(User user) {
        if (user.status == LoginStatus.EXPIRED) {
            System.out.println("Sent a mail to expired account : " + user.email);
        }
    }
}

public class IpProctector implements Monitor {
    @Override
    public void update(User user) {
        if (user.status == LoginStatus.INVALID) {
            System.out.println("Account invalid, blocked " + user.ip);
        }
    }
}
```

```java
public interface Accessor {
    void add(Monitor monitor);

    void remove(Monitor monitor);

    void notifyToAllMonitor();
}
```

```java
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
    
    public void changeConnectionStatus(LoginStatus status) {
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
        return user.email.equalsIgnoreCase("expired@mail.com") || user.status == LoginStatus.EXPIRED;
    }

    public void login() {
        if (isInvalidIP()) {
            user.status = LoginStatus.INVALID;
        } else if (isExpiredAccount()) {
            user.status = LoginStatus.EXPIRED;
        } else if (isValidEmail() && !isInvalidIP()) {
            user.status = LoginStatus.SUCCESS;
        } else {
            user.status = LoginStatus.FAILURE;
        }
        notifyToAllMonitor();

        if (user.status == LoginStatus.SUCCESS && isValidEmail() && !isExpiredAccount() && !isInvalidIP()) {
            System.out.println("Logged as " + user.email);
        }
    }
}
```

```java
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
        
        acc3.changeConnectionStatus(LoginStatus.EXPIRED);
        acc3.login();
    }
}
```

## Result
<!--![](/observer/result-observer.png)-->

## Where used it?
- Broadcast-type communication, when need change a object which refer to change the same at other objects
- JDK : mark interface `Observerable`, logic in many standard library.
- MVC Pattern : used to prevent Model from View (through Controller). 
- MVVM Pattern : used in Android mobile app development
## The Legendary Architectural Pattern in developer community

<!--![](/mvc/MVC_fun.jpg)-->
## What's it? History?
- `Definition` : MVC (Model-View-Controller) is a software architecture pattern for creating user interfaces on computers. MVC divides an application into three interoperable parts that separate the way the information is internally processed and the information presented and received by the user.
- The MVC pattern was first introduced in 1979 by computer scientist Trygve Mikkjel Heyerdahl Reenskaug and first used in the programming language Small Talk.

## Structure 
- MVC divide application into 3 building blocks, each block refer a fuction like its name:
> + __M__ : The application data resides in the model. The most important role of a model is connect Database, manipulate and prepare data for Controller use.
> + __V__ : Users see the application data (from Model) through the view, however, the view can’t influence what the user will do with the data. View can't get data directly from Model, this process must be throgh Controller.
> + __C__ : The controller is the building block between the model and the view. View triggers events, subsequently, the controller acts on it. The action is typically a method call to the model. The response is shown in the view. In Controller, we should handle any business logic here.

## Flow 
![](/mvc/Working-of-MVC.png)
> - First, when application start, nothing happen.
> - When user access application, user request View for interacting.
> - Now View send the data it need to Controller
> - Controller ask Model for this data.
> - Model interact Database, get, maniplate data and response for Controller
> - Controller render data to View (stardardize datetime, format name, ...)
> - View use them to display for user

#### A quote : Why we need Controller and make lower performance when we can interact directly View - Model?
1. Follow SOLID 

     Controller follow S (Single Resibility) in SOLID - 5 principle of OOP. So, if you don't create Controller, all logic will handle at Model, and we will make this pattern back to "Client-Server" - a worst architectural pattern for developing an non-commerce application.

2. Reusability and Flexibility

     You can change model or the view without changing the other. You can reuse all code in 2 above part just by change controller. The program is concenrated in Controller

3. Easy testing 

     We can test each part and won't affect much to application. Moreover, we can test app when it's running (I don't recommend this action)

4. Higher quality Product

     The idea of original MVC is to separate out the different "chunks" of logic so that they don't overlap. By follow it, the less these areas of concern overlap, the easier it is to do interesting things with them.

## Pros and Con of MVC
I. Advantage
- __Faster the development processing__ : Divide task into 3 team : Frontend (View), Backend (Controller) and Backend+System Designer (Model). The process working parallel.
- __Increase code reusability, lower complexibility__ : Keep logic apart help increase this code's reusability and simpler.
- __Higher Maintainance__ : Lower Dependency in code logic will make easier for maintaining and scale the application.
- __Maxium usage of a Server__ : This architect save much bandwith and space compare to the others.
- __Easier for detect error__ : We only need to test each part for find and fix bug in this part.
- __Simple structure__ : Support junior, some developer who aren't good at system design and technical can use and follow.
- __Support for SEO (Search Engine Optimization)__ : Easy create SEO code, SEO tag and URL for abtract user traffic.
- __Fit with small, normal application (size)__
- __Used commonly in Framework and Library__ : Optimize the Framework performance when developing.


II. Disadvantage
- __Difficult for durable maintainance__ : Controller logic will larger whenever support a new application's feature
- __Controller and View has 'tight coupling'__ : The more View changed, the more Controller affected
- __Unconform for small project__ : Implement with small application is over-complex. This instruction only mak benefit when the app is bigger (1 of the worst affection of application development, when `life cycle` of an app may be very short)
- __Difficult for navigate code__ : Navigate flow code from UI to data is harder when follow this AP.
- __Need to know multiple technogies__

## Code example

```java
public class ModelStudent {
    private static long count = 0;
    public int MAX_LENGTH_NAME = 10;

    private Long id;
    private String name;
    private LocalDate updatedDate;

    public boolean save() {
        if (name.length() <= MAX_LENGTH_NAME) {
            this.updatedDate = LocalDate.now();
            return true;
        }
        return false;
    }

    public ModelStudent(String name, LocalDate updatedDate) {
        this.id = ++count;
        this.name = name;
        this.updatedDate = updatedDate;
    }
    // Getter, setter
}
```

```java
public class ControllerStudent {
    private ModelStudent model;
    private ViewStudent view;

    public void initial() {
        model = new ModelStudent("unknown", LocalDate.of(2023, 2, 12));
        view = ViewStudent.getView();
    }

    public void showDetail() {
        view.showDetailPage(model);
    }

    public void rename(String newName) {
        model.setName(newName);
    }

    // ...

    public void save() {
        boolean isSuccess = model.save();
        if (isSuccess) {
            view.showUpdatedPage(model);
        } else {
            view.showErrorMessage("Unable to create user with name's length greater than " + model.MAX_LENGTH_NAME);
        }
    }
}
```

`Singleton used for View`

```java
public class ViewStudent {
    private static ViewStudent instance;

    private ViewStudent() {} ;

    public static ViewStudent getView() {
        if (instance == null) {
            instance = new ViewStudent();
        }
        return instance;
    }


    public void showHome() {
        System.out.println("Home page of Application.");
    }

    public void showDetailPage(ModelStudent student) {
        System.out.println("Student: ");
        System.out.println("+ Id: " + student.getId());
        System.out.println("+ Name: " + student.getName());
        System.out.println("+ Updated date: " +
                student.getUpdatedDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("---------------------------");
    }

    public void showUpdatedPage(ModelStudent student) {
        System.out.println("Saved ID(" + student.getId() + ") successfully");
        showDetailPage(student);
    }

    public void showErrorMessage(String messageError) {
        System.out.println("Something wrong!!!\n" + messageError);
    }
}
```

```java
public class MVCExample {
    public static void main(String[] args) {
        ControllerStudent controller = new ControllerStudent();
        controller.initial();
        controller.showDetail();

        controller.rename("duycodengu");
        controller.save();

        controller.rename("MVC Pattern is the best, all other is trash!");
        controller.save();
    }
}
```

`Result`

![](/mvc/mvc_result.png)

## References
- [FreeCodeCamp](https://www.freecodecamp.org/news/mvc-architecture-what-is-a-model-view-controller-framework/#:~:text=The%20MVC%20pattern%20was%20first,the%20programming%20language%20Small%20Talk.)
- [Wiki MVC's History](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller)
- [Linkedin - Blog](https://www.linkedin.com/pulse/architectural-pattern-vs-design-praveen-kumar-kushwaha/)
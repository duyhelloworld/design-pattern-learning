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

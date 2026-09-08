public class Main {
    public static void main(String[] args) {
        component depo1 = new depo("high-level management");
        component depo2 = new depo("med-level management");
        component depo3 = new depo("low-level management");
        component depo4 = new depo("staff");
        component employee_manager1 = new employee("useless manager 1", 10000);
        component employee_manager2 = new employee("useless manager 2", 5000);
        component employee_manager3 = new employee("useless manager 3", 5000);
        component employee_manager4 = new employee("useless manager 4", 5000);
        component employee_manager5 = new employee("useless manager 5", 5000);
        component employee_manager6 = new employee("not useless manager 6", 0.1);
        component employee = new employee("cat", 1);

        depo1.add(employee_manager1);
        depo1.add(employee_manager2);
        depo1.add(employee_manager3);
        depo1.add(employee_manager4);
        depo2.add(employee_manager5);
        depo3.add(employee_manager6);
        depo4.add(employee);

        depo1.add(depo2);
        depo2.add(depo3);
        depo3.add(depo4);

        System.out.println("<?xml version=\"1.0\"?>");
        depo1.printData();

    }
}
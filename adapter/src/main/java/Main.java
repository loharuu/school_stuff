public class Main {
    public static void main(String[] args) {
        calendarToNewDateAdapter cal = new calendarToNewDateAdapter();

        System.out.println(cal.getDay());
        System.out.println(cal.getMonth());
        System.out.println(cal.getYear());

        cal.setDay(1);
        cal.setMonth(0);
        cal.setYear(3333);

        System.out.println(cal.getDay());
        System.out.println(cal.getMonth());
        System.out.println(cal.getYear());

        cal.advanceDays(999);

        System.out.println(cal.getDay());
        System.out.println(cal.getMonth());
        System.out.println(cal.getYear());
    }
}

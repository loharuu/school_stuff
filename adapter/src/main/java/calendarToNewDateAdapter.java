import java.util.Calendar;

public class calendarToNewDateAdapter implements newDateInterface{
    Calendar c;
    public calendarToNewDateAdapter() {
        this.c = Calendar.getInstance();
    }
    @Override
    public void setDay(int day) {
        c.set(Calendar.DAY_OF_MONTH, day);
    }

    @Override
    public void setMonth(int month) {
        c.set(Calendar.MONTH, month);
    }

    @Override
    public void setYear(int year) {
        c.set(Calendar.YEAR, year);
    }

    @Override
    public int getDay() {
        return c.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public int getMonth() {
        return c.get(Calendar.MONTH);
    }

    @Override
    public int getYear() {
        return c.get(Calendar.YEAR);
    }

    @Override
    public void advanceDays(int days) {
        c.set(Calendar.DAY_OF_MONTH, days);
    }
}

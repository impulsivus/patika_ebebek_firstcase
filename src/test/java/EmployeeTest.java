import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class EmployeeTest {

    Employee employee1;
    Employee employee2;
    Employee employee3;

    @Before
    public void before() {
        employee1 = new Employee("Ahmet", 9980, 45, 2010);
        employee2 = new Employee("Mehmet", 900, 27, 2000);
        employee3 = new Employee("Celal", 8900, 40, 2021);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testEmptyName() {
        new Employee("", 8900, 40, 2021);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testInvalidWorkHours() {
        new Employee("Celal", 8900, -40, 2021);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testInvalidSalary() {
        new Employee("Celal", -8900, 40, 2021);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testInvalidHireYear() {
        new Employee("Celal", 8900, 40, 2030);
    }

    @Test
    public void testTaxWhenExists() {
        assertEquals(employee1.tax(),299.4f,0.1f);
    }

    @Test
    public void testTaxWhenDoesNotExist() {
        assertEquals(employee2.tax(),0f,0.1f);
    }

    @Test
    public void testBonusWhenExists() {
        assertEquals(employee1.bonus(),150f, 0.01f);
    }

    @Test
    public void testBonusWhenLower() {
        assertEquals(employee2.bonus(),0f,0.01f);
    }

    @Test
    public void testBonusWhenEqual() {
        assertEquals(employee3.bonus(),0f,0.01f);
    }

    @Test
    public void testRaiseSalaryLessThan10Yrs() {
        assertEquals(employee3.raiseSalary(),9625.35f,0.01f);
    }

    @Test
    public void testRaiseSalaryLessThan20Yrs() {
        assertEquals(employee1.raiseSalary(),11472.34f,0.01f);
    }

    @Test
    public void testRaiseSalaryMoreThan19Yrs() {
        assertEquals(employee2.raiseSalary(),1035.0f,0.01f);
    }
}

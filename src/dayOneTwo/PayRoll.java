/*
In an organization, salary of each employee is calculated on the basis of his basic 
salary. Every employee gets HRA, DA allowances. HRA is 35% of basic salary, DA is 45% 
f basic salary. For every employee there is TAX and PF deduction. TAX is calculate on 
he basis of Gross salary. 

Gross Salary = Basic Salary + HRA + DA. 

TAX is 20% of gross salary if gross salary is greater than 95000, 10 % if gross salary 
s between 70000 to 95000, is 5% if gross salary is between 40000 to 70000. 
PF is 12% of basic salary.
Net Salary is calculated as : Net Salary = Gross Salary - TAX - PF.

There are two types of employees in the organization - Manager and Worker

If worker works in over time hours, worker gets per hour overtime (OT) benifits of 100
 per hour. For worker, gross salary is calculate as

 Gross Salary = Basic Salary + HRA + DA + OT hours * 100

And Net salary calculate as Net Salary = Gross Salary - TAX - PF

For managers, company pays bonus which depends on number of targets completed by
manager. Company pays 2000 per target to Managers For managers, gross salary is
calculated as
Gross Salary = Basic Salary + HRA + DA + Number of Targets Completed * 2000
and Net salary is calculated as Net Salary = Gross Salary - TAX - PF*/

package dayOneTwo;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Employee {
    protected int empId;
    protected String name;
    protected float bs, ns, hra, da, gs, tax, pf;
    protected boolean hasError = true;

    Scanner sin = new Scanner(System.in);

    public Employee() {

        while (hasError) {
            System.out.println("Enter name of employee: ");
            try {
                name = sin.nextLine();
                Pattern pattern = Pattern.compile("^[a-zA-Z\\s]*$");
                Matcher matcher = pattern.matcher(name);
                if (!matcher.matches()) {
                    throw new NameException("Please use a valid name.");
                } else hasError = false;
            } catch (NameException e) {
                System.out.println("Provided name is not valid.");
            }
        }

        hasError = true;

        while (hasError) {
            System.out.print("Id : ");
            try {
                empId = sin.nextInt();
                if (empId < 0) {
                    throw new EmployeeIdException("Id must be positive.");
                } hasError = false;
            } catch (EmployeeIdException e) {
                System.out.println("Id is invalid. Must be a positive number.");
            }
        }

        hasError = true;

        while (hasError) {
            System.out.println("Enter basic salary: ");
            try {
                bs = sin.nextFloat();
                if (bs < 0) {
                    throw new NegativeNumberException("Salary cannot be negative.");
                } hasError = false;
            } catch (NegativeNumberException e) {
                System.out.println("Salary is invalid. Must be a positive number.");
            }
        }
    }

    public void calGrossSalary() {
        hra = 0.35f * bs;
        da = 0.45f * bs;
        gs = bs + hra + da;

    }

    public void calNetSalary() {
        pf = bs * 0.12f;

        tax = 0;
        if(gs >= 95000 ) {
            tax = 0.2f * gs;
        } else if( gs >= 70000 ) {
            tax = 0.1f * gs;
        } else if( gs >= 40000 ) {
            tax = 0.05f * gs;
        }

        ns = gs - tax - pf;
    }

    public void showSalarySlip() {
        System.out.println("Employee ID     : "+empId);
        System.out.println("Name            : "+name);
        System.out.println("Basic salary    : "+bs);
        System.out.println("HRA (35% of bs) : "+hra);
        System.out.println("DA (45% of bs   : "+da);
        System.out.println("Gross = bs + hra + da = "+gs);
        System.out.println("Tax             : "+tax);
        System.out.println("PF              : "+pf);
        System.out.println("Net Salary = GS - tax - pf : "+ns);
    }
}

class Worker extends Employee {
    private int otHours;
    public Worker() {
        Scanner sin = new Scanner(System.in);

        hasError = true;

        while (hasError) {
            System.out.println("Enter number of OT working hours: ");
            try {
                otHours = sin.nextInt();
                if (otHours < 0) {
                    throw new NegativeNumberException("OT hours cannot be negative.");
                } hasError = false;
            } catch (NegativeNumberException e) {
                System.out.println("OT hours is invalid. Must be a positive number.");
            }
        }
    }

    public void calGrossSalary() {
        super.calGrossSalary();
        gs = gs + otHours * 100;
    }

    public void showSalarySlip() {
        super.showSalarySlip();
        System.out.println("Number of OT hours   : "+otHours);
        System.out.println("OT Hours benefits    : "+otHours*100);
    }

}

class Manager extends Employee {
    private int targetsHit;

    public Manager() {
        Scanner sin = new Scanner(System.in);

        hasError = true;

        while (hasError) {
            System.out.println("Enter number of targets hit: ");
            try {
                targetsHit = sin.nextInt();
                if (targetsHit < 0) {
                    throw new NegativeNumberException("Target count cannot be negative.");
                } hasError = false;
            } catch (NegativeNumberException e) {
                System.out.println("Target count is invalid. Must be a positive number.");
            }
        }
    }

    public void calGrossSalary() {
        super.calGrossSalary();
        gs = gs + targetsHit * 2000;
    }

    public void showSalarySlip() {
        super.showSalarySlip();
        System.out.println("Number of targets hit   : "+targetsHit);
        System.out.println("Target bonus    : "+targetsHit * 2000);
    }

}

class PayRoll {
    public static void main(String[] args) {
        Worker w = new Worker();
        w.calGrossSalary();
        w.calNetSalary();
        w.showSalarySlip();

        Manager m = new Manager();
        m.calGrossSalary();
        m.calNetSalary();
        m.showSalarySlip();
    }
}

class NameException extends Exception {
    public NameException(String s) {
        super(s);
    }
}

class EmployeeIdException extends Exception {
    public EmployeeIdException(String s) {
        super(s);
    }
}

class NegativeNumberException extends Exception {
    public NegativeNumberException(String s) {
        super(s);
    }
}

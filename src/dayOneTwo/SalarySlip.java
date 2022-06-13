/*In an organization, salary of each employee is calculated on the basis of
his basic salary. Every employee gets HRA, DA allowances.
HRA is 35% of basic salary, DA is 45% of basic salary. For every employee
there is TAX and PF deduction. TAX is calculate on the basis of Gross salary.

Gross Salary = Basic Salary + HRA + DA.

TAX is 20% of gross salary if gross salary is greater than 95000,
10 % if gross salary is between 70000 to 95000,
is 5% if gross salary is between 40000 to 70000.

PF is 12% of basic salary.

Net Salary is calculated as : Net Salary = Gross Salary - TAX - PF.

Display detailed SalarySlip of an employee.*/

import java.util.Scanner;

public class SalarySlip {
    private int empId;
    private String name;
    private float bs, ns, hra, da, gs, tax, pf;

    public SalarySlip() {
        Scanner sin = new Scanner(System.in);
        System.out.println("Enter name of employee: ");
        name = sin.nextLine();

        System.out.println("Enter employee id: ");
        empId = sin.nextInt();

        System.out.println("Enter basic salary: ");
        bs = sin.nextFloat();
    }

    public void calculateSalary() {
        hra = 0.35f * bs;
        da = 0.45f * bs;
        gs = bs + hra + da;
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

class Payroll {
    public static void main(String[] args) {
        SalarySlip s = new SalarySlip();
        s.calculateSalary();
        s.showSalarySlip();
    }
}
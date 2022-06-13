package dayOneTwo;

import java.util.Scanner;
class Customer {
    private String name;
    private String mobileNo;
    private String address;

    public Customer(String name, String mobileNo, String address) {
        this.name = name;
        this.mobileNo = mobileNo;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

class SaleItem {
    private int id;
    private String name;
    private float qty;
    private float rate;
    private float amount;

    public SaleItem(int id, String name, float qty, float rate) {
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.rate = rate;
        this.amount = this.qty * this.rate;
    }

    public void printSaleItem() {
        System.out.printf("%5d - %-20s - %5.2f - %5.2f - %5.2f\n", id, name, qty, rate, amount);
    }

    public float getAmount() {
        return amount;
    }
}

class Bill {
    private static int nextBillNo = 1000;

    private Customer customer;
    private SaleItem[] sells;
    private float totalBill;
    private int billNo;

    public Bill() throws QtyException {
        Scanner sin = new Scanner(System.in);

        billNo = nextBillNo;
        nextBillNo++;

        boolean qtyError = true;
        boolean priceError = true;

        System.out.println("Enter customer details: ");
        System.out.print("Name : ");
        String name = sin.nextLine();

        System.out.print("Mobile No. : ");
        String mobileNo = sin.nextLine();

        System.out.print("Address : ");
        String address = sin.nextLine();

        customer = new Customer(name, mobileNo, address);

        System.out.println("How many sale items: ");
        int n = sin.nextInt();

        sells = new SaleItem[n];

        float qty = 0;
        float rate = 0;

        System.out.println("Enter sell details: ");
        for(int i=0;i<n;i++) {
            System.out.print("Product name: ");
            String productName = sin.nextLine();

            System.out.print("Enter product id: ");
            int id = sin.nextInt();

            while (qtyError) {
                System.out.print("Sale Qty : ");
                try {
                    qty = sin.nextFloat();
                    if (qty <= 0) {
                        throw new QtyException("qty must be positive & greater than 0.");
                    }
                    else qtyError = false;
                } catch (QtyException qtyException) {
                    System.out.println("Please enter a positive qty that's greater than 0");
                }
            }

            while (priceError) {
                System.out.print("Unit Price : ");
                try {
                    rate = sin.nextFloat();
                    if (rate <= 0) {
                        throw new RateException("rate must be positive & greater than 0.");
                    } else priceError = false;
                } catch (RateException rateException) {
                    System.out.println("Please enter a positive price that's greater than 0");
                }
            }

            sells[i] = new SaleItem(id, productName, qty, rate);
        }
    }

    public void calculateBill() {
        totalBill = 0;

        for(SaleItem s: sells) {
            totalBill = totalBill + s.getAmount();
        }
    }

    public void showDetailedBill() {
        System.out.println("Bill number   : "+billNo);
        System.out.println("Customer Name : "+customer.getName());
        System.out.println("Mobile number : "+customer.getMobileNo());
        System.out.println("Address       : "+customer.getAddress());

        System.out.println("Id\tName\tQty\tRate\tAmount\n");

        for (SaleItem sell : sells) {
            sell.printSaleItem();
        }

        System.out.println("\nTotal bill Amount : "+totalBill);
    }
}

class QtyException extends Exception {
    public QtyException(String s) {
        super(s);
    }
}

class RateException extends Exception {
    public RateException(String s) {
        super(s);
    }
}

class POS {
    public static void main(String[] args) throws QtyException {
        Bill bill1 = new Bill();
        bill1.calculateBill();
        bill1.showDetailedBill();

        Bill bill2 = new Bill();
        bill2.calculateBill();
        bill2.showDetailedBill();
    }
}



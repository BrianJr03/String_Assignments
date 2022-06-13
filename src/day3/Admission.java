package day3;

 abstract public class Admission {
    protected float hscScore, entranceExamScore;

    Admission(float hscScore, float entranceExamScore) {
        this.hscScore = hscScore;
        this.entranceExamScore = entranceExamScore;
    }

    abstract public boolean isAdmitted();
}

class BeAdmission extends Admission {
    int physicsMarks,  chemistryMarks,  mathMarks;
    public BeAdmission(int physicsMarks, int chemistryMarks, int mathMarks, float hscScore, float eeScore) {
        super(hscScore, eeScore);
        this.physicsMarks = physicsMarks;
        this.chemistryMarks = chemistryMarks;
        this.mathMarks = mathMarks;
    }

    public boolean isAdmitted() {
        if (physicsMarks >= 80 && chemistryMarks >= 80 && mathMarks >= 90) {
            return hscScore >= 85 && entranceExamScore >= 150;
        }
        return false;
    }
}

class BcaAdmission extends Admission {
    int mathMarks;
    public BcaAdmission(int mathMarks, float hscScore, float eeScore) {
        super(hscScore, eeScore);
        this.mathMarks = mathMarks;
    }

    public boolean isAdmitted() {
        if (mathMarks  >= 70) {
            return hscScore >= 60 && entranceExamScore >= 70;
        }
        return false;
    }
}

class Admin {
    public static void main(String[] args) {
        BeAdmission be = new BeAdmission(89, 80, 91, 86, 161);

        if (be.isAdmitted()) {
            System.out.println("Admitted into BE");
        }

        BcaAdmission bca = new BcaAdmission(89, 90, 90);

        if (bca.isAdmitted()) {
            System.out.println("Admitted into BCA");
        }
    }
}

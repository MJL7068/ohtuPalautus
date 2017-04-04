package ohtu;

public class Submission {
    private String student_number;
    private int week;
    private int hours;

    private boolean a1;
    private boolean a2;
    private boolean a3;
    private boolean a4;
    private boolean a5;
    private boolean a6;
    private boolean a7;
    private boolean a8;
    private boolean a9;
    private boolean a10;

    private boolean a11;
    private boolean a12;
    private boolean a13;
    private boolean a14;
    private boolean a15;
    private boolean a16;
    private boolean a17;
    private boolean a18;
    private boolean a19;
    private boolean a20;

    private boolean a21;

    private int count;
    private String tehtavat;

    public int getCount() {
        return count;
    }

    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getHours() {
        return hours;
    }

    public boolean geta1() {
        return a1;
    }

    public boolean geta2() {
        return a2;
    }

    public boolean geta3() {
        return a3;
    }

    public boolean geta4() {
        return a4;
    }

    public boolean geta5() {
        return a5;
    }

    public boolean geta6() {
        return a6;
    }

    public boolean geta7() {
        return a7;
    }

    public boolean geta8() {
        return a8;
    }

    public boolean geta9() {
        return a9;
    }

    public boolean geta10() {
        return a10;
    }

    public boolean geta11() {
        return a11;
    }

    public boolean geta12() {
        return a12;
    }

    public boolean geta13() {
        return a13;
    }

    public boolean geta14() {
        return a14;
    }

    public boolean geta15() {
        return a15;
    }

    public boolean geta16() {
        return a16;
    }

    public boolean geta17() {
        return a17;
    }

    public boolean geta18() {
        return a18;
    }

    public boolean geta19() {
        return a19;
    }

    public boolean geta20() {
        return a20;
    }

    public boolean geta21() {
        return a21;
    }

    public String tehtavat() {
        StringBuilder s = new StringBuilder();

        if (geta1()) {
            s.append("1 ");
            count++;
        }

        if (geta2()) {
            s.append("2 ");
            count++;
        }

        if (geta3()) {
            s.append("3 ");
            count++;
        }

        if (geta4()) {
            s.append("4 ");
            count++;
        }

        if (geta5()) {
            s.append("5 ");
            count++;
        }

        if (geta6()) {
            s.append("6 ");
            count++;
        }

        if (geta7()) {
            s.append("7 ");
            count++;
        }

        if (geta8()) {
            s.append("8 ");
            count++;
        }

        if (geta9()) {
            s.append("9 ");
            count++;
        }

        if (geta10()) {
            s.append("10 ");
            count++;
        }


        if (geta11()) {
            s.append("11 ");
            count++;
        }

        if (geta12()) {
            s.append("12 ");
            count++;
        }

        if (geta13()) {
            s.append("13 ");
            count++;
        }

        if (geta14()) {
            s.append("14 ");
            count++;
        }

        if (geta15()) {
            s.append("15 ");
            count++;
        }

        if (geta16()) {
            s.append("16 ");
            count++;
        }

        if (geta17()) {
            s.append("17 ");
            count++;
        }

        if (geta18()) {
            s.append("18 ");
            count++;
        }

        if (geta19()) {
            s.append("19 ");
            count++;
        }

        if (geta20()) {
            s.append("20 ");
            count++;
        }

        if (geta21()) {
            s.append("21 ");
            count++;
        }

        return s.toString();
    }

    @Override
    public String toString() {
        this.tehtavat = tehtavat();

        return "viikko " + week + ": tehtyjä tehtäviä yhteensä: " + this.count + ", aikaa kului " + hours + " tuntia, tehdyt tehtävät: " + this.tehtavat;
    }
    
}
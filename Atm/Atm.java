package OOpr.park.Atm;

import java.util.Date;

/**
 * Created by Pranay on 9/9/2017.
 */
public class Atm {

        // transaction - withdraw show balance transfer
    //  card id pin -> name acc bank
}
 abstract class card{
    // number pin name id bank cvv
     // bank to cusid account
     //
}

class bank{
    String add; long bankCode; String name;
    // customer accounts

}
class transaction{

}
class customer{
    private int id;
    private String name;
    private Date dob;

    public customer(int id, String name, Date dob) {
        this.id = id;
        this.name = name;
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDob() {
        return dob;
    }
}
abstract class account{
    // account have many transactions arraylist<>
}

class saving extends account{

}
class  current extends account{

}
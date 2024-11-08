package DataPackage;

import java.util.ArrayList;

public class DataSnooper {
    Data d = new Data();

    public void snoop() {
        System.out.println("Beginning DataPackage.Data");
        System.out.println(d.toString());

        // Problem 1
        System.out.println("Direct access");
        System.out.println("iValue = " + d.getiValue());
        System.out.println("sValue = " + d.getsValue());
        System.out.println("iList = ");
        int[] dListCopy = d.getiList(); // Use copy 
        for (int i=0; i < dListCopy.length; i++) {
            System.out.println(dListCopy[i]);
        }

        // Problem 2
        System.out.println("Change the simple data");
        d.setiValue(-1);
        d.setsValue("Dog");
        d.setiList(0, 0); // Safe setting array
        d.setiList(0, 1); // Safe setting array
        d.setiList(0, 2); // Safe setting array
        System.out.println(d.toString());

        // Problem 3
        System.out.println("Change the array");
        int[] mylist = {-1, -2, -3, -4, -5};
        d.setiList(mylist); //Safe set
        System.out.println(d.toString());

        // Problem 4
        System.out.println("Change the ArrayList");
        ArrayList<Integer> yourlist = new ArrayList<>();
        yourlist.add(1000);
        d.setaList(yourlist);
        System.out.println(d.toString());

        // Problem 5
        Data newD = new Data(d);
        newD.setsValue("Cat");
        DataPackage.ContainedClass cc = new DataPackage.ContainedClass();
        cc.setCcString("Elephant");
        newD.setCc( cc );
        System.out.println(newD.toString());
        System.out.println(d.toString());

        DataPackage.ContainedClass x = new DataPackage.ContainedClass();
        x.setCcString("Gopher");
        d.setCc(x);
        System.out.println(d);
        System.out.println(newD);

        // Test to violate Data rules
        System.out.println("Before trying to violate rules");
        System.out.println(d);
        d.setiValue(-10);
        d.setsValue("1234567891011");
        int[] newList1 = {1,2,3,4,5,6};
        d.setiList(newList1);

        int[] newList2 = {1,2,100};
        d.setiList(newList2);
        System.out.println("After trying to violate rules");
        System.out.println(d);

    }
}

package DataPackage;

import java.util.ArrayList;
import java.util.Arrays;

public class Data {
    private int iValue = 10;
    private String sValue = "a string";
    private int[] iList = {12, 15, 20};
    private ArrayList<Integer> aList = new ArrayList<>();
    private DataPackage.ContainedClass cc = new DataPackage.ContainedClass();

    public int getiValue() {
        return iValue;
    }

    public String getsValue() {
        return sValue;
    }

    public int[] getiList() {
        return iList.clone();
    }

    public ArrayList<Integer> getaList() {
        ArrayList<Integer> newArr = new ArrayList<Integer>();
        for (Integer e: aList) {
            newArr.add(e);
        }
        return newArr;
    }

    public DataPackage.ContainedClass getCc() {
        return new DataPackage.ContainedClass(cc); //copy constructor
    }

    Data() {
        for (int i=0; i<iList.length; i++) {
            aList.add(iList[i]);
        }
        cc.ccString = "a contained string";
    }

    Data(Data d) {
        this.iValue = d.getiValue();
        this.sValue = d.getsValue();
        this.iList = d.getiList();
        this.aList = d.getaList();
        this.cc  = d.cc;
    }

    @Override
    public String toString() {
        return "DataPackage.Data{" +
                "iValue=" + iValue +
                ", sValue='" + sValue + '\'' +
                ", iList=" + Arrays.toString(iList) +
                ", aList=" + aList +
                ", cc = " + cc.ccString +
                '}';
    }

    public void setiValue(int iValue) {
        if (iValue > 0) {
            this.iValue = iValue;
        } else {
            System.out.println("Cant set value to negative");
        }
    }

    public void setsValue(String sValue) {
        if (sValue.length() <= 10) {
            this.sValue = new String(sValue) ;
        }
        
    }

    // Setting direct element
    public void setiList(int element, int pos) {
        if (pos > 0 && pos < iList.length && element >= 10 && element <= 20){
            this.iList[pos] = element;
        }
        
    }

    // Setting to a whole no array
    public void setiList(int[] iList) {
        if (iList.length <= 4) {
            int[] newList = new int[iList.length];
            for (int i=0; i < iList.length; i++){
                if (iList[i] >= 10 && iList[i] <= 20) {
                    newList[i] = iList[i];
                } else {
                    return;
                }
            }
            
            this.iList = newList; //since array is of int i can use shallow copy
        }   
    }

    public void setaList(ArrayList<Integer> aList) {
        ArrayList<Integer> newArr = new ArrayList<Integer>();
        for (Integer e: aList) {
            newArr.add(e);
        }
        this.aList = newArr;
    }


    public void setCc(DataPackage.ContainedClass cc) {
        this.cc = new DataPackage.ContainedClass(cc);
    }
}

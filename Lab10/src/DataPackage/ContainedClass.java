package DataPackage;

public class ContainedClass {
    String ccString = "";

    public void setCcString(String ccString) {
        this.ccString = new String( ccString );
    }

    public String getCcString() {
        return new String( ccString );
    }

    public ContainedClass() {
    }
    
    public ContainedClass(ContainedClass copy) {
        ccString = copy.getCcString(); //save a copy
    }

    // public ContainedClass(ContainedClass copy) {
    //     return new ContainedClass(copy.getCcString())
    // }
}

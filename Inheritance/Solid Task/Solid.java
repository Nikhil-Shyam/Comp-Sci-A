public class Solid{
    private String myName;

    public Solid(String name){
        myName = name;
    }

    public String getName(){
        return myName;
    }

    // This should be overridden in subclasses
    public double volume(){
        return 0;
    }

    // This should be overridden in subclasses
    public double surfaceArea(){
        return 0;
    }
}

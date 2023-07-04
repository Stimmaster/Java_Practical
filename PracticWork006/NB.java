import java.util.*;

public class NB{
    private String name;  
    private Integer ram;  
    private Integer ssd;  
    private String os;    
    private String color; 

    public void setName(String name) {this.name = name;}
    public String getName() {return name;}
    public void setRam(Integer ram) {this.ram = ram;}
    public Integer getRam() {return ram;}
    public void setSsd(Integer ssd) {this.ssd = ssd;}
    public Integer getSsd() {return ssd;}
    public void setOs(String os) {this.os = os;}
    public String getOs() {return os;}
    public void setColor(String color) {this.color = color;}
    public String getColor() {return color;}

    
    public NB (String name, Integer ram, Integer ssd, String os, String color){
        this.name = name;
        this.ram = ram;
        this.ssd = ssd;
        this.os = os;
        this.color = color;
    }

    @Override
    public String toString() {
        return name + "; " +
                "ОЗУ:" + ram +  "; " +
                "Диск: " + ssd + "; " +
                "ОС: " + os + "; " +
                "цвет:" + color + "; ";
    }      
}
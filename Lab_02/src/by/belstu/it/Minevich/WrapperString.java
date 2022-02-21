package by.belstu.it.Minevich;
import java.util.Objects;
public class WrapperString {
    private String str;

    @Override
    public String toString() {
        return  str;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WrapperString that = (WrapperString) o;
        return Objects.equals(str, that.str);
    }

    @Override
    public int hashCode() {
        return super.hashCode();        //super обращается к родительскому классу
    }

    public void setStr(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    public void replace (char oldchar, char newchar){
        str=str.replace(oldchar,newchar);
    }

    public void delete(char delChar)
    {
        str = str.replace(delChar, ' ');
    }

    public WrapperString(String str) {
        this.str = str;
    }
}

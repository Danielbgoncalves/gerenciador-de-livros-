import java.util.ArrayList;

public interface FunctionHelper {
    static boolean isNumeric(String str){
        return str.matches("\\d+");
    }

    static boolean isHour(String str){
        return str.matches("^\\d+:\\d+$");
    }

}

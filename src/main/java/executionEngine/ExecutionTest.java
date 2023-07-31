package executionEngine;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import excelUtility.ReadExcelSheet;

public class ExecutionTest {

    /** Main method calls the ReadExcelSheet.executeTests() method. */
    public static void main(String[] args) throws IOException, Exception, IllegalArgumentException, InvocationTargetException {
        ReadExcelSheet res = new ReadExcelSheet();
        res.executeTests();
    }

}

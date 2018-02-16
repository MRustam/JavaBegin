package testalltypesexeption.test;

import java.nio.file.FileAlreadyExistsException;
import testAllTypesExeptions.myClassExeption.TrainingExeption;
import testAllTypesExeptions.myClassExeption.TrainigMethod;

public class TestAllTypesExeption {

    public static void main(String[] args) {

// Errors.
//        try {
//            throw new OutOfMemoryError();
//        } catch (VirtualMachineError e) {
//            e.printStackTrace();
//        }
//        try {
//            throw new StackOverflowError();
//        } catch (StackOverflowError e) {
//            e.printStackTrace();
//        }
//        try {
//            throw new ThreadDeath();
//        } catch (Throwable e) {
//            e.printStackTrace();
//        }
//
//// Exeptions.
//        try {
//            throw new NullPointerException();
//        } catch (NullPointerException e) {
//            e.printStackTrace();
//        } catch (RuntimeException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        // Nio.
//        try {
//            throw new FileAlreadyExistsException("/Users/rustam/Desktop/clearning.jpg");
//        } catch (Exception e) {
//            e.printStackTrace();
//        } catch (Throwable e) {
//            e.printStackTrace();
//        }
//        try {
//            throw new ClassNotFoundException();
//        } catch (ReflectiveOperationException e) {
//            e.printStackTrace();
//        }
// My Class Exeption. Arithmetic.
        
        int a = 10;
        int b = 0;
        
        TrainigMethod tm = new TrainigMethod();
        
        
        try {
            tm.div(a, b);
        } catch (ArithmeticException e) {
            throw new TrainingExeption();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
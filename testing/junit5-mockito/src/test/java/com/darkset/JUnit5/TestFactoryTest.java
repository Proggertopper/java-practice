package com.darkset.JUnit5;

import com.darkset.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
//@EnabledOnOs(OS.LINUX)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class TestFactoryTest {

     @Mock
     private Calculator calculator;

     @TestFactory
     public Stream<DynamicTest> dynamicTestForPalindromes(){
          return Stream.of("racecar", "radar"  , "mom" , "dad")
                  .map(text -> DynamicTest.dynamicTest("Тест для слова: "+ text , ()-> assertTrue(isPalindrome(text)) ));
     }

     public boolean isPalindrome(String text){
          if(text == null){
               return false;
          }

          char[] array = text.toCharArray();
          int counter = 0;
          boolean isPalindrome = false;
          for (int i = 0; i < array.length/2; i++) {
               if (array[i] == array[array.length-1-i]){
                    counter++;
               }
          }
          if(counter == array.length/2){
               isPalindrome = true;
          }
          return isPalindrome;
     }
}

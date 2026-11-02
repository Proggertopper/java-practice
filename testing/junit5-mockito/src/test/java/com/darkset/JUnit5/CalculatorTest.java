package com.darkset.JUnit5;

import com.darkset.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.stream.Stream;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;
import static org.junit.jupiter.api.condition.JRE.JAVA_11;
import static org.junit.jupiter.api.condition.JRE.JAVA_9;
import static org.junit.jupiter.api.condition.OS.MAC;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
//@EnabledOnOs(OS.LINUX)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CalculatorTest {

    private Calculator calc;
    private int countOfOperations;

    @BeforeEach
    public void init(){
        calc = new Calculator();
        System.out.println("BeforeEach method");
    }

    @BeforeAll
    public static void init2(){
        System.out.println("BeforeAll init2 method");
    }

    @AfterAll
    public static void endMethod(){
        System.out.println("AfterAll endMethod ");
    }

    @AfterEach
    public void loggingOperations(){
        System.out.println("AfterEach method");
    }

    @Test
    @DisplayName("Это мой тест ВАСЯ ТЫ")
    @EnabledOnOs({MAC , OS.LINUX})
    public void add(){
        int result = calc.add(5 , 5);
        assertEquals(10  , result);
    }

    @Test
    @DisabledOnOs(value = MAC, architectures = "aarch64")
    void notOnNewMacs() {
        // ...
    }

    @Test
    @DisabledOnOs(architectures = "x86_64")
    void notOnX86_64() {
        // ...
    }

    @RepeatedTest(3)
    void testWithInfo(RepetitionInfo repetitionInfo) {
        int current = repetitionInfo.getCurrentRepetition(); // Какая попытка сейчас?
        int total = repetitionInfo.getTotalRepetitions();     // Сколько всего?

        System.out.println("Запуск № " + current + " из " + total);

    }

    @ParameterizedTest
    @ValueSource(strings =  {"racecar" , "dad" , "mom", "radar" , "abba"})
    void palindromes(String candidate){
      assertTrue(isPalindrome(candidate));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = { " ", "   ", "\t", "\n" })
    void nullEmptyAndBlankStrings(String text) {
        assertTrue(text == null || text.trim().isEmpty());
    }

    @ParameterizedTest
    @EnumSource
    void testWithEnumSourceWithAutoDetection(ChronoUnit unit) {
        assertNotNull(unit);
    }

    @ParameterizedTest
    @MethodSource("stringProvider")
    void testWithExplicitLocalMethodSource(String argument) {
        assertNotNull(argument);
    }

//    @Test
//    void writeItemsToFile(@TempDir Path tempDir) throws IOException {
//        // JUnit создал уникальную папку и передал её в tempDir
//        Path file = tempDir.resolve("test.txt");
//        new ListWriter(file).write("a", "b", "c");
//
//        assertEquals(singletonList("a,b,c"), Files.readAllLines(file));
//        // После выхода из метода папка и файл test.txt удалятся сами
//    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/two-column.csv", numLinesToSkip = 1)
    void testWithCsvFileSourceFromFile(String country, int reference) {
        assertNotNull(country);
        assertNotEquals(0, reference);
    }

    static Stream<String> stringProvider() {
        return Stream.of("apple", "banana");
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



    @Test
    @Tag("java momentum")
    @DisplayName("TEST 3")
    void test1(TestInfo info){
        assertEquals("TEST 3" , info.getDisplayName());
        assertTrue(info.getTags().contains("java momentum"));
    }

    @Test
    void reportKeyValuePair(TestReporter testReporter) {
        // Передаем в отчет ключ и значение
        testReporter.publishEntry("user name", "dk38");
    }

    @Test
    @EnabledOnJre({JAVA_9 , JRE.JAVA_15 })
    void onJava9Or10() {
        // ...
    }

    @Test
    @EnabledForJreRange(min = JAVA_9, max = JAVA_11)
    void fromJava9to11() {
        // ...
    }

    @Test
    @EnabledIfSystemProperty(named = "os.arhc" , matches = ".*64.*")
    void onlyOn64BitArchitectures() {
        // ...
    }

    @Test
    @DisabledIfSystemProperty(named = "ci-server", matches = "true")
    @Order(1)
    void notOnCiServer() {
        // ...
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "ENV", matches = "staging-server")
    @Order(2)
    void onlyOnStagingServer() {
        // ...
    }

    @Test
    @DisabledIfEnvironmentVariable(named = "ENV", matches = ".*development.*")
    void notOnDeveloperWorkstation() {
        // ...
    }

    @Test
    @DisabledIf("customCondition")
    void disabled(){
        //
    }

    boolean customCondition(){
        return true;
    }


    @FastTest
    public void sub(){
        int result = calc.sub(5 , 2);
        assertEquals(3 , result);
    }

    @Test
    @Disabled("for demonstration purpose")
    @TestOnMac
    public void mul_num1_num2(){
        int result = calc.mul(-5 , -3);
        assertEquals(15 , result);
    }

    @Test
    public void div_num1_num2(){
        int result = calc.div(2 , 3);
        assertEquals(0 , result );
    }

    @Test
    void abortedTest(){
        assumeTrue("abc".contains("z"));
        fail("test should have been aborted");
    }

    @Test
    void standardAssertions(){
        assertEquals(2 , calc.add(1  , 1));
        assertTrue('a' < 'b' );
    }

    @Test
    void groupedAssertions(){
        assertAll();
    }

    @Test
    void exceptionTesting(){
        Exception exception = assertThrows(ArithmeticException.class , () -> calc.div(1 , 0));
        assertEquals("/ by zero", exception.getMessage());
    }

    @Test
    void timeoutNotExceeded(){
        assertTimeout(Duration.ofMinutes(2) , () -> {
            Thread.sleep(1500);
        });
        assumingThat("ci".equals("ci"), ()-> assertEquals(2 , calc.add(1 , 1)));
        assumeFalse('a' < 'b');
    }

    @Test
    void timeoutExceeded() {
        // The following assertion fails with an error message similar to:
        // execution exceeded timeout of 10 ms by 91 ms
        assertTimeout(ofMillis(10), () -> {
            // Simulate task that takes more than 10 ms.
            Thread.sleep(100);
        });
    }

    @Test
    void timeoutExceededWithPreemptiveTermination(){
        assertTimeoutPreemptively(Duration.ofMillis(10) , () ->
                Thread.sleep(100));
    }
}

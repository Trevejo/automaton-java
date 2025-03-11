// import com.example.automatodoc.CPFAutomaton;
// import org.junit.jupiter.api.Test;
// import static org.junit.jupiter.api.Assertions.*;

// public class CPFAutomatonTest {

// private final CPFAutomaton cpfAutomaton = new CPFAutomaton();

// @Test
// void testValidCPFWithDotsAndDash() {
// assertTrue(cpfAutomaton.validateCPF("123.123.123-12"));
// }

// @Test
// void testValidCPFWithoutDotsAndDash() {
// assertTrue(cpfAutomaton.validateCPF("12312312312"));
// }

// @Test
// void testInvalidCPFWithIncorrectFormat1() {
// assertFalse(cpfAutomaton.validateCPF("123.12312312"));
// }

// @Test
// void testInvalidCPFWithIncorrectFormat2() {
// assertFalse(cpfAutomaton.validateCPF("1231.231.23-12"));
// }

// @Test
// void testInvalidCPFWithIncorrectFormat3() {
// assertFalse(cpfAutomaton.validateCPF("123.123.123-123"));
// }

// @Test
// void testInvalidCPFWithTooManyDigits() {
// assertFalse(cpfAutomaton.validateCPF("1213131212121212121"));
// }

// @Test
// void testInvalidCPFWithTooFewDigitsAndDash() {
// assertFalse(cpfAutomaton.validateCPF("123123123-12"));
// }

// @Test
// void testEmptyCPF() {
// assertFalse(cpfAutomaton.validateCPF(""));
// }

// @Test
// void testCPFWithLetters() {
// assertFalse(cpfAutomaton.validateCPF("abc.abc.abc-ab"));
// }

// @Test
// void testCPFWithSpecialCharacters() {
// assertFalse(cpfAutomaton.validateCPF("123!123@123#12"));
// }
// }
package com.example.automatodoc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AutomatodocApplicationTests {

  @Autowired
  private CPFAutomaton cpfAutomaton;

  @Test
  void contextLoads() {
  }

  @Test
  void testValidCPFWithDotsAndDash() {
    assertThat(cpfAutomaton.validateCPF("123.123.123-12")).isTrue();
  }

  @Test
  void testValidCPFWithoutDotsAndDash() {
    assertThat(cpfAutomaton.validateCPF("12312312312")).isTrue();
  }

  @Test
  void testInvalidCPFWithIncorrectFormat1() {
    assertThat(cpfAutomaton.validateCPF("123.12312312")).isFalse();
  }

  @Test
  void testInvalidCPFWithIncorrectFormat2() {
    assertThat(cpfAutomaton.validateCPF("1231.231.23-12")).isFalse();
  }

  @Test
  void testInvalidCPFWithIncorrectFormat3() {
    assertThat(cpfAutomaton.validateCPF("123.123.123-123")).isFalse();
  }

  @Test
  void testInvalidCPFWithTooManyDigits() {
    assertThat(cpfAutomaton.validateCPF("1213131212121212121")).isFalse();
  }

  @Test
  void testInvalidCPFWithTooFewDigitsAndDash() {
    assertThat(cpfAutomaton.validateCPF("123123123-12")).isFalse();
  }

  @Test
  void testEmptyCPF() {
    assertThat(cpfAutomaton.validateCPF("")).isFalse();
  }

  @Test
  void testCPFWithLetters() {
    assertThat(cpfAutomaton.validateCPF("abc.abc.abc-ab")).isFalse();
  }

  @Test
  void testCPFWithSpecialCharacters() {
    assertThat(cpfAutomaton.validateCPF("123!123@123#12")).isFalse();
  }

  @Test
  void testInvalidCPFWithDotAtTheEnd() {
    assertThat(cpfAutomaton.validateCPF("123.")).isFalse();
  }

  @Test
  void testInvalidCPFWithDashAtTheEnd() {
    assertThat(cpfAutomaton.validateCPF("123-")).isFalse();
  }

  @Test
  void testInvalidCPFWithOnlyDotsAndDashes() {
    assertThat(cpfAutomaton.validateCPF("...-")).isFalse();
  }
}

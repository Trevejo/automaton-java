package com.example.automatodoc;

import java.util.HashMap;
import java.util.Map;

public class CPFAutomaton {

  // Enum para representar os estados do autômato
  private enum State {
    INITIAL,
    DIGIT1,
    DIGIT2,
    DIGIT3,
    DOT1,
    DIGIT4,
    DIGIT5,
    DIGIT6,
    DOT2,
    DIGIT7,
    DIGIT8,
    DIGIT9,
    DASH,
    DIGIT10,
    DIGIT11,
    ACCEPT,
    REJECT
  }

  private State currentState;
  private final Map<State, Map<Character, State>> transitionTable;

  public CPFAutomaton() {
    // Inicializa o estado inicial
    currentState = State.INITIAL;

    // Inicializa a tabela de transições
    transitionTable = new HashMap<>();

    // Define as transições para cada estado
    transitionTable.computeIfAbsent(State.INITIAL, k -> new HashMap<>()).put(
        'd', State.DIGIT1);
    transitionTable.computeIfAbsent(State.DIGIT1, k -> new HashMap<>()).put(
        'd', State.DIGIT2);
    transitionTable.computeIfAbsent(State.DIGIT2, k -> new HashMap<>()).put(
        'd', State.DIGIT3);
    transitionTable.computeIfAbsent(State.DIGIT3, k -> new HashMap<>()).put(
        '.', State.DOT1); // Espera um ponto
    transitionTable.computeIfAbsent(State.DIGIT3, k -> new HashMap<>()).put(
        'd', State.REJECT); // Não espera um dígito aqui
    transitionTable.computeIfAbsent(State.DOT1, k -> new HashMap<>()).put(
        'd', State.DIGIT4);
    transitionTable.computeIfAbsent(State.DIGIT4, k -> new HashMap<>()).put(
        'd', State.DIGIT5);
    transitionTable.computeIfAbsent(State.DIGIT5, k -> new HashMap<>()).put(
        'd', State.DIGIT6);
    transitionTable.computeIfAbsent(State.DIGIT6, k -> new HashMap<>()).put(
        '.', State.DOT2); // Espera um ponto
    transitionTable.computeIfAbsent(State.DIGIT6, k -> new HashMap<>()).put(
        'd', State.REJECT); // Não espera um dígito aqui
    transitionTable.computeIfAbsent(State.DOT2, k -> new HashMap<>()).put(
        'd', State.DIGIT7);
    transitionTable.computeIfAbsent(State.DIGIT7, k -> new HashMap<>()).put(
        'd', State.DIGIT8);
    transitionTable.computeIfAbsent(State.DIGIT8, k -> new HashMap<>()).put(
        'd', State.DIGIT9);
    transitionTable.computeIfAbsent(State.DIGIT9, k -> new HashMap<>()).put(
        '-', State.DASH); // Espera um traço
    transitionTable.computeIfAbsent(State.DIGIT9, k -> new HashMap<>()).put(
        'd', State.REJECT); // Não espera um dígito aqui
    transitionTable.computeIfAbsent(State.DASH, k -> new HashMap<>()).put(
        'd', State.DIGIT10);
    transitionTable.computeIfAbsent(State.DIGIT10, k -> new HashMap<>()).put(
        'd', State.DIGIT11);
    transitionTable.computeIfAbsent(State.DIGIT11, k -> new HashMap<>()).put(
        'd', State.ACCEPT);

    // Adiciona transições para o formato sem pontos e traço
    transitionTable.computeIfAbsent(State.DIGIT3, k -> new HashMap<>()).put(
        'd', State.DIGIT4);
    transitionTable.computeIfAbsent(State.DIGIT6, k -> new HashMap<>()).put(
        'd', State.DIGIT7);
    transitionTable.computeIfAbsent(State.DIGIT9, k -> new HashMap<>()).put(
        'd', State.DIGIT10);
    transitionTable.computeIfAbsent(State.DIGIT10, k -> new HashMap<>()).put(
        'd', State.ACCEPT); // Sem traço
  }

  public boolean validateCPF(String cpf) {
    currentState = State.INITIAL; // Resetar o estado para cada validação

    if (cpf.length() != 11 && cpf.length() != 14) {
      return false; // Se não tiver 11 dígitos (sem formatação) ou 14 (com
                    // formatação completa), rejeita
    }

    for (char c : cpf.toCharArray()) {
      State nextState;
      if (Character.isDigit(c)) {
        nextState = transitionTable.get(currentState) == null
            ? null
            : transitionTable.get(currentState).get('d');
      } else {
        nextState = transitionTable.get(currentState) == null
            ? null
            : transitionTable.get(currentState).get(c);
      }

      if (nextState == null) {
        currentState = State.REJECT;
        return false;
      }
      currentState = nextState;
    }

    return currentState == State.ACCEPT;
  }
}

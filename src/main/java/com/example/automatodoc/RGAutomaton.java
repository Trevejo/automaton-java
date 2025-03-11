package com.example.automatodoc;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class RGAutomaton {

  private enum State {
    INITIAL,
    DIGIT1,
    DIGIT2,
    DIGIT3,
    DIGIT4,
    DIGIT5,
    DIGIT6,
    DIGIT7,
    DIGIT8,
    DIGIT9,
    DOT1,
    DOT2,
    DASH1,
    ACCEPT,
    REJECT
  }

  private State currentState;
  private final Map<State, Map<Character, State>> transitionTable;

  public RGAutomaton() {
    currentState = State.INITIAL;
    transitionTable = new HashMap<>();

    // Define transitions
    transitionTable.put(State.INITIAL, new HashMap<>());
    transitionTable.put(State.DIGIT1, new HashMap<>());
    transitionTable.put(State.DIGIT2, new HashMap<>());
    transitionTable.put(State.DIGIT3, new HashMap<>());
    transitionTable.put(State.DIGIT4, new HashMap<>());
    transitionTable.put(State.DIGIT5, new HashMap<>());
    transitionTable.put(State.DIGIT6, new HashMap<>());
    transitionTable.put(State.DIGIT7, new HashMap<>());
    transitionTable.put(State.DIGIT8, new HashMap<>());
    transitionTable.put(State.DIGIT9, new HashMap<>());
    transitionTable.put(State.DOT1, new HashMap<>());
    transitionTable.put(State.DOT2, new HashMap<>());
    transitionTable.put(State.DASH1, new HashMap<>());

    // XX.XXX.XXX-X format transitions
    transitionTable.get(State.INITIAL).put('d', State.DIGIT1);

    transitionTable.get(State.DIGIT1).put('d', State.DIGIT2);
    transitionTable.get(State.DIGIT2).put('.', State.DOT1);

    transitionTable.get(State.DOT1).put('d', State.DIGIT3);
    transitionTable.get(State.DIGIT3).put('d', State.DIGIT4);
    transitionTable.get(State.DIGIT4).put('d', State.DIGIT5);
    transitionTable.get(State.DIGIT5).put('.', State.DOT2);

    transitionTable.get(State.DOT2).put('d', State.DIGIT6);
    transitionTable.get(State.DIGIT6).put('d', State.DIGIT7);
    transitionTable.get(State.DIGIT7).put('d', State.DIGIT8);
    transitionTable.get(State.DIGIT8).put('-', State.DASH1);

    transitionTable.get(State.DASH1).put('d', State.ACCEPT);
    transitionTable.get(State.DASH1).put('X', State.ACCEPT);

    // XXXXXXXXX format transitions
    transitionTable.get(State.DIGIT1).put('d', State.DIGIT2);
    transitionTable.get(State.DIGIT2).put('d', State.DIGIT3);
    transitionTable.get(State.DIGIT3).put('d', State.DIGIT4);
    transitionTable.get(State.DIGIT4).put('d', State.DIGIT5);
    transitionTable.get(State.DIGIT5).put('d', State.DIGIT6);
    transitionTable.get(State.DIGIT6).put('d', State.DIGIT7);
    transitionTable.get(State.DIGIT7).put('d', State.DIGIT8);
    transitionTable.get(State.DIGIT8).put('d', State.ACCEPT);

    transitionTable.get(State.DIGIT7).put('-', State.DASH1);
  }

  public boolean validateRG(String rg) {
    currentState = State.INITIAL;

    if (rg.length() != 9 && rg.length() != 12) {
      return false;
    }

    for (int i = 0; i < rg.length(); i++) {
      char c = rg.charAt(i);
      State nextState = null;

      if (Character.isDigit(c)) {
        nextState = transitionTable.get(currentState).get('d');
      } else {
        nextState = transitionTable.get(currentState).get(c);
      }

      if (nextState == null) {
        return false;
      }

      currentState = nextState;
    }

    return currentState == State.ACCEPT;
  }
}
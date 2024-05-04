import java.util.Set;
import java.util.HashSet;

public static void main(String[] args) {
    /*
     * 
     * INITIALIZATION
     * 
     */
    Set<String> Q = new HashSet<>();
    Set<Character> Σ = new HashSet<>();
    TransitionFunction<String, Character, String> σ = new TransitionFunction<>();
    String s = ""; 
    Set<String> F = new HashSet<>();

    /*
     * 
     * INSTANTIATION
     * 
     */
    Q.add("s0");
    Q.add("s1");
    Q.add("s2");
    Q.add("F");
    
    Σ.add('a');
    Σ.add('b');
    Σ.add('c');
    
    Transition<String, Character, String> σ1 = new Transition<>("s0", 'a', "s1");
    Transition<String, Character, String> σ2 = new Transition<>("s0", 'b', "s2");
    Transition<String, Character, String> σ3 = new Transition<>("s1", 'c', "F");
    Transition<String, Character, String> σ4 = new Transition<>("s2", 'c', "F");
    σ.add_transition(σ1);
    σ.add_transition(σ2);
    σ.add_transition(σ3);
    σ.add_transition(σ4);

    s = "s0";

    F.add("F");

    /*
     * 
     * OUTPUT
     * 
     */
    DFA A = new DFA(Q, Σ, σ, s, F);
    
    System.out.println(A.toString());
}
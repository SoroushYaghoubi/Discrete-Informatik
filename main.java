import java.util.Set;
import java.util.HashSet;

public static void main(String[] str) {
    // initialization of the sets
    Set<String> Q = new HashSet<>();
    Set<Character> Σ = new HashSet<>();
    Set<Tuple<Tuple<String, Character>, String>> σ = new HashSet<>();
    String s = ""; 
    Set<String> F = new HashSet<>();

    // examples
    Q.add("s0");
    Q.add("s1");
    Q.add("s2");
    Q.add("F");
    
    Σ.add('a');
    Σ.add('b');
    Σ.add('c');
    
    σ.add(new Tuple<Tuple<String,Character>,String>(new Tuple<String, Character>("s0", 'a'), "s1"));
    σ.add(new Tuple<Tuple<String,Character>,String>(new Tuple<String, Character>("s0", 'b'), "s2"));
    σ.add(new Tuple<Tuple<String,Character>,String>(new Tuple<String, Character>("s2", 'c'), "F"));
    σ.add(new Tuple<Tuple<String,Character>,String>(new Tuple<String, Character>("s2", 'c'), "F"));
    
    s = "s0";

    F.add("F");
    

    System.out.println("Σ"); // Output: Σ

    // output
    DFA A = new DFA(Q, Σ, σ, s, F);
    
    System.out.println(A.toString());
}
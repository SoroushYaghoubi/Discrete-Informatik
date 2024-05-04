import java.util.Set;
import java.util.HashSet;
import java.util.logging.Logger;;

public class DFA {
    /*
     * 
     * INITIALIZATION
     * 
     */
    private static final Logger logger = Logger.getLogger(DFA.class.getName());

    private Set<String> Q; // Menge aller Zustände
    private Set<Character> Σ; // das Alphabet
    private TransitionFunction<String, Character, String> σ;
    private String s; // Startzustand
    private Set<String> F; // Menge akzeptierender Zustände

    public DFA() {
        this.Q = new HashSet<String>();
        this.Σ = new HashSet<Character>();
        this.σ = new TransitionFunction<>();
        this.s = "";
        this.F = new HashSet<String>();
    }

    public DFA(Set<String> Q, Set<Character> Σ, TransitionFunction<String, Character, String> σ, String s,
            Set<String> F) {
        this.set_Q(Q);
        this.set_Σ(Σ);
        this.set_σ(σ);
        this.set_s(s);
        this.set_F(F);
    }

    /*
     * 
     * GETTERS
     * &
     * SETTERS
     * 
     */
    public Set<String> get_Q() {
        return Q;
    }

    public Set<Character> get_Σ() {
        return Σ;
    }

    public TransitionFunction<String, Character, String> get_σ() {
        return σ;
    }

    public String get_s() {
        return s;
    }

    public Set<String> get_F() {
        return F;
    }

    public void set_Q(Set<String> Q) {
        this.Q = Q;
    }

    public void set_Σ(Set<Character> Σ) {
        this.Σ = Σ;
    }

    public void set_σ(TransitionFunction<String, Character, String> σ) {
        for (Transition<String, Character, String> transition : σ) {
            String inputeState = transition.getInputState();
            char inputLetter = transition.getInputLetter();
            String outputState = transition.getOutputState();

            if (!this.Q.contains(inputeState)) {
                logger.warning(inputeState + " does not exist in Q. σ remains unchanged.");
                return;
            }
            if (!this.Σ.contains(inputLetter)) {
                logger.warning(inputLetter + " does not exist in Σ. σ remains unchanged.");
                return;
            }
            if (!this.Q.contains(outputState)) {
                logger.warning(outputState + " does not exist in Q. σ remains unchanged.");
                return;
            }
        }

        this.σ = σ;
    }

    public void set_s(String s) {
        if (!this.Q.contains(s)) {
            logger.warning(s + " does not exist in Q.");
        } else {
            this.s = s;
        }
    }

    public void set_F(Set<String> F) {
        if (!Q.containsAll(F)) {
            logger.warning(F + " must be a subset of Q.");
        } else {
            this.F = F;
        }
    }

    public void add_state(String state) {
        if (!this.Q.add(state)) {
            logger.warning(state + " already exists in Q.");
        }
    }

    public void remove_state(String state) {
        if (!this.Q.remove(state)) {
            logger.warning(state + " never existed in Q.");
        }
    }

    public void add_letter(char c) {
        if (!this.Σ.add(c)) {
            logger.warning(c + " already exists in Σ.");
        }
    }

    public void remove_letter(char c) {
        if (!this.Σ.remove(c)) {
            logger.warning(c + " never existed in Σ.");
        }
    }

    public void add_transition(Transition<String, Character, String> t) {
        this.σ.add_transition(t);
    }

    public void remove_transition(Transition<String, Character, String> t) {
        this.σ.remove_transition(t);
    }

    public void change_startState(String state) {
        this.s = state;
    }

    public void add_acceptedState(String state) {
        if (!this.F.add(state)) {
            logger.warning(state + " already exists in F.");
        }
    }

    public void remove_acceptedState(String state) {
        if (!this.F.remove(state)) {
            logger.warning(state + " never existed in F.");
        }
    }

    /*
     * 
     * OVERRIDES
     * 
     */
    @Override
    public String toString() {
        String Q = "Q: " + this.Q.toString() + "\n";
        String Σ = "Σ: " + this.Σ.toString() + "\n";
        String σ = "σ: " + this.σ.toString() + "\n";
        String s = "s: " + this.s + "\n";
        String F = "F: " + this.F.toString() + "\n";
        return "DFA: \n" + Q + Σ + σ + s + F + "\n";
    }

    /*
     * 
     * MAIN FUNCTIONALITY
     * 
     */
    public void run_DFA_on_String(String stream) {
        for (char c : stream.toCharArray()) {

        }
    }
}
import java.util.Set;
import java.util.HashSet;

public class CFG {
    /*
     * 
     * Initialization
     * 
     */
    private Set<String> V;

    /*
     * 
     * Sigma should ultimately be of type Set<RegEx>
     * 
     */
    private Set<DFA> Σ;
    private String S;
    private Set<String> P;
}

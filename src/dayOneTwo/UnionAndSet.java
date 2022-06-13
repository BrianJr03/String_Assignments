import java.util.Arrays;
import java.util.HashSet;

public class UnionAndSet {
    HashSet<String> set = new HashSet <>();

    public UnionAndSet() {
        set.add("mat");
        set.add("sat");
        set.add("cat");
    }

    public UnionAndSet getUnion(UnionAndSet uAs) {
        UnionAndSet unionAndSet = new UnionAndSet();
        unionAndSet.set.addAll(uAs.set);
        return unionAndSet;
    }

    public UnionAndSet getIntersection(UnionAndSet uAs) {
        UnionAndSet unionAndSet = new UnionAndSet();
        unionAndSet.set.retainAll(uAs.set);
        return unionAndSet;
    }
}

class UAS {
    public static void main(String[] args) {
        UnionAndSet a = new UnionAndSet();
        UnionAndSet b = new UnionAndSet();

        UnionAndSet c = a.getUnion(b);

        b.set.remove("sat");
        b.set.add("hat");
        b.set.add("fat");

        System.out.println("\na: " + a.set);
        System.out.println("b: " + b.set + "\n");

        b = a.getUnion(b);
        System.out.println("Union: " + c.set);

        b = a.getIntersection(b);

        c = a.getIntersection(b);
        System.out.println("Intersection: " + c.set);
    }
}

class SimpleSolution {
    public static void main(String[] args) {
        HashSet<String> set1 = new HashSet<>(Arrays.asList("mat", "sat", "cat"));
        HashSet<String> set2 = new HashSet<>(Arrays.asList("mat", "cat", "fat", "hat"));
        getUnion(set1, set2);
        getIntersection(set1, set2);
    }

    static public void getUnion(HashSet<String> set1, HashSet<String> set2) {
        set1.addAll(set2);
        System.out.println("Union = " + set1);
    }

    static public void getIntersection(HashSet<String> set1, HashSet<String> set2) {
        set1.retainAll(set2);
        System.out.println("Intersection = " + set1);
    }
}

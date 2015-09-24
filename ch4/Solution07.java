import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Hakim on 9/20/15.
 */

class Graph{
    GraphNode[] nodes;
}

class GraphNode{
    String name;
    List<GraphNode> children = new ArrayList<>();
    int incomingEdges;

    public void incrementIncomingEdges(){
        incomingEdges++;
    }

    public void decrementIncomingEdges(){
        incomingEdges--;
    }


    public GraphNode(String s){
        name = s;
    }

}

/**
 * Find a build order if one exists.
 */
public class Solution07 {
    public static void main(String[] args){
        Solution07 solution07 = new Solution07();
        // example 1: no cycles
        String[] projects = {"a","b","c","d","e","f"};
        List<String[]> dependencies = new ArrayList<>();
        String[] dep1 = {"a","d"};  // d depends on a
        String[] dep2 = {"f","b"};
        String[] dep3 = {"b","d"};
        String[] dep4 = {"f","a"};
        String[] dep5 = {"d","c"};

        dependencies.add(dep1);
        dependencies.add(dep2);
        dependencies.add(dep3);
        dependencies.add(dep4);
        dependencies.add(dep5);
        System.out.println("Order for graph 1 with no cycles:");
        solution07.printStringArray(solution07.buildOrder(projects, dependencies));

        // example2: cycle
        String[] projects2 = {"a","b","c","d","e","f"};
        List<String[]> dependencies2 = new ArrayList<>();
        String[] dep21 = {"a","d"};  // d depends on a
        String[] dep22 = {"f","b"};
        String[] dep23 = {"b","d"};
        String[] dep24 = {"f","a"};
        String[] dep25 = {"d","c"};
        String[] dep26 = {"c","a"};

        dependencies2.add(dep21);
        dependencies2.add(dep22);
        dependencies2.add(dep23);
        dependencies2.add(dep24);
        dependencies2.add(dep25);
        dependencies2.add(dep26);
        System.out.println("Order for graph 2 with cycle:");
        solution07.printStringArray(solution07.buildOrder(projects2, dependencies2));
    }

    /**
     * Find a build order that will allow the projects given in projects[] to be built
     * so that each project is built after the projects it depends on.
     * @param projects - list of the projects
     * @param dependencies - dependencies: [a,b] -> b depends on a
     * @return a valid build order if one exists, null otherwise
     */
    public String[] buildOrder(String[] projects, List<String[]> dependencies){
        String[] order = new String[projects.length];

        Map<String, GraphNode> map = new HashMap<>();
        // Build the graph
        GraphNode[] nodes = new GraphNode[projects.length];

        // Create all the nodes
        for (int i=0; i<projects.length; i++){
            GraphNode node = new GraphNode(projects[i]);
            nodes[i] = node;
            map.put(projects[i],node);
        }

        // Add the dependencies info
        for (String[] dep : dependencies){
            map.get(dep[1]).incrementIncomingEdges();
            map.get(dep[0]).children.add(map.get(dep[1]));
        }

        int compiled = 0;   // count the number of projects that were build already
        // Add all the nodes that have no incoming edges to the order list
        for (int i=0; i<projects.length; i++){
            if (nodes[i].incomingEdges == 0){
                order[compiled] = nodes[i].name;
                compiled++;
            }
        }

        // process the children of the current built project
        // add them to the ordered list if they can be built
        // ie all their dependencies have already been built
        int current = 0;
        while (compiled < projects.length){
            if (order[current] == null){
                return null;    // no valid build order
            }

            for (GraphNode child : map.get(order[current]).children){
                child.decrementIncomingEdges();
                if (child.incomingEdges == 0){
                    order[compiled] = child.name;
                    compiled++;
                }
            }
            current++;
        }

        return order;
    }

    /**
     * Helper function to print an array.
     * @param array
     */
    public void printStringArray(String[] array){
        if (array == null || array.length == 0){
            System.out.println();
            return;
        }
        for (int i=0; i<array.length-1; i++){
            System.out.print(array[i] + "; ");
        }
        System.out.println(array[array.length-1]);
    }
}
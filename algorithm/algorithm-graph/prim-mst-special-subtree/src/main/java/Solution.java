
import java.util.BitSet;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            final int numOfNode = scanner.nextInt();
            final int numOfEdge = scanner.nextInt();

            final int[][] edges = IntStream.range(0, numOfEdge)
                    .mapToObj(i -> new int[]{scanner.nextInt(), scanner.nextInt(), scanner.nextInt()})
                    .toArray(int[][]::new);

            final int initIndex = scanner.nextInt();

            System.out.println(Resolver.resolve(numOfNode, initIndex, edges));
        }

    }

    public static class Resolver {
        public static int resolve(int numOfNode, int initIndex, int[][] edges) {

            // convert to 0-based indexing.
            final int initIndexToUse = initIndex - 1;
            final int[][] edgesToUse = IntStream.range(0, edges.length)
                    .mapToObj(i -> new int[]{i, edges[i][0] - 1, edges[i][1] - 1, edges[i][2]})
                    .toArray(int[][]::new);

            // initialize nodes;
            final BitSet visitedNodes = new BitSet(numOfNode);
            visitedNodes.set(initIndexToUse);

            final BitSet unselectedEdges = new BitSet(edgesToUse.length);
            unselectedEdges.set(0, edgesToUse.length);

            try {
                while (visitedNodes.cardinality() < numOfNode) {

                    // select an edge crossing selected and unselected nodes.
                    // e[0] = edge index
                    // e[1] = edge.start
                    // e[2] = edge.end
                    // e[3] = edge.cost

                    final int selectedEdgeIndex = unselectedEdges
                            .stream()
                            .mapToObj(i -> edgesToUse[i])
                            .filter(e -> visitedNodes.get(e[1]) != visitedNodes.get(e[2]))
                            .min((e1, e2) -> e1[3] - e2[3])
                            .get()[0];

                    // move the selected edge to selectedEdges group
                    unselectedEdges.clear(selectedEdgeIndex);

                    // add the newly connected nodes.
                    visitedNodes.set(edgesToUse[selectedEdgeIndex][1]);
                    visitedNodes.set(edgesToUse[selectedEdgeIndex][2]);
                }
            } catch (NoSuchElementException e) {
                // when there are unreachable nodes
            }

            final BitSet selectedEdges = unselectedEdges;
            selectedEdges.flip(0, edgesToUse.length);

            return selectedEdges.stream().map(edgeIndex -> edgesToUse[edgeIndex][3]).sum();
        }
    }

}

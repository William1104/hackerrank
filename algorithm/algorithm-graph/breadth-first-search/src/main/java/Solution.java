import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by william on 11/27/2015.
 */
public class Solution {
    public static void main(String[] args) {
        try (final Scanner scanner = new Scanner(System.in)) {
            final int numOfTests = scanner.nextInt();
            IntStream.range(0, numOfTests).forEach(testNum -> {
                final int numOfNodes = scanner.nextInt();
                final int numOfEdges = scanner.nextInt();

                // converted to 0-based index
                final int[][] edges = IntStream.range(0, numOfEdges)
                        .mapToObj(edgeNum -> new int[]{scanner.nextInt() - 1, scanner.nextInt() - 1})
                        .toArray(int[][]::new);

                // converted to 0-based index
                final int initIndex = scanner.nextInt() - 1;

                IntStream.of(Resolver.resolve(numOfNodes, initIndex, edges))
                        .forEach(cost -> System.out.print(cost + " "));
                System.out.println();
            });
        }
    }

    public static final class Node {
        int index;
        int cost;
        Node prev;

        public Node(int index, int cost, Node prev) {
            super();
            // 0-based index
            this.index = index;

            // cost to reach this node
            this.cost = cost;

            // previous node
            this.prev = prev;
        }
    }

    public static final class Resolver {
        public static int[] resolve(
                final int numOfNodes,
                final int initIndex,
                final int[][] edges) {

            final PriorityQueue<Node> undiscoveredNode = new PriorityQueue<>((a, b) -> a.cost - b.cost);

            final Node[] nodes = IntStream.range(0, numOfNodes).mapToObj(i -> new Node(i, -1, null)).toArray(Node[]::new);

            final Node initNode = nodes[initIndex];
            initNode.cost = 0;

            undiscoveredNode.add(initNode);

            while (!undiscoveredNode.isEmpty()) {
                final Node node = undiscoveredNode.poll();

                Stream.of(edges)
                        .filter(e -> e[0] == node.index || e[1] == node.index)
                        .mapToInt(e -> (e[0] == node.index) ? e[1] : e[0])
                        .forEach(v -> {
                            final Node nodeV = nodes[v];
                            if ((nodeV.cost == -1) ||
                                    nodeV.cost > node.cost + 6) {
                                nodeV.cost = node.cost + 6;
                                nodeV.prev = node;
                                undiscoveredNode.add(nodeV);
                            }
                        });
            }

            return Stream.of(nodes).filter(node -> node.index != initIndex).mapToInt(node -> node.cost).toArray();
        }
    }

}

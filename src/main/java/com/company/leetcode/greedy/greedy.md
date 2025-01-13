A Greedy Algorithm is an approach for solving optimization problems by making a sequence of choices,
each of which is locally optimal (i.e., the best choice at the moment) with the hope that this leads to a globally optimal solution.

Key Concepts Behind Greedy Algorithms:
    1. Greedy Choice Property: 
            The algorithm always makes the choice that looks best at the current step,
             assuming that this choice will lead to the best solution for the overall problem.
    2. Optimal Substructure: A problem exhibits optimal substructure if an optimal solution to the problem contains optimal solutions to its sub problems. 
             Greedy algorithms rely on this to ensure that making locally optimal choices also results in the globally optimal solution.
            The problem can be broken down into smaller sub problems whose solutions lead to the optimal solution of the larger problem.
    3. Non-reversible Choices: Once a choice is made in a greedy algorithm, it is not reconsidered later, which is why it’s efficient.

Approaches:
     Sorting-based approach: Problems like activity selection involve sorting data first and then making a greedy choice based on the sorted order.
     Iterative approach: In problems like coin change, you iteratively subtract the largest possible denomination.
     Graph-based approach: Algorithms like Prim's or Kruskal's make greedy choices to find the minimum spanning tree.
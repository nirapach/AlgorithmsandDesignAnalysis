/**
 * Created by nirapach on 11/12/15.
 */
import java.io.*;
import java.util.*;
import java.util.LinkedList;

class DFS
{
    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency List

    //Constructor
    DFS(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    //Function to add an edge into the graph
    void addEdge(int v,int w)  {
        adj[v].add(w);
    }


    Boolean isReachable(int s, int d)
    {
        LinkedList<Integer>temp;

        // Mark all the vertices as not visited(By default set
        // as false)
        boolean visited[] = new boolean[V];

        // Create a Stack for DFS
        LinkedList<Integer> stack = new LinkedList<Integer>();

        // Mark the current node as visited and push it
        stack.add(s);
        visited[s]=true;


        // 'i' will be used to get all adjacent vertices of a vertex
        Iterator<Integer> i;
        while (stack.size()!=0)
        {
            // pop a vertex from stack and print it
            s = stack.poll();

            int n;
            i = adj[s].listIterator();

            // Get all adjacent vertices of the pop vertex s
            // If a adjacent has not been visited, then mark it
            // visited and push it
            while (i.hasNext())
            {
                n = i.next();
                if (!visited[n])
                {
                    stack.add(n);
                    visited[n] = true;

                }
                // If this adjacent node is the destination node,
                // then return true
                if (n==d)
                    return true;

            }

        }

        // If DFS is complete without visited d
        return false;
    }

    // Driver method
    public static void main(String args[])
    {
        // Create a graph given in the above diagram
        DFS g = new DFS(10);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(1, 3);
        g.addEdge(7, 6);
        g.addEdge(6, 8);
        g.addEdge(8, 9);
        g.addEdge(9, 6);
        g.addEdge(5, 4);
        g.addEdge(4, 3);

        int u = 1;
        int v = 3;
        if (g.isReachable(u, v))
            System.out.println("There is a path from " + u +" to " + v);
        else
            System.out.println("There is no path from " + u +" to " + v);;

        u = 3;
        v = 1;
        if (g.isReachable(u, v))
            System.out.println("There is a path from " + u +" to " + v);
        else
            System.out.println("There is no path from " + u +" to " + v);;
    }
}
//     ⠄⠄⠄⢰⣧⣼⣯⠄⣸⣠⣶⣶⣦⣾⠄⠄⠄⠄⡀⠄⢀⣿⣿⠄⠄⠄⢸⡇⠄⠄
    // ⠄⠄⠄⣾⣿⠿⠿⠶⠿⢿⣿⣿⣿⣿⣦⣤⣄⢀⡅⢠⣾⣛⡉⠄⠄⠄⠸⢀⣿⠄
    // ⠄⠄⢀⡋⣡⣴⣶⣶⡀⠄⠄⠙⢿⣿⣿⣿⣿⣿⣴⣿⣿⣿⢃⣤⣄⣀⣥⣿⣿⠄
    // ⠄⠄⢸⣇⠻⣿⣿⣿⣧⣀⢀⣠⡌⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠿⠿⣿⣿⣿⠄
    // ⠄⢀⢸⣿⣷⣤⣤⣤⣬⣙⣛⢿⣿⣿⣿⣿⣿⣿⡿⣿⣿⡍⠄⠄⢀⣤⣄⠉⠋⣰
    // ⠄⣼⣖⣿⣿⣿⣿⣿⣿⣿⣿⣿⢿⣿⣿⣿⣿⣿⢇⣿⣿⡷⠶⠶⢿⣿⣿⠇⢀⣤
    // ⠘⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣽⣿⣿⣿⡇⣿⣿⣿⣿⣿⣿⣷⣶⣥⣴⣿⡗
    // ⢀⠈⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠄
    // ⢸⣿⣦⣌⣛⣻⣿⣿⣧⠙⠛⠛⡭⠅⠒⠦⠭⣭⡻⣿⣿⣿⣿⣿⣿⣿⣿⡿⠃⠄
    // ⠘⣿⣿⣿⣿⣿⣿⣿⣿⡆⠄⠄⠄⠄⠄⠄⠄⠄⠹⠈⢋⣽⣿⣿⣿⣿⣵⣾⠃⠄
    // ⠄⠘⣿⣿⣿⣿⣿⣿⣿⣿⠄⣴⣿⣶⣄⠄⣴⣶⠄⢀⣾⣿⣿⣿⣿⣿⣿⠃⠄⠄
    // ⠄⠄⠈⠻⣿⣿⣿⣿⣿⣿⡄⢻⣿⣿⣿⠄⣿⣿⡀⣾⣿⣿⣿⣿⣛⠛⠁⠄⠄⠄
    // ⠄⠄⠄⠄⠈⠛⢿⣿⣿⣿⠁⠞⢿⣿⣿⡄⢿⣿⡇⣸⣿⣿⠿⠛⠁⠄⠄⠄⠄⠄
    // ⠄⠄⠄⠄⠄⠄⠄⠉⠻⣿⣿⣾⣦⡙⠻⣷⣾⣿⠃⠿⠋⠁⠄⠄⠄⠄⠄⢀⣠⣴
    // ⣿⣿⣿⣶⣶⣮⣥⣒⠲⢮⣝⡿⣿⣿⡆⣿⡿⠃⠄⠄⠄⠄⠄⠄⠄⣠⣴⣿⣿⣿ 

import java.util.*;

class Node
{
    int x;
    int y;
    int distance;

    Node(int x, int y, int distance)
    {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}


public class LeeAlgorithm
{


    private static boolean isValid(int arr[][], boolean visited[][], int row, int col)
    {
        return ((row >= 0) && (row < arr.length) && (col >= 0) && (col < arr[0].length) && (arr[row][col] == 1) && (!visited[row][col]));
    }

    private void BFS(int ar[][], int i, int j, int x, int y)
    {
        int row[] = {-1, 0, 0, 1};
        int col[] = {0, -1, 1, 0};

        boolean visited[][] = new boolean[ar.length][ar[0].length];
        Queue<Node> q = new LinkedList<Node>();
        visited[i][j] = true;

        q.add(new Node(i, j, 0));
        int minDistance = Integer.MAX_VALUE;
        
        while(!q.isEmpty())
        {
            Node node = q.poll();
            i = node.x;
            j = node.y;
            int dist = node.distance;
            if(i == x && j == y)
            {
                minDistance = dist;
            }

            for(int a = 0; a < 4; a++)
            {
                if(isValid(ar, visited, i + row[a], j + col[a]))
                {
                    visited[i + row[a]][j + col[a]] = true;
                    q.add(new Node(i + row[a], j + col[a], dist + 1));
                }
            }
        }

        if(minDistance == Integer.MAX_VALUE)
        {
            System.out.println("unreachable");
        }
        else
        {
            System.out.println("Length of shortest path: " + minDistance);
        }
    }

    public static void main(String [] args)
    {
        
        int[][] matrix = {
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
        };

        // bfs(matrix, 0, 0, 0, 0);
    }
}   
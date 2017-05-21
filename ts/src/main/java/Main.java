import java.awt.*;
import java.awt.geom.Point2D;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Number of points: ");
//        int n = Integer.parseInt(br.readLine());
        int n = scanner.nextInt();
        List<Point2D> pts = new ArrayList<Point2D>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            pts.add(new Point(random.nextInt(10),random.nextInt(20)));
        }
//        System.out.println("Enter points as X,Y:");
//        List<Point2D> pts = new ArrayList<Point2D>();

//        for (int i = 0; i < n ; i++)
//        {
//            System.out.println("Point " + (i+1) +": ");
//            String input[] = br.readLine().split(",");
//            pts.add(new Point(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
//        }
        long currentTime = System.currentTimeMillis();
        String resultRoute = bestRouteBruteForce(pts);
        System.out.println("time spent: " + (System.currentTimeMillis()-currentTime)+ " milliseconds");
        System.out.println(resultRoute);

    }

    public static String bestRouteBruteForce(List<Point2D> pts)
    {
        double lowestCost = Double.MAX_VALUE;
        List<Point2D> bestRoute = new ArrayList<Point2D>();
        for (List<Point2D> path : getPaths(pts))
        {
            double cost = 0d;
            for (int i = 0; i < path.size()-1; i++)
                cost += path.get(i).distance(path.get(i+1));

            if (cost < lowestCost)
            {
                lowestCost = cost;
                bestRoute = path;
            }
        }
        return getRouteString(bestRoute);
    }

    public static String getRouteString(List<Point2D> r)
    {
        String path = "";
        if (r.size() > 0)
        {
            for (int i = 0; i < r.size(); i++)
                path += (int) r.get(i).getX() + "," + (int) r.get(i).getY() + " -> ";
            return (path + (int) r.get(0).getX() + "," + (int) r.get(0).getY());
        }
        return "";
    }

    public static List<List<Point2D>> getPaths(List<Point2D> pts)
    {
        if (pts.size() == 0)
        {
            List<List<Point2D>> paths = new ArrayList<List<Point2D>>();
            paths.add(new ArrayList<Point2D>());
            return paths;
        }

        Point2D startingPoint = pts.remove(0);
        List<List<Point2D>> allPaths = new ArrayList<List<Point2D>>();
        List<List<Point2D>> pathsWithoutStartingPt = getPaths(pts);
        for (List<Point2D> path : pathsWithoutStartingPt)
        {
            for (int i = 0; i <= path.size(); i++)
            {
                List<Point2D> temp = new ArrayList<Point2D>(path);
                temp.add(i, startingPoint);
                allPaths.add(temp);
            }
        }
        return allPaths;
    }
}
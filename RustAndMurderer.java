import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
public class RustAndMurderer {
  public static void main(String[] args) throws Exception {
    final StringBuffer sb = new StringBuffer();
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    for(byte t = Byte.parseByte(br.readLine()); t > 0; --t){
      String[] line = br.readLine().split(" ");
      final int n = Integer.parseInt(line[0]);
      final List<Set<Integer>> roads = new ArrayList<Set<Integer>>(n);
      for(int i = 0; i < n; ++i){
        roads.add(new HashSet<Integer>());
      }
      for(short m = Short.parseShort(line[1]); m > 0; --m){
        line = br.readLine().split(" ");
        final int X = Integer.parseInt(line[0]) - 1;
        final int Y = Integer.parseInt(line[1]) - 1;
        roads.get(X).add(Y);
        roads.get(Y).add(X);
      }
      final int s = Integer.parseInt(br.readLine()) - 1;
      final int[] minD = getEdgelessminD(roads, s, n);   
      //Print output
      for(int i = 0; i < s; sb.append(minD[i++] + " ")){}
      for(int i = s; ++i < n; sb.append(minD[i] + " ")){}
      sb.append("\n");
    }
    System.out.print(sb);
  }
  private static int[] getEdgelessminD(final List<Set<Integer>> roads, final int origin, final int n){
    final int[] d = new int[n];
    for(int i = 0; i < n; d[i++] = -1){}
    final List<Integer> unvisitedCities = new LinkedList<Integer>();
    for(int i = 0; i < origin; unvisitedCities.add(i++)){}
    for(int i = origin; ++i < n; unvisitedCities.add(i)){}
    
    //Find min d
    final Queue<Integer> queue = new LinkedList<Integer>();
    queue.add(origin);
    do {
      final int city = queue.poll();
      final int distance = ++d[city];
      final Set<Integer> cityRoads = roads.get(city);
      for(Iterator<Integer> it = unvisitedCities.iterator(); it.hasNext();){
        final int unvisitedCity = it.next();
        if(!cityRoads.contains(unvisitedCity)){
          d[unvisitedCity] = distance;
          it.remove();
          queue.add(unvisitedCity);
        }
      }
    } while (!queue.isEmpty());   
    return d;
  }
}
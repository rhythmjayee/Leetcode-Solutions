```
class Solution {
class Edge{
int u;
int v;
int w;
Edge(int u,int v,int w){
this.u=u;
this.v=v;
this.w=w;
}
}
class Pair{
int v;
int wt;
int stops;
Pair(int v,int wt,int stops){
this.v=v;
this.wt=wt;
this.stops=stops;
}
}
public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
if(flights.length==0) return -1;
HashMap<Integer,List<Edge>> g=new HashMap<>();
for(int i=0;i<n;i++){
g.put(i,new ArrayList<>());
}
for(int[] x:flights){
g.get(x[0]).add(new Edge(x[0],x[1],x[2]));
}
PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->{
return a.wt-b.wt;
});
HashMap<Integer, Integer> seen = new HashMap<>();
​
pq.add(new Pair(src,0,0));
while(!pq.isEmpty()){
Pair rem=pq.poll();
int u=rem.v;
int d=rem.wt;
int stops=rem.stops;
System.out.println(u+" "+ stops+"======");
if(seen.containsKey(u) && seen.get(u)<=stops) //support path with less cost
continue;
seen.put(u,stops);
if(u==dst) return d;
if(stops>K) continue; //remove path greater than K
for(Edge e:g.get(rem.v)){
int t=stops+1;
System.out.println(e.v+" "+ t+"-----");
pq.add(new Pair(e.v,rem.wt+e.w,stops+1));
}
}
return -1;
}
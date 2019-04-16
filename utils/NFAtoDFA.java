import java.util.*;
import java.util.Collections;
public class NFAtoDFA {

	public static ArrayList<Integer> del( ArrayList nodes, String var, ArrayList< HashMap<String,ArrayList<Integer> > > nfaTransMatrix ){
		//del() ye nodes us variable ke se kahan kahan(newSetOfNodes) jati hain
        ArrayList<ArrayList <Integer> > newSetOfNodes=new ArrayList<ArrayList<Integer> >();
        for(int i=0; i<nodes.size(); i++){
            HashMap h=nfaTransMatrix.get( (Integer)nodes.get(i) );
            if( h.containsKey(var) ){
                newSetOfNodes.add( (ArrayList<Integer>)h.get(var) );// error (ArrayList<Integer>)
            }
        }
		//System.out.println("printitng ");
		//System.out.println( newSetOfNodes );
        return union(newSetOfNodes);
    }

    public static ArrayList<Integer> union( ArrayList<ArrayList<Integer> > nodes ){
        ArrayList<Integer> set=new ArrayList<Integer>();
        for(int i=0; i<nodes.size(); i++){
            ArrayList a=(ArrayList<Integer> )nodes.get(i);
            for(int j=0; j<a.size(); j++){
                if( !set.contains(a.get(j)) )
                    set.add( (Integer)a.get(j) );
            }
        }
        return set;
    }

	public static ArrayList<Integer> eClosure( int node, ArrayList< HashMap<String,ArrayList<Integer> > > nfaTransMatrix ){
        ArrayList<Integer> set=new ArrayList<Integer>();
        set.add(node);
        int i=0;
        while(i<set.size()){
            HashMap h=nfaTransMatrix.get( (Integer)set.get(i) );
            if( h.containsKey("EPS") ){
                ArrayList a=(ArrayList)h.get("EPS");
                for(int j=0; j<a.size(); j++){
                    if( !set.contains(a.get(j)) )
                        set.add( (Integer)a.get(j) );
                }
            }
            i++;
        }
        return set;
    }

	public static ArrayList<Integer> eClosureList( ArrayList<Integer> nodes, ArrayList< HashMap<String,ArrayList<Integer> > > nfaTransMatrix ){
        ArrayList< ArrayList<Integer> > combinedNodes=new ArrayList< ArrayList<Integer> >();
        for(int i=0; i<nodes.size(); i++){
            combinedNodes.add( eClosure( (Integer)nodes.get(i), nfaTransMatrix ) );
        }
        return union(combinedNodes);
    }

    public static int IsNewNodeNew(ArrayList<Integer> newNode, ArrayList< ArrayList<Integer> > dfaNodes){
		// first sorted because equals method of ArrayList checks corresponding pair of elements and size
        Collections.sort(newNode);
        for(int i=0; i<dfaNodes.size(); i++){
            ArrayList<Integer> a=( ArrayList<Integer> )dfaNodes.get(i);
            Collections.sort(a);
            if(newNode.equals(a)) // node is already present
                return i;
        }
        return -1; // node is not present -> create node
    }

	public static void nfaToDfaCode(int nNFANodes, int nVar, ArrayList<Integer> nfaNodes, ArrayList<String> variables, int nfaStartingNode, ArrayList<Integer> nfaFinalNodes, ArrayList< HashMap<String,ArrayList<Integer> > > nfaTransMatrix){
		ArrayList< ArrayList<Integer> > dfaNodes=new ArrayList< ArrayList<Integer> >();// one DFA node may comprise more than one NFA nodes
		ArrayList< HashMap<String,Integer> > dfaTransMatrix=new ArrayList< HashMap<String,Integer> >();// we have taken integer only and not AL because in DFA, one node points to only one node
		ArrayList<Integer> dfaFinalNodes=new ArrayList<Integer>();

		int nDFANodes=0;
		ArrayList<Integer> firstDFANode=eClosure(nfaStartingNode,nfaTransMatrix);
		System.out.println("eClosure of starting node(0) ::: "+firstDFANode);
		dfaNodes.add(firstDFANode);
        nDFANodes++;

		System.out.println("\nDFA transitions");

		int j=0;
        while(j<nDFANodes){
            //System.out.println("DFA node ::: "+j+" -> NFA nodes "+dfaNodes.get(j));
            HashMap<String,Integer> newNodeMap=new HashMap<String,Integer>();
            for(int i=0; i<nVar; i++){
                //System.out.println("transition via var ::: "+variables.get(i));
                ArrayList newNode=eClosureList( (ArrayList<Integer>)del( dfaNodes.get(j), variables.get(i), nfaTransMatrix ), nfaTransMatrix );
                int nodePointingTo=IsNewNodeNew(newNode, dfaNodes);
                if(nodePointingTo==-1){
                    dfaNodes.add(newNode);
                    //System.out.println("newNode ::: "+newNode);
                    newNodeMap.put(variables.get(i), nDFANodes);
                    nDFANodes++;
                }
                else{
                    newNodeMap.put(variables.get(i), nodePointingTo);
                }
            }
            dfaTransMatrix.add(newNodeMap);
            j++;
        }
        System.out.println("no of nodes in DFA formed "+nDFANodes);
        System.out.println("nodes of DFA "+dfaNodes);
        System.out.println("DFA Transition Matrix "+dfaTransMatrix);

		// if final nodes of NFA is presnt in any node of DFA, then it will be a final node
        for(int i=0; i<nfaFinalNodes.size(); i++){
            //System.out.println(nfaFinalNodes.get(i));
            for(int k=0; k<dfaNodes.size(); k++){
                ArrayList<Integer> a=(ArrayList<Integer>)dfaNodes.get(k);
                if( a.contains(nfaFinalNodes.get(i)) ){
                    dfaFinalNodes.add(k);
                    continue;
                }
            }
        }

        System.out.println("dfa final nodes "+dfaFinalNodes);

	}

	public static void main(String args[]) {
        int nNFANodes=3;// user input
        int nVar=2;// user input
        ArrayList<Integer> nfaNodes=new ArrayList<Integer>();
        for(int i=0; i<nNFANodes; i++){
            nfaNodes.add(i);
        }
        ArrayList<String> variables=new ArrayList<String>();
		// I have taken variables as string because I needed EPS which is string
        variables.add("0");// user input
        variables.add("1");// user input
        //nVar++; for epsilon
        variables.add("EPS");

        System.out.println("NFA nodes ::: "+nfaNodes);
        System.out.println("Variables ::: "+variables);

		int nfaStartingNode=0;// of NFA
        ArrayList<Integer> nfaFinalNodes=new ArrayList<Integer>();// can be many.... so used array.... not int
        nfaFinalNodes.add(2);// user input

		ArrayList< HashMap<String,ArrayList<Integer> > > nfaTransMatrix=new ArrayList< HashMap<String,ArrayList<Integer> > >(); // we have dfaTransMatrix also later

		HashMap<String,ArrayList<Integer> > h=new HashMap<String,ArrayList<Integer> >();
		// 	............................................................................... USER INPUTS
		// Q3
        // node 0
        h.put("EPS",new ArrayList<>( Arrays.asList(1)) );
        h.put("0",new ArrayList<>( Arrays.asList(1,2)) );
        h.put("1",new ArrayList<>( Arrays.asList(0)) );
		nfaTransMatrix.add(h);
		// node 1
        h=new HashMap<String,ArrayList<Integer> >();
        h.put("1",new ArrayList<>( Arrays.asList(1)) );
        h.put("EPS",new ArrayList<>( Arrays.asList(2)) );
        nfaTransMatrix.add(h);
        // node 2
        h=new HashMap<String,ArrayList<Integer> >();
        h.put("0",new ArrayList<>( Arrays.asList(2)) );
        h.put("1",new ArrayList<>( Arrays.asList(2)) );
        nfaTransMatrix.add(h);
		// 	............................................................................... USER INPUTS

		System.out.println("entered NFA Transition Matrix "+nfaTransMatrix);

		nfaToDfaCode(nNFANodes, nVar, nfaNodes, variables, nfaStartingNode, nfaFinalNodes, nfaTransMatrix);

	}
}

package problem_solving.scaler_questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


class MappingClass{
    HashMap<String,ArrayList<Integer>> serverNameToListOfRequestMap ;
    String lastServerAdd ;

    public MappingClass(HashMap<String,ArrayList<Integer>> serverNameToListOfRequestMap, String lastServerAdd) {
        this.serverNameToListOfRequestMap = serverNameToListOfRequestMap;
        this.lastServerAdd = lastServerAdd ;
    }
}

public class consistentHashing {
    public static void main(String[] args) {

        String[] s = new String[]{"ADD","ASSIGN","ASSIGN","ASSIGN","ADD","ASSIGN","ASSIGN","ASSIGN","ADD","ASSIGN","ASSIGN","ASSIGN","ADD",
                "ASSIGN","ASSIGN","ASSIGN","REMOVE","ASSIGN","ASSIGN","ASSIGN","REMOVE","ASSIGN","ASSIGN","ASSIGN","REMOVE","ASSIGN","ASSIGN"};
        String[] s1 = new String[]{"INDIA","VLVL","OXXV","HHGN","RUSSIA","AWNF","SPHI","FXKT","CHINA","JXZU","BWPK","JYWN","GERMANY","ZKYK","HLQZ","BRMS","INDIA","FMVA","NPJO","GACA","RUSSIA","ZMWM","XVUA","IDUW","CHINA","EHWW","KROX"};
        Integer[] ar = new Integer[]{431,563,223,761,197,409,31,223,769,619,991,613,139,797,547,821,-1,131,577,269,-1,499,599,29,-1,13,337};

        ArrayList<String> A = new ArrayList<>(List.of(s)) ;

        ArrayList<String> B = new ArrayList<>(List.of(s1)) ;

        ArrayList<Integer> C = new ArrayList<>(List.of(ar)) ;

        ArrayList<Integer> ans = solve(A,B,C);
        for(Integer i : ans){
            System.out.print(i + " ");
        }

    }


    public static int[] solve2(String[] A, String[] B, int[] C){
        int size = A.length ;
        int[] ans = new int[size];

        MappingClass[] arr = new MappingClass[360];

        for(int i = 0 ; i < size ; i++){
            String operation = A[i] ;
            String serverKeyName = B[i] ;
            int hashKey = C[i] ;


            // add a server
            if(operation.equals("ADD")){
                String serverName = serverKeyName ;

                int serverHash = userHash(serverName,hashKey);

                if(arr[serverHash] == null){
                    HashMap<String,ArrayList<Integer>> map = new HashMap<>();
                    map.put(serverName,new ArrayList<>()) ;
                    arr[serverHash] = new MappingClass(map,serverName);
                }
                else{
                   arr[serverHash].serverNameToListOfRequestMap.put(serverName,new ArrayList<>());
                   arr[serverHash].lastServerAdd = serverName ;                     
                }



            }
            // remove a server
            else if(operation.equals("REMOVE")){

            }
            else{

            }
        }

        return ans;
    }




    public static ArrayList<Integer> solve(ArrayList<String> operationList, ArrayList<String> keyServerNameList, ArrayList<Integer> hashKeyValueList) {

        ArrayList<Integer> ans = new ArrayList<>();
        int numberOfOperations = operationList.size();
        // Server's hash value will be on Ring :
        ArrayList<Integer> serverHashSortedList = new ArrayList<>();

        HashMap<Integer,ArrayList<Integer>> serverHashValueToRequestMapping = new HashMap<>();

        HashMap<String,Integer> serverToHash = new HashMap<>() ;

        for(int i = 0 ; i < numberOfOperations ; i++){
            String operation = operationList.get(i);

            if(operation.equals("ADD")){

                int hashValueNewServer = userHash(keyServerNameList.get(i),hashKeyValueList.get(i));

                serverToHash.put(keyServerNameList.get(i),hashValueNewServer) ;

                if(!serverHashValueToRequestMapping.containsKey(hashValueNewServer)){
                    serverHashSortedList.add(hashValueNewServer) ;
                    Collections.sort(serverHashSortedList);
                    serverHashValueToRequestMapping.put(hashValueNewServer,new ArrayList<>());
                }

                // this new server will to its next server friend in clockwise direction and ask the server
                // please give me the requests which i need to serve.

                int sizeOfServerSortedList = serverHashSortedList.size() ;
                if(sizeOfServerSortedList == 1){
                    ans.add(0);
                }
                else{
                    // what is the index of newly added server ?
                    int indexOfNewServer = getIndex(hashValueNewServer,serverHashSortedList);
                    int prevIndexServer = -1 ;

                    if(indexOfNewServer == 0){
                        // ask last server in hash ring
                        prevIndexServer = sizeOfServerSortedList - 1;
                    }
                    else{
                        prevIndexServer = indexOfNewServer - 1;
                    }

                    int countOfRedistribution =
                            redistributeLoadOnAdding(prevIndexServer,indexOfNewServer, serverHashSortedList, serverHashValueToRequestMapping) ;
                    ans.add(countOfRedistribution);
                }
            }
            else if(operation.equals("ASSIGN")){
                // server hash value where this request will get assign  ?
                int keyHash = userHash(keyServerNameList.get(i),hashKeyValueList.get(i));

                int indexServer = getServerHashServerRequest(keyHash,serverHashSortedList) ;

                int serverHash = serverHashSortedList.get(indexServer) ;

                ans.add(serverHash) ;

                System.out.println("i " + i);
                System.out.println("server hash : " + serverHash);
                System.out.println(serverHashValueToRequestMapping.get(serverHash));

                ArrayList<Integer> t = serverHashValueToRequestMapping.get(serverHash) ;
                System.out.println("t : " + t);
                ArrayList<Integer> temp = new ArrayList<>(t) ;
                temp.add(keyHash);
                serverHashValueToRequestMapping.put(serverHash,temp) ;
            }
            else{ // REMOVE

                int removeServerHash = serverToHash.get(keyServerNameList.get(i)) ;
                int indexRemoveServer = getIndex(removeServerHash,serverHashSortedList);
                int indexNextServer = 0;

                if(indexRemoveServer != serverHashSortedList.size()-1){
                    indexNextServer = indexRemoveServer + 1;
                }

                int nextServerHash = serverHashSortedList.get(indexNextServer) ;

                int countOfRequestServing = serverHashValueToRequestMapping.get(removeServerHash).size() ;
                ans.add(countOfRequestServing) ;

                serverToHash.remove(keyServerNameList.get(i)) ;
                serverHashSortedList.remove(indexRemoveServer);

                redistributeLoadOnRemoving(removeServerHash,nextServerHash, serverHashValueToRequestMapping);
            }
        }
        return ans;
    }

    public static void redistributeLoadOnRemoving(int removeServerHash, int nextServerHash, HashMap<Integer,ArrayList<Integer>> mapping){

        ArrayList<Integer> removeList = new ArrayList<>(mapping.get(removeServerHash));
        mapping.remove(removeServerHash) ;

        ArrayList<Integer> newList = new ArrayList<>(mapping.get(nextServerHash)) ;
        newList.addAll(removeList);
        mapping.put(nextServerHash,newList);
    }

    public static int getServerHashServerRequest(int key, ArrayList<Integer> sortedList){

        int size = sortedList.size() ;
        if(size == 1 || key > sortedList.get(size-1) || key < sortedList.get(0)){
            return 0 ;
        }
        int s = 0 ;
        int e = size-1 ;
        int index = -1;

        while(s <= e){
            int mid = (s+e)/2 ;
            if(sortedList.get(mid) > key){
                index = mid ;
                e = mid - 1;
            }
            else if(sortedList.get(mid) < key){
                s = mid+1 ;
            }
            else{
                index = mid ;
                break ;
            }
        }
        return index ;
    }

    public static int redistributeLoadOnAdding(int prevIndex, int currentIndex ,ArrayList<Integer> serverHashSortedList, HashMap<Integer,ArrayList<Integer>> mapping){

        int prevServerHash = serverHashSortedList.get(prevIndex);
        int currServerHash = serverHashSortedList.get(currentIndex) ;

        ArrayList<Integer> dest = new ArrayList<>(mapping.get(prevServerHash));
        ArrayList<Integer> src = new ArrayList<>(mapping.get(currServerHash));


        int count = 0 ;
        if(currentIndex == 0){
            for(Integer i : dest){
                if(i > prevServerHash ||  i <= currServerHash){
                    //dest.remove(i) ;
                    src.add(i);
                    count++;
                }
            }
        }
        else{
            for(Integer i : dest){
                if( i > prevServerHash && i <= currServerHash){
                    //dest.remove(i) ;
                    src.add(i) ;
                    count++ ;
                }
            }
        }
        for (int ele : src) {
            for (int j = 0; j < dest.size(); j++) {
                if (ele == dest.get(j)) {
                    dest.remove(j);
                    break;
                }
            }
        }
        mapping.put(prevServerHash,new ArrayList<>(dest)) ;
        mapping.put(currServerHash,new ArrayList<>(src)) ;
        return count ;
    }
    public static int getIndex(int key,ArrayList<Integer> list){
        int s = 0 ;
        int e = list.size()-1 ;

        int ans = -1 ;

        while(s <= e){
            int mid = (s+e)/2 ;
            if(list.get(mid) == key){
                ans = mid ;
                break ;
            }
            else if(list.get(mid) > key){
                e = mid -1 ;
            }
            else{
                s = mid+1 ;
            }
        }
        return ans ;
    }

    public static int userHash(String username, int hashKey){
        int p = hashKey;
        int n = 360;
        int hashCode = 0;
        long p_pow = 1;
        for (int i = 0; i < username.length(); i++) {
            char character = username.charAt(i);
            hashCode = (int)(hashCode + (character - 'A' + 1) * p_pow) % n;
            p_pow = (p_pow * p) % n;
        }
        return hashCode;
    }
}

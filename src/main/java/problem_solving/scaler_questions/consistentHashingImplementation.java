package problem_solving.scaler_questions;//package scaler_questions;
//
//import java.util.ArrayList;
//
//public class consistentHashingImplementation {
//    public static void main(String[] args) {
//
//        ArrayList<String> A = new ArrayList<>();
//        A.add("ADD");
//        A.add("ASSIGN");
//        A.add("ASSIGN");
//        A.add("ADD");
//        A.add("ASSIGN");
//        A.add("ASSIGN");
//        A.add("REMOVE");
//        A.add("ASSIGN");
//
//        ArrayList<String> B = new ArrayList<>();
//        B.add("INDIA");
//        B.add("GMWK");
//        B.add("GXJN");
//        B.add("RUSSIA");
//        B.add("QKUF");
//        B.add("JUNQ");
//        B.add("INDIA");
//        B.add("QYKY");
//
//        ArrayList<Integer> C = new ArrayList<>();
//        C.add(419);
//        C.add(727);
//        C.add(5);
//        C.add(757);
//        C.add(191);
//        C.add(823);
//        C.add(-1);
//        C.add(337);
//
//
//        /*
//            A = [ADD, ASSIGN, ASSIGN, ADD, ASSIGN, ASSIGN, REMOVE, ASSIGN]
//            B = [INDIA, IRYA, RGJK, RUSSIA, BGVH, SUKJ, INDIA, RBRF]
//            C = [11, 31, 7, 3, 5, 13, -1, 17]
//
//
//
//        ArrayList<String> A = new ArrayList<>();
//        A.add("ADD");
//        A.add("ASSIGN");
//        A.add("ASSIGN");
//        A.add("ADD");
//        A.add("ASSIGN");
//        A.add("ASSIGN");
//        A.add("REMOVE");
//        A.add("ASSIGN");
//
//        //B = [INDIA, IRYA, RGJK, RUSSIA, BGVH, SUKJ, INDIA, RBRF]
//        //C = [11, 31, 7, 3, 5, 13, -1, 17]
//
//        ArrayList<String> B = new ArrayList<>();
//        B.add("INDIA");
//        B.add("IRYA");
//        B.add("RGJK");
//        B.add("RUSSIA");
//        B.add("BGVH");
//        B.add("SUKJ");
//        B.add("INDIA");
//        B.add("RBRF");
//
//
//        ArrayList<Integer> C = new ArrayList<>();
//        C.add(11);
//        C.add(31);
//        C.add(7);
//        C.add(3);
//        C.add(5);
//        C.add(13);
//        C.add(-1);
//        C.add(17);
//
//         */
//
//        /*
//        ArrayList<String> A = new ArrayList<>();
//        A.add("ADD");
//        A.add("ASSIGN");
//        A.add("ADD");
//        A.add("ASSIGN");
//        A.add("REMOVE");
//        A.add("ASSIGN");
//
//        ArrayList<String> B = new ArrayList<>();
//        B.add("INDIA");
//        B.add("NWFJ");
//        B.add("RUSSIA");
//        B.add("OYVL");
//        B.add("INDIA");
//        B.add("IGAX");
//
//        ArrayList<Integer> C = new ArrayList<>();
//        C.add(7);
//        C.add(3);
//        C.add(5);
//        C.add(13);
//        C.add(-1);
//        C.add(17);
//
//         */
//
//        ArrayList<Integer> ans = solve(A,B,C);
//        for(Integer i : ans){
//            System.out.print(i + " ");
//        }
//
//        /*
//        A = [ADD, ASSIGN, ADD, ASSIGN, REMOVE, ASSIGN]
//        B = [INDIA, NWFJ, RUSSIA, OYVL, INDIA, IGAX]
//        C = [7, 3, 5, 13, -1, 17 ]
//         */
//
//    }
//
//    public static ArrayList<Integer> solve(ArrayList<String> A, ArrayList<String> B, ArrayList<Integer> C) {
//        ArrayList<Integer> ans = new ArrayList<>();
//        int n = A.size();
//
//        ArrayList<Integer> servers = new ArrayList<>();
//
//        ArrayList<ArrayList<Integer>> serversToRequest = new ArrayList<>();
//
//        ArrayList<String> serverName = new ArrayList<>();
//
//        for(int i = 0 ; i < n ; i++){
//            String operation = A.get(i);
//
//            if(operation.equals("ADD")){
//                int hashValueNewServer = userHash(B.get(i),C.get(i));
//                int newServerAddedIndex = -1;
//                //System.out.println("ADD");
//               // System.out.println("i :" + i + " " + hashValueNewServer);
//
//                if(servers.isEmpty()){
//                    servers.add(hashValueNewServer);
//                    serversToRequest.add(new ArrayList<Integer>());
//                    serverName.add(B.get(i));
//                }
//                else{
//                    //find the correct index of the new server in the list of servers;
//                    newServerAddedIndex = getIndex(servers,hashValueNewServer);
//                    if(newServerAddedIndex == -1){
//                        servers.add(hashValueNewServer);
//                        serverName.add(B.get(i));
//                        newServerAddedIndex = servers.size()-1;
//                    }
//                    else{
//                        servers.add(newServerAddedIndex,hashValueNewServer);
//                        serverName.add(newServerAddedIndex,B.get(i));
//                    }
//                    serversToRequest.add(newServerAddedIndex,new ArrayList<Integer>());
//                }
//
//                // redistribution of load - because a new server has added...
//                int numberOfKeysToNewServer =
//                        redistribution(serversToRequest,servers,newServerAddedIndex,hashValueNewServer);
//                ans.add(numberOfKeysToNewServer);
//            }
//            else if(operation.equals("ASSIGN")){
//
//                int hashValueOfNewRequest = userHash(B.get(i),C.get(i));
//
//                //System.out.println("ASSIGN : " + "i " + i + " " + hashValueOfNewRequest);
//                int assignedServer = getIndex(servers,hashValueOfNewRequest);
//                if(assignedServer == -1){
//                    assignedServer = 0;
//                }
//                serversToRequest.get(assignedServer).add(hashValueOfNewRequest);
//                ans.add(servers.get(assignedServer));
//            }
//            else{
//                // when operation is "REMOVE"
//                // no of request needs to be redistributed after removing this server ;
//
//               // int hashValueOfRemoveServer = userHash(B.get(i),C.get(i));
//
//                String removeServerName = B.get(i);
//                int removeServerIndex = -1;
//                for(int j = 0 ; j < serverName.size() ; j++){
//                    if(serverName.get(j).equals(removeServerName)){
//                        removeServerIndex = j;
//                        break;
//                    }
//                }
//                //System.out.println("remove Server Index : " + removeServerIndex);
//                serverName.remove(removeServerIndex);
//
//                int numberOfRequestServingByRemovedServer = serversToRequest.get(removeServerIndex).size();
//                //System.out.println("request serving " + numberOfRequestServingByRemovedServer);
//                ans.add(numberOfRequestServingByRemovedServer);
//                // copy all the load of removed server to the very next server
//                // if remove server is the last server
//                if(removeServerIndex == servers.size()-1){
//                    //add to the first server in the servers list
//                    copyFromRemovedToNext(serversToRequest,servers.size()-1,0);
//                    serversToRequest.remove(removeServerIndex-1);
//                }
//                else{
//                    copyFromRemovedToNext(serversToRequest,removeServerIndex,removeServerIndex+1);
//                    serversToRequest.remove(removeServerIndex);
//                }
//                // delete that servers from servers list
//                servers.remove(removeServerIndex);
//            }
//        }
//        return ans;
//    }
//
//
//    public static void copyFromRemovedToNext(ArrayList<ArrayList<Integer>> serversToRequest, int from, int to){
//        ArrayList<Integer> fromServer = serversToRequest.get(from);
//        for(Integer i : fromServer){
//            serversToRequest.get(to).add(i);
//        }
//    }
//
//    public static int getIndex(ArrayList<Integer> servers, int hashValueNewServer){
//        int n = servers.size();
//        int s = 0 ;
//        int e = n-1;
//        int ans = -1;
//
//        while(s <= e){
//            int mid = (s+e)/2 ;
//            if(servers.get(mid) > hashValueNewServer){
//                ans = mid;
//                e = mid-1;
//            }
//            else{
//                s = mid+1;
//            }
//        }
//        return ans;
//    }
//
//    public static int redistribution(ArrayList<ArrayList<Integer>> serversToRequest,ArrayList<Integer> servers, int index, int hashValueNewServer){
//
//        if(servers.size() == 1){
//            return 0;
//        }
//        int count = 0;
//        int prevServer = 0;
//        int addedServer = index ;
//        int nextServer = 0;
//
//        int totalServers = servers.size();
//
//        if(addedServer != totalServers-1 && addedServer != 0){
//            prevServer = addedServer - 1;
//            nextServer = addedServer + 1;
//        }
//        else if(addedServer == 0){
//            prevServer = totalServers - 1;
//            nextServer = addedServer + 1;
//        }
//        else{
//           // System.out.println("redistribution : " + addedServer);
//            prevServer = addedServer - 1;
//            nextServer = 0;
//        }
//
//        int fromHashValue = servers.get(prevServer);
//        int toHashValue = hashValueNewServer;
//
//        if(addedServer == 0){
//            // fromHashValue to 359 && 0 to toHashValue
//            ArrayList<Integer> listOfHashValueFromNextServer = serversToRequest.get(nextServer);
//            for(int i = 0 ; i < listOfHashValueFromNextServer.size() ; i++){
//                int value = listOfHashValueFromNextServer.get(i);
//
//                if( (value > fromHashValue && value <= 359) || (value >= 0 &&value < toHashValue)){
//                    serversToRequest.get(addedServer).add(value);
//                    count++;
//                    serversToRequest.get(nextServer).remove(Integer.valueOf(value));
//                }
//            }
//        }
//        else{
//            ArrayList<Integer> listOfHashValueFromNextServer = new ArrayList<>(serversToRequest.get(nextServer));
//
//            //System.out.println("size " + listOfHashValueFromNextServer.size());
//
//            int len = listOfHashValueFromNextServer.size();
//
//            for(int i = 0 ; i < listOfHashValueFromNextServer.size() ; i++){
//
//                int value = listOfHashValueFromNextServer.get(i);
//                //System.out.println("value : " + value);
//                //System.out.println("i from redis... " + i);
//                if((value > fromHashValue) && (value < toHashValue)){
//                    serversToRequest.get(addedServer).add(value);
//                    count++;
//                    serversToRequest.get(nextServer).remove(Integer.valueOf(value));
//                }
//            }
//        }
//        return count;
//    }
//
//
//    public static int userHash(String username, int hashKey){
//        int p = hashKey;
//        int n = 360;
//        int hashCode = 0;
//        long p_pow = 1;
//        for (int i = 0; i < username.length(); i++) {
//            char character = username.charAt(i);
//            hashCode = (int)(hashCode + (character - 'A' + 1) * p_pow) % n;
//            p_pow = (p_pow * p) % n;
//        }
//        return hashCode;
//    }
//}
//
//

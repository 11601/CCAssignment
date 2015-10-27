import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Queue;

/**
 * Created by Hakim on 10/21/15.
 */

enum Rank{
    RESPONDENT, MANAGER, DIRECTOR
}
abstract class Employee{
    int id;
    String name;
    Rank rank;
    Call currentCall;

    void processCall(Call call) {
        // update isAvailable before and after
        // update currentCall
    }


}

class Respondent extends Employee {
    public Respondent() {
        rank = Rank.RESPONDENT;
    }
}

class Manager extends Employee{
    public Manager() {
        rank = Rank.MANAGER;
    }
}

class Director extends Employee{
    public Director() {
        rank = Rank.DIRECTOR;
    }
}

class Call{
    int id;
    Date received;

    public Call(int id){

    }
}

class CallCenter{
    Queue<Call> calls;
    int numRespondents;
    int numManagers;
    int numDirectors;

    List<Respondent> respondents;
    List<Manager> managers;
    List<Director> directors;
    List<List<? extends Employee>> employees;

    public CallCenter(int numResp, int numMng, int numDirs) {
        numRespondents = numResp;
        numManagers = numMng;
        numDirectors = numDirs;

        respondents = new ArrayList<>();
        managers = new ArrayList<>();
        directors = new ArrayList<>();

        for (int r=0; r<numRespondents; r++){
            respondents.add(new Respondent());
        }
        for (int m=0; m<numManagers; m++){
            managers.add(new Manager());
        }
        for (int d=0; d<numDirectors; d++){
            directors.add(new Director());
        }

        employees.add(respondents);
        employees.add(managers);
        employees.add(directors);

        }

    public void dispatchCall(){
        if (!calls.isEmpty()){
            Call call = calls.poll();

            for (List<? extends Employee> e : employees){
                for (Employee emp : e){
                    if (emp.currentCall == null){
                        emp.processCall(call);
                    }
                }
            }
        }
    }
}


public class Solution02 {

}

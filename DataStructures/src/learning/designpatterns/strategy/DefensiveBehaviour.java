package learning.designpatterns.strategy;

public class DefensiveBehaviour implements Behaviour {
    @Override
    public String getStrategy() {
        return ("Defend");
    }
}

package learning.designpatterns.strategy;

public class AttackingBehaviour implements Behaviour {
    @Override
    public String getStrategy() {
        return "Attack";
    }
}

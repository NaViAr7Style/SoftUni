package lecture05BPolymorphismExercise.calculator;

import java.util.ArrayList;
import java.util.List;

public class DivisionOperation implements Operation {
    private List<Integer> operands;
    private int result;

    public DivisionOperation() {
        this.operands = new ArrayList<>();
    }

    @Override
    public void addOperand(int operand) {
        this.operands.add(operand);

        if (this.isCompleted()) {
            this.result = operands.get(0) / operands.get(1);
        }
    }

    @Override
    public int getResult() {
        return this.result;
    }

    @Override
    public boolean isCompleted() {
        return this.operands.size() == 2;
    }
}

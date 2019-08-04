package practice.calc.operation;

public class SumOperation extends ArithmeticOperation {

    public SumOperation(Number arg1, Number arg2) {
        super(new ConstOperation(arg1), new ConstOperation(arg2));
    }

    public SumOperation(Operation arg1, Number arg2) {
        super(arg1, new ConstOperation(arg2));
    }

    public SumOperation(Operation arg1, Operation arg2) {
        super(arg1, arg2);
    }

    @Override
    public Number operate() {
        return addNumbers(arg1.operate(), arg2.operate());
    }

}

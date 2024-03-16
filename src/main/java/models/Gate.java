package models;

public class Gate {
    private Long number;
    private GateType gateType;
    private Operator operator;
    private GateStatus gateStatus;

    public java.lang.Long getNumber() {
        return number;
    }

    public void setNumber(java.lang.Long number) {
        this.number = number;
    }

    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public GateStatus getGateStatus() {
        return gateStatus;
    }

    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
    }
}

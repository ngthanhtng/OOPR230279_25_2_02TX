package model;

public class WaivedFeePolicy implements LateFeePolicy {

    @Override
    public double applyPolicy(double baseFee) {
        return 0;
    }

    @Override
    public String getPolicyName() {
        return "Mien phi phat";
    }
}

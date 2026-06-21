package interfaces;

public interface LateFeePolicy {
    double applyPolicy(double baseFee);
    String getPolicyName();
}

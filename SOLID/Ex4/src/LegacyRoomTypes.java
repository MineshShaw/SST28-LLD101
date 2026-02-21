public class LegacyRoomTypes {
    public static final PricingComponent SINGLE = new SingleRoomPricing();
    public static final PricingComponent DOUBLE = new DoubleRoomPricing();
    public static final PricingComponent TRIPLE = new TripleRoomPricing();
    public static final PricingComponent DELUXE = new DeluxeRoomPricing();

    public static String nameOf(PricingComponent component) {
        if (component == SINGLE) return "SINGLE";
        if (component == DOUBLE) return "DOUBLE";
        if (component == TRIPLE) return "TRIPLE";
        return "DELUXE";
    }
}

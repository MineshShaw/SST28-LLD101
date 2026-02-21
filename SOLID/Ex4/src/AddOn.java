public class AddOn {
    public static final PricingComponent MESS = new MessAddOn();
    public static final PricingComponent LAUNDRY = new LaundryAddOn();
    public static final PricingComponent GYM = new GymAddOn();

    public static String nameOf(PricingComponent component) {
        if (component == MESS) return "MESS";
        if (component == LAUNDRY) return "LAUNDRY";
        return "GYM";
    }
}

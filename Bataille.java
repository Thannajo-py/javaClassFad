public class Bataille {
    public static void main(String[] args){
        Cards[] b = Cards.values();
        Cards[] d = Cards.values();
        ArrayUtils.printTab(d);
        d = ArrayUtils.remove(d,3);
        ArrayUtils.printTab(d);
        ArrayUtils.printTab(b);

    }
    public enum Cards {
        as, deux, trois, quatre, cinq, six, sept, huit, neuf, dix, valet, dame, roi
    }
}

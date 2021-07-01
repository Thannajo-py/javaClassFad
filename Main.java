public class Main {
    public static void main(String[] args){
        int[] table = new int[10];
        ArrayUtils.fillTab(table);
        int[] table2 = new int[5];
        ArrayUtils.fillTab(table2);
        System.out.print("table 1 = ");
        ArrayUtils.printTab(table);
        System.out.print("table 2 = ");
        ArrayUtils.printTab(table2);
        System.out.println("max table 1 = " + ArrayUtils.getMax(table));
        System.out.println("max table 2 = " + ArrayUtils.getMax(table2));
        ArrayUtils.permute(table2, 3, 4);
        System.out.print("table 2 = ");
        ArrayUtils.printTab(table2);
        System.out.println("sum table2 = " + ArrayUtils.getSum(table2));
        System.out.println("average table 2 = " + ArrayUtils.getAverage(table2));
        System.out.println("table 2 valeur supérieure à la moyenne:");
        ArrayUtils.showBetterThanAverage(table2);
        System.out.print("table 2 nb max occurence = ");
        System.out.println(ArrayUtils.maxOccurence(table2));
        System.out.print("fuuuuusion!!! = ");
        ArrayUtils.printTab(ArrayUtils.fusion(table,table2));
        System.out.print("fuuuuusion!!!(cell(sept) version) = ");
        ArrayUtils.printTab(ArrayUtils.add(table,7));
        System.out.print("suppression case 3 = ");
        ArrayUtils.printTab(ArrayUtils.remove(table,3));
    }
}

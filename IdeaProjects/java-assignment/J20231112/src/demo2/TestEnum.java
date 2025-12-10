package demo2;

public enum TestEnum {
    RED(1,"红色"),
    GREEN(2,"绿色"),
    BLACK(3,"黑色");
    private int ordinal;
    private String color;
    TestEnum(int ordinal, String color){
        this.ordinal = ordinal;
        this.color = color;
    }

    public static void main(String[] args) {
        TestEnum[] testEnum = TestEnum.values();
        for (int i = 0; i < testEnum.length; i++) {
            System.out.println(testEnum[i].ordinal());
        }
        System.out.println("========");
        TestEnum v = TestEnum.valueOf("BLACK");
        System.out.println(v);
        System.out.println("=========");
        System.out.println(RED.compareTo(BLACK));
    }

    public static void main1(String[] args) {
        TestEnum color = RED;//定义目标颜色
        switch(color){
            case GREEN:
                System.out.println("GREEN");
                break;
            case RED:
                System.out.println("RED");
                break;
            case BLACK:
                System.out.println("BLACK");
                break;
            default:
                System.out.println("error");
                break;
        }
    }
}

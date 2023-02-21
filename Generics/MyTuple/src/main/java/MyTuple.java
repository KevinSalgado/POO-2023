public class MyTuple<Integer> {

    private Integer item1;
    private Integer item2;

    public MyTuple (Integer item1, Integer item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    public Integer getItem1 () {
        return this.item1;
    }

    public Integer getItem2 () {
        return this.item2;
    }

}

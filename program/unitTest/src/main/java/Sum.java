/**
 * @author qiaozhe
 */
class Sum {

    private final int time;
    private final int time1;


    Sum(int time, int time1) {
        this.time = time;
        this.time1 = time1;
    }

    Article reduce() {
        int sum = this.time + this.time1;
        return new Article(sum);
    }
}

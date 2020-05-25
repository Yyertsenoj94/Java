package Playground;
public class udemyPracticals_paintBucketChallenge {
    public static void main(String[] args) {

        System.out.println(getBucketCount(-3.4, 2.1, 1.5, 2));
        System.out.println(getBucketCount(3.4, 2.1, 1.5, 2));
        System.out.println(getBucketCount(2.75, 3.25, 2.5, 1));

    }

    public static int getBucketCount(double width, double height, double areaPerBucket, int extraBuckets) {

        double bucketsNeeded = 0;
        int intBucketsNeeded = 0;

        double areaTotal = width * height;

        double areaExtra = areaPerBucket * extraBuckets;

        double areaNeeded = areaTotal - areaExtra;


        System.out.println("areaTotal: " + areaTotal + " area Extra: " + areaExtra + " area Needed: " + areaNeeded);


        if (width < 1 || height < 1 || areaPerBucket < 1 || extraBuckets < 1) {
            return -1;
        }

        if (areaNeeded <= 0) {
            bucketsNeeded = 0;
        } else {
            bucketsNeeded = (areaNeeded / areaPerBucket);
            System.out.println("Buckets needed: " + bucketsNeeded+ " to cover an area of " + areaNeeded);
        }

        intBucketsNeeded = (int) Math.ceil(bucketsNeeded);

        return intBucketsNeeded;
    }
}

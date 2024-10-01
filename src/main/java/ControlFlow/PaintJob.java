package ControlFlow;

public class PaintJob {
   public static int getBucketCount(double area, double areaPerBucket) {
      if (!(area <= 0.0D) && !(areaPerBucket <= 0.0D)) {
         return (int)Math.ceil(area / areaPerBucket);
      } else {
         throw new IllegalArgumentException("Numbers must not be negative");
      }
   }

   public static int getBucketCount(double width, double height, double areaPerBucket) {
      if (!(width <= 0.0D) && !(height <= 0.0D) && !(areaPerBucket <= 0.0D)) {
         double area = width * height;
         return getBucketCount(area, areaPerBucket);
      } else {
         throw new IllegalArgumentException("Numbers must not be negative");
      }
   }

   public static int getBucketCount(double width, double height, double areaPerBucket, int extraBuckets) {
      if (!(width <= 0.0D) && !(height <= 0.0D) && !(areaPerBucket <= 0.0D) && extraBuckets >= 0) {
         double area = width * height;
         return getBucketCount(area, areaPerBucket) - extraBuckets;
      } else {
         throw new IllegalArgumentException("Numbers must not be negative");
      }
   }
}

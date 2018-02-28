package com.javarush.test.level17.lesson10.home02;

/* Comparable
Реализуйте интерфейс Comparable<Beach> в классе Beach, который будет использоваться нитями.
*/

class Beach implements Comparable<Beach> {

  private String name;      //название
  private float distance;   //расстояние
  private int quality;    //качество

  public Beach(String name, float distance, int quality) {
    this.name = name;
    this.distance = distance;
    this.quality = quality;
  }

  @Override
  public synchronized int compareTo(Beach o) {
    int distanceParam = (int) (distance - o.getDistance());
    int qualityParam = quality - o.getQuality();
    return 10000 * name.compareTo(o.getName()) + 100 * distanceParam + qualityParam;

  }

  private synchronized String getName() {
    return name;
  }

  public synchronized void setName(String name) {
    this.name = name;
  }

  private synchronized float getDistance() {
    return distance;
  }

  public synchronized void setDistance(float distance) {
    this.distance = distance;
  }

  private synchronized int getQuality() {
    return quality;
  }

  public synchronized void setQuality(int quality) {
    this.quality = quality;
  }


}

/*(a) Create class CinemaShow with private String title, private int seatsAvailable, private 
final int capacity, and private static int totalBooked=0. 
(b) Constructor(title, capacity): set both and seatsAvailable = capacity. Constructor(title): 
chain with this(title, 100). 
(c) book(int n): if n ≤ seatsAvailable, reduce seatsAvailable by n, add n to totalBooked, 
return true; else return false unchanged. 
(d) cancel(int n): increase seatsAvailable by n but never above capacity. 
(e) Add getSeatsAvailable() and static getTotalBooked(). 
(f) In main: run a sequence of book and cancel calls, printing the result and seats after 
each, then print getTotalBooked(). */
public class CinemaShow {
    private String title;
    private int seatsAvailable;
    private final int capacity;
    private static int totalBooked = 0;

    public CinemaShow(String title, int capacity) {
        this.title = title;
        this.capacity = capacity;
        this.seatsAvailable = capacity;
    }

    public CinemaShow(String title) {
        this(title, 100);
    }

    public boolean book(int n) {
        if (n <= seatsAvailable) {
            seatsAvailable -= n;
            totalBooked += n;
            return true;
        }
        return false;
    }

    public void cancel(int n) {
        seatsAvailable = Math.min(seatsAvailable + n, capacity);
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public static int getTotalBooked() {
        return totalBooked;
    }

    public static void main(String[] args) {
        CinemaShow show = new CinemaShow("Inception", 50);

        System.out.println("Book 20: " + show.book(20));
        System.out.println("Seats left: " + show.getSeatsAvailable());

        System.out.println("Book 40: " + show.book(40));
        System.out.println("Seats left: " + show.getSeatsAvailable());

        show.cancel(10);
        System.out.println("Seats after cancel: " + show.getSeatsAvailable());

        System.out.println("Total booked: " + CinemaShow.getTotalBooked());
    }
}

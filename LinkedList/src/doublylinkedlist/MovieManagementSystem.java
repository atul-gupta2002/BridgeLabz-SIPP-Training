package doublylinkedlist;

class Movie {
        String title;
        String director;
        int year;
        double rating;
        Movie prev;
        Movie next;

        public Movie(String title, String director, int year, double rating) {
            this.title = title;
            this.director = director;
            this.year = year;
            this.rating = rating;
            this.prev = null;
            this.next = null;
        }
    }

    class MovieList {
        private Movie head;
        private Movie tail;

        public void addAtBeginning(String title, String director, int year, double rating) {
            Movie newMovie = new Movie(title, director, year, rating);
            if (head == null) {
                head = tail = newMovie;
            } else {
                newMovie.next = head;
                head.prev = newMovie;
                head = newMovie;
            }
        }

        public void addAtEnd(String title, String director, int year, double rating) {
            Movie newMovie = new Movie(title, director, year, rating);
            if (tail == null) {
                head = tail = newMovie;
            } else {
                tail.next = newMovie;
                newMovie.prev = tail;
                tail = newMovie;
            }
        }

        public void addAtPosition(int position, String title, String director, int year, double rating) {
            if (position <= 0) {
                System.out.println("Invalid position.");
                return;
            }

            if (position == 1) {
                addAtBeginning(title, director, year, rating);
                return;
            }

            Movie temp = head;
            for (int i = 1; i < position - 1 && temp != null; i++)
                temp = temp.next;

            if (temp == null || temp == tail) {
                addAtEnd(title, director, year, rating);
            } else {
                Movie newMovie = new Movie(title, director, year, rating);
                newMovie.next = temp.next;
                newMovie.prev = temp;
                temp.next.prev = newMovie;
                temp.next = newMovie;
            }
        }

        public void removeByTitle(String title) {
            Movie temp = head;

            while (temp != null) {
                if (temp.title.equalsIgnoreCase(title)) {
                    if (temp == head && temp == tail) {
                        head = tail = null;
                    } else if (temp == head) {
                        head = head.next;
                        head.prev = null;
                    } else if (temp == tail) {
                        tail = tail.prev;
                        tail.next = null;
                    } else {
                        temp.prev.next = temp.next;
                        temp.next.prev = temp.prev;
                    }
                    System.out.println("Removed movie: " + title);
                    return;
                }
                temp = temp.next;
            }

            System.out.println("Movie not found.");
        }

        public void searchByDirector(String director) {
            Movie temp = head;
            boolean found = false;
            while (temp != null) {
                if (temp.director.equalsIgnoreCase(director)) {
                    System.out.println("Found: " + temp.title + " (" + temp.year + ") - Rating: " + temp.rating);
                    found = true;
                }
                temp = temp.next;
            }
            if (!found)
                System.out.println("No movies found for director: " + director);
        }

        public void searchByRating(double rating) {
            Movie temp = head;
            boolean found = false;
            while (temp != null) {
                if (temp.rating == rating) {
                    System.out.println("Found: " + temp.title + " by " + temp.director + " (" + temp.year + ")");
                    found = true;
                }
                temp = temp.next;
            }
            if (!found)
                System.out.println("No movies found with rating: " + rating);
        }

        public void updateRating(String title, double newRating) {
            Movie temp = head;
            while (temp != null) {
                if (temp.title.equalsIgnoreCase(title)) {
                    temp.rating = newRating;
                    System.out.println("Updated rating for movie: " + title);
                    return;
                }
                temp = temp.next;
            }
            System.out.println("Movie not found.");
        }

        public void displayForward() {
            if (head == null) {
                System.out.println("No movies to display.");
                return;
            }
            System.out.println("Movies in Forward Order:");
            Movie temp = head;
            while (temp != null) {
                System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | " + temp.rating);
                temp = temp.next;
            }
        }

        public void displayReverse() {
            if (tail == null) {
                System.out.println("No movies to display.");
                return;
            }
            System.out.println("Movies in Reverse Order:");
            Movie temp = tail;
            while (temp != null) {
                System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | " + temp.rating);
                temp = temp.prev;
            }
        }
    }

    public class MovieManagementSystem {
        public static void main(String[] args) {
            MovieList movieList = new MovieList();

            movieList.addAtEnd("Inception", "Christopher Nolan", 2010, 8.8);
            movieList.addAtBeginning("Interstellar", "Christopher Nolan", 2014, 8.6);
            movieList.addAtPosition(2, "The Matrix", "Lana Wachowski", 1999, 8.7);

            movieList.displayForward();
            movieList.displayReverse();

            movieList.searchByDirector("Christopher Nolan");
            movieList.searchByRating(8.7);

            movieList.updateRating("Inception", 9.0);
            movieList.displayForward();

            movieList.removeByTitle("The Matrix");
            movieList.displayForward();
        }
    }


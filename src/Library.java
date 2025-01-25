public class Library {
    private String name;
    private String librarian;
    private int year;
    private boolean isOpen;

    Library(String name, String librarian, int year, boolean isOpen){
        this.name = name;
        this.librarian = librarian;
        this.year = year;
        this.isOpen = isOpen;
    }


    @Override
    public String toString(){
        return this.name + " " + this.librarian + " " + this.year + " " + this.isOpen;
    }

    void open(){
        this.isOpen = true;
    }

    void close(){
        this.isOpen = false;
    }

    String getName(){
        return this.name;
    }

    String getLibrarian(){
        return this.librarian;
    }

    int getYear(){
        return this.year;
    }
}
